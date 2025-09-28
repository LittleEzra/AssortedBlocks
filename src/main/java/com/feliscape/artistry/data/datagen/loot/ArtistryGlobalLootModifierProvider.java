package com.feliscape.artistry.data.datagen.loot;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.loot.modifiers.ReplaceSnifferLootModifier;
import com.feliscape.artistry.data.loot.ArtistryLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ArtistryGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ArtistryGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Artistry.MOD_ID);
    }

    @Override
    protected void start() {
        /*add("add_aspen_plants_to_sniffer",
                new ReplaceWithRandomItemModifier(new LootItemCondition[]{
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("gameplay/sniffer_digging")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5F).build(),
                        EntityOnBlockLootCondition.onBlock(ArtistryTags.Blocks.SNIFFER_HAS_ASPEN_PLANTS).build()
                },
                        List.of(ArtistryBlocks.SUNSPROUT.asItem(), ArtistryBlocks.ASPEN_SAPLING.asItem())),
                List.of()
                );
        add("add_teardrop_grass_to_sniffer",
                new ReplaceWithRandomItemModifier(new LootItemCondition[]{
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("gameplay/sniffer_digging")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5F).build(),
                        EntityOnBlockLootCondition.onBlock(ArtistryTags.Blocks.SNIFFER_HAS_TEARDROP_GRASS).build()
                },
                        List.of(ArtistryBlocks.TEARDROP_GRASS.asItem())),
                List.of()
                );
        add("add_lush_plants_to_sniffer",
                new ReplaceWithRandomItemModifier(new LootItemCondition[]{
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("gameplay/sniffer_digging")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5F).build(),
                        EntityOnBlockLootCondition.onBlock(ArtistryTags.Blocks.SNIFFER_HAS_LUSH_PLANTS).build()
                },
                        List.of(ArtistryBlocks.BLOOMING_VINES.asItem(), ArtistryBlocks.LUSH_FERN.asItem())),
                List.of()
                );*/

        add("add_to_sniffer_loot",
                new ReplaceSnifferLootModifier(new LootItemCondition[]{
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("gameplay/sniffer_digging")).build()
                }),
                List.of()
        );
    }
}
