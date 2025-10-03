package com.feliscape.artistry.compat.jei.leeching;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.compat.jei.sniffer.SnifferDigEntry;
import com.feliscape.artistry.registry.ArtistryBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;

public class LeechingCategory implements IRecipeCategory<LeechingEntry> {
    public static final ResourceLocation LOCATION = Artistry.location("leeching");
    public static final ResourceLocation BACKGROUND = Artistry.location("textures/gui/jei/leeching.png");

    public static final RecipeType<LeechingEntry> TYPE = new RecipeType<>(LOCATION, LeechingEntry.class);

    private final IDrawable background;
    private final IDrawable icon;

    public LeechingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(BACKGROUND, 0, 0, getWidth(), getHeight());
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ArtistryBlocks.LEECHING_SOIL));
    }

    @Override
    public int getWidth() {
        return 120;
    }

    @Override
    public int getHeight() {
        return 24;
    }

    @Override
    public RecipeType<LeechingEntry> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("artistry.jei.leeching.title");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, LeechingEntry entry, IFocusGroup focuses) {
        builder.addOutputSlot(98, 4).addItemLike(entry.item());
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 52, 4).addItemLike(ArtistryBlocks.LEECHING_SOIL);
        builder.addSlot(RecipeIngredientRole.INPUT, 6, 4).addItemStacks(entry.unleeched().stream().map(holder -> new ItemStack(holder.value())).toList());
    }

    @Override
    public void draw(LeechingEntry entry, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics);
    }
}
