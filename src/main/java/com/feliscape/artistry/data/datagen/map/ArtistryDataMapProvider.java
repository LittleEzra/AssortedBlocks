package com.feliscape.artistry.data.datagen.map;

import com.feliscape.artistry.data.map.Leechable;
import com.feliscape.artistry.data.map.SnifferPlants;
import com.feliscape.artistry.data.map.Strippable;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryDataMapTypes;
import com.feliscape.artistry.registry.ArtistryItems;
import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.*;

import java.util.List;
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
                .add(ArtistryBlocks.ROTTEN_LEAVES.getId(), new Compostable(0.3F), false)
                .add(ArtistryBlocks.ROTTEN_SAPLING.getId(), new Compostable(0.3F), false)
                .add(ArtistryBlocks.SHORT_TEARDROP_GRASS.getId(), new Compostable(0.3F), false)
                .add(ArtistryBlocks.TALL_TEARDROP_GRASS.getId(), new Compostable(0.3F), false)
        ;
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ArtistryTags.Items.WOODEN_TABLES, new FurnaceFuel(300), false)
        ;
        this.builder(NeoForgeDataMaps.WAXABLES)
                .add(ArtistryBlocks.COPPER_CHAIN, new Waxable(ArtistryBlocks.WAXED_COPPER_CHAIN.get()), false)
                .add(ArtistryBlocks.EXPOSED_COPPER_CHAIN, new Waxable(ArtistryBlocks.WAXED_EXPOSED_COPPER_CHAIN.get()), false)
                .add(ArtistryBlocks.WEATHERED_COPPER_CHAIN, new Waxable(ArtistryBlocks.WAXED_WEATHERED_COPPER_CHAIN.get()), false)
                .add(ArtistryBlocks.OXIDIZED_COPPER_CHAIN, new Waxable(ArtistryBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get()), false)
                .add(ArtistryBlocks.LEECHING_SOIL, new Waxable(ArtistryBlocks.WAXED_LEECHING_SOIL.get()), false)
        ;
        this.builder(NeoForgeDataMaps.OXIDIZABLES)
                .add(ArtistryBlocks.COPPER_CHAIN, new Oxidizable(ArtistryBlocks.EXPOSED_COPPER_CHAIN.get()), false)
                .add(ArtistryBlocks.EXPOSED_COPPER_CHAIN, new Oxidizable(ArtistryBlocks.WEATHERED_COPPER_CHAIN.get()), false)
                .add(ArtistryBlocks.WEATHERED_COPPER_CHAIN, new Oxidizable(ArtistryBlocks.OXIDIZED_COPPER_CHAIN.get()), false)
        ;
        this.builder(ArtistryDataMapTypes.SNIFFER_PLANTS)
                .add(ArtistryTags.Blocks.SNIFFER_HAS_ASPEN_PLANTS, SnifferPlants.create(List.of(
                        ArtistryItems.SUNSPROUT,
                        ArtistryBlocks.ASPEN_SAPLING
                )), false)
                .add(ArtistryTags.Blocks.SNIFFER_HAS_TEARDROP_GRASS, SnifferPlants.create(List.of(
                        ArtistryItems.ANCIENT_TEAR
                )), false)
                .add(ArtistryTags.Blocks.SNIFFER_HAS_LUSH_PLANTS, SnifferPlants.create(List.of(
                        ArtistryItems.FERN_SEED,
                        ArtistryBlocks.BLOOMING_VINES
                )), false)
        ;
        this.builder(ArtistryDataMapTypes.LEECHABLES)
                .add(ArtistryBlocks.BLOOMING_VINES, new Leechable(Blocks.GLOW_LICHEN), false)
                .add(ArtistryTags.Blocks.LEECHABLE_SAPLINGS, new Leechable(ArtistryBlocks.ROTTEN_SAPLING), false)
        ;
        this.builder(ArtistryDataMapTypes.STRIPPABLES)
                .add(ArtistryBlocks.ASPEN_LOG, new Strippable(ArtistryBlocks.STRIPPED_ASPEN_LOG), false)
                .add(ArtistryBlocks.ASPEN_WOOD, new Strippable(ArtistryBlocks.STRIPPED_ASPEN_WOOD), false)
                .add(ArtistryBlocks.ROTTEN_LOG, new Strippable(ArtistryBlocks.STRIPPED_ROTTEN_LOG), false)
                .add(ArtistryBlocks.ROTTEN_WOOD, new Strippable(ArtistryBlocks.STRIPPED_ROTTEN_WOOD), false)
        ;
    }
}
