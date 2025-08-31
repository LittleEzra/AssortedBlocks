package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.data.map.Leechable;
import com.feliscape.artistry.data.map.SnifferPlants;
import com.feliscape.artistry.data.map.Strippable;
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
    public static final AdvancedDataMapType<Block, SnifferPlants, Default<SnifferPlants, Block>> SNIFFER_PLANTS = AdvancedDataMapType.builder(
            Artistry.location("sniffer_plants"),
            Registries.BLOCK,
            SnifferPlants.CODEC
    ).merger(SnifferPlants.merger()).build();
    public static final DataMapType<Block, Leechable> LEECHABLES = DataMapType.builder(
            Artistry.location("leechables"),
            Registries.BLOCK,
            Leechable.CODEC
    ).build();
    public static final DataMapType<Block, Strippable> STRIPPABLES = AdvancedDataMapType.builder(
            Artistry.location("strippables"),
            Registries.BLOCK,
            Strippable.CODEC
    ).build();

    @SubscribeEvent
    private static void registerDataMapTypes(RegisterDataMapTypesEvent event){
        event.register(SNIFFER_PLANTS);
        event.register(LEECHABLES);
        event.register(STRIPPABLES);
    }
}
