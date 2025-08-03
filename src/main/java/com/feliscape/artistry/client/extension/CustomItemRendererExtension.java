package com.feliscape.artistry.client.extension;

import com.feliscape.artistry.client.render.ArtistrySpecialItemRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class CustomItemRendererExtension implements IClientItemExtensions {
    private final ArtistrySpecialItemRenderer renderer = new ArtistrySpecialItemRenderer();

    @Override
    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        return renderer;
    }
}
