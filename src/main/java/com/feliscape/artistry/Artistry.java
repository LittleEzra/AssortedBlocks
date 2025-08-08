package com.feliscape.artistry;

import com.feliscape.artistry.data.worldgen.registry.ArtistryFoliagePlacers;
import com.feliscape.artistry.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Artistry.MOD_ID)
public class Artistry
{
    public static final String MOD_ID = "artistry";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Artistry(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        ArtistryBlocks.register(modEventBus);
        ArtistryItems.register(modEventBus);
        ArtistryDataComponents.register(modEventBus);

        ArtistryCreativeModeTabs.register(modEventBus);

        ArtistryBlockEntityTypes.register(modEventBus);
        ArtistryEntityTypes.register(modEventBus);

        ArtistryLootModifiers.register(modEventBus);
        ArtistryLootConditions.register(modEventBus);

        ArtistryParticles.register(modEventBus);

        ArtistryFoliagePlacers.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static String stringLocation(String path){
        return MOD_ID + ":" + path;
    }
    public static ResourceLocation location(String path){
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ArtistryBlocks.ASPEN_SAPLING.getId(), ArtistryBlocks.POTTED_ASPEN_SAPLING);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ArtistryBlocks.SHORT_TEARDROP_GRASS.getId(), ArtistryBlocks.POTTED_TEARDROP_GRASS);
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
}
