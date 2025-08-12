package com.feliscape.artistry.compat.jei;

import com.feliscape.artistry.Artistry;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.Optional;

@JeiPlugin
public class JEIArtistryPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return Artistry.location("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SnifferDigCategory(registration.getJeiHelpers().getGuiHelper()));

        getLevel().ifPresent(SnifferDigEntryCollector.getInstance()::collect);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(SnifferDigCategory.TYPE, SnifferDigEntryCollector.getInstance().getEntries());
    }

    private static Optional<Level> getLevel(){
        Minecraft minecraft = Minecraft.getInstance();
        return Optional.of(minecraft)
                .map(Minecraft::getSingleplayerServer)
                .map(integratedServer -> integratedServer.getLevel(Level.OVERWORLD));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(Items.SNIFFER_EGG, SnifferDigCategory.TYPE);
    }
}
