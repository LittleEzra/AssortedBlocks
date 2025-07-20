package com.feliscape.artistry.client;

import com.feliscape.artistry.Artistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Artistry.MOD_ID, dist = Dist.CLIENT)
public class ArtistryClient {
    public ArtistryClient(ModContainer modContainer){
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
