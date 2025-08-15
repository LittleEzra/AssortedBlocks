package com.feliscape.artistry.content.block.plant;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LushFernCropBlock extends CropBlock {
    public static final MapCodec<LushFernCropBlock> CODEC = simpleCodec(LushFernCropBlock::new);

    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final int MAX_AGE = 4;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0),
            Block.box(3.0, 0.0, 3.0, 13.0, 10.0, 13.0),
            Block.box(3.0, 0.0, 3.0, 13.0, 12.0, 13.0),
    };

    public LushFernCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<LushFernCropBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ArtistryItems.FERN_SEED;
    }

    @Override
    public BlockState getStateForAge(int age) {
        return age == MAX_AGE ? ArtistryBlocks.LUSH_FERN.get().defaultBlockState() : super.getStateForAge(age);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
        if (random.nextInt(3) != 0) {
            super.randomTick(state, serverLevel, blockPos, random);
        }
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return 1;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }
}
