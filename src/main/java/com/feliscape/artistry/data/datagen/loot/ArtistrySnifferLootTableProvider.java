package com.feliscape.artistry.data.datagen.loot;

import com.feliscape.artistry.content.loot.EntityOnBlockLootCondition;
import com.feliscape.artistry.data.loot.ArtistryLootTables;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.function.BiConsumer;

import static net.minecraft.world.level.storage.loot.LootPool.lootPool;
import static net.minecraft.world.level.storage.loot.LootTable.lootTable;

public class ArtistrySnifferLootTableProvider implements LootTableSubProvider {
    protected static final LootItemCondition.Builder ON_ASPEN_PLANT_BLOCK = EntityOnBlockLootCondition.onBlock(ArtistryTags.Blocks.SNIFFER_HAS_ASPEN_PLANTS);
    protected static final LootItemCondition.Builder ON_TEARDROP_GRASS_BLOCK = EntityOnBlockLootCondition.onBlock(ArtistryTags.Blocks.SNIFFER_HAS_TEARDROP_GRASS);
    protected static final LootItemCondition.Builder ON_LUSH_PLANT_BLOCK = EntityOnBlockLootCondition.onBlock(ArtistryTags.Blocks.SNIFFER_HAS_LUSH_PLANTS);

    protected final HolderLookup.Provider registries;

    public ArtistrySnifferLootTableProvider(HolderLookup.Provider registries) {
        this.registries = registries;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(ArtistryLootTables.SNIFFER_ADDITIONAL, lootTable()
                .withPool(lootPool()
                        .add(LootItem.lootTableItem(ArtistryBlocks.SUNSPROUT).when(ON_ASPEN_PLANT_BLOCK))
                        .add(LootItem.lootTableItem(ArtistryBlocks.ASPEN_SAPLING).when(ON_ASPEN_PLANT_BLOCK))
                        .add(LootItem.lootTableItem(ArtistryItems.ANCIENT_TEAR).when(ON_TEARDROP_GRASS_BLOCK))
                        .add(LootItem.lootTableItem(ArtistryBlocks.BLOOMING_VINES).when(ON_LUSH_PLANT_BLOCK))
                        .add(LootItem.lootTableItem(ArtistryItems.FERN_SEED).when(ON_LUSH_PLANT_BLOCK))
                )
        );
    }
}
