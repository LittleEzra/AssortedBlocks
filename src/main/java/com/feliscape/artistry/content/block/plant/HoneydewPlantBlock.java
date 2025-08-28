package com.feliscape.artistry.content.block.plant;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import com.feliscape.artistry.registry.ArtistryTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.util.TriState;

public class HoneydewPlantBlock extends CropBlock {
    public static final MapCodec<HoneydewPlantBlock> CODEC = simpleCodec(HoneydewPlantBlock::new);

    public HoneydewPlantBlock(Properties properties) {
        super(properties);
    }
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    public static final int MAX_AGE = 5;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(4.0, 0.0, 4.0, 12.0, 3.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 6.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 10.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 12.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 14.0, 12.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0)
    };

    @Override
    public MapCodec<HoneydewPlantBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(ArtistryTags.Blocks.UNDERGROUND_PLANT_SOIL);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState belowBlockState = level.getBlockState(blockpos);
        TriState soilDecision = belowBlockState.canSustainPlant(level, blockpos, Direction.UP, state);
        if (!soilDecision.isDefault()) return soilDecision.isTrue();
        return this.mayPlaceOn(belowBlockState, level, blockpos);
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
        return ArtistryItems.GOLDEN_BULB;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;

        int i = this.getAge(state);
        if (i < this.getMaxAge()) {
            float f = getGrowthSpeed(state, level, pos);
            if (CommonHooks.canCropGrow(level, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
                level.setBlock(pos, this.getStateForAge(i + 1), 2);
                if ((i + 1) >= getMaxAge() && level.isEmptyBlock(pos.above())){
                    level.setBlock(pos.above(), getFruitState(random), 3);
                }
                CommonHooks.fireCropGrowPost(level, pos, state);
            }
        } else if (random.nextInt(60) == 0 && level.isEmptyBlock(pos.above())){
            level.setBlock(pos.above(), getFruitState(random), 3);
        }
    }

    private BlockState getFruitState(RandomSource random) {
        return ArtistryBlocks.HONEYDEW_FRUIT.get().defaultBlockState().setValue(HoneydewFruitBlock.PLANTED, true);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return 1;
    }


    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void growCrops(Level level, BlockPos pos, BlockState state) {
        int increasedAge = this.getAge(state) + this.getBonemealAgeIncrease(level);
        int maxAge = this.getMaxAge();
        if (increasedAge > maxAge) {
            increasedAge = maxAge;
        }

        level.setBlock(pos, this.getStateForAge(increasedAge), 2);
        if (increasedAge == maxAge && level.isEmptyBlock(pos.above())){
            level.setBlock(pos.above(), getFruitState(level.random), 3);
        }
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }
}
