package com.feliscape.artistry.data.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ArtistryLootProvider extends LootTableProvider {

    public ArtistryLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(ArtistryBlockLootTableProvider::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(ArtistryGLMBlockLootProvider::new, LootContextParamSets.BLOCK)
                ),
                registries);
    }
}
