package com.feliscape.artistry.client.render.entity;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.entity.ModBoat;
import com.feliscape.artistry.content.entity.ModChestBoat;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class ModBoatRenderer extends BoatRenderer {
    private final Map<ModBoat.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public ModBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.boatResources = Stream.of(ModBoat.Type.values()).collect(ImmutableMap.toImmutableMap(type -> type,
                type -> Pair.of(Artistry.location(getTextureLocation(type, pChestBoat)), this.createBoatModel(pContext, type, pChestBoat))));
    }

    private static String getTextureLocation(ModBoat.Type pType, boolean pChestBoat) {
        return pChestBoat ? "textures/entity/chest_boat/" + pType.getName() + ".png" : "textures/entity/boat/" + pType.getName() + ".png";
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context pContext, ModBoat.Type pType, boolean pChestBoat) {
        ModelLayerLocation modellayerlocation = pChestBoat ? ModBoatRenderer.createChestBoatModelName(pType) : ModBoatRenderer.createBoatModelName(pType);
        ModelPart modelpart = pContext.bakeLayer(modellayerlocation);
        return pChestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
    }

    public static ModelLayerLocation createBoatModelName(ModBoat.Type pType) {
        return createLocation("boat/" + pType.getName(), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(ModBoat.Type pType) {
        return createLocation("chest_boat/" + pType.getName(), "main");
    }

    private static ModelLayerLocation createLocation(String pPath, String pModel) {
        return new ModelLayerLocation(Artistry.location(pPath), pModel);
    }

    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if(boat instanceof ModBoat modBoat) {
            return this.boatResources.get(modBoat.getModVariant());
        } else if(boat instanceof ModChestBoat modChestBoatEntity) {
            return this.boatResources.get(modChestBoatEntity.getModVariant());
        } else {
            return null;
        }
    }
}
