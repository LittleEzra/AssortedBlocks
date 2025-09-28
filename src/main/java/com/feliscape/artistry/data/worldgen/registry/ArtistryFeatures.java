package com.feliscape.artistry.data.worldgen.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.data.worldgen.feature.HugeGlowingMushroomFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeRedMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ArtistryFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, Artistry.MOD_ID);

    public static final Supplier<Feature<HugeMushroomFeatureConfiguration>> HUGE_GLOWING_MUSHROOM = FEATURES.register(
            "huge_glowing_mushroom", () -> new HugeGlowingMushroomFeature(HugeMushroomFeatureConfiguration.CODEC)
    );

    public static void register(IEventBus eventBus){
        FEATURES.register(eventBus);
    }
}
