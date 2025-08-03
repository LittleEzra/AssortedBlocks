package com.feliscape.artistry.content.block;

import com.feliscape.artistry.content.block.entity.PaintedPotBlockEntity;
import com.feliscape.artistry.content.pot.PaintedPotDecorations;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PaintedPotBlock extends DecoratedPotBlock {
    public PaintedPotBlock(Properties properties) {
        super(properties);
    }

    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof PaintedPotBlockEntity pot) {
            if (level.isClientSide) {
                return ItemInteractionResult.CONSUME;
            } else {
                boolean isDye = DyeColor.getColor(itemStack) != null;
                if (itemStack.is(Items.SPONGE) || isDye){
                    if (applyItem(itemStack, pot, state, level, blockPos, player, blockHitResult)){
                        return ItemInteractionResult.SUCCESS;
                    }
                    return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                } else{
                    ItemStack potItem = pot.getTheItem();
                    if (!itemStack.isEmpty() && (potItem.isEmpty() || ItemStack.isSameItemSameComponents(potItem, itemStack) && potItem.getCount() < potItem.getMaxStackSize())) {
                        pot.wobble(DecoratedPotBlockEntity.WobbleStyle.POSITIVE);
                        player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
                        ItemStack itemstack = itemStack.consumeAndReturn(1, player);
                        float f;
                        if (pot.isEmpty()) {
                            pot.setTheItem(itemstack);
                            f = (float)itemstack.getCount() / (float)itemstack.getMaxStackSize();
                        } else {
                            potItem.grow(1);
                            f = (float)potItem.getCount() / (float)potItem.getMaxStackSize();
                        }

                        level.playSound((Player)null, blockPos, SoundEvents.DECORATED_POT_INSERT, SoundSource.BLOCKS, 1.0F, 0.7F + 0.5F * f);
                        if (level instanceof ServerLevel) {
                            ServerLevel serverlevel = (ServerLevel)level;
                            serverlevel.sendParticles(ParticleTypes.DUST_PLUME, (double)blockPos.getX() + (double)0.5F, (double)blockPos.getY() + 1.2, (double)blockPos.getZ() + (double)0.5F, 7, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F);
                        }

                        pot.setChanged();
                        level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
                        return ItemInteractionResult.SUCCESS;
                    } else {
                        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                    }
                }
            }
        } else {
            return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        }
    }

    public boolean applyItem(ItemStack itemStack, PaintedPotBlockEntity pot, BlockState state, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult){
        boolean isDye = DyeColor.getColor(itemStack) != null;

        if (blockHitResult.getDirection().getAxis().isVertical()){
            if (pot.paintBase(itemStack)){
                level.playSound((Player)null, blockPos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0f);
                if (isDye) itemStack.consume(1, player);
                return true;
            }
        } else{
            Vec3 hitLocation = blockHitResult.getLocation().subtract(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            if (hitLocation.y < 0.25D || hitLocation.y > 0.75D){
                if (pot.paintTrim(itemStack)){
                    level.playSound((Player)null, blockPos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0f);
                    if (isDye) itemStack.consume(1, player);
                    return true;

                }
            } else{
                if (pot.paintPattern(itemStack)){
                    level.playSound((Player)null, blockPos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (isDye) itemStack.consume(1, player);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos pos, BlockState state) {
        return levelReader.getBlockEntity(pos) instanceof PaintedPotBlockEntity pot
                ? pot.getPotAsItem()
                : super.getCloneItemStack(levelReader, pos, state);
    }

    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        BlockEntity var7 = level.getBlockEntity(blockPos);
        if (var7 instanceof PaintedPotBlockEntity pot) {
            level.playSound((Player)null, blockPos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            pot.wobble(DecoratedPotBlockEntity.WobbleStyle.NEGATIVE);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PaintedPotBlockEntity(pos, state);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext context, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, components, tooltipFlag);
        PaintedPotDecorations decorations = itemStack.get(PaintedPotDecorations.type());
        if (decorations != null){
            if (decorations.base().isPresent()){
                components.add(Component.translatable("artistry.painted_pot.base." + decorations.base().get().getName()).withStyle(ChatFormatting.GRAY));
            }
            if (decorations.trim().isPresent()){
                components.add(Component.translatable(Util.makeDescriptionId("painted_pot.trim", decorations.trim().get().location())).withColor(decorations.trimColor()));
            }
            if (decorations.pattern().isPresent()){
                components.add(Component.translatable(Util.makeDescriptionId("painted_pot.pattern", decorations.pattern().get().location())).withColor(decorations.patternColor()));
            }
        }
    }
}
