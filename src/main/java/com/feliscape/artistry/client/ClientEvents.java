package com.feliscape.artistry.client;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.client.atlas.ArtistrySheets;
import com.feliscape.artistry.client.extension.CustomItemRendererExtension;
import com.feliscape.artistry.client.model.UrnModel;
import com.feliscape.artistry.client.render.blockentity.PaintedPotRenderer;
import com.feliscape.artistry.client.render.blockentity.UrnRenderer;
import com.feliscape.artistry.client.render.entity.ModBoatRenderer;
import com.feliscape.artistry.content.block.entity.SparkFountainBlockEntity;
import com.feliscape.artistry.registry.ArtistryBlockEntityTypes;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryEntityTypes;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMaterialAtlasesEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(modid = Artistry.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerMaterialAtlases(RegisterMaterialAtlasesEvent event){
        event.register(ArtistrySheets.PAINTED_POT_BASE_SHEET, Artistry.location("painted_pot/pot"));
        event.register(ArtistrySheets.PAINTED_POT_TRIM_SHEET, Artistry.location("painted_pot/trim"));
        event.register(ArtistrySheets.PAINTED_POT_PATTERN_SHEET, Artistry.location("painted_pot/pattern"));
    }
    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event){
        event.register(((itemStack, index) -> index > 0 ? -1 : DyedItemColor.getOrDefault(itemStack, SparkFountainBlockEntity.DEFAULT_SPARK_COLOR_RGB)),
                ArtistryBlocks.SPARK_FOUNTAIN);
    }
    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event){
        event.register(((blockState, blockAndTintGetter, blockPos, index) -> {
            if (index > 0 && blockAndTintGetter != null && blockPos != null){
                BlockEntity entity = blockAndTintGetter.getBlockEntity(blockPos);
                if (entity instanceof SparkFountainBlockEntity fountain){
                    return fountain.getColor();
                }
            }
            return -1;
        }), ArtistryBlocks.SPARK_FOUNTAIN.get());
    }
    @SubscribeEvent
    public static void registerClientReloadListeners(RegisterClientReloadListenersEvent event){
        new ArtistryClient.ReloadListener(event);
    }
    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event){
        event.registerItem(new CustomItemRendererExtension(), ArtistryItems.PAINTED_POT);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ArtistryModelLayers.ASPEN_BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(ArtistryModelLayers.ASPEN_CHEST_BOAT, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(ArtistryModelLayers.ROTTEN_BOAT, BoatModel::createBodyModel);
        event.registerLayerDefinition(ArtistryModelLayers.ROTTEN_CHEST_BOAT, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(ArtistryModelLayers.URN, UrnModel::createLayer);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ArtistryEntityTypes.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
        event.registerEntityRenderer(ArtistryEntityTypes.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));

        event.registerBlockEntityRenderer(ArtistryBlockEntityTypes.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ArtistryBlockEntityTypes.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
        event.registerBlockEntityRenderer(ArtistryBlockEntityTypes.PAINTED_POT.get(), PaintedPotRenderer::new);
        event.registerBlockEntityRenderer(ArtistryBlockEntityTypes.URN.get(), UrnRenderer::new);
    }
}
