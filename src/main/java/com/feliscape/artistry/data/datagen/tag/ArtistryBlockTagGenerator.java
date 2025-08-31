package com.feliscape.artistry.data.datagen.tag;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static com.feliscape.artistry.registry.ArtistryBlocks.*;

public class ArtistryBlockTagGenerator extends BlockTagsProvider {
    public ArtistryBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Artistry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(
                        ASPEN_LEAVES.get(),
                        ROTTEN_LEAVES.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        CRACKED_BRICKS.get(),
                        MOSSY_BRICKS.get(),
                        STONE_TILES.get(),
                        STONE_TILE_STAIRS.get(),
                        STONE_TILE_SLAB.get(),

                        MOSSY_STONE_TILES.get(),
                        MOSSY_STONE_TILE_STAIRS.get(),
                        MOSSY_STONE_TILE_SLAB.get(),

                        OVERGROWN_STONE_TILES.get(),
                        STONE_PILLAR.get(),
                        MOSSY_STONE_PILLAR.get(),
                        LARGE_LANTERN.get(),
                        LARGE_SOUL_LANTERN.get(),
                        ROUND_LANTERN.get(),
                        FLAT_LIGHT.get(),
                        SPARKLER.get(),
                        FLY_LURE.get(),

                        COPPER_CHAIN.get(),
                        EXPOSED_COPPER_CHAIN.get(),
                        WEATHERED_COPPER_CHAIN.get(),
                        OXIDIZED_COPPER_CHAIN.get(),
                        WAXED_COPPER_CHAIN.get(),
                        WAXED_EXPOSED_COPPER_CHAIN.get(),
                        WAXED_WEATHERED_COPPER_CHAIN.get(),
                        WAXED_OXIDIZED_COPPER_CHAIN.get(),

                        WATER_FOUNTAIN.get(),

                        STONE_TABLE.get(),
                        ANDESITE_TABLE.get(),
                        GRANITE_TABLE.get(),
                        DIORITE_TABLE.get(),
                        DEEPSLATE_TABLE.get(),
                        POLISHED_BLACKSTONE_TABLE.get(),
                        TUFF_TABLE.get(),
                        CALCITE_TABLE.get(),

                        ROCKY_DIRT.get(),

                        CALCITE_STAIRS.get(),
                        CALCITE_SLAB.get(),
                        CALCITE_WALL.get(),

                        SMOOTH_CALCITE.get(),
                        SMOOTH_CALCITE_STAIRS.get(),
                        SMOOTH_CALCITE_SLAB.get(),

                        POLISHED_CALCITE.get(),
                        CHISELED_CALCITE.get(),
                        POLISHED_CALCITE_STAIRS.get(),
                        POLISHED_CALCITE_SLAB.get(),
                        POLISHED_CALCITE_WALL.get(),
                        CALCITE_BRICKS.get(),
                        CALCITE_BRICK_STAIRS.get(),
                        CALCITE_BRICK_SLAB.get(),
                        CALCITE_BRICK_WALL.get(),
                        SMALL_CALCITE_BRICKS.get(),
                        SMALL_CALCITE_BRICK_STAIRS.get(),
                        SMALL_CALCITE_BRICK_SLAB.get(),

                        WHITE_FROSTED_GLASS.get(),
                        LIGHT_GRAY_FROSTED_GLASS.get(),
                        GRAY_FROSTED_GLASS.get(),
                        BLACK_FROSTED_GLASS.get(),
                        BROWN_FROSTED_GLASS.get(),
                        RED_FROSTED_GLASS.get(),
                        ORANGE_FROSTED_GLASS.get(),
                        YELLOW_FROSTED_GLASS.get(),
                        LIME_FROSTED_GLASS.get(),
                        GREEN_FROSTED_GLASS.get(),
                        CYAN_FROSTED_GLASS.get(),
                        LIGHT_BLUE_FROSTED_GLASS.get(),
                        BLUE_FROSTED_GLASS.get(),
                        PURPLE_FROSTED_GLASS.get(),
                        MAGENTA_FROSTED_GLASS.get(),
                        PINK_FROSTED_GLASS.get(),

                        PAINTED_SMOOTH_CALCITE.get(),
                        PAINTED_POLISHED_CALCITE.get(),
                        PAINTED_CALCITE_BRICKS.get(),
                        PAINTED_SMALL_CALCITE_BRICKS.get(),

                        DRIPSTONE_STAIRS.get(),
                        DRIPSTONE_SLAB.get(),
                        DRIPSTONE_WALL.get(),

                        POLISHED_DRIPSTONE.get(),
                        CHISELED_DRIPSTONE.get(),
                        POLISHED_DRIPSTONE_STAIRS.get(),
                        POLISHED_DRIPSTONE_SLAB.get(),
                        POLISHED_DRIPSTONE_WALL.get(),
                        DRIPSTONE_BRICKS.get(),
                        DRIPSTONE_BRICK_STAIRS.get(),
                        DRIPSTONE_BRICK_SLAB.get(),
                        DRIPSTONE_BRICK_WALL.get(),

                        HEADSTONE.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(ArtistryTags.Blocks.WOODEN_TABLES).add(
                        WICKED_CARVED_PUMPKIN.get(),
                        HUNGRY_CARVED_PUMPKIN.get(),
                        HAPPY_CARVED_PUMPKIN.get(),
                        STALWART_CARVED_PUMPKIN.get(),
                        PEEKING_CARVED_PUMPKIN.get(),
                        BELLOWING_CARVED_PUMPKIN.get(),

                        WICKED_JACK_O_LANTERN.get(),
                        HUNGRY_JACK_O_LANTERN.get(),
                        HAPPY_JACK_O_LANTERN.get(),
                        STALWART_JACK_O_LANTERN.get(),
                        PEEKING_JACK_O_LANTERN.get(),
                        BELLOWING_JACK_O_LANTERN.get(),

                        BLOOMING_VINES.get(),
                        SUNSPROUT.get(),
                        SUNBURST_VINES.get(),
                        SUNBURST_VINES_PLANT.get(),
                        BLOOMING_VINES.get(),
                        SHORT_TEARDROP_GRASS.get(),
                        LUSH_FERN.get(),
                        LUSH_FERN_CROP.get(),
                        CORPSE_FLOWER.get(),
                        FLY_LURE.get(),
                        HONEYDEW_FRUIT.get(),
                        HONEYDEW_STALK.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ROCKY_DIRT.get())
                .add(TEARDROP_GRASS_BLOCK.get())
                .add(LEECHING_SOIL.get())
                .add(WAXED_LEECHING_SOIL.get())
        ;

        this.tag(ArtistryTags.Blocks.FROSTED_GLASS)
                .add(
                        WHITE_FROSTED_GLASS.get(),
                        LIGHT_GRAY_FROSTED_GLASS.get(),
                        GRAY_FROSTED_GLASS.get(),
                        BLACK_FROSTED_GLASS.get(),
                        BROWN_FROSTED_GLASS.get(),
                        RED_FROSTED_GLASS.get(),
                        ORANGE_FROSTED_GLASS.get(),
                        YELLOW_FROSTED_GLASS.get(),
                        LIME_FROSTED_GLASS.get(),
                        GREEN_FROSTED_GLASS.get(),
                        CYAN_FROSTED_GLASS.get(),
                        LIGHT_BLUE_FROSTED_GLASS.get(),
                        BLUE_FROSTED_GLASS.get(),
                        PURPLE_FROSTED_GLASS.get(),
                        MAGENTA_FROSTED_GLASS.get(),
                        PINK_FROSTED_GLASS.get()
                );

        this.tag(ArtistryTags.Blocks.UNDERGROUND_PLANT_SOIL)
                .addTag(Tags.Blocks.STONES)
                .add(Blocks.CALCITE)
                .add(Blocks.GRAVEL)
                .add(Blocks.INFESTED_STONE)
                .add(Blocks.INFESTED_DEEPSLATE)
                .add(Blocks.SUSPICIOUS_GRAVEL)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.MOSSY_COBBLESTONE)
                .add(Blocks.INFESTED_COBBLESTONE)
                .add(ROCKY_DIRT.get())
        ;
        this.tag(ArtistryTags.Blocks.LEECHABLE_SAPLINGS)
                .addTag(BlockTags.SAPLINGS)
                .remove(ROTTEN_SAPLING.get())
        ;
        this.tag(ArtistryTags.Blocks.CARVABLE_PUMPKINS).add(
                        Blocks.PUMPKIN,
                        Blocks.CARVED_PUMPKIN,
                        ArtistryBlocks.WICKED_CARVED_PUMPKIN.get(),
                        ArtistryBlocks.HUNGRY_CARVED_PUMPKIN.get(),
                        ArtistryBlocks.HAPPY_CARVED_PUMPKIN.get(),
                        ArtistryBlocks.STALWART_CARVED_PUMPKIN.get(),
                        ArtistryBlocks.PEEKING_CARVED_PUMPKIN.get(),
                        ArtistryBlocks.BELLOWING_CARVED_PUMPKIN.get()
        );
        this.tag(Tags.Blocks.PUMPKINS_CARVED).add(
                        ArtistryBlocks.WICKED_CARVED_PUMPKIN.get(),
                        ArtistryBlocks.HUNGRY_CARVED_PUMPKIN.get(),
                        ArtistryBlocks.HAPPY_CARVED_PUMPKIN.get(),
                        ArtistryBlocks.STALWART_CARVED_PUMPKIN.get(),
                        ArtistryBlocks.PEEKING_CARVED_PUMPKIN.get(),
                        ArtistryBlocks.BELLOWING_CARVED_PUMPKIN.get()
        );
        this.tag(Tags.Blocks.PUMPKINS_JACK_O_LANTERNS).add(
                        ArtistryBlocks.WICKED_JACK_O_LANTERN.get(),
                        ArtistryBlocks.HUNGRY_JACK_O_LANTERN.get(),
                        ArtistryBlocks.HAPPY_JACK_O_LANTERN.get(),
                        ArtistryBlocks.STALWART_JACK_O_LANTERN.get(),
                        ArtistryBlocks.PEEKING_JACK_O_LANTERN.get(),
                        ArtistryBlocks.BELLOWING_JACK_O_LANTERN.get()
        );

