package com.feliscape.artistry.data.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.pot.PaintedPotDecorations;
import com.feliscape.artistry.data.pot.PaintedPotDecoration;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;

@EventBusSubscriber(modid = Artistry.MOD_ID)
public class ArtistryDatapackRegistries {
    public static final ResourceKey<Registry<PaintedPotDecoration>> PAINTED_POT_PATTERN = ResourceKey.createRegistryKey(Artistry.location("painted_pot/pattern"));
    public static final ResourceKey<Registry<PaintedPotDecoration>> PAINTED_POT_TRIM = ResourceKey.createRegistryKey(Artistry.location("painted_pot/trim"));

    @SubscribeEvent
    public static void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event){
        event.dataPackRegistry(PAINTED_POT_PATTERN, PaintedPotDecoration.DIRECT_CODEC, PaintedPotDecoration.DIRECT_CODEC);
        event.dataPackRegistry(PAINTED_POT_TRIM, PaintedPotDecoration.DIRECT_CODEC, PaintedPotDecoration.DIRECT_CODEC);
    }
}
