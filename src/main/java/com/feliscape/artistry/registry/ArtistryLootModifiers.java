package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.loot.modifiers.AddEnchantmentModifier;
import com.feliscape.artistry.content.loot.modifiers.AddItemModifier;
import com.feliscape.artistry.content.loot.modifiers.ReplaceWithRandomItemModifier;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ArtistryLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS =
            DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Artistry.MOD_ID);

    public static final Supplier<MapCodec<AddItemModifier>> ADD_ITEM = LOOT_MODIFIERS.register("add_item",
            () -> AddItemModifier.CODEC);
    public static final Supplier<MapCodec<AddEnchantmentModifier>> ADD_ENCHANTMENT = LOOT_MODIFIERS.register("add_enchantment",
            () -> AddEnchantmentModifier.CODEC);
    public static final Supplier<MapCodec<ReplaceWithRandomItemModifier>> ADD_RANDOM_ITEM = LOOT_MODIFIERS.register("add_random_item",
            () -> ReplaceWithRandomItemModifier.CODEC);

    public static void register(IEventBus eventBus){
        LOOT_MODIFIERS.register(eventBus);
    }
}
