package com.feliscape.artistry.client;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.client.render.entity.ModBoatRenderer;
import com.feliscape.artistry.registry.ArtistryBlockEntityTypes;
import com.feliscape.artistry.registry.ArtistryEntityTypes;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class ClientEvents {
    //@EventBusSubscriber(modid = Artistry.MOD_ID, value = Dist.CLIENT)
    public static class ClientGameEvents{

    }

    @EventBusSubscriber(modid = Artistry.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents{

        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
            event.registerLayerDefinition(ArtistryModelLayers.ASPEN_BOAT, BoatModel::createBodyModel);
            event.registerLayerDefinition(ArtistryModelLayers.ASPEN_CHEST_BOAT, ChestBoatModel::createBodyModel);
        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event){
            event.registerEntityRenderer(ArtistryEntityTypes.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            event.registerEntityRenderer(ArtistryEntityTypes.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));

            event.registerBlockEntityRenderer(ArtistryBlockEntityTypes.MOD_SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(ArtistryBlockEntityTypes.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
        }
    }
}
