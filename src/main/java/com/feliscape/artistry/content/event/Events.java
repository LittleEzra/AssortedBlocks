package com.feliscape.artistry.content.event;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.entity.PaintedPotBlockEntity;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class Events {
    @EventBusSubscriber(modid = Artistry.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
    public static class GameEvents{

        @SubscribeEvent
        public static void rightClickBlock(PlayerInteractEvent.RightClickBlock event){
            Level level = event.getLevel();
            BlockPos pos = event.getHitVec().getBlockPos();
            BlockState blockState = event.getLevel().getBlockState(pos);
            ItemStack itemStack = event.getItemStack();
            if (blockState.is(Blocks.DECORATED_POT) && DyeColor.getColor(itemStack) != null){
                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
                BlockEntity oldEntity = level.getBlockEntity(pos);
                ItemStack stackToTransfer = ItemStack.EMPTY;
                if (oldEntity instanceof DecoratedPotBlockEntity decoratedPot){
                    stackToTransfer = decoratedPot.getTheItem();
                    decoratedPot.setTheItem(ItemStack.EMPTY);
                }

                BlockState newState = ArtistryBlocks.PAINTED_POT.get().withPropertiesOf(blockState);
                level.setBlock(pos, newState, Block.UPDATE_NONE);

                BlockEntity newEntity = level.getBlockEntity(pos);
                if (newEntity instanceof PaintedPotBlockEntity paintedPot){
                    ArtistryBlocks.PAINTED_POT.get().applyItem(itemStack, paintedPot, newState, level, pos, event.getEntity(), event.getHitVec());
                    paintedPot.setTheItem(stackToTransfer);
                }
            }
        }
    }
}
