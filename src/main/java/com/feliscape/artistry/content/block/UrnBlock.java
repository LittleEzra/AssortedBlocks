package com.feliscape.artistry.content.block;

import com.feliscape.artistry.content.block.entity.UrnBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class UrnBlock extends BaseEntityBlock implements SimpleWaterloggedBlock{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final MapCodec<UrnBlock> CODEC = simpleCodec(UrnBlock::new);
    public static final BooleanProperty CRACKED = BlockStateProperties.CRACKED;

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(4, 5, 4, 12, 13, 12),
            Block.box(5, 0, 5, 11, 16, 11)
    );

    public UrnBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(CRACKED, false)
        );
    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack itemStack, BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult
    ) {
        if (level.getBlockEntity(blockPos) instanceof UrnBlockEntity urn) {
            if (level.isClientSide) {
                return ItemInteractionResult.CONSUME;
            } else {
                ItemStack urnStack = urn.getTheItem();
                if (!itemStack.isEmpty()
                        && (
                        urnStack.isEmpty()
                                || ItemStack.isSameItemSameComponents(urnStack, itemStack) && urnStack.getCount() < urnStack.getMaxStackSize()
                )) {
                    urn.wobble(UrnBlockEntity.WobbleStyle.POSITIVE);
                    player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
                    ItemStack itemstack = itemStack.consumeAndReturn(1, player);
                    float f;
                    if (urn.isEmpty()) {
                        urn.setTheItem(itemstack);
                        f = (float)itemstack.getCount() / (float)itemstack.getMaxStackSize();
                    } else {
                        urnStack.grow(1);
                        f = (float)urnStack.getCount() / (float)urnStack.getMaxStackSize();
                    }

                    level.playSound(null, blockPos, SoundEvents.DECORATED_POT_INSERT, SoundSource.BLOCKS, 1.0F, 0.7F + 0.5F * f);
                    if (level instanceof ServerLevel serverlevel) {
                        serverlevel.sendParticles(
                                ParticleTypes.DUST_PLUME,
                                (double)blockPos.getX() + 0.5,
                                (double)blockPos.getY() + 1.2,
                                (double)blockPos.getZ() + 0.5,
                                7,
                                0.0,
                                0.0,
                                0.0,
                                0.0
                        );
                    }

                    urn.setChanged();
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
                    return ItemInteractionResult.SUCCESS;
                } else {
                    return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                }
            }
        } else {
            return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        }
    }

    @Override
    protected void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        BlockPos blockpos = hit.getBlockPos();
        if (!level.isClientSide && projectile.mayInteract(level, blockpos) && projectile.mayBreak(level)) {
            level.setBlock(blockpos, state.setValue(CRACKED, Boolean.TRUE), 4);
            level.destroyBlock(blockpos, true, projectile);
        }
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos blockPos, BlockState state, Player player) {
        ItemStack itemstack = player.getMainHandItem();
        BlockState blockstate = state;
        if (itemstack.is(ItemTags.BREAKS_DECORATED_POTS) && !EnchantmentHelper.hasTag(itemstack, EnchantmentTags.PREVENTS_DECORATED_POT_SHATTERING)) {
            blockstate = state.setValue(CRACKED, Boolean.TRUE);
            level.setBlock(blockPos, blockstate, 4);
        }

        return super.playerWillDestroy(level, blockPos, blockstate, player);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (level.getBlockEntity(blockPos) instanceof UrnBlockEntity urn) {
            level.playSound(null, blockPos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            urn.wobble(UrnBlockEntity.WobbleStyle.NEGATIVE);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    @Override
    protected BlockState updateShape(
            BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos blockPos, BlockPos neighborPos
    ) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, neighborState, level, blockPos, neighborPos);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) {
        return state.getValue(CRACKED) ? SoundType.DECORATED_POT_CRACKED : SoundType.DECORATED_POT;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos blockPos, BlockState newState, boolean movedByPiston) {
        Containers.dropContentsOnDestroy(state, newState, level, blockPos);
        super.onRemove(state, level, blockPos, newState, movedByPiston);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, CRACKED);
    }

    @Override
    protected MapCodec<? extends UrnBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new UrnBlockEntity(pos, state);
    }
}
