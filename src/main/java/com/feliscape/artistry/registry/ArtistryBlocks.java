package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.RoundLanternBlock;
import com.feliscape.artistry.content.block.*;
import com.feliscape.artistry.content.block.flammable.*;
import com.feliscape.artistry.data.worldgen.registry.ArtistryTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ArtistryBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Artistry.MOD_ID);

    //region Stone Bricks Set
    public static final DeferredBlock<Block> MOSSY_BRICKS = registerBlockWithItem("mossy_bricks", p -> new Block(p
            .mapColor(MapColor.COLOR_RED)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> CRACKED_BRICKS = registerBlockWithItem("cracked_bricks", p -> new Block(p
            .mapColor(MapColor.COLOR_RED)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(2.0F, 6.0F)));

    public static final DeferredBlock<Block> STONE_TILES = registerBlockWithItem("stone_tiles", p -> new Block(p
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)));
    public static final DeferredBlock<StairBlock> STONE_TILE_STAIRS = registerBlockWithItem("stone_tile_stairs", p -> new StairBlock(
            STONE_TILES.get().defaultBlockState(), p
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)));
    public static final DeferredBlock<SlabBlock> STONE_TILE_SLAB = registerBlockWithItem("stone_tile_slab", p -> new SlabBlock(p
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)));


    public static final DeferredBlock<Block> MOSSY_STONE_TILES = registerBlockWithItem("mossy_stone_tiles", p -> new Block(p
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)));
    public static final DeferredBlock<StairBlock> MOSSY_STONE_TILE_STAIRS = registerBlockWithItem("mossy_stone_tile_stairs", p -> new StairBlock(
            STONE_TILES.get().defaultBlockState(), p
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)));
    public static final DeferredBlock<SlabBlock> MOSSY_STONE_TILE_SLAB = registerBlockWithItem("mossy_stone_tile_slab", p -> new SlabBlock(p
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)));


    public static final DeferredBlock<Block> OVERGROWN_STONE_TILES = registerBlockWithItem("overgrown_stone_tiles", p -> new Block(p
            .mapColor(MapColor.PLANT)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)));
    public static final DeferredBlock<RotatedPillarBlock> STONE_PILLAR = registerBlockWithItem("stone_pillar", p -> new RotatedPillarBlock(p
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)));
    public static final DeferredBlock<RotatedPillarBlock> MOSSY_STONE_PILLAR = registerBlockWithItem("mossy_stone_pillar", p -> new RotatedPillarBlock(p
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()
            .strength(1.5F, 6.0F)));
    //endregion

    public static final DeferredBlock<Block> ROCKY_DIRT = registerBlockWithItem("rocky_dirt",
            p -> new Block(p
                    .mapColor(MapColor.STONE)
                    .strength(1.2F)
                    .instrument(NoteBlockInstrument.BASEDRUM)
            ));

    public static final DeferredBlock<SunsproutBlock> SUNSPROUT = BLOCKS.registerBlock("sunsprout",
            p -> new SunsproutBlock(p
                    .mapColor(MapColor.PLANT)
                    .randomTicks()
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
            ));
    public static final DeferredBlock<SunburstVinesBlock> SUNBURST_VINES = BLOCKS.registerBlock("sunburst_vines",
            p -> new SunburstVinesBlock(p
                    .mapColor(MapColor.PLANT)
                    .randomTicks()
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
            ));
    public static final DeferredBlock<SunburstVinesPlantBlock> SUNBURST_VINES_PLANT = BLOCKS.registerBlock("sunburst_vines_plant",
            p -> new SunburstVinesPlantBlock(p
                    .mapColor(MapColor.PLANT)
                    .randomTicks()
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.CAVE_VINES)
                    .pushReaction(PushReaction.DESTROY)
            ));

    public static final DeferredBlock<TableBlock> OAK_TABLE = registerBlockWithItem("oak_table", p -> table(p, MapColor.WOOD));
    public static final DeferredBlock<TableBlock> SPRUCE_TABLE = registerBlockWithItem("spruce_table", p -> table(p, MapColor.PODZOL));
    public static final DeferredBlock<TableBlock> BIRCH_TABLE = registerBlockWithItem("birch_table", p -> table(p, MapColor.SAND));
    public static final DeferredBlock<TableBlock> JUNGLE_TABLE = registerBlockWithItem("jungle_table", p -> table(p, MapColor.DIRT));
    public static final DeferredBlock<TableBlock> ACACIA_TABLE = registerBlockWithItem("acacia_table", p -> table(p, MapColor.COLOR_ORANGE));
    public static final DeferredBlock<TableBlock> CHERRY_TABLE = registerBlockWithItem("cherry_table", p -> table(p, MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD));
    public static final DeferredBlock<TableBlock> DARK_OAK_TABLE = registerBlockWithItem("dark_oak_table", p -> table(p, MapColor.COLOR_BROWN));
    public static final DeferredBlock<TableBlock> MANGROVE_TABLE = registerBlockWithItem("mangrove_table", p -> table(p, MapColor.COLOR_RED));
    public static final DeferredBlock<TableBlock> ASPEN_TABLE = registerBlockWithItem("aspen_table", p -> table(p, MapColor.SAND));
    public static final DeferredBlock<TableBlock> BAMBOO_TABLE = registerBlockWithItem("bamboo_table", p -> table(p, MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD));
    public static final DeferredBlock<TableBlock> CRIMSON_TABLE = registerBlockWithItem("crimson_table", p -> inflammableTable(p, MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD));
    public static final DeferredBlock<TableBlock> WARPED_TABLE = registerBlockWithItem("warped_table", p -> inflammableTable(p, MapColor.WARPED_STEM, SoundType.NETHER_WOOD));

    public static final DeferredBlock<TableBlock> STONE_TABLE = registerBlockWithItem("stone_table", p -> stoneTable(p, MapColor.STONE, SoundType.STONE));
    public static final DeferredBlock<TableBlock> ANDESITE_TABLE = registerBlockWithItem("andesite_table", p -> stoneTable(p, MapColor.STONE, SoundType.STONE));
    public static final DeferredBlock<TableBlock> GRANITE_TABLE = registerBlockWithItem("granite_table", p -> stoneTable(p, MapColor.DIRT, SoundType.STONE));
    public static final DeferredBlock<TableBlock> DIORITE_TABLE = registerBlockWithItem("diorite_table", p -> stoneTable(p, MapColor.QUARTZ, SoundType.STONE));
    public static final DeferredBlock<TableBlock> DEEPSLATE_TABLE = registerBlockWithItem("deepslate_table", p -> stoneTable(p, MapColor.DEEPSLATE, SoundType.POLISHED_DEEPSLATE));
    public static final DeferredBlock<TableBlock> POLISHED_BLACKSTONE_TABLE = registerBlockWithItem("polished_blackstone_table", p -> stoneTable(p, MapColor.COLOR_BLACK, SoundType.STONE));
    public static final DeferredBlock<TableBlock> TUFF_TABLE = registerBlockWithItem("tuff_table", p -> stoneTable(p, MapColor.TERRACOTTA_GRAY, SoundType.POLISHED_TUFF));
    public static final DeferredBlock<TableBlock> CALCITE_TABLE = registerBlockWithItem("calcite_table", p -> stoneTable(p, MapColor.TERRACOTTA_WHITE, SoundType.CALCITE));

    public static final DeferredBlock<FrostedGlassBlock> WHITE_FROSTED_GLASS = frostedGlass(DyeColor.WHITE);
    public static final DeferredBlock<FrostedGlassBlock> LIGHT_GRAY_FROSTED_GLASS = frostedGlass(DyeColor.LIGHT_GRAY);
    public static final DeferredBlock<FrostedGlassBlock> GRAY_FROSTED_GLASS = frostedGlass(DyeColor.GRAY);
    public static final DeferredBlock<FrostedGlassBlock> BLACK_FROSTED_GLASS = frostedGlass(DyeColor.BLACK);
    public static final DeferredBlock<FrostedGlassBlock> BROWN_FROSTED_GLASS = frostedGlass(DyeColor.BROWN);
    public static final DeferredBlock<FrostedGlassBlock> RED_FROSTED_GLASS = frostedGlass(DyeColor.RED);
    public static final DeferredBlock<FrostedGlassBlock> ORANGE_FROSTED_GLASS = frostedGlass(DyeColor.ORANGE);
    public static final DeferredBlock<FrostedGlassBlock> YELLOW_FROSTED_GLASS = frostedGlass(DyeColor.YELLOW);
    public static final DeferredBlock<FrostedGlassBlock> LIME_FROSTED_GLASS = frostedGlass(DyeColor.LIME);
    public static final DeferredBlock<FrostedGlassBlock> GREEN_FROSTED_GLASS = frostedGlass(DyeColor.GREEN);
    public static final DeferredBlock<FrostedGlassBlock> CYAN_FROSTED_GLASS = frostedGlass(DyeColor.CYAN);
    public static final DeferredBlock<FrostedGlassBlock> LIGHT_BLUE_FROSTED_GLASS = frostedGlass(DyeColor.LIGHT_BLUE);
    public static final DeferredBlock<FrostedGlassBlock> BLUE_FROSTED_GLASS = frostedGlass(DyeColor.BLUE);
    public static final DeferredBlock<FrostedGlassBlock> PURPLE_FROSTED_GLASS = frostedGlass(DyeColor.PURPLE);
    public static final DeferredBlock<FrostedGlassBlock> MAGENTA_FROSTED_GLASS = frostedGlass(DyeColor.MAGENTA);
    public static final DeferredBlock<FrostedGlassBlock> PINK_FROSTED_GLASS = frostedGlass(DyeColor.PINK);

    public static final DeferredBlock<WeatheringCopperChainBlock> COPPER_CHAIN = registerBlockWithItem("copper_chain",
            p -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.UNAFFECTED, p
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.CHAIN)
                    .noOcclusion()
            ));
    public static final DeferredBlock<WeatheringCopperChainBlock> EXPOSED_COPPER_CHAIN = registerBlockWithItem("exposed_copper_chain",
            p -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.EXPOSED, p
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.CHAIN)
                    .noOcclusion()
            ));
    public static final DeferredBlock<WeatheringCopperChainBlock> WEATHERED_COPPER_CHAIN = registerBlockWithItem("weathered_copper_chain",
            p -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.WEATHERED, p
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.CHAIN)
                    .noOcclusion()
            ));
    public static final DeferredBlock<WeatheringCopperChainBlock> OXIDIZED_COPPER_CHAIN = registerBlockWithItem("oxidized_copper_chain",
            p -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.OXIDIZED, p
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.CHAIN)
                    .noOcclusion()
            ));

    public static final DeferredBlock<ChainBlock> WAXED_COPPER_CHAIN = registerBlockWithItem("waxed_copper_chain",
            p -> new ChainBlock(p
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.CHAIN)
                    .noOcclusion()
            ));
    public static final DeferredBlock<ChainBlock> WAXED_EXPOSED_COPPER_CHAIN = registerBlockWithItem("waxed_exposed_copper_chain",
            p -> new ChainBlock(p
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.CHAIN)
                    .noOcclusion()
            ));
    public static final DeferredBlock<ChainBlock> WAXED_WEATHERED_COPPER_CHAIN = registerBlockWithItem("waxed_weathered_copper_chain",
            p -> new ChainBlock(p
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.CHAIN)
                    .noOcclusion()
            ));
    public static final DeferredBlock<ChainBlock> WAXED_OXIDIZED_COPPER_CHAIN = registerBlockWithItem("waxed_oxidized_copper_chain",
            p -> new ChainBlock(p
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.CHAIN)
                    .noOcclusion()
            ));

    public static final DeferredBlock<StringLightsBlock> STRING_LIGHTS = BLOCKS.registerBlock("string_lights",
            p -> new StringLightsBlock(p
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instabreak()
                    .sound(SoundType.WOOL)
                    .lightLevel(state -> 12)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
                    ));
    public static final DeferredBlock<WallStringLightsBlock> WALL_STRING_LIGHTS = BLOCKS.registerBlock("wall_string_lights",
            p -> new WallStringLightsBlock(p
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instabreak()
                    .sound(SoundType.WOOL)
                    .lightLevel(state -> 12)
                    .noCollission()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
                    ));

    public static final DeferredBlock<LargeLanternBlock> LARGE_LANTERN = registerBlockWithItem("large_lantern",
            p -> new LargeLanternBlock(p
                    .mapColor(MapColor.METAL)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightLevel(state -> 15)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
                    ));
    public static final DeferredBlock<LargeLanternBlock> LARGE_SOUL_LANTERN = registerBlockWithItem("large_soul_lantern",
            p -> new LargeLanternBlock(p
                    .mapColor(MapColor.METAL)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightLevel(state -> 10)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
                    ));
    public static final DeferredBlock<RoundLanternBlock> ROUND_LANTERN = registerBlockWithItem("round_lantern",
            p -> new RoundLanternBlock(p
                    .mapColor(MapColor.METAL)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightLevel(state -> 15)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
                    ));
    public static final DeferredBlock<FlatLightBlock> FLAT_LIGHT = registerBlockWithItem("flat_light",
            p -> new FlatLightBlock(p
                    .mapColor(MapColor.METAL)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.LANTERN)
                    .lightLevel(state -> 15)
                    .noOcclusion()
                    .noCollission()
                    .pushReaction(PushReaction.DESTROY)
                    ));

    public static final DeferredBlock<SparklerBlock> SPARKLER = registerBlockWithItem("sparkler",
            p -> new SparklerBlock(p
                    .mapColor(MapColor.COLOR_PURPLE)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
            ));
    public static final DeferredBlock<AmethystStarsBlock> AMETHYST_STARS = registerBlockWithItem("amethyst_stars",
            p -> new AmethystStarsBlock(p
                    .mapColor(MapColor.COLOR_PURPLE)
                    .instabreak()
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .lightLevel(state -> 5)
                    .noOcclusion()
                    .noCollission()
                    .pushReaction(PushReaction.DESTROY)
            ));

    public static final DeferredBlock<SparkFountainBlock> SPARK_FOUNTAIN = BLOCKS.registerBlock("spark_fountain",
            p -> new SparkFountainBlock(p
                    .mapColor(MapColor.COLOR_BLUE)
                    .instabreak()
                    .lightLevel(state -> state.getValue(SparkFountainBlock.POWERED) ? 8 : 0)
                    .sound(SoundType.BAMBOO)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
            ));
    public static final DeferredBlock<WaterFountainBlock> WATER_FOUNTAIN = registerBlockWithItem("water_fountain",
            p -> new WaterFountainBlock(p
                    .mapColor(MapColor.SNOW)
                    .strength(1.5F, 6.0F)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
            ));


    public static final DeferredBlock<BloomingVinesBlock> BLOOMING_VINES = registerBlockWithItem("blooming_vines",
            p -> new BloomingVinesBlock(p
                    .mapColor(MapColor.PLANT)
                    .replaceable()
                    .noCollission()
                    .randomTicks()
                    .strength(0.2F)
                    .sound(SoundType.CAVE_VINES)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            ));
    public static final DeferredBlock<LushFernBlock> LUSH_FERN = registerBlockWithItem("lush_fern",
            p -> new LushFernBlock(p
                    .mapColor(MapColor.PLANT)
                    .replaceable()
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            ));
    public static final DeferredBlock<LushFernCropBlock> LUSH_FERN_CROP = BLOCKS.registerBlock("lush_fern_crop",
            p -> new LushFernCropBlock(p
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)
            ));
    public static final DeferredBlock<TeardropGrassBlock> TEARDROP_GRASS = registerBlockWithItem("teardrop_grass",
            p -> new TeardropGrassBlock(p
                    .mapColor(MapColor.PLANT)
                    .replaceable()
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            ));

    public static final DeferredBlock<FlowerPotBlock> POTTED_TEARDROP_GRASS = BLOCKS.registerBlock("potted_teardrop_grass",
            p -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, TEARDROP_GRASS, p
                    .instabreak()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<PaintedPotBlock> PAINTED_POT = BLOCKS.registerBlock("painted_pot",
            p -> new PaintedPotBlock(p
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .strength(0.0F, 0.0F)
                    .pushReaction(PushReaction.DESTROY)
                    .noOcclusion()
            ));

    //region Calcite

    public static final DeferredBlock<StairBlock> CALCITE_STAIRS = registerBlockWithItem("calcite_stairs",
            p -> new StairBlock(Blocks.CALCITE.defaultBlockState(), p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<SlabBlock> CALCITE_SLAB = registerBlockWithItem("calcite_slab",
            p -> new SlabBlock(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<WallBlock> CALCITE_WALL = registerBlockWithItem("calcite_wall",
            p -> new WallBlock(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));


    public static final DeferredBlock<Block> SMOOTH_CALCITE = registerBlockWithItem("smooth_calcite",
            p -> new Block(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<StairBlock> SMOOTH_CALCITE_STAIRS = registerBlockWithItem("smooth_calcite_stairs",
            p -> new StairBlock(Blocks.CALCITE.defaultBlockState(), p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<SlabBlock> SMOOTH_CALCITE_SLAB = registerBlockWithItem("smooth_calcite_slab",
            p -> new SlabBlock(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));

    public static final DeferredBlock<Block> POLISHED_CALCITE = registerBlockWithItem("polished_calcite",
            p -> new Block(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<Block> CHISELED_CALCITE = registerBlockWithItem("chiseled_calcite",
            p -> new Block(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<StairBlock> POLISHED_CALCITE_STAIRS = registerBlockWithItem("polished_calcite_stairs",
            p -> new StairBlock(POLISHED_CALCITE.get().defaultBlockState(), p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<SlabBlock> POLISHED_CALCITE_SLAB = registerBlockWithItem("polished_calcite_slab",
            p -> new SlabBlock(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<WallBlock> POLISHED_CALCITE_WALL = registerBlockWithItem("polished_calcite_wall",
            p -> new WallBlock(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));

    public static final DeferredBlock<Block> CALCITE_BRICKS = registerBlockWithItem("calcite_bricks",
            p -> new Block(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<StairBlock> CALCITE_BRICK_STAIRS = registerBlockWithItem("calcite_brick_stairs",
            p -> new StairBlock(CALCITE_BRICKS.get().defaultBlockState(), p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<SlabBlock> CALCITE_BRICK_SLAB = registerBlockWithItem("calcite_brick_slab",
            p -> new SlabBlock(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<WallBlock> CALCITE_BRICK_WALL = registerBlockWithItem("calcite_brick_wall",
            p -> new WallBlock(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));

    public static final DeferredBlock<Block> SMALL_CALCITE_BRICKS = registerBlockWithItem("small_calcite_bricks",
            p -> new Block(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<StairBlock> SMALL_CALCITE_BRICK_STAIRS = registerBlockWithItem("small_calcite_brick_stairs",
            p -> new StairBlock(SMALL_CALCITE_BRICKS.get().defaultBlockState(), p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<SlabBlock> SMALL_CALCITE_BRICK_SLAB = registerBlockWithItem("small_calcite_brick_slab",
            p -> new SlabBlock(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));



    public static final DeferredBlock<Block> PAINTED_SMOOTH_CALCITE = registerBlockWithItem("painted_smooth_calcite",
            p -> new Block(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<Block> PAINTED_POLISHED_CALCITE = registerBlockWithItem("painted_polished_calcite",
            p -> new Block(p
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<Block> PAINTED_CALCITE_BRICKS = registerBlockWithItem("painted_calcite_bricks",
            p -> new Block(p
                    .mapColor(MapColor.LAPIS)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));
    public static final DeferredBlock<Block> PAINTED_SMALL_CALCITE_BRICKS = registerBlockWithItem("painted_small_calcite_bricks",
            p -> new Block(p
                    .mapColor(MapColor.LAPIS)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.CALCITE)
                    .requiresCorrectToolForDrops()
                    .strength(0.75F)
            ));

    //endregion

    //region Dripstone


    public static final DeferredBlock<StairBlock> DRIPSTONE_STAIRS = registerBlockWithItem("dripstone_stairs",
            p -> new StairBlock(Blocks.DRIPSTONE_BLOCK.defaultBlockState(), p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));
    public static final DeferredBlock<SlabBlock> DRIPSTONE_SLAB = registerBlockWithItem("dripstone_slab",
            p -> new SlabBlock(p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));
    public static final DeferredBlock<WallBlock> DRIPSTONE_WALL = registerBlockWithItem("dripstone_wall",
            p -> new WallBlock(p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));

    public static final DeferredBlock<Block> POLISHED_DRIPSTONE = registerBlockWithItem("polished_dripstone",
            p -> new Block(p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));
    public static final DeferredBlock<StairBlock> POLISHED_DRIPSTONE_STAIRS = registerBlockWithItem("polished_dripstone_stairs",
            p -> new StairBlock(ArtistryBlocks.POLISHED_DRIPSTONE.get().defaultBlockState(), p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));
    public static final DeferredBlock<SlabBlock> POLISHED_DRIPSTONE_SLAB = registerBlockWithItem("polished_dripstone_slab",
            p -> new SlabBlock(p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));
    public static final DeferredBlock<WallBlock> POLISHED_DRIPSTONE_WALL = registerBlockWithItem("polished_dripstone_wall",
            p -> new WallBlock(p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));


    public static final DeferredBlock<Block> DRIPSTONE_BRICKS = registerBlockWithItem("dripstone_bricks",
            p -> new Block(p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));

    public static final DeferredBlock<StairBlock> DRIPSTONE_BRICK_STAIRS = registerBlockWithItem("dripstone_brick_stairs",
            p -> new StairBlock(ArtistryBlocks.DRIPSTONE_BRICKS.get().defaultBlockState(), p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));
    public static final DeferredBlock<SlabBlock> DRIPSTONE_BRICK_SLAB = registerBlockWithItem("dripstone_brick_slab",
            p -> new SlabBlock(p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));
    public static final DeferredBlock<WallBlock> DRIPSTONE_BRICK_WALL = registerBlockWithItem("dripstone_brick_wall",
            p -> new WallBlock(p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));

    public static final DeferredBlock<Block> CHISELED_DRIPSTONE = registerBlockWithItem("chiseled_dripstone",
            p -> new Block(p
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sound(SoundType.DRIPSTONE_BLOCK)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 1.0F)
            ));

    //endregion

    //region Aspen Wood

    public static final DeferredBlock<FlammableLeavesBlock> ASPEN_LEAVES = registerBlockWithItem("aspen_leaves",
            p -> flammableLeaves(p, SoundType.GRASS));

    public static final DeferredBlock<FlammableLogBlock> ASPEN_LOG = registerBlockWithItem("aspen_log",
            p -> log(p, MapColor.SAND, MapColor.SNOW));
    public static final DeferredBlock<FlammableLogBlock> ASPEN_WOOD = registerBlockWithItem("aspen_wood",
            p -> log(p, MapColor.SNOW, MapColor.SNOW));
    public static final DeferredBlock<FlammableLogBlock> STRIPPED_ASPEN_LOG = registerBlockWithItem("stripped_aspen_log",
            p -> log(p, MapColor.SAND, MapColor.SAND));
    public static final DeferredBlock<FlammableLogBlock> STRIPPED_ASPEN_WOOD = registerBlockWithItem("stripped_aspen_wood",
            p -> log(p, MapColor.SAND, MapColor.SAND));

    public static final DeferredBlock<FlammableBlock> ASPEN_PLANKS = registerBlockWithItem("aspen_planks",
            p -> new FlammableBlock(p
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
            ));

    public static final DeferredBlock<ModStandingSignBlock> ASPEN_SIGN = BLOCKS.registerBlock("aspen_sign",
            p -> new ModStandingSignBlock(ArtistryWoodTypes.ASPEN, p
                    .mapColor(MapColor.SAND)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.0F)
                    .ignitedByLava()));
    public static final DeferredBlock<ModWallSignBlock> ASPEN_WALL_SIGN = BLOCKS.registerBlock("aspen_wall_sign",
            p -> new ModWallSignBlock(ArtistryWoodTypes.ASPEN, p
                    .mapColor(MapColor.SAND)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.0F)
                    .ignitedByLava()));

    public static final DeferredBlock<ModHangingSignBlock> ASPEN_HANGING_SIGN = BLOCKS.registerBlock("aspen_hanging_sign",
            p -> new ModHangingSignBlock(ArtistryWoodTypes.ASPEN, p
                    .mapColor(MapColor.SAND)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.0F)
                    .ignitedByLava()));
    public static final DeferredBlock<ModWallHangingSignBlock> ASPEN_WALL_HANGING_SIGN = BLOCKS.registerBlock("aspen_wall_hanging_sign",
            p -> new ModWallHangingSignBlock(ArtistryWoodTypes.ASPEN, p
                    .mapColor(MapColor.SAND)
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(1.0F)
                    .ignitedByLava()));

    public static final DeferredBlock<FlammableStairBlock> ASPEN_STAIRS = registerBlockWithItem("aspen_stairs",
            p -> flammableStair(ASPEN_PLANKS.get()));
    public static final DeferredBlock<FlammableSlabBlock> ASPEN_SLAB = registerBlockWithItem("aspen_slab",
            p -> new FlammableSlabBlock(p
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()));

    public static final DeferredBlock<ButtonBlock> ASPEN_BUTTON = registerBlockWithItem("aspen_button",
            p -> woodenButton(ArtistryBlockSetTypes.ASPEN));
    public static final DeferredBlock<PressurePlateBlock> ASPEN_PRESSURE_PLATE = registerBlockWithItem("aspen_pressure_plate",
            p -> new PressurePlateBlock(ArtistryBlockSetTypes.ASPEN, p
                    .mapColor(ASPEN_PLANKS.get().defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollission()
                    .strength(0.5F)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
            ));

    public static final DeferredBlock<FlammableFenceBlock> ASPEN_FENCE = registerBlockWithItem("aspen_fence",
            p -> new FlammableFenceBlock(p
                    .mapColor(ASPEN_PLANKS.get().defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .ignitedByLava()
                    .sound(SoundType.WOOD)
            ));
    public static final DeferredBlock<FlammableFenceGateBlock> ASPEN_FENCE_GATE = registerBlockWithItem("aspen_fence_gate",
            p -> new FlammableFenceGateBlock(ArtistryWoodTypes.ASPEN, p
                    .mapColor(ASPEN_PLANKS.get().defaultMapColor())
                    .forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .ignitedByLava()));

    public static final DeferredBlock<FlammableDoorBlock> ASPEN_DOOR = registerBlockWithItem("aspen_door",
            p -> new FlammableDoorBlock(ArtistryBlockSetTypes.ASPEN, p
                    .mapColor(ASPEN_PLANKS.get().defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .noOcclusion()
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<FlammableTrapdoorBlock> ASPEN_TRAPDOOR = registerBlockWithItem("aspen_trapdoor",
            p -> new FlammableTrapdoorBlock(ArtistryBlockSetTypes.ASPEN, p
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .noOcclusion()
                    .isValidSpawn(Blocks::never)
                    .ignitedByLava()));

    public static final DeferredBlock<SaplingBlock> ASPEN_SAPLING = registerBlockWithItem("aspen_sapling",
            p -> new SaplingBlock(ArtistryTreeGrowers.ASPEN, p
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_ASPEN_SAPLING = BLOCKS.registerBlock("potted_aspen_sapling",
            p -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ASPEN_SAPLING, p
                    .instabreak()
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)));
    //endregion

    private static DeferredBlock<FrostedGlassBlock> frostedGlass(DyeColor color) {
        return registerBlockWithItem(color.getName() + "_frosted_glass", p -> new FrostedGlassBlock(color, p
                .mapColor(color)
                .instrument(NoteBlockInstrument.HAT)
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn(Blocks::never)
                .isRedstoneConductor(ArtistryBlocks::never)
                .isSuffocating(ArtistryBlocks::never)
        ));
    }

    private static TableBlock table(BlockBehaviour.Properties properties, MapColor mapColor) {
        return ArtistryBlocks.table(properties, mapColor, SoundType.WOOD);
    }
    private static TableBlock table(BlockBehaviour.Properties properties, MapColor mapColor, SoundType soundType) {
        return new TableBlock(
                properties
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .sound(soundType)
                        .ignitedByLava()
        );
    }
    private static TableBlock inflammableTable(BlockBehaviour.Properties properties, MapColor mapColor, SoundType soundType) {
        return new TableBlock(
                properties
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F)
                        .sound(soundType)
        , false);
    }
    private static TableBlock stoneTable(BlockBehaviour.Properties properties, MapColor mapColor, SoundType soundType) {
        return new TableBlock(
                properties
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .strength(1.5F, 6.0F)
                        .requiredFeatures()
                        .sound(soundType)
        , false);
    }

    private static FlammableLogBlock log(BlockBehaviour.Properties properties, MapColor topMapColor, MapColor sideMapColor) {
        return new FlammableLogBlock(
                properties
                        .mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava()
        );
    }

    private static LeavesBlock leaves(BlockBehaviour.Properties properties, SoundType soundType) {
        return new LeavesBlock(
                properties
                        .mapColor(MapColor.PLANT)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(soundType)
                        .noOcclusion()
                        .isValidSpawn(Blocks::ocelotOrParrot)
                        .isSuffocating(ArtistryBlocks::never)
                        .isViewBlocking(ArtistryBlocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(ArtistryBlocks::never)
        );
    }
    private static FlammableLeavesBlock flammableLeaves(BlockBehaviour.Properties properties, SoundType soundType) {
        return new FlammableLeavesBlock(
                properties
                        .mapColor(MapColor.PLANT)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(soundType)
                        .noOcclusion()
                        .isValidSpawn(Blocks::ocelotOrParrot)
                        .isSuffocating(ArtistryBlocks::never)
                        .isViewBlocking(ArtistryBlocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(ArtistryBlocks::never)
        );
    }

    private static boolean always(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }

    private static FlammableStairBlock flammableStair(Block baseBlock) {
        return new FlammableStairBlock(baseBlock.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }

    private static ButtonBlock woodenButton(BlockSetType type) {
        return new ButtonBlock(type, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY));
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, ? extends T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, DeferredBlock<T> block)
    {
        return ArtistryItems.ITEMS.registerItem(name, p -> new BlockItem(block.get(), p));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
