package com.feliscape.artistry.compat.jei;

import com.feliscape.artistry.Artistry;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEIArtistryPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return Artistry.location("jei_plugin");
    }
}
