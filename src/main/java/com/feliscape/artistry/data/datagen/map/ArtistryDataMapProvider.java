package com.feliscape.artistry.data.datagen.map;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ArtistryDataMapProvider extends DataMapProvider {
    public ArtistryDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ArtistryBlocks.BLOOMING_VINES.getId(), new Compostable(0.3F), false)
                .add(ArtistryBlocks.LUSH_FERN.getId(), new Compostable(0.3F), false)
                .add(ArtistryItems.SUNBURST_VINES.getId(), new Compostable(0.3F), false)
                .add(ArtistryItems.SUNSPROUT.getId(), new Compostable(0.3F), false)
                .add(ArtistryItems.FERN_SEED.getId(), new Compostable(0.3F), false)
                .add(ArtistryBlocks.ASPEN_LEAVES.getId(), new Compostable(0.3F), false)
                .add(ArtistryBlocks.ASPEN_SAPLING.getId(), new Compostable(0.3F), false)
        ;
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ArtistryTags.Items.WOODEN_TABLES, new FurnaceFuel(300), false)
        ;
    }
}
