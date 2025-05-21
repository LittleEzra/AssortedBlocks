package com.feliscape.artistry.content.block;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;

public class SunsproutBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<SunsproutBlock> CODEC = simpleCodec(SunsproutBlock::new);
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(4.0, 11.0, 4.0, 12.0, 16.0, 12.0),
            Block.box(3.0, 9.0, 3.0, 13.0, 16.0, 13.0),
            Block.box(2.0, 7.0, 2.0, 14.0, 16.0, 14.0),
            Block.box(2.0, 5.0, 2.0, 14.0, 16.0, 14.0)
    };

    public SunsproutBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.isAreaLoaded(pos, 1)) {
            int age = this.getAge(state);
            if (age < 4) {
                float f = 1.0F;
                if (random.nextInt((int)(25.0F / f) + 1) == 0) {
                    if (age == 3){
                        level.setBlock(pos, ArtistryBlocks.SUNBURST_VINES.get().defaultBlockState(), 2);
                    } else{
                        level.setBlock(pos, state.setValue(AGE, age + 1), 2);
                    }
                }
            }
        }
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        int age = this.getAge(blockState);

        if (age == 3){
            serverLevel.setBlock(blockPos, ArtistryBlocks.SUNBURST_VINES.get().defaultBlockState(), 2);
        } else{
            serverLevel.setBlock(blockPos, blockState.setValue(AGE, age + 1), 2);
        }
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.relative(Direction.UP);
        BlockState blockstate = level.getBlockState(blockpos);
        return blockstate.isFaceSturdy(level, blockpos, Direction.DOWN) || blockstate.is(BlockTags.LEAVES);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(ArtistryItems.SUNSPROUT.get());
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    public int getAge(BlockState state) {
        return state.getValue(AGE);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }
}