        this.tag(BlockTags.SNIFFER_DIGGABLE_BLOCK)
                .add(Blocks.CLAY)
                .add(Blocks.SAND)
        ;
        this.tag(ArtistryTags.Blocks.SNIFFER_HAS_ASPEN_PLANTS)
                .add(Blocks.PODZOL)
                .add(Blocks.COARSE_DIRT)
        ;
        this.tag(ArtistryTags.Blocks.SNIFFER_HAS_TEARDROP_GRASS)
                .add(Blocks.MUD)
                .add(Blocks.MUDDY_MANGROVE_ROOTS)
                .add(Blocks.CLAY)
                .add(Blocks.SAND)
        ;
        this.tag(ArtistryTags.Blocks.SNIFFER_HAS_LUSH_PLANTS)
                .add(Blocks.MOSS_BLOCK)
        ;

        this.tag(Tags.Blocks.GLASS_BLOCKS_CHEAP)
                .addTag(ArtistryTags.Blocks.FROSTED_GLASS);

        this.tag(ArtistryTags.Blocks.WOODEN_TABLES)
                .add(OAK_TABLE.get())
                .add(SPRUCE_TABLE.get())
                .add(BIRCH_TABLE.get())
                .add(JUNGLE_TABLE.get())
                .add(ACACIA_TABLE.get())
                .add(CHERRY_TABLE.get())
                .add(DARK_OAK_TABLE.get())
                .add(MANGROVE_TABLE.get())
                .add(ASPEN_TABLE.get())
                .add(ROTTEN_TABLE.get())
                .add(BAMBOO_TABLE.get())
                .add(CRIMSON_TABLE.get())
                .add(WARPED_TABLE.get())
        ;
        this.tag(BlockTags.SWORD_EFFICIENT)
                .add(BLOOMING_VINES.get())
                .add(SHORT_TEARDROP_GRASS.get())
                .add(LUSH_FERN.get())
                .add(LUSH_FERN_CROP.get())
                .add(CORPSE_FLOWER.get())
                .add(SUNSPROUT.get())
                .add(SUNBURST_VINES.get())
                .add(SUNBURST_VINES_PLANT.get())
                .add(HONEYDEW_STALK.get())
        ;
        this.tag(ArtistryTags.Blocks.TABLES)
                .addTag(ArtistryTags.Blocks.WOODEN_TABLES)
                .add(STONE_TABLE.get())
                .add(ANDESITE_TABLE.get())
                .add(GRANITE_TABLE.get())
                .add(DIORITE_TABLE.get())
                .add(DEEPSLATE_TABLE.get())
                .add(POLISHED_BLACKSTONE_TABLE.get())
                .add(TUFF_TABLE.get())
                .add(CALCITE_TABLE.get())
        ;
        this.tag(ArtistryTags.Blocks.STRING_LIGHTS)
                .add(STRING_LIGHTS.get())
        ;

