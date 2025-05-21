package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.*;
import com.feliscape.artistry.content.block.flammable.*;
import com.feliscape.artistry.data.worldgen.registry.ArtistryTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.BlockItem;
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
    public static final DeferredBlock<Block> MOSSY_STONE_TILES = registerBlockWithItem("mossy_stone_tiles", p -> new Block(p
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

    public static final DeferredBlock<StringLightsBlock> STRING_LIGHTS = registerBlockWithItem("string_lights",
            p -> new StringLightsBlock(p
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instabreak()
                    .sound(SoundType.WOOL)
                    .lightLevel(state -> 12)
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
            p -> new SaplingBlock(ArtistryTreeGrowers.PRISMA, p
                    .mapColor(MapColor.PLANT)
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)));
    //endregion


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
