package com.feliscape.artistry.data.datagen.model;


import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class ArtistryItemModelProvider extends ItemModelProvider {

    public ArtistryItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Artistry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        blockItemSprite(ArtistryBlocks.ASPEN_DOOR);

        manualBlockItem(ArtistryBlocks.STONE_PILLAR);
        manualBlockItem(ArtistryBlocks.MOSSY_STONE_PILLAR);

        manualBlockItem(ArtistryBlocks.ASPEN_LOG);
        manualBlockItem(ArtistryBlocks.ASPEN_WOOD);
        manualBlockItem(ArtistryBlocks.STRIPPED_ASPEN_LOG);
        manualBlockItem(ArtistryBlocks.STRIPPED_ASPEN_WOOD);

        manualBlockItem(ArtistryBlocks.ASPEN_STAIRS);
        manualBlockItem(ArtistryBlocks.ASPEN_SLAB);
        manualBlockItem(ArtistryBlocks.ASPEN_PRESSURE_PLATE);
        manualBlockItem(ArtistryBlocks.ASPEN_FENCE_GATE);
        buttonItem(ArtistryBlocks.ASPEN_BUTTON, ArtistryBlocks.ASPEN_PLANKS);
        fenceItem(ArtistryBlocks.ASPEN_FENCE, ArtistryBlocks.ASPEN_PLANKS);
        trapdoorItem(ArtistryBlocks.ASPEN_TRAPDOOR);

        generatedBlockItem(ArtistryBlocks.ASPEN_SAPLING);

        simpleItem(ArtistryItems.ASPEN_SIGN);
        simpleItem(ArtistryItems.ASPEN_HANGING_SIGN);
        simpleItem(ArtistryItems.ASPEN_BOAT);
        simpleItem(ArtistryItems.ASPEN_CHEST_BOAT);
    }

    private ItemModelBuilder simpleItem(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                Artistry.location("item/" + getLocation(item.get()).getPath()));
    }
    private ItemModelBuilder handheldItem(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld")).texture("layer0",
                Artistry.location("item/" + getLocation(item.get()).getPath()));
    }
    private ItemModelBuilder rotatedHandheldItem(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                Artistry.location("item/rotated_handheld")).texture("layer0",
                Artistry.location("item/" + getLocation(item.get()).getPath()));
    }

    public void manualBlockItem(Supplier<? extends Block> block) {
        this.withExistingParent(Artistry.MOD_ID + ":" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(Supplier<? extends Block> block) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
                modLoc("block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(Supplier<? extends Block> block, Supplier<? extends Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  Artistry.location("block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(Supplier<? extends Block> block, Supplier<? extends Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  Artistry.location("block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(Supplier<? extends Block> block, Supplier<? extends Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  Artistry.location("block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder blockItemSprite(Supplier<? extends Block> block) { // Uses a block instead of item (Example: Doors)
        return withExistingParent(getBlockLocation(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                Artistry.location("item/" + getBlockLocation(block.get()).getPath()));
    }
    private ItemModelBuilder generatedBlockItem(Supplier<? extends Block> block) { // Uses the texture from textures/block (Example: Saplings)
        return withExistingParent(getBlockLocation(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                Artistry.location("block/" + getBlockLocation(block.get()).getPath()));
    }

    private ResourceLocation getLocation(Supplier<? extends Item> item){
        return BuiltInRegistries.ITEM.getKey(item.get());
    }
    private ResourceLocation getLocation(Item item){
        return BuiltInRegistries.ITEM.getKey(item);
    }

    private ResourceLocation getBlockLocation(Supplier<Block> block){
        return BuiltInRegistries.BLOCK.getKey(block.get());
    }
    private ResourceLocation getBlockLocation(Block block){
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
