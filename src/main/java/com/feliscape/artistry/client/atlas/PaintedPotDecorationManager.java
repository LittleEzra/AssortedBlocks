package com.feliscape.artistry.client.atlas;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.data.pot.PaintedPotDecoration;
import com.feliscape.artistry.data.registry.ArtistryDatapackRegistries;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.RecordBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.item.DyeColor;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PaintedPotDecorationManager implements ResourceManagerReloadListener {
    private static Map<DyeColor, Material> BASES;
    private static Map<DyeColor, Material> SIDES;
    private static Map<ResourceKey<PaintedPotDecoration>, Material> TRIMS;
    private static Map<ResourceKey<PaintedPotDecoration>, Material> PATTERNS;

    private static Material createPotBaseMaterial(ResourceLocation assetId) {
        return new Material(ArtistrySheets.PAINTED_POT_BASE_SHEET, assetId.withPrefix("entity/painted_pot/pot/base/"));
    }
    private static Material createPotSideMaterial(ResourceLocation assetId) {
        return new Material(ArtistrySheets.PAINTED_POT_BASE_SHEET, assetId.withPrefix("entity/painted_pot/pot/side/"));
    }
    private static Material createTrimMaterial(ResourceLocation assetId) {
        return new Material(ArtistrySheets.PAINTED_POT_TRIM_SHEET, assetId.withPrefix("entity/painted_pot/trim/"));
    }
    private static Material createPatternMaterial(ResourceLocation assetId) {
        return new Material(ArtistrySheets.PAINTED_POT_PATTERN_SHEET, assetId.withPrefix("entity/painted_pot/pattern/"));
    }

    public Material getSide(Optional<DyeColor> dyeColor){
        if (dyeColor.isEmpty()) return Sheets.DECORATED_POT_SIDE;

        if (SIDES == null) loadMaps();
        if (SIDES == null) return null;

        if (!SIDES.containsKey(dyeColor.get())) return null;
        return SIDES.get(dyeColor.get());
    }

    public Material getBase(Optional<DyeColor> dyeColor){
        if (dyeColor.isEmpty()) return Sheets.DECORATED_POT_BASE;

        if (BASES == null) loadMaps();
        if (BASES == null) return null;

        if (!BASES.containsKey(dyeColor.get())) return null;
        return BASES.get(dyeColor.get());
    }
    @Nullable
    public Material getTrim(ResourceKey<PaintedPotDecoration> key){
        if (TRIMS == null) loadMaps();
        if (TRIMS == null) return null;

        if (!TRIMS.containsKey(key)) return null;
        return TRIMS.get(key);
    }
    @Nullable
    public Material getPattern(ResourceKey<PaintedPotDecoration> key){
        if (PATTERNS == null) loadMaps();
        if (PATTERNS == null) return null;

        if (!PATTERNS.containsKey(key)) return null;
        return PATTERNS.get(key);
    }
    @Nullable
    public Material getPotPaint(ResourceKey<Registry<PaintedPotDecoration>> registry, ResourceKey<PaintedPotDecoration> key){
        if (registry == ArtistryDatapackRegistries.PAINTED_POT_TRIM){
            return getTrim(key);
        }
        if (registry == ArtistryDatapackRegistries.PAINTED_POT_PATTERN){
            return getPattern(key);
        }
        Artistry.LOGGER.error("Tried to get painted pot decoration from invalid registry");
        return null;
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {
        loadMaps();
    }

    private void loadMaps(){
        if (Minecraft.getInstance().getConnection() == null) return;

        var baseBuilder = ImmutableMap.<DyeColor, Material>builder();
        var sideBuilder = ImmutableMap.<DyeColor, Material>builder();
        for (DyeColor d : DyeColor.values()){
            baseBuilder.put(d, createPotBaseMaterial(Artistry.location(d.getName())));
            sideBuilder.put(d, createPotSideMaterial(Artistry.location(d.getName())));
        }
        BASES = baseBuilder.build();
        SIDES = sideBuilder.build();

        TRIMS = Minecraft.getInstance().getConnection().registryAccess().registryOrThrow(ArtistryDatapackRegistries.PAINTED_POT_TRIM).holders()
                .collect(Collectors.toMap(Holder.Reference::key, holder -> createTrimMaterial(holder.value().texture())));
        PATTERNS = Minecraft.getInstance().getConnection().registryAccess().registryOrThrow(ArtistryDatapackRegistries.PAINTED_POT_PATTERN).holders()
                .collect(Collectors.toMap(Holder.Reference::key, holder -> createPatternMaterial(holder.value().texture())));
    }
}
