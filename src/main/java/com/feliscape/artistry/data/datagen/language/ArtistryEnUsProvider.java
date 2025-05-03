package com.feliscape.artistry.data.datagen.language;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.data.PackOutput;

public class ArtistryEnUsProvider extends ArtistryLanguageProvider {
    public ArtistryEnUsProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addItem(ArtistryItems.ASPEN_SIGN, "Aspen Sign");
        this.addItem(ArtistryItems.ASPEN_HANGING_SIGN, "Aspen Hanging Sign");
        this.addItem(ArtistryItems.ASPEN_BOAT, "Aspen Boat");
        this.addItem(ArtistryItems.ASPEN_CHEST_BOAT, "Aspen Boat with Chest");

        this.addBlock(ArtistryBlocks.MOSSY_BRICKS, "Mossy Bricks");
        this.addBlock(ArtistryBlocks.CRACKED_BRICKS, "Cracked Bricks");
        this.addBlock(ArtistryBlocks.STONE_TILES, "Stone Tiles");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_TILES, "Mossy Stone Tiles");
        this.addBlock(ArtistryBlocks.OVERGROWN_STONE_TILES, "Overgrown Stone Tiles");
        this.addBlock(ArtistryBlocks.STONE_PILLAR, "Stone Pillar");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_PILLAR, "Mossy Stone Pillar");

        this.addBlock(ArtistryBlocks.BLOOMING_VINES, "Blooming Vines");

        this.addBlock(ArtistryBlocks.OAK_TABLE, "Oak Table");
        this.addBlock(ArtistryBlocks.SPRUCE_TABLE, "Spruce Table");
        this.addBlock(ArtistryBlocks.BIRCH_TABLE, "Birch Table");
        this.addBlock(ArtistryBlocks.JUNGLE_TABLE, "Jungle Table");
        this.addBlock(ArtistryBlocks.ACACIA_TABLE, "Acacia Table");
        this.addBlock(ArtistryBlocks.CHERRY_TABLE, "Cherry Table");
        this.addBlock(ArtistryBlocks.DARK_OAK_TABLE, "Dark Oak Table");
        this.addBlock(ArtistryBlocks.MANGROVE_TABLE, "Mangrove Table");
        this.addBlock(ArtistryBlocks.ASPEN_TABLE, "Aspen Table");
        this.addBlock(ArtistryBlocks.BAMBOO_TABLE, "Bamboo Table");
        this.addBlock(ArtistryBlocks.CRIMSON_TABLE, "Crimson Table");
        this.addBlock(ArtistryBlocks.WARPED_TABLE, "Warped Table");

        this.addBlock(ArtistryBlocks.ASPEN_LEAVES, "Aspen Leaves");
        this.addBlock(ArtistryBlocks.ASPEN_LOG, "Aspen Log");
        this.addBlock(ArtistryBlocks.ASPEN_WOOD, "Aspen Wood");
        this.addBlock(ArtistryBlocks.STRIPPED_ASPEN_LOG, "Stripped Aspen Log");
        this.addBlock(ArtistryBlocks.STRIPPED_ASPEN_WOOD, "Stripped Aspen Wood");
        this.addBlock(ArtistryBlocks.ASPEN_PLANKS, "Aspen Planks");
        this.addBlock(ArtistryBlocks.ASPEN_STAIRS, "Aspen Stairs");
        this.addBlock(ArtistryBlocks.ASPEN_SLAB, "Aspen Slab");
        this.addBlock(ArtistryBlocks.ASPEN_BUTTON, "Aspen Button");
        this.addBlock(ArtistryBlocks.ASPEN_PRESSURE_PLATE, "Aspen Pressure Plate");
        this.addBlock(ArtistryBlocks.ASPEN_FENCE, "Aspen Fence");
        this.addBlock(ArtistryBlocks.ASPEN_FENCE_GATE, "Aspen Fence Gate");
        this.addBlock(ArtistryBlocks.ASPEN_DOOR, "Aspen Door");
        this.addBlock(ArtistryBlocks.ASPEN_TRAPDOOR, "Aspen Trapdoor");
        this.addBlock(ArtistryBlocks.ASPEN_SAPLING, "Aspen Sapling");

        this.add("itemGroup.artistry.base", "Artistry");
    }
}
