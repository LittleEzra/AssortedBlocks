package com.feliscape.artistry.data.datagen.loot;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.loot.modifiers.ReplaceWithRandomItemModifier;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ArtistryGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ArtistryGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Artistry.MOD_ID);
    }

    @Override
    protected void start() {
        add("add_to_sniffer_loot",
                new ReplaceWithRandomItemModifier(new LootItemCondition[]{
                        LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("gameplay/sniffer_digging")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5F).build()
                },
                List.of(ArtistryBlocks.SUNSPROUT.asItem(), ArtistryBlocks.BLOOMING_VINES.asItem())),
                List.of()
                );
    }
}
