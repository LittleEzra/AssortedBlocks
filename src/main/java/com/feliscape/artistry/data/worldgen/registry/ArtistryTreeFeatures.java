package com.feliscape.artistry.data.worldgen.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.data.worldgen.tree.foliage.AspenFoliagePlacer;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.function.Consumer;

public class ArtistryTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_TREE = createKey("aspen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROTTEN_TREE = createKey("rotten");

    private static TreeConfiguration.TreeConfigurationBuilder createAspenTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ArtistryBlocks.ASPEN_LOG.get()),
                new StraightTrunkPlacer(9, 1, 3),

                BlockStateProvider.simple(ArtistryBlocks.ASPEN_LEAVES.get()),
                new AspenFoliagePlacer(ConstantInt.of(3), ConstantInt.of(7), 3, UniformInt.of(9, 11)),

                new TwoLayersFeatureSize(1, 0, 2)
        );
    }
    private static TreeConfiguration.TreeConfigurationBuilder createRottenTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ArtistryBlocks.ROTTEN_LOG.get()),
                new StraightTrunkPlacer(4, 2, 0),

                weightedRandomState(b -> b
                        .add(ArtistryBlocks.ROTTEN_LEAVES.get().defaultBlockState(), 4)
                        .add(Blocks.AIR.defaultBlockState(), 1)
                ),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static WeightedStateProvider weightedRandomState(Consumer<SimpleWeightedRandomList.Builder<BlockState>> builderConsumer) {
        var builder = SimpleWeightedRandomList.<BlockState>builder();
        builderConsumer.accept(builder);
        return new WeightedStateProvider(builder);
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, ASPEN_TREE, Feature.TREE, createAspenTree().build());
        FeatureUtils.register(context, ROTTEN_TREE, Feature.TREE, createRottenTree().build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Artistry.location(name));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(
            Block logBlock, Block leavesBlock, int baseHeight, int heightRandA, int heightRandB, int radius
    ) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new StraightTrunkPlacer(baseHeight, heightRandA, heightRandB),
                BlockStateProvider.simple(leavesBlock),
                new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }
}
