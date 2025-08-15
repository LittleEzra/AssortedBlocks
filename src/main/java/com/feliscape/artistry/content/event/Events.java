package com.feliscape.artistry.content.event;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.entity.PaintedPotBlockEntity;
import com.feliscape.artistry.content.entity.ai.RunAwayFromBlockGoal;
import com.feliscape.artistry.registry.ArtistryAttachmentTypes;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
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
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

@EventBusSubscriber(modid = Artistry.MOD_ID)
public class Events {
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

    @SubscribeEvent
    public static void onEntitySpawn(EntityJoinLevelEvent event){
        Entity entity = event.getEntity();
        if (entity instanceof PathfinderMob mob && entity.isAlive() && !entity.getType().is(ArtistryTags.EntityTypes.NOT_SCARED_OF_CORPSE_FLOWER)){
            if (mob.goalSelector.getAvailableGoals().stream().anyMatch(goal -> goal.getGoal() instanceof RunAwayFromBlockGoal runAway &&
                    runAway.block().test(ArtistryBlocks.CORPSE_FLOWER.get().defaultBlockState()))) return;

            mob.goalSelector.addGoal(3, new RunAwayFromBlockGoal(mob, ArtistryBlocks.CORPSE_FLOWER.get(), 1.2D));
        }
    }

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event){
        Entity entity = event.getEntity();
        if (entity instanceof Sniffer sniffer && sniffer.tickCount % 10 == 0){
            int motivation = sniffer.getData(ArtistryAttachmentTypes.SNIFFER_MOTIVATION);
            if (motivation > 0 && sniffer.getBrain().hasMemoryValue(MemoryModuleType.SNIFF_COOLDOWN)){
                sniffer.getBrain().eraseMemory(MemoryModuleType.SNIFF_COOLDOWN);
                sniffer.setData(ArtistryAttachmentTypes.SNIFFER_MOTIVATION, motivation - 1);
            }
        }
    }
}
