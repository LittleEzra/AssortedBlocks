package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.datamaps.*;
import net.neoforged.neoforge.registries.datamaps.DataMapValueRemover.Default;

import java.util.List;

@EventBusSubscriber(modid = Artistry.MOD_ID)
public class ArtistryDataMapTypes {
    public static final AdvancedDataMapType<Block, List<Item>, Default<List<Item>, Block>> SNIFFER_PLANTS = AdvancedDataMapType.builder(
            Artistry.location("sniffer_plants"),
            Registries.BLOCK,
            BuiltInRegistries.ITEM.byNameCodec().listOf()
    ).merger(DataMapValueMerger.listMerger()).build();

    @SubscribeEvent
    private static void registerDataMapTypes(RegisterDataMapTypesEvent event){
        event.register(SNIFFER_PLANTS);
    }
}
