package com.feliscape.artistry.content.block;

import com.feliscape.artistry.registry.ArtistryTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class StringLightsBlock extends CrossCollisionBlock {
    public static final BooleanProperty DOWN = PipeBlock.DOWN;
    public static final BooleanProperty SUPPORTED = BooleanProperty.create("supported");
    public static final MapCodec<StringLightsBlock> CODEC = simpleCodec(StringLightsBlock::new);

    /* Little guide on how to use makeShapes, since its variables are misleading:
        "extensionBottom" describes the bottom of each extension,
        "extensionHeight" denotes the TOP of each extension, not the total height. It should really be called "extensionTop"
        The same goes for the nodeHeight, though that one always starts at 0, making the distinction meaningless.
    */

    private final VoxelShape[] shapesWithDown;
    private final VoxelShape[] shapes;

    public StringLightsBlock(Properties properties) {
        super(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, properties);
        this.registerDefaultState(this.defaultBlockState().setValue(DOWN, true).setValue(SUPPORTED, true));
        this.shapes = makeShapesWithoutPost(1.0F, 8.0F, 16.0F);
        this.shapesWithDown = makeShapes(1.0F, 1.0F, 16.0F, 8.0F, 16.0F);
    }

    protected VoxelShape[] makeShapesWithoutPost(float extensionWidth, float extensionBottom, float extensionHeight) {
        float f2 = 8.0F - extensionWidth;
        float f3 = 8.0F + extensionWidth;
        VoxelShape voxelshape1 = Block.box((double)f2, (double)extensionBottom, 0.0, (double)f3, (double)extensionHeight, (double)f3);
        VoxelShape voxelshape2 = Block.box((double)f2, (double)extensionBottom, (double)f2, (double)f3, (double)extensionHeight, 16.0);
        VoxelShape voxelshape3 = Block.box(0.0, (double)extensionBottom, (double)f2, (double)f3, (double)extensionHeight, (double)f3);
        VoxelShape voxelshape4 = Block.box((double)f2, (double)extensionBottom, (double)f2, 16.0, (double)extensionHeight, (double)f3);
        VoxelShape voxelshape5 = Shapes.or(voxelshape1, voxelshape4);
        VoxelShape voxelshape6 = Shapes.or(voxelshape2, voxelshape3);
        VoxelShape[] avoxelshape = new VoxelShape[]{
                Shapes.empty(),
                voxelshape2,
                voxelshape3,
                voxelshape6,
                voxelshape1,
                Shapes.or(voxelshape2, voxelshape1),
                Shapes.or(voxelshape3, voxelshape1),
                Shapes.or(voxelshape6, voxelshape1),
                voxelshape4,
                Shapes.or(voxelshape2, voxelshape4),
                Shapes.or(voxelshape3, voxelshape4),
                Shapes.or(voxelshape6, voxelshape4),
                voxelshape5,
                Shapes.or(voxelshape2, voxelshape5),
                Shapes.or(voxelshape3, voxelshape5),
                Shapes.or(voxelshape6, voxelshape5)
        };

        return avoxelshape;
    }

    @Override
    protected VoxelShape @NotNull [] makeShapes(float nodeWidth, float extensionWidth, float nodeHeight, float extensionBottom, float extensionHeight) {
        if (nodeWidth < 0.1F) return new VoxelShape[]{};
        return super.makeShapes(nodeWidth, extensionWidth, nodeHeight, extensionBottom, extensionHeight);
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(DOWN) ? shapesWithDown[getAABBIndex(state)] : shapes[getAABBIndex(state)];
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState above = level.getBlockState(pos.above());
        if (Block.canSupportCenter(level, pos.above(), Direction.DOWN) ||
                (above.is(ArtistryTags.Blocks.STRING_LIGHTS) && above.getValue(SUPPORTED)) ||
                above.is(BlockTags.LEAVES))
            return true;

        BlockState north = level.getBlockState(pos.north());
        BlockState east = level.getBlockState(pos.east());
        BlockState south = level.getBlockState(pos.south());
        BlockState west = level.getBlockState(pos.west());
        return (canBlockSupport(north) && canBlockSupport(south)) ||
                (canBlockSupport(east) && canBlockSupport(west));
    }

    protected boolean canSurviveWithoutSupport(LevelReader level, BlockPos pos) {
        BlockState above = level.getBlockState(pos.above());
        return Block.canSupportCenter(level, pos.above(), Direction.DOWN) ||
                (above.is(ArtistryTags.Blocks.STRING_LIGHTS) && above.getValue(SUPPORTED)) ||
                above.is(BlockTags.LEAVES);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelReader reader = context.getLevel();
        BlockGetter blockGetter = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockPos north = blockpos.north();
        BlockPos east = blockpos.east();
        BlockPos south = blockpos.south();
        BlockPos west = blockpos.west();
        BlockState northState = blockGetter.getBlockState(north);
        BlockState eastState = blockGetter.getBlockState(east);
        BlockState southState = blockGetter.getBlockState(south);
        BlockState westState = blockGetter.getBlockState(west);
        boolean connectsNorth = this.connectsTo(northState, northState.isFaceSturdy(blockGetter, north, Direction.SOUTH), Direction.SOUTH);
        boolean connectsEast =  this.connectsTo(eastState,  eastState.isFaceSturdy(blockGetter,  east,  Direction.WEST), Direction.WEST);
        boolean connectsSouth = this.connectsTo(southState, southState.isFaceSturdy(blockGetter, south, Direction.NORTH), Direction.NORTH);
        boolean connectsWest =  this.connectsTo(westState,  westState.isFaceSturdy(blockGetter,  west,  Direction.EAST), Direction.EAST);

        boolean connectsDown = blockGetter.getBlockState(blockpos.below()).is(ArtistryTags.Blocks.STRING_LIGHTS);
        boolean supported = canSurviveWithoutSupport(reader, blockpos);

        return super.getStateForPlacement(context)
                .setValue(NORTH, connectsNorth)
                .setValue(EAST,  connectsEast)
                .setValue(SOUTH, connectsSouth)
                .setValue(WEST,  connectsWest)
                .setValue(DOWN, (!connectsNorth && !connectsSouth && !connectsEast && !connectsWest) || connectsDown)
                .setValue(SUPPORTED, supported)
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    public boolean connectsTo(BlockState state, boolean isSideSolid, Direction direction) {
        return !isExceptionForConnection(state) && isSideSolid || state.is(ArtistryTags.Blocks.STRING_LIGHTS);
    }

    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (facing == Direction.UP){
            if (!canSurvive(state, level, pos)) return Blocks.AIR.defaultBlockState();
            return state.setValue(SUPPORTED, canSurviveWithoutSupport(level, pos));
        }

        boolean supported = state.getValue(SUPPORTED);
        if (facing == Direction.DOWN){
            boolean connectsDown = level.getBlockState(neighborPos).is(ArtistryTags.Blocks.STRING_LIGHTS);
            return state.setValue(DOWN, supported && (!hasHorizontalConnection(state) || connectsDown));
        } else if (facing.getAxis().getPlane() == Direction.Plane.HORIZONTAL){
            if (!state.getValue(SUPPORTED) && state.getValue(PROPERTY_BY_DIRECTION.get(facing)) && !canSurvive(state, level, pos)){
                return Blocks.AIR.defaultBlockState();
            }

            boolean connectsDown = level.getBlockState(pos.below()).is(ArtistryTags.Blocks.STRING_LIGHTS);
            BlockState newState = state
                    .setValue(PROPERTY_BY_DIRECTION.get(facing), this.connectsTo(facingState,
                            facingState.isFaceSturdy(level, neighborPos, facing.getOpposite()),
                            facing.getOpposite()));
            return newState.setValue(DOWN, supported && (!hasHorizontalConnection(newState) || connectsDown));
        }
        return super.updateShape(state, facing, facingState, level, pos, neighborPos);
    }

    private boolean canBlockSupport(BlockState state) {
        return state.is(this) && state.getValue(SUPPORTED);
    }

    protected boolean hasHorizontalConnection(BlockState state){
        return state.getValue(NORTH) || state.getValue(EAST) || state.getValue(SOUTH) || state.getValue(WEST);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, DOWN, SUPPORTED, WATERLOGGED);
    }

    @Override
    protected MapCodec<? extends CrossCollisionBlock> codec() {
        return CODEC;
    }
}
