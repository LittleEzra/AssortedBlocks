package com.feliscape.artistry.data.worldgen.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.data.worldgen.tree.foliage.AspenFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ArtistryFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, Artistry.MOD_ID);

    public static final Supplier<FoliagePlacerType<AspenFoliagePlacer>> ASPEN_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("aspen_foliage_placer", () -> new FoliagePlacerType<>(AspenFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus){
        FOLIAGE_PLACERS.register(eventBus);
    }
}
