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
        this.addItem(ArtistryItems.SUNBURST_VINES, "Sunburst Vines");
        this.addItem(ArtistryItems.SUNSPROUT, "Sunsprout");

        this.addBlock(ArtistryBlocks.MOSSY_BRICKS, "Mossy Bricks");
        this.addBlock(ArtistryBlocks.CRACKED_BRICKS, "Cracked Bricks");

        this.addBlock(ArtistryBlocks.STONE_TILES, "Stone Tiles");
        this.addBlock(ArtistryBlocks.STONE_TILE_STAIRS, "Stone Tile Stairs");
        this.addBlock(ArtistryBlocks.STONE_TILE_SLAB, "Stone Tile Slab");

        this.addBlock(ArtistryBlocks.MOSSY_STONE_TILES, "Mossy Stone Tiles");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_TILE_STAIRS, "Mossy Stone Tile Stairs");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_TILE_SLAB, "Mossy Stone Tile Slab");

        this.addBlock(ArtistryBlocks.OVERGROWN_STONE_TILES, "Overgrown Stone Tiles");
        this.addBlock(ArtistryBlocks.STONE_PILLAR, "Stone Pillar");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_PILLAR, "Mossy Stone Pillar");

        this.addBlock(ArtistryBlocks.SUNSPROUT, "Sunsprout");
        this.addBlock(ArtistryBlocks.SUNBURST_VINES, "Sunburst Vines");
        this.addBlock(ArtistryBlocks.SUNBURST_VINES_PLANT, "Sunburst Vines");

        this.addBlock(ArtistryBlocks.BLOOMING_VINES, "Blooming Vines");
        this.addBlock(ArtistryBlocks.LUSH_FERN, "Lush Fern");

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

        this.addBlock(ArtistryBlocks.STONE_TABLE, "Stone Table");
        this.addBlock(ArtistryBlocks.ANDESITE_TABLE, "Andesite Table");
        this.addBlock(ArtistryBlocks.GRANITE_TABLE, "Granite Table");
        this.addBlock(ArtistryBlocks.DIORITE_TABLE, "Diorite Table");
        this.addBlock(ArtistryBlocks.DEEPSLATE_TABLE, "Deepslate Table");
        this.addBlock(ArtistryBlocks.POLISHED_BLACKSTONE_TABLE, "Polished Blackstone Table");
        this.addBlock(ArtistryBlocks.TUFF_TABLE, "Tuff Table");

        this.addBlock(ArtistryBlocks.STRING_LIGHTS, "String Lights");
        this.addBlock(ArtistryBlocks.WALL_STRING_LIGHTS, "Wall String Lights");
        this.addBlock(ArtistryBlocks.LARGE_LANTERN, "Large Lantern");
        this.addBlock(ArtistryBlocks.LARGE_SOUL_LANTERN, "Large Soul Lantern");
        this.addBlock(ArtistryBlocks.ROUND_LANTERN, "Round Lantern");

        this.addBlock(ArtistryBlocks.SPARKLER, "Sparkler");
        this.addBlock(ArtistryBlocks.AMETHYST_STARS, "Amethyst Stars");

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
        this.addBlock(ArtistryBlocks.POTTED_ASPEN_SAPLING, "Potted Aspen Sapling");

        this.add("itemGroup.artistry.base", "Artistry");

        this.add("artistry.config.common.survivability_changes", "Survivability Changes");
    }
}
