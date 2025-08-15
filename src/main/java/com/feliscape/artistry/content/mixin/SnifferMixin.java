package com.feliscape.artistry.content.mixin;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryAttachmentTypes;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;

@Mixin(Sniffer.class)
public abstract class SnifferMixin extends Animal {

    @Shadow abstract Optional<BlockPos> calculateDigPosition();

    @Shadow public abstract Sniffer transitionTo(Sniffer.State state);

    protected SnifferMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    public void onMobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.is(ArtistryItems.SNIFFER_CAKE)){
            this.level().playSound((Player)null, this, this.getEatingSound(itemStack), SoundSource.NEUTRAL, 1.0F,
                    Mth.randomBetween(this.level().random, 0.8F, 1.2F));

            if (!this.level().isClientSide()){
                //var brain = this.getBrain();
                /*if (brain.hasMemoryValue(MemoryModuleType.SNIFF_COOLDOWN)) {
                    brain.eraseMemory(MemoryModuleType.SNIFF_COOLDOWN);
                }*/
                this.setData(ArtistryAttachmentTypes.SNIFFER_MOTIVATION, 3);
            } else{
                for (int i = 0; i < 10; i++){
                    this.level().addParticle(ParticleTypes.HAPPY_VILLAGER,
                            this.getRandomX((double)1.0F), this.getRandomY() + (double)0.5F, this.getRandomZ((double)1.0F),
                            (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }
            itemStack.consume(1, player);

            cir.setReturnValue(InteractionResult.SUCCESS);
        }
    }
}
