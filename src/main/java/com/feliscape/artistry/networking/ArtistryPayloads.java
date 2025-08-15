package com.feliscape.artistry.networking;

import com.feliscape.artistry.Artistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = Artistry.MOD_ID)
public class ArtistryPayloads {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event){
        final PayloadRegistrar registrar = event.registrar("1");

        registrar.playToClient(
                ArtistryLevelEventPayload.TYPE,
                ArtistryLevelEventPayload.STREAM_CODEC,
                ArtistryLevelEventPayload::handle
        );
    }
}
