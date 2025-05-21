package com.feliscape.artistry.content.block;

import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class TableBlock extends Block implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty NORTH_WEST = BooleanProperty.create("north_west");
    public static final BooleanProperty NORTH_EAST = BooleanProperty.create("north_east");
    public static final BooleanProperty SOUTH_EAST = BooleanProperty.create("south_east");
    public static final BooleanProperty SOUTH_WEST = BooleanProperty.create("south_west");

    final boolean flammable;

    private static final VoxelShape BASE_SHAPE = Block.box(0, 11, 0, 16, 16, 16);
    private static final VoxelShape NW_LEG_SHAPE = Block.box(1, 0, 1, 5, 11, 5);
    private static final VoxelShape NE_LEG_SHAPE = Block.box(11, 0, 1, 15, 11, 5);
    private static final VoxelShape SE_LEG_SHAPE = Block.box(11, 0, 11, 15, 11, 15);
    private static final VoxelShape SW_LEG_SHAPE = Block.box(1, 0, 11, 5, 11, 15);

    /*
    To explain how the shapes are laid out: Each of the Leg Shapes gets an index, or a specific bit of an integer
    NW = 1st bit
    NE = 2nd bit
    SE = 3rd bit
    SW = 4th bit
    Then they are added up to create an index which can be used in ALL_SHAPES to get the corresponding shape
     */

    private static final VoxelShape[] ALL_SHAPES = new VoxelShape[]{
            BASE_SHAPE, // No Legs
            Shapes.or(BASE_SHAPE, NW_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, NE_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, NW_LEG_SHAPE, NE_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, SE_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, SE_LEG_SHAPE, NW_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, NE_LEG_SHAPE, SE_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, NW_LEG_SHAPE, NE_LEG_SHAPE, SE_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, SW_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, SW_LEG_SHAPE, NW_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, SW_LEG_SHAPE, NE_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, SW_LEG_SHAPE, NE_LEG_SHAPE, NW_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, SW_LEG_SHAPE, SE_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, SW_LEG_SHAPE, SE_LEG_SHAPE, NW_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, SW_LEG_SHAPE, SE_LEG_SHAPE, NE_LEG_SHAPE),
            Shapes.or(BASE_SHAPE, NW_LEG_SHAPE, NE_LEG_SHAPE, SE_LEG_SHAPE, SW_LEG_SHAPE), // All Legs
    };

    public TableBlock(Properties properties) {
        this(properties, true);
    }
    public TableBlock(Properties properties, boolean flammable) {
        super(properties);
        this.flammable = flammable;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH_WEST, true)
                .setValue(NORTH_EAST, true)
                .setValue(SOUTH_EAST, true)
                .setValue(SOUTH_WEST, true)
        );
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return ALL_SHAPES[getShapeIndex(state)];
    }

    private int getShapeIndex(BlockState state){
        int i = 0;
        if (state.getValue(NORTH_WEST)) i += (1);
        if (state.getValue(NORTH_EAST)) i += (1 << 1);
        if (state.getValue(SOUTH_EAST)) i += (1 << 2);
        if (state.getValue(SOUTH_WEST)) i += (1 << 3);
        return i;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return getConnections(this.defaultBlockState().setValue(WATERLOGGED, waterlogged), context.getLevel(), context.getClickedPos());
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return getConnections(state, level, currentPos);
    }

    public BlockState getConnections(BlockState state, LevelAccessor level, BlockPos pos){
        boolean north = canConnect(level.getBlockState(pos.north()));
        boolean south = canConnect(level.getBlockState(pos.south()));
        boolean east  = canConnect(level.getBlockState(pos.east()));
        boolean west  = canConnect(level.getBlockState(pos.west()));

        return state
                .setValue(NORTH_WEST, (!west && !north) || (west && north && !(canConnect(level.getBlockState(pos.north().west())))))
                .setValue(NORTH_EAST, (!north && !east) || (north && east && !(canConnect(level.getBlockState(pos.north().east())))))
                .setValue(SOUTH_EAST, (!east && !south) || (east && south && !(canConnect(level.getBlockState(pos.south().east())))))
                .setValue(SOUTH_WEST, (!west && !south) || (west && south && !(canConnect(level.getBlockState(pos.south().west())))))
                ;
    }

    public boolean canConnect(BlockState state) {
        return state.is(ArtistryTags.Blocks.TABLES);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, NORTH_WEST, NORTH_EAST, SOUTH_EAST, SOUTH_WEST);
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return flammable && !state.getValue(WATERLOGGED) ? 5 : 0;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return flammable && !state.getValue(WATERLOGGED) ? 20 : 0;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }
}
