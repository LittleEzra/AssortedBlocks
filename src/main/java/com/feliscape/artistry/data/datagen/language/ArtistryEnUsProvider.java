package com.feliscape.artistry.data.datagen.language;

import com.feliscape.artistry.data.pot.ArtistryPaintedPotDecorations;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;

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
        this.addItem(ArtistryItems.FERN_SEED, "Fern Seed");
        this.addItem(ArtistryItems.ANCIENT_TEAR, "Ancient Tear");
        this.addItem(ArtistryItems.SNIFFER_CAKE, "Sniffer Cake");
        this.addItemTooltip(ArtistryItems.SNIFFER_CAKE, "A Sniffer's favorite food");

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
        this.addBlock(ArtistryBlocks.LUSH_FERN_CROP, "Lush Fern");
        this.addBlock(ArtistryBlocks.TEARDROP_GRASS_BLOCK, "Teardrop Grass Block");
        this.addBlock(ArtistryBlocks.SHORT_TEARDROP_GRASS, "Short Teardrop Grass");
        this.addBlock(ArtistryBlocks.POTTED_TEARDROP_GRASS, "Potted Teardrop Grass");
        this.addBlock(ArtistryBlocks.TALL_TEARDROP_GRASS, "Tall Teardrop Grass");
        this.addBlock(ArtistryBlocks.CORPSE_FLOWER, "Corpse Flower");
        this.addBlock(ArtistryBlocks.FLY_LURE, "Fly Lure");
        this.addBlock(ArtistryBlocks.SPIRAL_FUNGUS, "Spiral Fungus");

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
        this.addBlock(ArtistryBlocks.CALCITE_TABLE, "Calcite Table");
        
        this.addBlock(ArtistryBlocks.WHITE_FROSTED_GLASS, "White Frosted Glass");
        this.addBlock(ArtistryBlocks.LIGHT_GRAY_FROSTED_GLASS, "Light Gray Frosted Glass");
        this.addBlock(ArtistryBlocks.GRAY_FROSTED_GLASS, "Gray Frosted Glass");
        this.addBlock(ArtistryBlocks.BLACK_FROSTED_GLASS, "Black Frosted Glass");
        this.addBlock(ArtistryBlocks.BROWN_FROSTED_GLASS, "Brown Frosted Glass");
        this.addBlock(ArtistryBlocks.RED_FROSTED_GLASS, "Red Frosted Glass");
        this.addBlock(ArtistryBlocks.ORANGE_FROSTED_GLASS, "Orange Frosted Glass");
        this.addBlock(ArtistryBlocks.YELLOW_FROSTED_GLASS, "Yellow Frosted Glass");
        this.addBlock(ArtistryBlocks.LIME_FROSTED_GLASS, "Lime Frosted Glass");
        this.addBlock(ArtistryBlocks.GREEN_FROSTED_GLASS, "Green Frosted Glass");
        this.addBlock(ArtistryBlocks.CYAN_FROSTED_GLASS, "Cyan Frosted Glass");
        this.addBlock(ArtistryBlocks.LIGHT_BLUE_FROSTED_GLASS, "Light Blue Frosted Glass");
        this.addBlock(ArtistryBlocks.BLUE_FROSTED_GLASS, "Blue Frosted Glass");
        this.addBlock(ArtistryBlocks.PURPLE_FROSTED_GLASS, "Purple Frosted Glass");
        this.addBlock(ArtistryBlocks.MAGENTA_FROSTED_GLASS, "Magenta Frosted Glass");
        this.addBlock(ArtistryBlocks.PINK_FROSTED_GLASS, "Pink Frosted Glass");

        this.addBlock(ArtistryBlocks.STRING_LIGHTS, "String Lights");
        this.addBlock(ArtistryBlocks.WALL_STRING_LIGHTS, "Wall String Lights");
        this.addBlock(ArtistryBlocks.LARGE_LANTERN, "Large Lantern");
        this.addBlock(ArtistryBlocks.LARGE_SOUL_LANTERN, "Large Soul Lantern");
        this.addBlock(ArtistryBlocks.ROUND_LANTERN, "Round Lantern");
        this.addBlock(ArtistryBlocks.FLAT_LIGHT, "Flat Light");

        this.addBlock(ArtistryBlocks.COPPER_CHAIN, "Copper Chain");
        this.addBlock(ArtistryBlocks.EXPOSED_COPPER_CHAIN, "Exposed Copper Chain");
        this.addBlock(ArtistryBlocks.WEATHERED_COPPER_CHAIN, "Weathered Copper Chain");
        this.addBlock(ArtistryBlocks.OXIDIZED_COPPER_CHAIN, "Oxidized Copper Chain");

        this.addBlock(ArtistryBlocks.WAXED_COPPER_CHAIN, "Waxed Copper Chain");
        this.addBlock(ArtistryBlocks.WAXED_EXPOSED_COPPER_CHAIN, "Waxed Exposed Copper Chain");
        this.addBlock(ArtistryBlocks.WAXED_WEATHERED_COPPER_CHAIN, "Waxed Weathered Copper Chain");
        this.addBlock(ArtistryBlocks.WAXED_OXIDIZED_COPPER_CHAIN, "Waxed Oxidized Copper Chain");

        this.addBlock(ArtistryBlocks.SPARKLER, "Sparkler");
        this.addBlock(ArtistryBlocks.AMETHYST_STARS, "Amethyst Stars");
        this.addBlock(ArtistryBlocks.SPARK_FOUNTAIN, "Spark Fountain");
        this.addBlock(ArtistryBlocks.WATER_FOUNTAIN, "Water Fountain");

        this.addBlock(ArtistryBlocks.ROCKY_DIRT, "Rocky Dirt");

        this.addBlock(ArtistryBlocks.PAINTED_POT, "Painted Pot");

        this.addBlock(ArtistryBlocks.CALCITE_STAIRS, "Calcite Stairs");
        this.addBlock(ArtistryBlocks.CALCITE_SLAB, "Calcite Slab");
        this.addBlock(ArtistryBlocks.CALCITE_WALL, "Calcite Wall");

        this.addBlock(ArtistryBlocks.SMOOTH_CALCITE, "Smooth Calcite");
        this.addBlock(ArtistryBlocks.SMOOTH_CALCITE_STAIRS, "Smooth Calcite Stairs");
        this.addBlock(ArtistryBlocks.SMOOTH_CALCITE_SLAB, "Smooth Calcite Slab");

        this.addBlock(ArtistryBlocks.POLISHED_CALCITE, "Polished Calcite");
        this.addBlock(ArtistryBlocks.CHISELED_CALCITE, "Chiseled Calcite");
        this.addBlock(ArtistryBlocks.POLISHED_CALCITE_STAIRS, "Polished Calcite Stairs");
        this.addBlock(ArtistryBlocks.POLISHED_CALCITE_SLAB, "Polished Calcite Slab");
        this.addBlock(ArtistryBlocks.POLISHED_CALCITE_WALL, "Polished Calcite Wall");

        this.addBlock(ArtistryBlocks.CALCITE_BRICKS, "Calcite Bricks");
        this.addBlock(ArtistryBlocks.CALCITE_BRICK_STAIRS, "Calcite Brick Stairs");
        this.addBlock(ArtistryBlocks.CALCITE_BRICK_SLAB, "Calcite Brick Slab");
        this.addBlock(ArtistryBlocks.CALCITE_BRICK_WALL, "Calcite Brick Wall");

        this.addBlock(ArtistryBlocks.SMALL_CALCITE_BRICKS, "Small Calcite Bricks");
        this.addBlock(ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS, "Small Calcite Brick Stairs");
        this.addBlock(ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB, "Small Calcite Brick Slab");

        this.addBlock(ArtistryBlocks.PAINTED_SMOOTH_CALCITE, "Painted Smooth Calcite");
        this.addBlock(ArtistryBlocks.PAINTED_POLISHED_CALCITE, "Painted Polished Calcite");
        this.addBlock(ArtistryBlocks.PAINTED_CALCITE_BRICKS, "Painted Calcite Bricks");
        this.addBlock(ArtistryBlocks.PAINTED_SMALL_CALCITE_BRICKS, "Painted Small Calcite Bricks");

        this.addBlock(ArtistryBlocks.DRIPSTONE_STAIRS, "Dripstone Stairs");
        this.addBlock(ArtistryBlocks.DRIPSTONE_SLAB, "Dripstone Slab");
        this.addBlock(ArtistryBlocks.DRIPSTONE_WALL, "Dripstone Wall");

        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE, "Polished Dripstone");
        this.addBlock(ArtistryBlocks.CHISELED_DRIPSTONE, "Chiseled Dripstone");
        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE_STAIRS, "Polished Dripstone Stairs");
        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE_SLAB, "Polished Dripstone Slab");
        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE_WALL, "Polished Dripstone Wall");

        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICKS, "Dripstone Bricks");
        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICK_STAIRS, "Dripstone Brick Stairs");
        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICK_SLAB, "Dripstone Brick Slab");
        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICK_WALL, "Dripstone Brick Wall");

        // Aspen

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

        this.add("block.artistry.aspen_wall_sign", "Aspen Wall Sign");
        this.add("block.artistry.aspen_wall_hanging_sign", "Aspen Wall Hanging Sign");

        this.addBlock(ArtistryBlocks.ASPEN_DOOR, "Aspen Door");
        this.addBlock(ArtistryBlocks.ASPEN_TRAPDOOR, "Aspen Trapdoor");
        this.addBlock(ArtistryBlocks.ASPEN_SAPLING, "Aspen Sapling");
        this.addBlock(ArtistryBlocks.POTTED_ASPEN_SAPLING, "Potted Aspen Sapling");

        // Woven Wood

        this.addBlock(ArtistryBlocks.WOVEN_LEAVES, "Woven Leaves");
        this.addBlock(ArtistryBlocks.WOVEN_LOG, "Woven Log");
        this.addBlock(ArtistryBlocks.WOVEN_WOOD, "Woven Wood");
        this.addBlock(ArtistryBlocks.STRIPPED_WOVEN_LOG, "Stripped Woven Log");
        this.addBlock(ArtistryBlocks.STRIPPED_WOVEN_WOOD, "Stripped Woven Wood");
        this.addBlock(ArtistryBlocks.WOVEN_PLANKS, "Woven Planks");

        this.addPaintedPotBase(DyeColor.WHITE, "White Base");
        this.addPaintedPotBase(DyeColor.LIGHT_GRAY, "Light Gray Base");
        this.addPaintedPotBase(DyeColor.GRAY, "Gray Base");
        this.addPaintedPotBase(DyeColor.BLACK, "Black Base");
        this.addPaintedPotBase(DyeColor.BROWN, "Brown Base");
        this.addPaintedPotBase(DyeColor.RED, "Red Base");
        this.addPaintedPotBase(DyeColor.ORANGE, "Orange Base");
        this.addPaintedPotBase(DyeColor.YELLOW, "Yellow Base");
        this.addPaintedPotBase(DyeColor.LIME, "Lime Base");
        this.addPaintedPotBase(DyeColor.GREEN, "Green Base");
        this.addPaintedPotBase(DyeColor.CYAN, "Cyan Base");
        this.addPaintedPotBase(DyeColor.LIGHT_BLUE, "Light Blue Base");
        this.addPaintedPotBase(DyeColor.BLUE, "Blue Base");

        this.addPaintedPotBase(DyeColor.PURPLE, "Purple Base");
        this.addPaintedPotBase(DyeColor.MAGENTA, "Magenta Base");
        this.addPaintedPotBase(DyeColor.PINK, "Pink Base");

        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.WAVY_TRIM, "Wavy Trim");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.TICKED_TRIM, "Ticked Trim");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.MAW_TRIM, "Maw Trim");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.PYRAMIDS_TRIM, "Pyramids Trim");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.CORNERS_TRIM, "Corners Trim");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.BOW_TRIM, "Bow Trim");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.EYE_TRIM, "Eye Trim");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.SEAM_TRIM, "Seam Trim");

        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.FREQUENCY_PATTERN, "Frequency Pattern");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.RINGS_PATTERN, "Rings Pattern");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.DOTS_PATTERN, "Dots Pattern");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.CROSS_PATTERN, "Cross Pattern");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.WAVE_PATTERN, "Wave Pattern");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.WEAVE_PATTERN, "Weave Pattern");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.ARROWS_PATTERN, "Arrows Pattern");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.CYCLE_PATTERN, "Cycle Pattern");

        this.add("artistry.jei.sniffer_dig.title", "Sniffer Digging");
        this.add("artistry.jei.sniffer_dig.found_in", "Found In:");

        this.add("itemGroup.artistry.base", "Artistry");

        this.add("artistry.configuration.tweaks", "Tweaks");
        this.add("artistry.config.server.survivability_changes", "Survivability Changes");
        this.add("artistry.config.server.sniffer_cake_motivation", "Sniffer Cake Motivation");
    }
}
