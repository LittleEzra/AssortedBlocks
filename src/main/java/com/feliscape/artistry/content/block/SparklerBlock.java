package com.feliscape.artistry.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SparklerBlock extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    private static final VoxelShape UP =    Block.box(6, 0, 6, 10, 11, 10);
    private static final VoxelShape DOWN =  Block.box(6, 5, 6, 10, 16, 10);
    private static final VoxelShape NORTH = Block.box(6, 6, 5, 10, 10, 16);
    private static final VoxelShape EAST =  Block.box(0, 6, 6, 11, 10, 10);
    private static final VoxelShape SOUTH = Block.box(6, 6, 0, 10, 10, 11);
    private static final VoxelShape WEST =  Block.box(5, 6, 6, 16, 10, 10);
    //private static final VoxelShape SHAPE = Block.box(6, 0, 6, 10, 11, 10);

    public SparklerBlock(Properties properties) {
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
    public void animateTick(BlockState state, Level level, BlockPos blockPos, RandomSource random) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        Direction d = state.getValue(FACING);

        for (int i = 0; i < 4; i++) {
            Vec3i normal = d.getNormal();
            int relativeX = normal.getX() != 0 ? normal.getX() * random.nextInt(-2, 10) : Mth.nextInt(random, -10, 10);
            int relativeY = normal.getY() != 0 ? normal.getY() * random.nextInt(-2, 10) : Mth.nextInt(random, -10, 10);
            int relativeZ = normal.getZ() != 0 ? normal.getZ() * random.nextInt(-2, 10) : Mth.nextInt(random, -10, 10);
            mutableBlockPos.set(x + relativeX, y + relativeY, z + relativeZ);
            BlockState blockstate = level.getBlockState(mutableBlockPos);
            if (!blockstate.isCollisionShapeFullBlock(level, mutableBlockPos)) {
                level.addParticle(
                        ParticleTypes.END_ROD,
                        (double)mutableBlockPos.getX() + random.nextDouble(),
                        (double)mutableBlockPos.getY() + random.nextDouble(),
                        (double)mutableBlockPos.getZ() + random.nextDouble(),
                        0.0,
                        0.0,
                        0.0
                );
            }
        }
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
