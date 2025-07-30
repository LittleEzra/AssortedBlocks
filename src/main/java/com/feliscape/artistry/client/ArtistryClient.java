package com.feliscape.artistry.client;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.client.atlas.PaintedPotDecorationManager;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Artistry.MOD_ID, dist = Dist.CLIENT)
public class ArtistryClient {
    public ArtistryClient(ModContainer modContainer){
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    private static ReloadListener reloadListeners;

    public static ReloadListener reloadListeners(){
        return reloadListeners;
    }

    public static class ReloadListener {
        PaintedPotDecorationManager paintedPotDecorations;

        public ReloadListener(RegisterClientReloadListenersEvent event){
            reloadListeners = this;
            paintedPotDecorations = new PaintedPotDecorationManager();
            event.registerReloadListener(paintedPotDecorations);
        }

        public PaintedPotDecorationManager getPaintedPotDecorations(){
            return paintedPotDecorations;
        }
    }
}
