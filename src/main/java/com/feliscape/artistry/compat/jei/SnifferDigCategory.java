package com.feliscape.artistry.compat.jei;

import com.feliscape.artistry.Artistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.crafting.IngredientType;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

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
        return 96;
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
        builder.addInputSlot(6, 4).addItemLike(entry.item());
        if (entry.block() == null){
            //if (Minecraft.getInstance().getConnection() == null) return;
            //var registryAccess = Minecraft.getInstance().getConnection().registryAccess();
            Optional<HolderSet.Named<Block>> registry = BuiltInRegistries.BLOCK.getTag(BlockTags.SNIFFER_DIGGABLE_BLOCK);
            if (registry.isPresent()){
                addHolderSetSlot(builder, 74, 4, registry.get());
            }

        } else if (entry.block().blocks().isPresent()){
            builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 74, 4).addItemStacks(entry.block().blocks().get().stream().map(Holder::value).map(ItemStack::new).toList());
        }
    }

    private void addHolderSetSlot(IRecipeLayoutBuilder builder, int x, int y, HolderSet.Named<Block> holders) {
        builder.addInputSlot(74, 4).addItemStacks(holders.stream().map(holder -> new ItemStack(holder.value())).toList());
    }

    @Override
    public void draw(SnifferDigEntry entry, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);

        guiGraphics.drawString(Minecraft.getInstance().font, Component.translatable("artistry.jei.sniffer_dig.found_in"),
                27, 9, 0x8b8b8b, false);
    }
}
