package com.feliscape.artistry.content.block;

import com.feliscape.artistry.registry.ArtistryParticles;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

public class FlyLureBlock extends Block implements SimpleWaterloggedBlock {
    public static final MapCodec<FlyLureBlock> CODEC = simpleCodec(FlyLureBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape FLOOR_AABB = Shapes.or(
            Block.box(7.0, 0.0, 7.0, 9.0, 7.0, 9.0),
            Block.box(4.5, 7.0, 4.5, 11.5, 14.0, 11.5));
    protected static final VoxelShape HANGING_AABB = Shapes.or(
            Block.box(7.0, 9.0, 7.0, 9.0, 16.0, 9.0),
            Block.box(4.5, 2.0, 4.5, 11.5, 9.0, 11.5));

    protected static final VoxelShape NORTH_AABB = Shapes.or(
            Block.box(7.0, 9.0, 11.0, 9.0, 11.0, 16.0),
            Block.box(4.5, 7.0, 4.5, 11.5, 14.0, 11.5));
    protected static final VoxelShape EAST_AABB = Shapes.or(
            Block.box(0.0, 9.0, 7.0, 5.0, 11.0, 9.0),
            Block.box(4.5, 7.0, 4.5, 11.5, 14.0, 11.5));
    protected static final VoxelShape SOUTH_AABB = Shapes.or(
            Block.box(7.0, 9.0, 0.0, 9.0, 11.0, 5.0),
            Block.box(4.5, 7.0, 4.5, 11.5, 14.0, 11.5));
    protected static final VoxelShape WEST_AABB = Shapes.or(
            Block.box(11.0, 9.0, 7.0, 16.0, 11.0, 9.0),
            Block.box(4.5, 7.0, 4.5, 11.5, 14.0, 11.5));

    public FlyLureBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
    }

    @Override
    public MapCodec<FlyLureBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        return switch (direction) {
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
            case EAST -> EAST_AABB;
            case WEST -> WEST_AABB;
            case DOWN -> HANGING_AABB;
            default -> FLOOR_AABB;
        };
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(WATERLOGGED)) return;

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

        ParticleOptions particle = ArtistryParticles.FLY.get();
        if (level.dimension() == Level.NETHER) {
            particle = ArtistryParticles.NETHER_FLY.get();
        }

        Direction d = state.getValue(FACING);
        Vec3i normal = d.getNormal();

        for (int i = 0; i < 1; i++) {
            int relativeX = normal.getX() != 0 ? normal.getX() * random.nextInt(-1, 3) : Mth.nextInt(random, -2, 2);
            int relativeY = normal.getY() != 0 ? normal.getY() * random.nextInt(-1, 3) : Mth.nextInt(random, -2, 2);
            int relativeZ = normal.getZ() != 0 ? normal.getZ() * random.nextInt(-1, 3) : Mth.nextInt(random, -2, 2);
            mutableBlockPos.set(x + relativeX, y + relativeY, z + relativeZ);
            if (!level.getBlockState(mutableBlockPos).isCollisionShapeFullBlock(level, mutableBlockPos)) {
                level.addParticle(
                        particle,
                        (double) mutableBlockPos.getX() + random.nextDouble(),
                        (double) mutableBlockPos.getY() + random.nextDouble(),
                        (double) mutableBlockPos.getZ() + random.nextDouble(),
                        0.0,
                        0.0,
                        0.0
                );
            }
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean inWater = fluidstate.getType() == Fluids.WATER;
        return super.getStateForPlacement(context
                ).setValue(WATERLOGGED, inWater)
                .setValue(FACING, context.getClickedFace());
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos blockPos) {
        Direction direction = state.getValue(FACING);
        BlockPos relative = blockPos.relative(direction.getOpposite());
        return level.getBlockState(relative).isFaceSturdy(level, relative, direction);
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
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("item.artistry.wip").withStyle(ChatFormatting.GRAY));
    }
}
