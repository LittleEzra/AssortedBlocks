package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.loot.EntityOnBlockLootCondition;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ArtistryLootConditions {
    public static final DeferredRegister<LootItemConditionType> LOOT_CONDITIONS =
            DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, Artistry.MOD_ID);

    public static final Supplier<LootItemConditionType> ENTITY_ON_BLOCK = LOOT_CONDITIONS.register("entity_on_block",
            () -> new LootItemConditionType(EntityOnBlockLootCondition.CODEC));

    public static void register(IEventBus eventBus){
        LOOT_CONDITIONS.register(eventBus);
    }
}
