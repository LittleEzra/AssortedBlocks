package com.feliscape.artistry.client;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryBlockEntityTypes;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
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
        public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event){
            event.registerBlockEntityRenderer(ArtistryBlockEntityTypes.MOD_SIGN.get(), SignRenderer::new);
            event.registerBlockEntityRenderer(ArtistryBlockEntityTypes.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
        }
    }
}