        this.tag(BlockTags.CLIMBABLE)
                .add(SUNSPROUT.get())
                .add(SUNBURST_VINES.get())
                .add(SUNBURST_VINES_PLANT.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ASPEN_FENCE_GATE.get())
                .add(ROTTEN_FENCE_GATE.get())
        ;

        this.tag(BlockTags.STAIRS)
                .add(STONE_TILE_STAIRS.get())
                .add(MOSSY_STONE_TILE_STAIRS.get())

                .add(CALCITE_STAIRS.get())
                .add(SMOOTH_CALCITE_STAIRS.get())
                .add(POLISHED_CALCITE_STAIRS.get())
                .add(CALCITE_BRICK_STAIRS.get())
                .add(SMALL_CALCITE_BRICK_STAIRS.get())

                .add(DRIPSTONE_STAIRS.get())
                .add(POLISHED_DRIPSTONE_STAIRS.get())
                .add(DRIPSTONE_BRICK_STAIRS.get())
        ;
        this.tag(BlockTags.SLABS)
                .add(STONE_TILE_SLAB.get())
                .add(MOSSY_STONE_TILE_SLAB.get())

                .add(CALCITE_SLAB.get())
                .add(SMOOTH_CALCITE_SLAB.get())
                .add(POLISHED_CALCITE_SLAB.get())
                .add(CALCITE_BRICK_SLAB.get())
                .add(SMALL_CALCITE_BRICK_SLAB.get())

