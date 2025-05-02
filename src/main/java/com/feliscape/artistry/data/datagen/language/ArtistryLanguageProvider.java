package com.feliscape.artistry.data.datagen.language;

import com.feliscape.artistry.Artistry;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public abstract class ArtistryLanguageProvider extends LanguageProvider {
    public ArtistryLanguageProvider(PackOutput output, String locale) {
        super(output, Artistry.MOD_ID, locale);
    }

    protected void addBlockAndItem(Supplier<? extends Block> key, String name) {
        this.addBlock(key, name);
        this.addItem(key.get()::asItem, name);
    }

    protected void addItemTooltip(Supplier<? extends Item> key, String name) {
        add(key.get().getDescriptionId() + ".tooltip", name);
    }
    protected void addMobEffect(Holder<? extends MobEffect> key, String name) {
        add(key.value().getDescriptionId(), name);
    }
    protected void addSubtitle(Supplier<SoundEvent> key, String name) {
        add("subtitle.{}.{}".formatted(Artistry.MOD_ID, key.get().getLocation().getPath()), name);
    }
    protected void addAdvancement(String id, String title, String description) {
        add("advancements.%s.%s.title".formatted(Artistry.MOD_ID, id), title);
        add("advancements.%s.%s.description".formatted(Artistry.MOD_ID, id), description);
    }
    protected void addEnchantment(ResourceKey<Enchantment> key, String name) {
        add("enchantment.%s.%s".formatted(Artistry.MOD_ID, key.location().getPath()), name);
    }
    protected void addDeathMessage(ResourceKey<DamageType> key, String message) {
        add("death.attack.%s".formatted(key.location().toString()), message);
    }
    protected void addDeathMessageItem(ResourceKey<DamageType> key, String message) {
        add("death.attack.%s.item".formatted(key.location().toString()), message);
    }
    protected void addDeathMessagePlayer(ResourceKey<DamageType> key, String message) {
        add("death.attack.%s.player".formatted(key.location().toString()), message);
    }
}
