package com.feliscape.artistry.data.datagen;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.data.pot.ArtistryPaintedPotDecorations;
import com.feliscape.artistry.data.registry.ArtistryDatapackRegistries;
import com.feliscape.artistry.data.worldgen.registry.ArtistryConfiguredFeatures;
import com.feliscape.artistry.data.worldgen.registry.ArtistryTreeFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ArtistryGeneratedEntries extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ArtistryConfiguredFeatures::bootstrap)
            .add(ArtistryDatapackRegistries.PAINTED_POT_PATTERN, ArtistryPaintedPotDecorations::bootstrapPatterns)
            .add(ArtistryDatapackRegistries.PAINTED_POT_TRIM, ArtistryPaintedPotDecorations::bootstrapTrims)
            ;
    public ArtistryGeneratedEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Artistry.MOD_ID));
    }
}
