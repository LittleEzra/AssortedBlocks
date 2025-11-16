package com.feliscape.artistry.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;

public class GrateBlock extends Block {
    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 8);
    public static final BooleanProperty FALLING = BlockStateProperties.FALLING;

    public GrateBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, 0).setValue(FALLING, false));
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(LEVEL) > 0){
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEVEL, FALLING);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        int level = state.getValue(LEVEL);
        return level == 0 ? super.getFluidState(state) : Fluids.WATER.defaultFluidState()
                //.setValue(WaterFluid.LEVEL, level)
                .setValue(WaterFluid.FALLING, state.getValue(FALLING));
    }
}
