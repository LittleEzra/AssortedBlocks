package com.feliscape.artistry.data.worldgen.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.data.worldgen.tree.foliage.AspenFoliagePlacer;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ArtistryTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE = createKey("aspen");

    private static TreeConfiguration.TreeConfigurationBuilder createAspenTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ArtistryBlocks.ASPEN_LOG.get()),
                new StraightTrunkPlacer(9, 1, 3),

                BlockStateProvider.simple(ArtistryBlocks.ASPEN_LEAVES.get()),
                new AspenFoliagePlacer(ConstantInt.of(3), ConstantInt.of(7), 3, UniformInt.of(9, 11)),

                new TwoLayersFeatureSize(1, 0, 2)
        );
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, ASPEN_TREE, Feature.TREE, createAspenTree().build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Artistry.location(name));
    }
}