                .add(DRIPSTONE_SLAB.get())
                .add(POLISHED_DRIPSTONE_SLAB.get())
                .add(DRIPSTONE_BRICK_SLAB.get())
        ;

        this.tag(BlockTags.DIRT)
                .add(OVERGROWN_STONE_TILES.get())
                .add(ROCKY_DIRT.get())
                .add(TEARDROP_GRASS_BLOCK.get())
                .add(LEECHING_SOIL.get())
                .add(WAXED_LEECHING_SOIL.get())
        ;
        this.tag(BlockTags.SNIFFER_DIGGABLE_BLOCK)
                .add(OVERGROWN_STONE_TILES.get())
                .add(ROCKY_DIRT.get())
        ;
        this.tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).remove(OVERGROWN_STONE_TILES.get());
        this.tag(BlockTags.NETHER_CARVER_REPLACEABLES).remove(OVERGROWN_STONE_TILES.get());
        this.tag(BlockTags.ENDERMAN_HOLDABLE).remove(OVERGROWN_STONE_TILES.get(), ROCKY_DIRT.get(), TEARDROP_GRASS_BLOCK.get(), LEECHING_SOIL.get());
        this.tag(BlockTags.MOSS_REPLACEABLE).remove(OVERGROWN_STONE_TILES.get(), ROCKY_DIRT.get(), TEARDROP_GRASS_BLOCK.get(), LEECHING_SOIL.get());
        this.tag(BlockTags.AZALEA_ROOT_REPLACEABLE).remove(OVERGROWN_STONE_TILES.get(), ROCKY_DIRT.get(), TEARDROP_GRASS_BLOCK.get(), LEECHING_SOIL.get());


        this.tag(BlockTags.WALLS)
                .add(CALCITE_WALL.get())
                .add(POLISHED_CALCITE_WALL.get())
                .add(CALCITE_BRICK_WALL.get())
                .add(DRIPSTONE_WALL.get())
                .add(POLISHED_DRIPSTONE_WALL.get())
                .add(DRIPSTONE_BRICK_WALL.get())
        ;

        this.tag(BlockTags.PLANKS)
                .add(ROTTEN_PLANKS.get())
                .add(ASPEN_PLANKS.get())
        ;
        this.tag(ArtistryTags.Blocks.ASPEN_LOGS)
                .add(ASPEN_LOG.get())
                .add(ASPEN_WOOD.get())
                .add(STRIPPED_ASPEN_LOG.get())
                .add(STRIPPED_ASPEN_WOOD.get());
        this.tag(ArtistryTags.Blocks.ROTTEN_LOGS)
                .add(ROTTEN_LOG.get())
                .add(ROTTEN_WOOD.get())
                .add(STRIPPED_ROTTEN_LOG.get())
                .add(STRIPPED_ROTTEN_WOOD.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(ArtistryTags.Blocks.ASPEN_LOGS)
                .addTag(ArtistryTags.Blocks.ROTTEN_LOGS);
        this.tag(Tags.Blocks.STRIPPED_LOGS)
                .add(STRIPPED_ASPEN_LOG.get())
                .add(STRIPPED_ROTTEN_LOG.get())
        ;
        this.tag(Tags.Blocks.STRIPPED_WOODS)
                .add(STRIPPED_ASPEN_WOOD.get())
                .add(STRIPPED_ROTTEN_WOOD.get())
        ;

        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ASPEN_STAIRS.get())
                .add(ROTTEN_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS)
                .add(ASPEN_SLAB.get())
                .add(ROTTEN_SLAB.get());
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ASPEN_BUTTON.get())
                .add(ROTTEN_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ASPEN_PRESSURE_PLATE.get())
                .add(ROTTEN_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_FENCES)
                .add(ASPEN_FENCE.get())
                .add(ROTTEN_FENCE.get());
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ASPEN_DOOR.get())
                .add(ROTTEN_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ASPEN_TRAPDOOR.get())
                .add(ROTTEN_TRAPDOOR.get());
        this.tag(BlockTags.STANDING_SIGNS)
                .add(ASPEN_SIGN.get())
                .add(ROTTEN_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS)
                .add(ASPEN_WALL_SIGN.get())
                .add(ROTTEN_WALL_SIGN.get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(ASPEN_HANGING_SIGN.get())
                .add(ROTTEN_HANGING_SIGN.get());
        this.tag(BlockTags.WALL_HANGING_SIGNS)
                .add(ASPEN_WALL_HANGING_SIGN.get())
                .add(ROTTEN_WALL_HANGING_SIGN.get());
        this.tag(BlockTags.SAPLINGS)
                .add(ASPEN_SAPLING.get())
                .add(ROTTEN_SAPLING.get());

        this.tag(BlockTags.LEAVES)
                .add(ASPEN_LEAVES.get())
                .add(ROTTEN_LEAVES.get())
        ;

        this.tag(BlockTags.HOGLIN_REPELLENTS)
                .add(CORPSE_FLOWER.get())
        ;
        this.tag(BlockTags.PIGLIN_REPELLENTS)
                .add(CORPSE_FLOWER.get())
        ;

        this.tag(BlockTags.REPLACEABLE)
                .add(BLOOMING_VINES.get())
                .add(SHORT_TEARDROP_GRASS.get())
                .add(LUSH_FERN.get())
                .add(CORPSE_FLOWER.get())
        ;
        this.tag(BlockTags.ENCHANTMENT_POWER_TRANSMITTER)
                .add(BLOOMING_VINES.get())
                .add(SHORT_TEARDROP_GRASS.get())
                .add(LUSH_FERN.get())
                .add(LUSH_FERN_CROP.get())
                .add(HONEYDEW_STALK.get())
                .add(CORPSE_FLOWER.get())
        ;
        this.tag(BlockTags.REPLACEABLE_BY_TREES)
                .add(BLOOMING_VINES.get())
                .add(SHORT_TEARDROP_GRASS.get())
                .add(LUSH_FERN.get())
                .add(CORPSE_FLOWER.get())
        ;
        this.tag(BlockTags.MAINTAINS_FARMLAND)
                .add(LUSH_FERN_CROP.get())
                .add(LUSH_FERN.get())
                .add(HONEYDEW_STALK.get())
        ;
        this.tag(BlockTags.CROPS)
                .add(LUSH_FERN_CROP.get())
                .add(HONEYDEW_STALK.get())
        ;
        this.tag(BlockTags.BEE_GROWABLES)
                .add(LUSH_FERN_CROP.get())
                .add(HONEYDEW_STALK.get())
        ;


        this.tag(Tags.Blocks.CHAINS)
                .add(
                        COPPER_CHAIN.get(),
                        EXPOSED_COPPER_CHAIN.get(),
                        WEATHERED_COPPER_CHAIN.get(),
                        OXIDIZED_COPPER_CHAIN.get(),
                        WAXED_COPPER_CHAIN.get(),
                        WAXED_EXPOSED_COPPER_CHAIN.get(),
                        WAXED_WEATHERED_COPPER_CHAIN.get(),
                        WAXED_OXIDIZED_COPPER_CHAIN.get()
                )
        ;
    }
}
