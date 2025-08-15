package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.mojang.serialization.Codec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ArtistryAttachmentTypes {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(
            NeoForgeRegistries.ATTACHMENT_TYPES, Artistry.MOD_ID
    );

    public static final Supplier<AttachmentType<Integer>> SNIFFER_MOTIVATION = ATTACHMENT_TYPES.register("sniffer_motivation",
            () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());

    public static void register(IEventBus eventBus){
        ATTACHMENT_TYPES.register(eventBus);
    }
}
