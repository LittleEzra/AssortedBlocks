package com.feliscape.artistry.data.pot;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.data.registry.ArtistryDatapackRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;

public class ArtistryPaintedPotDecorations {
    public static final ResourceKey<PaintedPotDecoration> WAVY_TRIM = createTrimKey("wavy");
    public static final ResourceKey<PaintedPotDecoration> TICKED_TRIM = createTrimKey("ticked");
    public static final ResourceKey<PaintedPotDecoration> MAW_TRIM = createTrimKey("maw");
    public static final ResourceKey<PaintedPotDecoration> PYRAMIDS_TRIM = createTrimKey("pyramids");
    public static final ResourceKey<PaintedPotDecoration> CORNERS_TRIM = createTrimKey("corners");
    public static final ResourceKey<PaintedPotDecoration> BOW_TRIM = createTrimKey("bow");

    public static final ResourceKey<PaintedPotDecoration> FREQUENCY_PATTERN = createPatternKey("frequency");
    public static final ResourceKey<PaintedPotDecoration> RINGS_PATTERN = createPatternKey("rings");
    public static final ResourceKey<PaintedPotDecoration> DOTS_PATTERN = createPatternKey("dots");
    public static final ResourceKey<PaintedPotDecoration> CROSS_PATTERN = createPatternKey("cross");
    public static final ResourceKey<PaintedPotDecoration> WAVE_PATTERN = createPatternKey("wave");
    public static final ResourceKey<PaintedPotDecoration> WEAVE_PATTERN = createPatternKey("weave");

    public static void bootstrapTrims(BootstrapContext<PaintedPotDecoration> context) {
        context.register(WAVY_TRIM, new PaintedPotDecoration(Artistry.location("wavy")));
        context.register(TICKED_TRIM, new PaintedPotDecoration(Artistry.location("ticked")));
        context.register(MAW_TRIM, new PaintedPotDecoration(Artistry.location("maw")));
        context.register(PYRAMIDS_TRIM, new PaintedPotDecoration(Artistry.location("pyramids")));
        context.register(CORNERS_TRIM, new PaintedPotDecoration(Artistry.location("corners")));
        context.register(BOW_TRIM, new PaintedPotDecoration(Artistry.location("bow")));
    }
    public static void bootstrapPatterns(BootstrapContext<PaintedPotDecoration> context) {
        context.register(FREQUENCY_PATTERN, new PaintedPotDecoration(Artistry.location("frequency")));
        context.register(RINGS_PATTERN, new PaintedPotDecoration(Artistry.location("rings")));
        context.register(DOTS_PATTERN, new PaintedPotDecoration(Artistry.location("dots")));
        context.register(CROSS_PATTERN, new PaintedPotDecoration(Artistry.location("cross")));
        context.register(WAVE_PATTERN, new PaintedPotDecoration(Artistry.location("wave")));
        context.register(WEAVE_PATTERN, new PaintedPotDecoration(Artistry.location("weave")));
    }

    public static ResourceKey<PaintedPotDecoration> createTrimKey(String name) {
        return ResourceKey.create(ArtistryDatapackRegistries.PAINTED_POT_TRIM, Artistry.location(name));
    }
    public static ResourceKey<PaintedPotDecoration> createPatternKey(String name) {
        return ResourceKey.create(ArtistryDatapackRegistries.PAINTED_POT_PATTERN, Artistry.location(name));
    }
}
