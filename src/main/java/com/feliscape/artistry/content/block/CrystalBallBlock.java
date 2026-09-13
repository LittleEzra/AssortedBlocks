package com.feliscape.artistry.content.block;

import com.feliscape.artistry.content.block.entity.CrystalBallBlockEntity;
import com.feliscape.artistry.content.block.entity.WaterFountainBlockEntity;
import com.feliscape.artistry.registry.ArtistryBlockEntityTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
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
import org.jetbrains.annotations.Nullable;

public class CrystalBallBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    private static final MapCodec<CrystalBallBlock> CODEC = simpleCodec(CrystalBallBlock::new);

    private static final VoxelShape UP = Shapes.or(
            Block.box(6, 0, 6, 10, 3, 10),
            Block.box(4, 3, 4, 12, 11, 12)
    );
    private static final VoxelShape NORTH = Shapes.or(
            Block.box(6, 6, 13, 10, 10, 16),
            Block.box(4, 4, 5, 12, 12, 13)
    );
    private static final VoxelShape EAST = Shapes.or(
            Block.box(0, 6, 6, 3, 10, 10),
            Block.box(3, 4, 4, 11, 12, 12)
    );
    private static final VoxelShape SOUTH = Shapes.or(
            Block.box(6, 6, 0, 10, 10, 3),
            Block.box(4, 4, 3, 12, 12, 11)
    );
    private static final VoxelShape WEST = Shapes.or(
            Block.box(13, 6, 6, 16, 10, 10),
            Block.box(5, 4, 4, 13, 12, 12)
    );
    private static final VoxelShape DOWN = Shapes.or(
            Block.box(6, 13, 6, 10, 16, 10),
            Block.box(4, 5, 4, 12, 13, 12)
    );

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public CrystalBallBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(WATERLOGGED, Boolean.FALSE)
                        .setValue(FACING, Direction.NORTH)
        );
    }

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

        return Block.canSupportCenter(level, relative, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CrystalBallBlockEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (!level.isClientSide()) return null;
        return createTickerHelper(blockEntityType, ArtistryBlockEntityTypes.CRYSTAL_BALL.get(), CrystalBallBlockEntity::clientTick);
    }
}
