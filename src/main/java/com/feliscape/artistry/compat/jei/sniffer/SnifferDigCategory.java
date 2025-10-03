package com.feliscape.artistry.compat.jei.sniffer;

import com.feliscape.artistry.Artistry;
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

public class SnifferDigCategory implements IRecipeCategory<SnifferDigEntry> {
    public static final ResourceLocation LOCATION = Artistry.location("sniffer_dig");
    public static final ResourceLocation BACKGROUND = Artistry.location("textures/gui/jei/sniffer_dig.png");

    public static final RecipeType<SnifferDigEntry> TYPE = new RecipeType<>(LOCATION, SnifferDigEntry.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SnifferDigCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(BACKGROUND, 0, 0, getWidth(), getHeight());
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.SNIFFER_EGG));
    }

    @Override
    public RecipeType<SnifferDigEntry> getRecipeType() {
        return TYPE;
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
    public Component getTitle() {
        return Component.translatable("artistry.jei.sniffer_dig.title");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SnifferDigEntry entry, IFocusGroup focuses) {
        builder.addOutputSlot(6, 4).addItemLike(entry.item());
        builder.addSlot(RecipeIngredientRole.CATALYST, 98, 4).addItemStacks(entry.block().stream().map(holder -> new ItemStack(holder.value())).toList());
    }

    @Override
    public void draw(SnifferDigEntry entry, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);

        Component text = Component.translatable("artistry.jei.sniffer_dig.found_in");
        guiGraphics.drawString(Minecraft.getInstance().font, text,
                60 - Minecraft.getInstance().font.width(text) / 2, 9, 0x8b8b8b, false);
    }
}
