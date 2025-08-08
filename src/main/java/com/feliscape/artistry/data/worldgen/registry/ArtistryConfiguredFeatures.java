package com.feliscape.artistry.data.worldgen.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ArtistryConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> TEARDROP_GRASS_BONEMEAL = createKey("teardrop_grass_bonemeal");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        ArtistryTreeFeatures.bootstrap(context);

        FeatureUtils.register(context, TEARDROP_GRASS_BONEMEAL, Feature.RANDOM_PATCH, simplePatchConfiguration(
                Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ArtistryBlocks.SHORT_TEARDROP_GRASS.get())),
                List.of(ArtistryBlocks.TEARDROP_GRASS_BLOCK.get()), 3, 2, 10
        ));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Artistry.location(name));
    }

    public static RandomPatchConfiguration simpleRandomPatchConfiguration(int tries, Holder<PlacedFeature> feature, int xzSpread, int ySpread) {
        return new RandomPatchConfiguration(tries, xzSpread, ySpread, feature);
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> RandomPatchConfiguration simplePatchConfiguration(F feature, FC config, List<Block> blocks, int xzSpread, int ySpread, int tries) {
        return simpleRandomPatchConfiguration(tries, PlacementUtils.filtered(feature, config, simplePatchPredicate(blocks)), xzSpread, ySpread);
    }
    public static <FC extends FeatureConfiguration, F extends Feature<FC>> RandomPatchConfiguration simplePatchConfiguration(F feature, FC config, List<Block> blocks, int xzSpread, int ySpread) {
        return FeatureUtils.simplePatchConfiguration(feature, config, blocks, 96);
    }

    private static BlockPredicate simplePatchPredicate(List<Block> blocks) {
        BlockPredicate blockpredicate;
        if (!blocks.isEmpty()) {
            blockpredicate = BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), blocks));
        } else {
            blockpredicate = BlockPredicate.ONLY_IN_AIR_PREDICATE;
        }

        return blockpredicate;
    }
}
