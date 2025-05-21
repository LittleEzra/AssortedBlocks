package com.feliscape.artistry.content.block;

import com.feliscape.artistry.registry.ArtistryTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StringLightsBlock extends CrossCollisionBlock {
    public static final BooleanProperty DOWN = PipeBlock.DOWN;
    public static final MapCodec<StringLightsBlock> CODEC = simpleCodec(StringLightsBlock::new);

    protected final VoxelShape[] shapes;

    public StringLightsBlock(Properties properties) {
        super(2.0F, 2.0F, 16.0F, 16.0F, 16.0F, properties);
        this.shapes = makeShapes(2.0F, 2.0F, 16.0F, 8.0F, 8.0F);
        this.registerDefaultState(this.defaultBlockState().setValue(DOWN, true));
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.shapes[this.getAABBIndex(state)];
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockPos north = blockpos.north();
        BlockPos east = blockpos.east();
        BlockPos south = blockpos.south();
        BlockPos west = blockpos.west();
        BlockState northState = blockgetter.getBlockState(north);
        BlockState eastState = blockgetter.getBlockState(east);
        BlockState southState = blockgetter.getBlockState(south);
        BlockState westState = blockgetter.getBlockState(west);
        boolean connectsNorth = this.connectsTo(northState, northState.isFaceSturdy(blockgetter, north, Direction.SOUTH), Direction.SOUTH);
        boolean connectsEast =  this.connectsTo(eastState,  eastState.isFaceSturdy(blockgetter,  east,  Direction.WEST), Direction.WEST);
        boolean connectsSouth = this.connectsTo(southState, southState.isFaceSturdy(blockgetter, south, Direction.NORTH), Direction.NORTH);
        boolean connectsWest =  this.connectsTo(westState,  westState.isFaceSturdy(blockgetter,  west,  Direction.EAST), Direction.EAST);
        boolean connectsDown = blockgetter.getBlockState(blockpos.below()).is(ArtistryTags.Blocks.STRING_LIGHTS);
        return super.getStateForPlacement(context)
                .setValue(NORTH, connectsNorth)
                .setValue(EAST,  connectsEast)
                .setValue(SOUTH, connectsSouth)
                .setValue(WEST,  connectsWest)
                .setValue(DOWN, (!connectsNorth && !connectsSouth && !connectsEast && !connectsWest) || connectsDown)
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    public boolean connectsTo(BlockState state, boolean isSideSolid, Direction direction) {
        Block block = state.getBlock();
        return !isExceptionForConnection(state) && isSideSolid || state.is(ArtistryTags.Blocks.STRING_LIGHTS) || state.is(BlockTags.FENCES);
    }

    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return facing.getAxis().getPlane() == Direction.Plane.HORIZONTAL ? (BlockState)state.setValue((Property)PROPERTY_BY_DIRECTION.get(facing), this.connectsTo(facingState, facingState.isFaceSturdy(level, facingPos, facing.getOpposite()), facing.getOpposite())) : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, DOWN, WATERLOGGED);
    }

    @Override
    protected MapCodec<? extends CrossCollisionBlock> codec() {
        return CODEC;
    }
}
