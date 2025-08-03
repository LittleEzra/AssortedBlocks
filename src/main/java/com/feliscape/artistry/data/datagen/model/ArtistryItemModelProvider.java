package com.feliscape.artistry.data.datagen.model;


import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

        simpleItem(ArtistryItems.SUNSPROUT);
        simpleItem(ArtistryItems.FERN_SEED);
        itemWithBlockTexture(ArtistryItems.SUNBURST_VINES);
        simpleItem(ArtistryItems.STRING_LIGHTS);

        blockItemSprite(ArtistryBlocks.COPPER_CHAIN);
        blockItemSprite(ArtistryBlocks.EXPOSED_COPPER_CHAIN);
        blockItemSprite(ArtistryBlocks.WEATHERED_COPPER_CHAIN);
        blockItemSprite(ArtistryBlocks.OXIDIZED_COPPER_CHAIN);

        blockItemSprite(ArtistryBlocks.WAXED_COPPER_CHAIN, getBlockItemSpriteLocation(ArtistryBlocks.COPPER_CHAIN));
        blockItemSprite(ArtistryBlocks.WAXED_EXPOSED_COPPER_CHAIN, getBlockItemSpriteLocation(ArtistryBlocks.EXPOSED_COPPER_CHAIN));
        blockItemSprite(ArtistryBlocks.WAXED_WEATHERED_COPPER_CHAIN, getBlockItemSpriteLocation(ArtistryBlocks.WEATHERED_COPPER_CHAIN));
        blockItemSprite(ArtistryBlocks.WAXED_OXIDIZED_COPPER_CHAIN, getBlockItemSpriteLocation(ArtistryBlocks.OXIDIZED_COPPER_CHAIN));

        manualBlockItem(ArtistryBlocks.STONE_PILLAR);
        manualBlockItem(ArtistryBlocks.MOSSY_STONE_PILLAR);
        manualBlockItem(ArtistryBlocks.STONE_TILE_STAIRS);
        manualBlockItem(ArtistryBlocks.STONE_TILE_SLAB);
        manualBlockItem(ArtistryBlocks.MOSSY_STONE_TILE_STAIRS);
        manualBlockItem(ArtistryBlocks.MOSSY_STONE_TILE_SLAB);

        manualBlockItem(ArtistryBlocks.SMOOTH_CALCITE_STAIRS);
        manualBlockItem(ArtistryBlocks.SMOOTH_CALCITE_SLAB);
        manualBlockItem(ArtistryBlocks.CALCITE_STAIRS);
        manualBlockItem(ArtistryBlocks.CALCITE_SLAB);
        minecraftBasedWallItem(ArtistryBlocks.CALCITE_WALL, Blocks.CALCITE);
        manualBlockItem(ArtistryBlocks.POLISHED_CALCITE_STAIRS);
        manualBlockItem(ArtistryBlocks.POLISHED_CALCITE_SLAB);
        wallItem(ArtistryBlocks.POLISHED_CALCITE_WALL, ArtistryBlocks.POLISHED_CALCITE);
        manualBlockItem(ArtistryBlocks.CALCITE_BRICK_STAIRS);
        manualBlockItem(ArtistryBlocks.CALCITE_BRICK_SLAB);
        wallItem(ArtistryBlocks.CALCITE_BRICK_WALL, ArtistryBlocks.CALCITE_BRICKS);
        manualBlockItem(ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS);
        manualBlockItem(ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB);

        manualBlockItem(ArtistryBlocks.DRIPSTONE_STAIRS);
        manualBlockItem(ArtistryBlocks.DRIPSTONE_SLAB);
        minecraftBasedWallItem(ArtistryBlocks.DRIPSTONE_WALL, Blocks.DRIPSTONE_BLOCK);
        manualBlockItem(ArtistryBlocks.POLISHED_DRIPSTONE_STAIRS);
        manualBlockItem(ArtistryBlocks.POLISHED_DRIPSTONE_SLAB);
        wallItem(ArtistryBlocks.POLISHED_DRIPSTONE_WALL, ArtistryBlocks.POLISHED_DRIPSTONE);
        manualBlockItem(ArtistryBlocks.DRIPSTONE_BRICK_STAIRS);
        manualBlockItem(ArtistryBlocks.DRIPSTONE_BRICK_SLAB);
        wallItem(ArtistryBlocks.DRIPSTONE_BRICK_WALL, ArtistryBlocks.DRIPSTONE_BRICKS);

        blockItemSprite(ArtistryBlocks.LARGE_LANTERN);
        blockItemSprite(ArtistryBlocks.LARGE_SOUL_LANTERN);
        blockItemSprite(ArtistryBlocks.ROUND_LANTERN);
        blockItemSprite(ArtistryBlocks.FLAT_LIGHT);
        generatedBlockItem(ArtistryBlocks.SPARKLER);
        generatedBlockItem(ArtistryBlocks.AMETHYST_STARS);
        blockItemSpriteLayered(ArtistryBlocks.SPARK_FOUNTAIN);

        blockItemSprite(ArtistryBlocks.BLOOMING_VINES);
        blockItemSprite(ArtistryBlocks.LUSH_FERN);
        generatedBlockItem(ArtistryBlocks.TEARDROP_GRASS);

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
                ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", Artistry.location("item/" + getLocation(item.get()).getPath()));
    }
    private ItemModelBuilder simpleDoubleLayered(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", Artistry.location("item/" + getLocation(item.get()).getPath()))
                .texture("layer1", Artistry.location("item/" + getLocation(item.get()).getPath() + "_overlay"))
                ;
    }
    private ItemModelBuilder handheldItem(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld"))
                .texture("layer0", Artistry.location("item/" + getLocation(item.get()).getPath()));
    }
    private ItemModelBuilder rotatedHandheldItem(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                Artistry.location("item/rotated_handheld"))
                .texture("layer0", Artistry.location("item/" + getLocation(item.get()).getPath()));
    }
    private ItemModelBuilder itemWithBlockTexture(Supplier<? extends Item> item){
        return withExistingParent(getLocation(item.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", Artistry.location("block/" + getLocation(item.get()).getPath()));
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
    public void minecraftBasedWallItem(Supplier<? extends Block> block, Block baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.withDefaultNamespace("block/" + BuiltInRegistries.BLOCK.getKey(baseBlock).getPath()));
    }

    private ItemModelBuilder blockItemSprite(Supplier<? extends Block> block) { // Uses a block instead of item with a unique item texture (Example: Doors or Lanterns)
        return withExistingParent(getBlockLocation(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                Artistry.location("item/" + getBlockLocation(block.get()).getPath()));
    }
    private ItemModelBuilder blockItemSprite(Supplier<? extends Block> block, ResourceLocation texture) { // Uses a block instead of item with a unique item texture (Example: Doors or Lanterns)
        return withExistingParent(getBlockLocation(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0", texture);
    }
    private ItemModelBuilder blockItemSpriteLayered(Supplier<? extends Block> block) { // Uses a block instead of item with a unique item texture (Example: Doors or Lanterns)
        return withExistingParent(getBlockLocation(block.get()).getPath(),
                ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", Artistry.location("item/" + getBlockLocation(block.get()).getPath()))
                .texture("layer1", Artistry.location("item/" + getBlockLocation(block.get()).getPath()) + "_overlay")
                ;
    }
    private ItemModelBuilder generatedBlockItem(Supplier<? extends Block> block) { // Uses the texture from textures/block (Example: Saplings or Torches)
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

    private ResourceLocation getBlockItemSpriteLocation(Supplier<? extends Block> block){
        return Artistry.location("item/" + getBlockLocation(block.get()).getPath());
    }
}
