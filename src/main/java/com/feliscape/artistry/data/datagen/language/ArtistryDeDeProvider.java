package com.feliscape.artistry.data.datagen.language;

import com.feliscape.artistry.data.pot.ArtistryPaintedPotDecorations;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;

@SuppressWarnings("SpellCheckingInspection")
public class ArtistryDeDeProvider extends ArtistryLanguageProvider {
    public ArtistryDeDeProvider(PackOutput output) {
        super(output, "de_de");
    }

    @Override
    protected void addTranslations() {
        this.addItem(ArtistryItems.ASPEN_SIGN, "Espenholzschild");
        this.addItem(ArtistryItems.ASPEN_HANGING_SIGN, "Espenholzhängeschild");
        this.addItem(ArtistryItems.ASPEN_BOAT, "Espenholzboot");
        this.addItem(ArtistryItems.ASPEN_CHEST_BOAT, "Espenholztruhenboot");
        this.addItem(ArtistryItems.SUNBURST_VINES, "Sonnenscheinranken");
        this.addItem(ArtistryItems.SUNSPROUT, "Sonnensprosse");
        this.addItem(ArtistryItems.FERN_SEED, "Farnsamen");
        this.addItem(ArtistryItems.GOLDEN_BULB, "Goldene Knolle");
        this.addItem(ArtistryItems.ANCIENT_TEAR, "Antike Träne");
        this.addItem(ArtistryItems.SNIFFER_CAKE, "Schnüffler-Kuchen");
        this.addItemTooltip(ArtistryItems.SNIFFER_CAKE, "Das Lieblingsessen eines Schnüfflers");

        this.addBlock(ArtistryBlocks.MOSSY_BRICKS, "Bemooste Ziegelsteine");
        this.addBlock(ArtistryBlocks.CRACKED_BRICKS, "Rissige Ziegelsteine");

        this.addBlock(ArtistryBlocks.STONE_TILES, "Steinfliesen");
        this.addBlock(ArtistryBlocks.STONE_TILE_STAIRS, "Steinfliesentreppe");
        this.addBlock(ArtistryBlocks.STONE_TILE_SLAB, "Steinfliesenstufe");

        this.addBlock(ArtistryBlocks.MOSSY_STONE_TILES, "Bemooste Steinfliesen");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_TILE_STAIRS, "Bemooste Steinfliesentreppe");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_TILE_SLAB, "Bemooste Steinfliesenstufe");

        this.addBlock(ArtistryBlocks.OVERGROWN_STONE_TILES, "Überwucherte Steinfliesen");
        this.addBlock(ArtistryBlocks.STONE_PILLAR, "Steinsäule");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_PILLAR, "Bemooste Steinsäule");

        this.addBlock(ArtistryBlocks.SUNSPROUT, "Sonnensprosse");
        this.addBlock(ArtistryBlocks.SUNBURST_VINES, "Sonnenscheinranken");
        this.addBlock(ArtistryBlocks.SUNBURST_VINES_PLANT, "Sonnenscheinranken");

        this.addBlock(ArtistryBlocks.BLOOMING_VINES, "Blühende Ranken");
        this.addBlock(ArtistryBlocks.LUSH_FERN, "Üppiger Farn");
        this.addBlock(ArtistryBlocks.LUSH_FERN_CROP, "Üppiger Farn");
        this.addBlock(ArtistryBlocks.TEARDROP_GRASS_BLOCK, "Tränengrasblock");
        this.addBlock(ArtistryBlocks.SHORT_TEARDROP_GRASS, "Kurzes Tränengras");
        this.addBlock(ArtistryBlocks.POTTED_TEARDROP_GRASS, "Eingetopftes Tränengras");
        this.addBlock(ArtistryBlocks.TALL_TEARDROP_GRASS, "Hohes Tränengras");
        this.addBlock(ArtistryBlocks.CORPSE_FLOWER, "Leichenblume");
        this.addBlock(ArtistryBlocks.FLY_LURE, "Fliegenköder");

        this.addBlock(ArtistryBlocks.HONEYDEW_FRUIT, "Honigtaufrucht");
        this.addBlock(ArtistryBlocks.HONEYDEW_STALK, "Honigtaustiel");

        this.addBlock(ArtistryBlocks.OAK_TABLE, "Eichenholztisch");
        this.addBlock(ArtistryBlocks.SPRUCE_TABLE, "Fichtenholztisch");
        this.addBlock(ArtistryBlocks.BIRCH_TABLE, "Birkenholztisch");
        this.addBlock(ArtistryBlocks.JUNGLE_TABLE, "Tropenholz");
        this.addBlock(ArtistryBlocks.ACACIA_TABLE, "Akazienholztisch");
        this.addBlock(ArtistryBlocks.CHERRY_TABLE, "Kirschenholztisch");
        this.addBlock(ArtistryBlocks.DARK_OAK_TABLE, "Schwarzeichenholztisch");
        this.addBlock(ArtistryBlocks.MANGROVE_TABLE, "Mangrovenholztisch");
        this.addBlock(ArtistryBlocks.ASPEN_TABLE, "Espenholztisch");
        this.addBlock(ArtistryBlocks.BAMBOO_TABLE, "Bambustisch");
        this.addBlock(ArtistryBlocks.CRIMSON_TABLE, "Karmesintisch");
        this.addBlock(ArtistryBlocks.WARPED_TABLE, "Wirrtisch");

        this.addBlock(ArtistryBlocks.STONE_TABLE, "Steintisch");
        this.addBlock(ArtistryBlocks.ANDESITE_TABLE, "Andesittisch");
        this.addBlock(ArtistryBlocks.GRANITE_TABLE, "Granittisch");
        this.addBlock(ArtistryBlocks.DIORITE_TABLE, "Diorittisch");
        this.addBlock(ArtistryBlocks.DEEPSLATE_TABLE, "Tiefenschiefertisch");
        this.addBlock(ArtistryBlocks.POLISHED_BLACKSTONE_TABLE, "Polierter Schwarzsteintisch");
        this.addBlock(ArtistryBlocks.TUFF_TABLE, "Tuffsteintisch");
        this.addBlock(ArtistryBlocks.CALCITE_TABLE, "Kalzittisch");

        this.addBlock(ArtistryBlocks.WHITE_FROSTED_GLASS, "Weißes Milchglas");
        this.addBlock(ArtistryBlocks.LIGHT_GRAY_FROSTED_GLASS, "Hellgraues Milchglas");
        this.addBlock(ArtistryBlocks.GRAY_FROSTED_GLASS, "Graues Milchglas");
        this.addBlock(ArtistryBlocks.BLACK_FROSTED_GLASS, "Schwarzes Milchglas");
        this.addBlock(ArtistryBlocks.BROWN_FROSTED_GLASS, "Braunes Milchglas");
        this.addBlock(ArtistryBlocks.RED_FROSTED_GLASS, "Rotes Milchglas");
        this.addBlock(ArtistryBlocks.ORANGE_FROSTED_GLASS, "Oranges Milchglas");
        this.addBlock(ArtistryBlocks.YELLOW_FROSTED_GLASS, "Gelbes Milchglas");
        this.addBlock(ArtistryBlocks.LIME_FROSTED_GLASS, "Hellgrün Milchglas");
        this.addBlock(ArtistryBlocks.GREEN_FROSTED_GLASS, "Grünes Milchglas");
        this.addBlock(ArtistryBlocks.CYAN_FROSTED_GLASS, "Türkises Milchglas");
        this.addBlock(ArtistryBlocks.LIGHT_BLUE_FROSTED_GLASS, "Hellblaues Milchglas");
        this.addBlock(ArtistryBlocks.BLUE_FROSTED_GLASS, "Blaues Milchglas");
        this.addBlock(ArtistryBlocks.PURPLE_FROSTED_GLASS, "Violettes Milchglas");
        this.addBlock(ArtistryBlocks.MAGENTA_FROSTED_GLASS, "Magenta Milchglas");
        this.addBlock(ArtistryBlocks.PINK_FROSTED_GLASS, "Pinkes Milchglas");

        this.addBlock(ArtistryBlocks.STRING_LIGHTS, "Lichterkette");
        this.addBlock(ArtistryBlocks.WALL_STRING_LIGHTS, "Wandlichterkette");
        this.addBlock(ArtistryBlocks.LARGE_LANTERN, "Große Laterne");
        this.addBlock(ArtistryBlocks.LARGE_SOUL_LANTERN, "Große Seelenlaterne");
        this.addBlock(ArtistryBlocks.ROUND_LANTERN, "Runde Laterne");
        this.addBlock(ArtistryBlocks.FLAT_LIGHT, "Flache Lampe");

        this.addBlock(ArtistryBlocks.COPPER_CHAIN, "Kupferkette");
        this.addBlock(ArtistryBlocks.EXPOSED_COPPER_CHAIN, "Angelaufene Kupferkette");
        this.addBlock(ArtistryBlocks.WEATHERED_COPPER_CHAIN, "Verwitterte Kupferkette");
        this.addBlock(ArtistryBlocks.OXIDIZED_COPPER_CHAIN, "Oxidierte Kupferkette");

        this.addBlock(ArtistryBlocks.WAXED_COPPER_CHAIN, "Gewachste Kupferkette");
        this.addBlock(ArtistryBlocks.WAXED_EXPOSED_COPPER_CHAIN, "Gewachste angelaufene Kupferkette");
        this.addBlock(ArtistryBlocks.WAXED_WEATHERED_COPPER_CHAIN, "Gewachste verwitterte Kupferkette");
        this.addBlock(ArtistryBlocks.WAXED_OXIDIZED_COPPER_CHAIN, "Gewachste oxidierte Kupferkette");

        this.addBlock(ArtistryBlocks.SPARKLER, "Wunderkerze");
        this.addBlock(ArtistryBlocks.AMETHYST_STARS, "Amethyststerne");
        this.addBlock(ArtistryBlocks.SPARK_FOUNTAIN, "Funkenbrunnen");
        this.addBlock(ArtistryBlocks.WATER_FOUNTAIN, "Wasserbrunnen");

        this.addBlock(ArtistryBlocks.ROCKY_DIRT, "Steinige Erde");

        this.addBlock(ArtistryBlocks.PAINTED_POT, "Bemalter Topf");

        this.addBlock(ArtistryBlocks.CALCITE_STAIRS, "Kalzittreppe");
        this.addBlock(ArtistryBlocks.CALCITE_SLAB, "Kalzitstufe");
        this.addBlock(ArtistryBlocks.CALCITE_WALL, "Kalzitmauer");

        this.addBlock(ArtistryBlocks.SMOOTH_CALCITE, "Glatter Kalzit");
        this.addBlock(ArtistryBlocks.SMOOTH_CALCITE_STAIRS, "Glatte Kalzittreppe");
        this.addBlock(ArtistryBlocks.SMOOTH_CALCITE_SLAB, "Glatte Kalzitstufe");

        this.addBlock(ArtistryBlocks.POLISHED_CALCITE, "Polierter Kalzit");
        this.addBlock(ArtistryBlocks.CHISELED_CALCITE, "Gemeißelter Kalzit");
        this.addBlock(ArtistryBlocks.POLISHED_CALCITE_STAIRS, "Polierte Kalzittreppe");
        this.addBlock(ArtistryBlocks.POLISHED_CALCITE_SLAB, "Polierte Kalzitstufe");
        this.addBlock(ArtistryBlocks.POLISHED_CALCITE_WALL, "Polierte Kalzitmauer");

        this.addBlock(ArtistryBlocks.CALCITE_BRICKS, "Kalzitziegel");
        this.addBlock(ArtistryBlocks.CALCITE_BRICK_STAIRS, "Kalzitziegeltreppe");
        this.addBlock(ArtistryBlocks.CALCITE_BRICK_SLAB, "Kalzitziegelstufe");
        this.addBlock(ArtistryBlocks.CALCITE_BRICK_WALL, "Kalzitziegelmauer");

        this.addBlock(ArtistryBlocks.SMALL_CALCITE_BRICKS, "Kleine Kalzitziegel");
        this.addBlock(ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS, "Kleine Kalzitziegeltreppe");
        this.addBlock(ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB, "Kleine Kalzitziegelstufe");

        this.addBlock(ArtistryBlocks.PAINTED_SMOOTH_CALCITE, "Bemalter glatter Kalzit");
        this.addBlock(ArtistryBlocks.PAINTED_POLISHED_CALCITE, "Bemalter polierter Kalzit");
        this.addBlock(ArtistryBlocks.PAINTED_CALCITE_BRICKS, "Bemalte Kalzitziegel");
        this.addBlock(ArtistryBlocks.PAINTED_SMALL_CALCITE_BRICKS, "Kleine bemalte Kalzitziegel");

        this.addBlock(ArtistryBlocks.DRIPSTONE_STAIRS, "Tropfsteintreppen");
        this.addBlock(ArtistryBlocks.DRIPSTONE_SLAB, "Tropfsteinslab");
        this.addBlock(ArtistryBlocks.DRIPSTONE_WALL, "Tropfsteinwall");

        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE, "Polierter Tropfstein");
        this.addBlock(ArtistryBlocks.CHISELED_DRIPSTONE, "Gemeißelter Tropfstein");
        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE_STAIRS, "Polierte Tropfsteintreppe");
        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE_SLAB, "Polierte Tropfsteinstufe");
        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE_WALL, "Polierte Tropfsteinmauer");

        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICKS, "Tropfsteinziegel");
        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICK_STAIRS, "Tropfsteinziegeltreppe");
        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICK_SLAB, "Tropfsteinziegelstufe");
        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICK_WALL, "Tropfsteinziegelmauer");

        this.addBlock(ArtistryBlocks.ASPEN_LEAVES, "Espenlaub");
        this.addBlock(ArtistryBlocks.ASPEN_LOG, "Espenstamm");
        this.addBlock(ArtistryBlocks.ASPEN_WOOD, "Espenholz");
        this.addBlock(ArtistryBlocks.STRIPPED_ASPEN_LOG, "Entrindeter Espenstamm");
        this.addBlock(ArtistryBlocks.STRIPPED_ASPEN_WOOD, "Entrindetes Espenholz");
        this.addBlock(ArtistryBlocks.ASPEN_PLANKS, "Espenholzbretter");
        this.addBlock(ArtistryBlocks.ASPEN_STAIRS, "Espenholztreppe");
        this.addBlock(ArtistryBlocks.ASPEN_SLAB, "Espenholzstufe");
        this.addBlock(ArtistryBlocks.ASPEN_BUTTON, "Espenholz");
        this.addBlock(ArtistryBlocks.ASPEN_PRESSURE_PLATE, "Espenholz");
        this.addBlock(ArtistryBlocks.ASPEN_FENCE, "Espenholz");
        this.addBlock(ArtistryBlocks.ASPEN_FENCE_GATE, "Espenholz");

        this.add("block.artistry.aspen_wall_sign", "Espenholzwandschild");
        this.add("block.artistry.aspen_wall_hanging_sign", "Espenholzwandhängeschild");

        this.addBlock(ArtistryBlocks.ASPEN_DOOR, "Espenholztür");
        this.addBlock(ArtistryBlocks.ASPEN_TRAPDOOR, "Espenholzfalltür");
        this.addBlock(ArtistryBlocks.ASPEN_SAPLING, "Espensetzling");
        this.addBlock(ArtistryBlocks.POTTED_ASPEN_SAPLING, "Eingetopfter Espensetzling");

        this.addPaintedPotBase(DyeColor.WHITE, "Weiße Basis");
        this.addPaintedPotBase(DyeColor.LIGHT_GRAY, "Hellgraue Basis");
        this.addPaintedPotBase(DyeColor.GRAY, "Graue Basis");
        this.addPaintedPotBase(DyeColor.BLACK, "Schwarze Basis");
        this.addPaintedPotBase(DyeColor.BROWN, "Braune Basis");
        this.addPaintedPotBase(DyeColor.RED, "Rote Basis");
        this.addPaintedPotBase(DyeColor.ORANGE, "Orange Basis");
        this.addPaintedPotBase(DyeColor.YELLOW, "Gelbe Basis");
        this.addPaintedPotBase(DyeColor.LIME, "Hellgrüne Basis");
        this.addPaintedPotBase(DyeColor.GREEN, "Grüne Basis");
        this.addPaintedPotBase(DyeColor.CYAN, "Türkise Basis");
        this.addPaintedPotBase(DyeColor.LIGHT_BLUE, "Hellblaue Basis");
        this.addPaintedPotBase(DyeColor.BLUE, "Blaue Basis");
        this.addPaintedPotBase(DyeColor.PURPLE, "Violette Basis");
        this.addPaintedPotBase(DyeColor.MAGENTA, "Magenta Basis");
        this.addPaintedPotBase(DyeColor.PINK, "Pinke Basis");

        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.WAVY_TRIM, "Wellige Umrandung");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.TICKED_TRIM, "Getigerte Umrandung");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.MAW_TRIM, "Maul Umrandung");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.PYRAMIDS_TRIM, "Pyramiden Umrandung");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.CORNERS_TRIM, "Ecken Umrandung");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.BOW_TRIM, "Bogen Umrandung");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.EYE_TRIM, "Augem Umrandung");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.SEAM_TRIM, "Naht Umrandung");

        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.FREQUENCY_PATTERN, "Frequenz Muster");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.RINGS_PATTERN, "Ringe Muster");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.DOTS_PATTERN, "Punkte Muster");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.CROSS_PATTERN, "Kreuz Muster");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.WAVE_PATTERN, "Wellen Muster");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.WEAVE_PATTERN, "Gewebe Muster");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.ARROWS_PATTERN, "Pfeile Muster");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.CYCLE_PATTERN, "Zyklus Muster");

        this.add("artistry.jei.sniffer_dig.title", "Schnüffler-Graben");
        this.add("artistry.jei.sniffer_dig.found_in", "Gefunden In:");

        this.add("itemGroup.artistry.base", "Artistry");

        this.add("artistry.configuration.tweaks", "Änderungen");
        this.add("artistry.config.common.survivability_changes", "Stabilitätsänderungen");
        this.add("artistry.config.server.sniffer_cake_motivation", "Schnüffler-Kuchen Motivation");
    }
}
