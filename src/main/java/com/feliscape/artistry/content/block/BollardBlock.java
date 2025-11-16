package com.feliscape.artistry.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BollardBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    private static final VoxelShape UP = Shapes.or(
            Block.box(5, 0, 5, 11, 8, 11),
            Block.box(4, 8, 4, 12, 12, 12)
    );
    private static final VoxelShape DOWN = Shapes.or(
            Block.box(5, 8, 5, 11, 16, 11),
            Block.box(4, 4, 4, 12, 8, 12)
    );
    private static final VoxelShape NORTH = Shapes.or(
            Block.box(5, 5, 8, 11, 11, 16),
            Block.box(4, 4, 4, 12, 12, 8)
    );
    private static final VoxelShape EAST = Shapes.or(
            Block.box(0, 5, 5, 8, 11, 11),
            Block.box(8, 4, 4, 12, 12, 12)
    );
    private static final VoxelShape SOUTH = Shapes.or(
            Block.box(5, 5, 0, 11, 11, 8),
            Block.box(4, 4, 8, 12, 12, 12)
    );
    private static final VoxelShape WEST = Shapes.or(
            Block.box(8, 5, 5, 16, 11, 11),
            Block.box(4, 4, 4, 8, 12, 12)
    );

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        return switch (direction) {
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case EAST -> EAST;
            case WEST -> WEST;
            case DOWN -> DOWN;
            default -> UP;
        };
    }

    public BollardBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(WATERLOGGED, Boolean.FALSE)
                        .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean inWater = fluidstate.getType() == Fluids.WATER;
        return super.getStateForPlacement(context
                ).setValue(WATERLOGGED, inWater)
                .setValue(FACING, context.getClickedFace());
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected BlockState updateShape(
            BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos
    ) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return !this.canSurvive(state, level, pos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos blockPos) {
        Direction direction = state.getValue(FACING);
        BlockPos relative = blockPos.relative(direction.getOpposite());
        return level.getBlockState(relative).isFaceSturdy(level, relative, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }
}
