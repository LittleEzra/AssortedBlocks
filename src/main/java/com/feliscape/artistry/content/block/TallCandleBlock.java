package com.feliscape.artistry.content.block;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryTags;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.ToIntFunction;

public class TallCandleBlock extends AbstractCandleBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<TallCandleBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            DyeColor.CODEC.optionalFieldOf("color", null).forGetter(TallCandleBlock::getColor), propertiesCodec())
            .apply(instance, TallCandleBlock::new)
    );
    public static final int MIN_CANDLES = 1;
    public static final int MAX_CANDLES = 4;
    public static final IntegerProperty CANDLES = BlockStateProperties.CANDLES;
    public static final BooleanProperty LIT = AbstractCandleBlock.LIT;
    public static final BooleanProperty BASE = BooleanProperty.create("base");
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final ToIntFunction<BlockState> LIGHT_EMISSION = state -> state.getValue(LIT) ? 3 * state.getValue(CANDLES) : 0;
    @Nullable
    private final DyeColor color;

    private static final Int2ObjectMap<List<Vec3>> PARTICLE_OFFSETS = Util.make(
            () -> {
                Int2ObjectMap<List<Vec3>> int2objectmap = new Int2ObjectOpenHashMap<>();
                int2objectmap.defaultReturnValue(ImmutableList.of());
                int2objectmap.put(1, ImmutableList.of(
                        new Vec3(0.5, 0.875, 0.5)));
                int2objectmap.put(2, ImmutableList.of(
                        new Vec3(0.375, 0.75, 0.5),
                        new Vec3(0.625, 0.875, 0.44)));
                int2objectmap.put(3, ImmutableList.of(
                        new Vec3(0.53, 0.6, 0.66),
                        new Vec3(0.35, 0.75, 0.47),
                        new Vec3(0.6, 0.875, 0.44)));
                int2objectmap.put(4, ImmutableList.of(
                        new Vec3(0.4, 0.6, 0.6),
                        new Vec3(0.66, 0.81, 0.6),
                        new Vec3(0.34, 0.75, 0.34),
                        new Vec3(0.6, 0.875, 0.34))
                );
                return Int2ObjectMaps.unmodifiable(int2objectmap);
            }
    );
    private static final VoxelShape ONE_AABB = Block.box(6.5, 0.0, 6.5, 9.5, 12.0, 9.5);
    private static final VoxelShape TWO_AABB = Block.box(4.0, 0.0, 5.0, 12.0, 12.0, 9.0);
    private static final VoxelShape THREE_AABB = Block.box(4.0, 0.0, 5.0, 11.0, 12.0, 12.0);
    private static final VoxelShape FOUR_AABB = Block.box(4.0, 0.0, 4.0, 12.0, 12.0, 11.0);
    private static final VoxelShape BASE_ONE_AABB = Block.box(6.5, 0.0, 6.5, 9.5, 16.0, 9.5);
    private static final VoxelShape BASE_TWO_AABB = Block.box(4.0, 0.0, 5.0, 12.0, 16.0, 9.0);
    private static final VoxelShape BASE_THREE_AABB = Block.box(4.0, 0.0, 5.0, 11.0, 16.0, 12.0);
    private static final VoxelShape BASE_FOUR_AABB = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 11.0);

    public TallCandleBlock(DyeColor color, Properties properties) {
        super(properties);
        this.color = color;
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(CANDLES, 1)
                        .setValue(LIT, Boolean.FALSE)
                        .setValue(BASE, Boolean.FALSE)
                        .setValue(WATERLOGGED, Boolean.FALSE)
        );
    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult
    ) {
        if (stack.isEmpty() && player.getAbilities().mayBuild && state.getValue(LIT) && !state.getValue(BASE)) {
            extinguish(player, state, level, pos);
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.isSecondaryUseActive() && useContext.getItemInHand().getItem() == this.asItem() && state.getValue(CANDLES) < 4 || super.canBeReplaced(state, useContext);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {

        BlockState below = context.getLevel().getBlockState(context.getClickedPos().below());
        BlockState above = context.getLevel().getBlockState(context.getClickedPos().above());
        ItemStack itemInHand = context.getItemInHand();

        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.is(this)) {
            if (blockstate.getValue(BASE)) return null;
            BlockState returnState = blockstate.cycle(CANDLES);
            if (isSame(below)){
                int belowCandles = below.getValue(CANDLES);
                int requiredCandles = returnState.getValue(CANDLES);
                if (requiredCandles > belowCandles) {
                    if (!canConsume(itemInHand, requiredCandles - belowCandles, context.getPlayer())){
                        return null;
                    }
                    context.getLevel().setBlock(context.getClickedPos().below(), below.setValue(CANDLES, requiredCandles), Block.UPDATE_CLIENTS);
                    itemInHand.consume(requiredCandles - belowCandles, context.getPlayer());
                }
            }
            return returnState;
        } else {
            boolean lit = false;
            int candles = 1;
            boolean base = false;
            if (isSame(below)){
                candles = below.getValue(CANDLES);
                if (!itemInHand.isEmpty() && !canConsume(itemInHand, candles, context.getPlayer())){
                    return null;
                }

                itemInHand.consume(candles - 1, context.getPlayer());
                lit = below.getValue(LIT);
            } else if (isSame(above) && !above.getValue(BASE)){
                candles = above.getValue(CANDLES);
                if (!itemInHand.isEmpty() && !canConsume(itemInHand, candles, context.getPlayer())){
                    return null;
                }

                itemInHand.consume(candles - 1, context.getPlayer());
                lit = above.getValue(LIT);
                base = true;
            }

            FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
            boolean flag = fluidstate.getType() == Fluids.WATER;

            return super.getStateForPlacement(context)
                    .setValue(LIT, lit)
                    .setValue(BASE, base)
                    .setValue(WATERLOGGED, flag)
                    .setValue(CANDLES, candles);
        }
    }

    private static boolean canConsume(ItemStack itemStack, int count, @Nullable Player player){
        if (player != null && player.hasInfiniteMaterials()) return true;
        return itemStack.getCount() >= count;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (!state.getValue(BASE)) {
            super.animateTick(state, level, pos, random);
        }
    }

    @Override
    protected BlockState updateShape(
            BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos
    ) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (direction == Direction.UP){
            BlockState newState = super.updateShape(state, direction, neighborState, level, pos, neighborPos)
                    .setValue(BASE, isSame(neighborState));
            if (newState.getValue(BASE)){
                newState = newState.setValue(LIT, neighborState.is(this) ? neighborState.getValue(LIT) : false);
           }
            return newState;
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        boolean base = state.getValue(BASE);
        return switch (state.getValue(CANDLES)) {
            default -> base ? BASE_ONE_AABB : ONE_AABB;
            case 2  -> base ? BASE_TWO_AABB : TWO_AABB;
            case 3  -> base ? BASE_THREE_AABB : THREE_AABB;
            case 4  -> base ? BASE_FOUR_AABB : FOUR_AABB;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(CANDLES, LIT, BASE, WATERLOGGED);
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!state.getValue(WATERLOGGED) && fluidState.getType() == Fluids.WATER) {
            BlockState blockstate = state.setValue(WATERLOGGED, Boolean.valueOf(true));
            if (state.getValue(LIT)) {
                extinguish(null, blockstate, level, pos);
            } else {
                level.setBlock(pos, blockstate, 3);
            }

            level.scheduleTick(pos, fluidState.getType(), fluidState.getType().getTickDelay(level));
            return true;
        } else {
            return false;
        }
    }

    public static boolean canLight(BlockState state) {
        return state.is(ArtistryTags.Blocks.TALL_CANDLES, base -> base.hasProperty(LIT) && base.hasProperty(WATERLOGGED))
                && !state.getValue(LIT)
                && !state.getValue(BASE)
                && !state.getValue(WATERLOGGED)
                ;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (ItemAbilities.FIRESTARTER_LIGHT == itemAbility) {
            if (canLight(state)) {
                return state.setValue(BlockStateProperties.LIT, Boolean.valueOf(true));
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }

    @Override
    protected boolean canBeLit(BlockState state) {
        return !state.getValue(BASE) && !state.getValue(WATERLOGGED) && super.canBeLit(state);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return Block.canSupportCenter(level, pos.below(), Direction.UP) ||
                (level.getBlockState(pos.below()).is(ArtistryTags.Blocks.TALL_CANDLES) &&
                        Block.canSupportCenter(level, pos.below(2), Direction.UP)
                        && !level.getBlockState(pos.below(2)).is(ArtistryTags.Blocks.TALL_CANDLES)
                );
    }

    @Override
    protected MapCodec<? extends TallCandleBlock> codec() {
        return CODEC;
    }

    @Override
    protected Iterable<Vec3> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS.get(state.getValue(CANDLES).intValue());
    }

    @Nullable
    public DyeColor getColor() {
        return this.color;
    }

    private boolean isSame(BlockState state){
        return state.getBlock() instanceof TallCandleBlock candle && candle.color == this.color;
    }
}
