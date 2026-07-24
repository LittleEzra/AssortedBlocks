package com.feliscape.artistry.data.datagen.language;

import com.feliscape.artistry.data.pot.ArtistryPaintedPotDecorations;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;

@SuppressWarnings("SpellCheckingInspection")
public class ArtistryEsEsProvider extends ArtistryLanguageProvider{
    public ArtistryEsEsProvider(PackOutput output) {
        super(output, "es_es");
    }

    @Override
    protected void addTranslations() {
        this.add("item.artistry.wip", "WIP - Imposible de obtener en modo supervivencia");

        this.addItem(ArtistryItems.ASPEN_SIGN, "Cartel de álamo temblón");
        this.addItem(ArtistryItems.ASPEN_HANGING_SIGN, "Cartel colgante de álamo temblón");
        this.addItem(ArtistryItems.ASPEN_BOAT, "Barca de álamo temblón");
        this.addItem(ArtistryItems.ASPEN_CHEST_BOAT, "Barca de álamo temblón con cofre");

        this.addItem(ArtistryItems.ROTTEN_SIGN, "Cartel podrido");
        this.addItem(ArtistryItems.ROTTEN_HANGING_SIGN, "Cartel colgante podrido");
        this.addItem(ArtistryItems.ROTTEN_BOAT, "Barca podrida");
        this.addItem(ArtistryItems.ROTTEN_CHEST_BOAT, "Barca podrida con cofre");

        this.addItem(ArtistryItems.SUNBURST_VINES, "Enredaderas de rayos de sol");
        this.addItem(ArtistryItems.SUNSPROUT, "Brote de sol");
        this.addItem(ArtistryItems.FERN_SEED, "Semilla de helecho");
        this.addItem(ArtistryItems.ANCIENT_TEAR, "Lágrima antigua");
        this.addItem(ArtistryItems.SNIFFER_CAKE, "Pastel sniffer");
        this.addItemTooltip(ArtistryItems.SNIFFER_CAKE, "A Sniffer's favorite food");
        this.addItem(ArtistryItems.CARVING_KNIFE, "La comida favorita del sniffer");

        this.addBlock(ArtistryBlocks.MOSSY_BRICKS, "Ladrillos musgosos");
        this.addBlock(ArtistryBlocks.CRACKED_BRICKS, "Ladrillos agrietados");

        this.addBlock(ArtistryBlocks.STONE_TILES, "Baldosas de piedra");
        this.addBlock(ArtistryBlocks.STONE_TILE_STAIRS, "Escaleras de baldosas de piedra");
        this.addBlock(ArtistryBlocks.STONE_TILE_SLAB, "Losa de baldosas de piedra");

        this.addBlock(ArtistryBlocks.MOSSY_STONE_TILES, "Baldosas de piedra musgosa");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_TILE_STAIRS, "Escaleras de baldosas de piedra musgosa");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_TILE_SLAB, "Losa de baldosas de piedra musgosa");

        this.addBlock(ArtistryBlocks.OVERGROWN_STONE_TILES, "Baldosas de piedra cubiertas de maleza");
        this.addBlock(ArtistryBlocks.STONE_PILLAR, "Pilar de piedra");
        this.addBlock(ArtistryBlocks.MOSSY_STONE_PILLAR, "Pilar de piedra cubierto de musgo");

        this.addBlock(ArtistryBlocks.SUNSPROUT, "Brote de sol");
        this.addBlock(ArtistryBlocks.SUNBURST_VINES, "Enredaderas de rayos de sol");
        this.addBlock(ArtistryBlocks.SUNBURST_VINES_PLANT, "Enredaderas de rayos de sol");

        this.addBlock(ArtistryBlocks.BLOOMING_VINES, "Enredaderas en flor");
        this.addBlock(ArtistryBlocks.LUSH_FERN, "Helecho frondoso");
        this.addBlock(ArtistryBlocks.LUSH_FERN_CROP, "Helecho frondoso");
        this.addBlock(ArtistryBlocks.TEARDROP_GRASS_BLOCK, "Bloque de hierba lágrima");
        this.addBlock(ArtistryBlocks.SHORT_TEARDROP_GRASS, "Hierba de lágrima corta");
        this.addBlock(ArtistryBlocks.POTTED_TEARDROP_GRASS, "Maceta con hierba lágrima");
        this.addBlock(ArtistryBlocks.TALL_TEARDROP_GRASS, "Hierba de lágrima alta");
        this.addBlock(ArtistryBlocks.CORPSE_FLOWER, "Flor cadáver");
        this.addBlock(ArtistryBlocks.FLY_LURE, "Señuelo para moscas");

        this.addBlock(ArtistryBlocks.GLOWING_MUSHROOM, "Seta luminosa");
        this.addBlock(ArtistryBlocks.GLOWING_MUSHROOM_BLOCK, "Bloque de seta luminosa");

        this.addBlock(ArtistryBlocks.OAK_TABLE, "Oak Table");
        this.addBlock(ArtistryBlocks.SPRUCE_TABLE, "Spruce Table");
        this.addBlock(ArtistryBlocks.BIRCH_TABLE, "Birch Table");
        this.addBlock(ArtistryBlocks.JUNGLE_TABLE, "Jungle Table");
        this.addBlock(ArtistryBlocks.ACACIA_TABLE, "Acacia Table");
        this.addBlock(ArtistryBlocks.CHERRY_TABLE, "Cherry Table");
        this.addBlock(ArtistryBlocks.DARK_OAK_TABLE, "Dark Oak Table");
        this.addBlock(ArtistryBlocks.MANGROVE_TABLE, "Mangrove Table");
        this.addBlock(ArtistryBlocks.ASPEN_TABLE, "Aspen Table");
        this.addBlock(ArtistryBlocks.ROTTEN_TABLE, "Rotten Table");
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

        this.addBlock(ArtistryBlocks.WHITE_FROSTED_GLASS, "Vidrio esmerilado blanco");
        this.addBlock(ArtistryBlocks.LIGHT_GRAY_FROSTED_GLASS, "Vidrio esmerilado gris claro");
        this.addBlock(ArtistryBlocks.GRAY_FROSTED_GLASS, "Vidrio esmerilado gris");
        this.addBlock(ArtistryBlocks.BLACK_FROSTED_GLASS, "Vidrio esmerilado negro");
        this.addBlock(ArtistryBlocks.BROWN_FROSTED_GLASS, "Vidrio esmerilado marrón");
        this.addBlock(ArtistryBlocks.RED_FROSTED_GLASS, "Vidrio esmerilado rojo");
        this.addBlock(ArtistryBlocks.ORANGE_FROSTED_GLASS, "Vidrio esmerilado naranja");
        this.addBlock(ArtistryBlocks.YELLOW_FROSTED_GLASS, "Vidrio esmerilado amarillo");
        this.addBlock(ArtistryBlocks.LIME_FROSTED_GLASS, "Vidrio esmerilado lima");
        this.addBlock(ArtistryBlocks.GREEN_FROSTED_GLASS, "Vidrio esmerilado verde");
        this.addBlock(ArtistryBlocks.CYAN_FROSTED_GLASS, "Vidrio esmerilado cian");
        this.addBlock(ArtistryBlocks.LIGHT_BLUE_FROSTED_GLASS, "Vidrio esmerilado azul claro");
        this.addBlock(ArtistryBlocks.BLUE_FROSTED_GLASS, "Vidrio esmerilado azul");
        this.addBlock(ArtistryBlocks.PURPLE_FROSTED_GLASS, "Vidrio esmerilado marado");
        this.addBlock(ArtistryBlocks.MAGENTA_FROSTED_GLASS, "Vidrio esmerilado magenta");
        this.addBlock(ArtistryBlocks.PINK_FROSTED_GLASS, "Vidrio esmerilado rosa");

        this.addBlock(ArtistryBlocks.STRING_LIGHTS, "Guirnaldas de luces");
        this.addBlock(ArtistryBlocks.WALL_STRING_LIGHTS, "Guirnaldas de luces en pared");
        this.addBlock(ArtistryBlocks.LARGE_LANTERN, "Gran farol");
        this.addBlock(ArtistryBlocks.LARGE_SOUL_LANTERN, "Gran farol de almas");
        this.addBlock(ArtistryBlocks.STONE_LANTERN, "TODO"); // TODO
        this.addBlock(ArtistryBlocks.ROUND_LANTERN, "Farol redondo");
        this.addBlock(ArtistryBlocks.FLAT_LIGHT, "Farol plano");

        this.addBlock(ArtistryBlocks.COPPER_CHAIN, "Cadena de cobre");
        this.addBlock(ArtistryBlocks.EXPOSED_COPPER_CHAIN, "Cadena de cobre expueste");
        this.addBlock(ArtistryBlocks.WEATHERED_COPPER_CHAIN, "Cadena de cobre degradado");
        this.addBlock(ArtistryBlocks.OXIDIZED_COPPER_CHAIN, "Cadena de cobre oxidado");

        this.addBlock(ArtistryBlocks.WAXED_COPPER_CHAIN, "Cadena de cobre encarado");
        this.addBlock(ArtistryBlocks.WAXED_EXPOSED_COPPER_CHAIN, "Cadena de cobre expueste encarado");
        this.addBlock(ArtistryBlocks.WAXED_WEATHERED_COPPER_CHAIN, "Cadena de cobre degradado encarado");
        this.addBlock(ArtistryBlocks.WAXED_OXIDIZED_COPPER_CHAIN, "Cadena de cobre oxidado encarado");

        this.addBlock(ArtistryBlocks.BOLLARD, "Bolardo");

        this.addBlock(ArtistryBlocks.SPARKLER, "Bengala");
        this.addBlock(ArtistryBlocks.AMETHYST_STARS, "Estrellas de amatista");
        this.addBlock(ArtistryBlocks.SPARK_FOUNTAIN, "Fuente de chispas");
        this.addBlock(ArtistryBlocks.WATER_FOUNTAIN, "Fuente de agua");

        this.addBlock(ArtistryBlocks.ROCKY_DIRT, "Tierra rocosa");

        this.addBlock(ArtistryBlocks.PAINTED_POT, "Vasija pintada");

        this.addBlock(ArtistryBlocks.CALCITE_STAIRS, "Escaleras de calcita");
        this.addBlock(ArtistryBlocks.CALCITE_SLAB, "Losa de calcita");
        this.addBlock(ArtistryBlocks.CALCITE_WALL, "Muro de calcita");

        this.addBlock(ArtistryBlocks.SMOOTH_CALCITE, "Calcita lisa");
        this.addBlock(ArtistryBlocks.SMOOTH_CALCITE_STAIRS, "Losa de calcita lisa");
        this.addBlock(ArtistryBlocks.SMOOTH_CALCITE_SLAB, "Muro de calcita lisa");

        this.addBlock(ArtistryBlocks.POLISHED_CALCITE, "Calcita pulida");
        this.addBlock(ArtistryBlocks.CHISELED_CALCITE, "Calcita cincelada");
        this.addBlock(ArtistryBlocks.CALCITE_PILLAR, "TODO"); // TODO
        this.addBlock(ArtistryBlocks.POLISHED_CALCITE_STAIRS, "Escaleras de calcita pulida");
        this.addBlock(ArtistryBlocks.POLISHED_CALCITE_SLAB, "Losa de calcita pulida");
        this.addBlock(ArtistryBlocks.POLISHED_CALCITE_WALL, "Muro de calcita pulida");

        this.addBlock(ArtistryBlocks.CALCITE_BRICKS, "Ladrillos de calcita");
        this.addBlock(ArtistryBlocks.CALCITE_BRICK_STAIRS, "Escaleras de ladrillos de calcita");
        this.addBlock(ArtistryBlocks.CALCITE_BRICK_SLAB, "Losa de ladrillos de calcita");
        this.addBlock(ArtistryBlocks.CALCITE_BRICK_WALL, "Muro de ladrillos de calcita");

        this.addBlock(ArtistryBlocks.SMALL_CALCITE_BRICKS, "Pequeños ladrillos de calcita");
        this.addBlock(ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS, "Escaleras de pequeños ladrillos de calcita");
        this.addBlock(ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB, "Losa de pequeños ladrillos de calcita");

        this.addBlock(ArtistryBlocks.PAINTED_SMOOTH_CALCITE, "Calcita lisa pintada");
        this.addBlock(ArtistryBlocks.PAINTED_POLISHED_CALCITE, "Calcita pulida pintada");
        this.addBlock(ArtistryBlocks.PAINTED_CALCITE_BRICKS, "Ladrillos de calcita pintados");
        this.addBlock(ArtistryBlocks.PAINTED_SMALL_CALCITE_BRICKS, "Pequeños ladrillos de calcita pintados");

        this.addBlock(ArtistryBlocks.DRIPSTONE_STAIRS, "Escaleras de caliza");
        this.addBlock(ArtistryBlocks.DRIPSTONE_SLAB, "Losa de caliza");
        this.addBlock(ArtistryBlocks.DRIPSTONE_WALL, "Muro de caliza");

        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE, "Caliza pulida");
        this.addBlock(ArtistryBlocks.CHISELED_DRIPSTONE, "Caliza cincelada");
        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE_STAIRS, "Escaleras de caliza pulida");
        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE_SLAB, "Losa de caliza pulida");
        this.addBlock(ArtistryBlocks.POLISHED_DRIPSTONE_WALL, "Muro de caliza pulida");

        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICKS, "Ladrillos de caliza");
        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICK_STAIRS, "Escaleras de ladrillos de caliza");
        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICK_SLAB, "Losa de ladrillos de caliza");
        this.addBlock(ArtistryBlocks.DRIPSTONE_BRICK_WALL, "Muro de ladrillos de caliza");

        // Aspen

        this.addBlock(ArtistryBlocks.ASPEN_LEAVES, "Hojas de álamo temblón");
        this.addBlock(ArtistryBlocks.ASPEN_LOG, "Tronco de álamo temblón");
        this.addBlock(ArtistryBlocks.ASPEN_WOOD, "Leño de álamo temblón");
        this.addBlock(ArtistryBlocks.STRIPPED_ASPEN_LOG, "Tronco de álamo temblón sin corteza");
        this.addBlock(ArtistryBlocks.STRIPPED_ASPEN_WOOD, "Leño de álamo temblón sin corteza");
        this.addBlock(ArtistryBlocks.ASPEN_PLANKS, "Tablones de álamo temblón");
        this.addBlock(ArtistryBlocks.ASPEN_STAIRS, "Escaleras de álamo temblón");
        this.addBlock(ArtistryBlocks.ASPEN_SLAB, "Losa de álamo temblón");
        this.addBlock(ArtistryBlocks.ASPEN_BUTTON, "Botón de álamo temblón");
        this.addBlock(ArtistryBlocks.ASPEN_PRESSURE_PLATE, "Place de presión de álamo temblón");
        this.addBlock(ArtistryBlocks.ASPEN_FENCE, "Valla de álamo temblón");
        this.addBlock(ArtistryBlocks.ASPEN_FENCE_GATE, "Puerta de valla de álamo temblón");

        this.add("block.artistry.aspen_wall_sign", "Cartel de álamo temblón en pared");
        this.add("block.artistry.aspen_wall_hanging_sign", "Cartel colgante de álamo temblón en pared");

        this.addBlock(ArtistryBlocks.ASPEN_DOOR, "Puerta de álamo temblón");
        this.addBlock(ArtistryBlocks.ASPEN_TRAPDOOR, "Trampilla de álamo temblón");
        this.addBlock(ArtistryBlocks.ASPEN_SAPLING, "Brote de álamo temblón");
        this.addBlock(ArtistryBlocks.POTTED_ASPEN_SAPLING, "Maceta con brote de álamo temblón");

        this.addBlock(ArtistryBlocks.HEADSTONE, "Lápida");
        this.addBlock(ArtistryBlocks.LEECHING_SOIL, "Suelo de sanguijuela");
        this.addBlock(ArtistryBlocks.WAXED_LEECHING_SOIL, "Suelo de sanguijuela encerado");
        this.addBlock(ArtistryBlocks.URN, "Urna");
        this.addBlock(ArtistryBlocks.MARIGOLD, "Caléndula");
        this.addBlock(ArtistryBlocks.POTTED_MARIGOLD, "Maceta con caléndula");

        this.addBlock(ArtistryBlocks.WICKED_CARVED_PUMPKIN, "Calabaza tallada malvada");
        this.addBlock(ArtistryBlocks.HUNGRY_CARVED_PUMPKIN, "Calabaza tallada hambrienta");
        this.addBlock(ArtistryBlocks.HAPPY_CARVED_PUMPKIN, "Calabaza tallada feliz");
        this.addBlock(ArtistryBlocks.STALWART_CARVED_PUMPKIN, "Calabaza tallada robusta");
        this.addBlock(ArtistryBlocks.PEEKING_CARVED_PUMPKIN, "Calabaza tallada asomándose");
        this.addBlock(ArtistryBlocks.BELLOWING_CARVED_PUMPKIN, "Calabaza tallada rugiente");

        this.addBlock(ArtistryBlocks.WICKED_JACK_O_LANTERN, "Malvada calabaza de Halloween");
        this.addBlock(ArtistryBlocks.HUNGRY_JACK_O_LANTERN, "Hambrienta calabaza de Halloween");
        this.addBlock(ArtistryBlocks.HAPPY_JACK_O_LANTERN, "Feliz calabaza de Halloween");
        this.addBlock(ArtistryBlocks.STALWART_JACK_O_LANTERN, "Robusta calabaza de Halloween");
        this.addBlock(ArtistryBlocks.PEEKING_JACK_O_LANTERN, "Asomándose calabaza de Halloween");
        this.addBlock(ArtistryBlocks.BELLOWING_JACK_O_LANTERN, "Rugiente calabaza de Halloween");

        this.addBlock(ArtistryBlocks.TALL_CANDLE, "Vela alta");

        this.addBlock(ArtistryBlocks.WHITE_TALL_CANDLE, "Vela alta blanca");
        this.addBlock(ArtistryBlocks.LIGHT_GRAY_TALL_CANDLE, "Vela alta gris claro");
        this.addBlock(ArtistryBlocks.GRAY_TALL_CANDLE, "Vela alta gris");
        this.addBlock(ArtistryBlocks.BLACK_TALL_CANDLE, "Vela alta negra");
        this.addBlock(ArtistryBlocks.BROWN_TALL_CANDLE, "Vela alta marrón");
        this.addBlock(ArtistryBlocks.RED_TALL_CANDLE, "Vela alta roja");
        this.addBlock(ArtistryBlocks.ORANGE_TALL_CANDLE, "Vela alta naranja");
        this.addBlock(ArtistryBlocks.YELLOW_TALL_CANDLE, "Vela alta amarilla");
        this.addBlock(ArtistryBlocks.LIME_TALL_CANDLE, "Vela alta lima");
        this.addBlock(ArtistryBlocks.GREEN_TALL_CANDLE, "Vela alta verde");
        this.addBlock(ArtistryBlocks.CYAN_TALL_CANDLE, "Vela alta cian");
        this.addBlock(ArtistryBlocks.LIGHT_BLUE_TALL_CANDLE, "Vela alta azul claro");
        this.addBlock(ArtistryBlocks.BLUE_TALL_CANDLE, "Vela alta azul");
        this.addBlock(ArtistryBlocks.PURPLE_TALL_CANDLE, "Vela alta morada");
        this.addBlock(ArtistryBlocks.MAGENTA_TALL_CANDLE, "Vela alta magenta");
        this.addBlock(ArtistryBlocks.PINK_TALL_CANDLE, "Vela alta rosa");

        // Rotten

        this.addBlock(ArtistryBlocks.ROTTEN_LEAVES, "Hojas podridas");
        this.addBlock(ArtistryBlocks.ROTTEN_LOG, "Tronco podrido");
        this.addBlock(ArtistryBlocks.ROTTEN_WOOD, "Leño podrido");
        this.addBlock(ArtistryBlocks.STRIPPED_ROTTEN_LOG, "Tronco podrido sin corteza");
        this.addBlock(ArtistryBlocks.STRIPPED_ROTTEN_WOOD, "Leño podrido sin corteza");
        this.addBlock(ArtistryBlocks.ROTTEN_PLANKS, "Tablones podridos");
        this.addBlock(ArtistryBlocks.ROTTEN_STAIRS, "Escaleras podridas");
        this.addBlock(ArtistryBlocks.ROTTEN_SLAB, "Losa podrida");
        this.addBlock(ArtistryBlocks.ROTTEN_BUTTON, "Botón podrido");
        this.addBlock(ArtistryBlocks.ROTTEN_PRESSURE_PLATE, "Place de presión podrido");
        this.addBlock(ArtistryBlocks.ROTTEN_FENCE, "Valla podrida");
        this.addBlock(ArtistryBlocks.ROTTEN_FENCE_GATE, "Puerta de valla podrida");

        this.add("block.artistry.rotten_wall_sign", "Cartel podrido en pared");
        this.add("block.artistry.rotten_wall_hanging_sign", "Cartel colgante podrido temblón en pared");

        this.addBlock(ArtistryBlocks.ROTTEN_DOOR, "Puerta podrida");
        this.addBlock(ArtistryBlocks.ROTTEN_TRAPDOOR, "Trampilla podrida");
        this.addBlock(ArtistryBlocks.ROTTEN_SAPLING, "Brote podrido");
        this.addBlock(ArtistryBlocks.POTTED_ROTTEN_SAPLING, "Maceta con brote podrido");

        this.addPaintedPotBase(DyeColor.WHITE, "Base blanca");
        this.addPaintedPotBase(DyeColor.LIGHT_GRAY, "Base gris claro");
        this.addPaintedPotBase(DyeColor.GRAY, "Base gris");
        this.addPaintedPotBase(DyeColor.BLACK, "Base negra");
        this.addPaintedPotBase(DyeColor.BROWN, "Base marrón");
        this.addPaintedPotBase(DyeColor.RED, "Base roja");
        this.addPaintedPotBase(DyeColor.ORANGE, "Base naranja");
        this.addPaintedPotBase(DyeColor.YELLOW, "Base amarilla");
        this.addPaintedPotBase(DyeColor.LIME, "Base lima");
        this.addPaintedPotBase(DyeColor.GREEN, "Base verde");
        this.addPaintedPotBase(DyeColor.CYAN, "Base cian");
        this.addPaintedPotBase(DyeColor.LIGHT_BLUE, "Base azul claro");
        this.addPaintedPotBase(DyeColor.BLUE, "Base azul");
        this.addPaintedPotBase(DyeColor.PURPLE, "Base morada");
        this.addPaintedPotBase(DyeColor.MAGENTA, "Base magenta");
        this.addPaintedPotBase(DyeColor.PINK, "Base rosa");

        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.WAVY_TRIM, "Ribete ondulado");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.TICKED_TRIM, "Ribete marcado");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.MAW_TRIM, "Recorte de la boca");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.PYRAMIDS_TRIM, "Ribete piramidales");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.CORNERS_TRIM, "Ribete de esquinas");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.BOW_TRIM, "Ribete de arco");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.EYE_TRIM, "Ribete del ojo");
        this.addPaintedPotTrim(ArtistryPaintedPotDecorations.SEAM_TRIM, "Ribete de costura");

        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.FREQUENCY_PATTERN, "Patrón de frecuencia");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.RINGS_PATTERN, "Patrón de anillos");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.DOTS_PATTERN, "Patrón de puntos");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.CROSS_PATTERN, "Patrón cruzado");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.WAVE_PATTERN, "Patrón de onda");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.WEAVE_PATTERN, "Patrón de tejido");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.ARROWS_PATTERN, "Patrón de flechas");
        this.addPaintedPotPattern(ArtistryPaintedPotDecorations.CYCLE_PATTERN, "Patrón cíclico");

        this.add("artistry.jei.sniffer_dig.title", "Excavación con sniffer");
        this.add("artistry.jei.sniffer_dig.found_in", "encontrado en:");
        this.add("artistry.jei.leeching.title", "Extracción");

        this.add("itemGroup.artistry.base", "Artistry");

        this.add("artistry.configuration.tweaks", "Ajustes");
        this.add("artistry.config.server.survivability_changes", "Cambios de ubicación");
        this.add("artistry.config.server.sniffer_cake_motivation", "Pastel de sniffer motivación");
    }
}
