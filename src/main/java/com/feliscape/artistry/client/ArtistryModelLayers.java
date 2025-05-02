package com.feliscape.artistry.client;

import com.feliscape.artistry.Artistry;
import com.google.common.collect.Sets;
import net.minecraft.client.model.geom.ModelLayerLocation;

import java.util.Set;
import java.util.stream.Stream;

public class ArtistryModelLayers {
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();

    public static final ModelLayerLocation ASPEN_BOAT = register("boat/aspen");
    public static final ModelLayerLocation ASPEN_CHEST_BOAT = register("chest_boat/aspen");

    private static ModelLayerLocation register(String path) {
        return register(path, "main");
    }

    private static ModelLayerLocation register(String path, String model) {
        ModelLayerLocation modellayerlocation = createLocation(path, model);
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    private static ModelLayerLocation createLocation(String path, String model) {
        return new ModelLayerLocation(Artistry.location(path), model);
    }

    public static Stream<ModelLayerLocation> getKnownLocations() {
        return ALL_MODELS.stream();
    }
}
