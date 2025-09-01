package com.feliscape.artistry.data.datagen.loot;

import com.feliscape.artistry.data.loot.ArtistryLootTables;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import java.util.function.BiConsumer;

public class ArtistryGLMBlockLootProvider implements LootTableSubProvider {
    private final HolderLookup.Provider registries;

    public ArtistryGLMBlockLootProvider(HolderLookup.Provider registries) {
        this.registries = registries;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        output.accept(ArtistryLootTables.GOLDEN_BULB_DROP, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(ArtistryItems.GOLDEN_BULB)))
        );
    }
}
