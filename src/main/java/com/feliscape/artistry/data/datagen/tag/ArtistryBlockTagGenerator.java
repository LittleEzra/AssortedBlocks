package com.feliscape.artistry.data.datagen.tag;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ArtistryBlockTagGenerator extends BlockTagsProvider {
    public ArtistryBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Artistry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ArtistryBlocks.CRACKED_BRICKS.get(),
                        ArtistryBlocks.MOSSY_BRICKS.get(),
                        ArtistryBlocks.STONE_TILES.get(),
                        ArtistryBlocks.MOSSY_STONE_TILES.get(),
                        ArtistryBlocks.OVERGROWN_STONE_TILES.get(),
                        ArtistryBlocks.STONE_PILLAR.get(),
                        ArtistryBlocks.MOSSY_STONE_PILLAR.get(),
                        ArtistryBlocks.LARGE_LANTERN.get(),
                        ArtistryBlocks.LARGE_SOUL_LANTERN.get(),
                        ArtistryBlocks.ROUND_LANTERN.get(),
                        ArtistryBlocks.FLAT_LIGHT.get(),
                        ArtistryBlocks.SPARKLER.get(),

                        ArtistryBlocks.WATER_FOUNTAIN.get(),

                        ArtistryBlocks.STONE_TABLE.get(),
                        ArtistryBlocks.ANDESITE_TABLE.get(),
                        ArtistryBlocks.GRANITE_TABLE.get(),
                        ArtistryBlocks.DIORITE_TABLE.get(),
                        ArtistryBlocks.DEEPSLATE_TABLE.get(),
                        ArtistryBlocks.POLISHED_BLACKSTONE_TABLE.get(),
                        ArtistryBlocks.TUFF_TABLE.get(),
                        ArtistryBlocks.CALCITE_TABLE.get(),

                        ArtistryBlocks.ROCKY_DIRT.get(),

                        ArtistryBlocks.POLISHED_CALCITE.get(),
                        ArtistryBlocks.POLISHED_CALCITE_STAIRS.get(),
                        ArtistryBlocks.POLISHED_CALCITE_SLAB.get(),
                        ArtistryBlocks.POLISHED_CALCITE_WALL.get(),
                        ArtistryBlocks.CALCITE_BRICKS.get(),
                        ArtistryBlocks.CALCITE_BRICK_STAIRS.get(),
                        ArtistryBlocks.CALCITE_BRICK_SLAB.get(),
                        ArtistryBlocks.CALCITE_BRICK_WALL.get(),
                        ArtistryBlocks.SMALL_CALCITE_BRICKS.get(),
                        ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS.get(),
                        ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB.get(),

                        ArtistryBlocks.WHITE_FROSTED_GLASS.get(),
                        ArtistryBlocks.LIGHT_GRAY_FROSTED_GLASS.get(),
                        ArtistryBlocks.GRAY_FROSTED_GLASS.get(),
                        ArtistryBlocks.BLACK_FROSTED_GLASS.get(),
                        ArtistryBlocks.BROWN_FROSTED_GLASS.get(),
                        ArtistryBlocks.RED_FROSTED_GLASS.get(),
                        ArtistryBlocks.ORANGE_FROSTED_GLASS.get(),
                        ArtistryBlocks.YELLOW_FROSTED_GLASS.get(),
                        ArtistryBlocks.LIME_FROSTED_GLASS.get(),
                        ArtistryBlocks.GREEN_FROSTED_GLASS.get(),
                        ArtistryBlocks.CYAN_FROSTED_GLASS.get(),
                        ArtistryBlocks.LIGHT_BLUE_FROSTED_GLASS.get(),
                        ArtistryBlocks.BLUE_FROSTED_GLASS.get(),
                        ArtistryBlocks.PURPLE_FROSTED_GLASS.get(),
                        ArtistryBlocks.MAGENTA_FROSTED_GLASS.get(),
                        ArtistryBlocks.PINK_FROSTED_GLASS.get(),

                        ArtistryBlocks.PAINTED_POLISHED_CALCITE.get(),
                        ArtistryBlocks.PAINTED_CALCITE_BRICKS.get(),
                        ArtistryBlocks.PAINTED_SMALL_CALCITE_BRICKS.get()
                );

        this.tag(ArtistryTags.Blocks.FROSTED_GLASS)
                .add(
                        ArtistryBlocks.WHITE_FROSTED_GLASS.get(),
                        ArtistryBlocks.LIGHT_GRAY_FROSTED_GLASS.get(),
                        ArtistryBlocks.GRAY_FROSTED_GLASS.get(),
                        ArtistryBlocks.BLACK_FROSTED_GLASS.get(),
                        ArtistryBlocks.BROWN_FROSTED_GLASS.get(),
                        ArtistryBlocks.RED_FROSTED_GLASS.get(),
                        ArtistryBlocks.ORANGE_FROSTED_GLASS.get(),
                        ArtistryBlocks.YELLOW_FROSTED_GLASS.get(),
                        ArtistryBlocks.LIME_FROSTED_GLASS.get(),
                        ArtistryBlocks.GREEN_FROSTED_GLASS.get(),
                        ArtistryBlocks.CYAN_FROSTED_GLASS.get(),
                        ArtistryBlocks.LIGHT_BLUE_FROSTED_GLASS.get(),
                        ArtistryBlocks.BLUE_FROSTED_GLASS.get(),
                        ArtistryBlocks.PURPLE_FROSTED_GLASS.get(),
                        ArtistryBlocks.MAGENTA_FROSTED_GLASS.get(),
                        ArtistryBlocks.PINK_FROSTED_GLASS.get()
                );
        this.tag(Tags.Blocks.GLASS_BLOCKS_CHEAP)
                .addTag(ArtistryTags.Blocks.FROSTED_GLASS);

        this.tag(ArtistryTags.Blocks.WOODEN_TABLES)
                .add(ArtistryBlocks.OAK_TABLE.get())
                .add(ArtistryBlocks.SPRUCE_TABLE.get())
                .add(ArtistryBlocks.BIRCH_TABLE.get())
                .add(ArtistryBlocks.JUNGLE_TABLE.get())
                .add(ArtistryBlocks.ACACIA_TABLE.get())
                .add(ArtistryBlocks.CHERRY_TABLE.get())
                .add(ArtistryBlocks.DARK_OAK_TABLE.get())
                .add(ArtistryBlocks.MANGROVE_TABLE.get())
                .add(ArtistryBlocks.ASPEN_TABLE.get())
                .add(ArtistryBlocks.BAMBOO_TABLE.get())
                .add(ArtistryBlocks.CRIMSON_TABLE.get())
                .add(ArtistryBlocks.WARPED_TABLE.get())
        ;
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(ArtistryTags.Blocks.WOODEN_TABLES)
                .add(ArtistryBlocks.BLOOMING_VINES.get())
                .add(ArtistryBlocks.SUNSPROUT.get())
                .add(ArtistryBlocks.SUNBURST_VINES.get())
                .add(ArtistryBlocks.SUNBURST_VINES_PLANT.get())
        ;
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ArtistryBlocks.ROCKY_DIRT.get())
        ;
        this.tag(BlockTags.SWORD_EFFICIENT)
                .add(ArtistryBlocks.BLOOMING_VINES.get())
                .add(ArtistryBlocks.SUNSPROUT.get())
                .add(ArtistryBlocks.SUNBURST_VINES.get())
                .add(ArtistryBlocks.SUNBURST_VINES_PLANT.get())
        ;
        this.tag(ArtistryTags.Blocks.TABLES)
                .addTag(ArtistryTags.Blocks.WOODEN_TABLES)
                .add(ArtistryBlocks.STONE_TABLE.get())
                .add(ArtistryBlocks.ANDESITE_TABLE.get())
                .add(ArtistryBlocks.GRANITE_TABLE.get())
                .add(ArtistryBlocks.DIORITE_TABLE.get())
                .add(ArtistryBlocks.DEEPSLATE_TABLE.get())
                .add(ArtistryBlocks.POLISHED_BLACKSTONE_TABLE.get())
                .add(ArtistryBlocks.TUFF_TABLE.get())
                .add(ArtistryBlocks.CALCITE_TABLE.get())
        ;
        this.tag(ArtistryTags.Blocks.STRING_LIGHTS)
                .add(ArtistryBlocks.STRING_LIGHTS.get())
        ;

        this.tag(BlockTags.CLIMBABLE)
                .add(ArtistryBlocks.SUNSPROUT.get())
                .add(ArtistryBlocks.SUNBURST_VINES.get())
                .add(ArtistryBlocks.SUNBURST_VINES_PLANT.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ArtistryBlocks.ASPEN_FENCE_GATE.get());

        this.tag(BlockTags.STAIRS)
                .add(ArtistryBlocks.STONE_TILE_STAIRS.get())
                .add(ArtistryBlocks.MOSSY_STONE_TILE_STAIRS.get())
        ;
        this.tag(BlockTags.SLABS)
                .add(ArtistryBlocks.STONE_TILE_SLAB.get())
                .add(ArtistryBlocks.MOSSY_STONE_TILE_SLAB.get())
        ;

        this.tag(BlockTags.DIRT)
                .add(ArtistryBlocks.OVERGROWN_STONE_TILES.get())
                .add(ArtistryBlocks.ROCKY_DIRT.get())
        ;
        this.tag(BlockTags.SNIFFER_DIGGABLE_BLOCK)
                .add(ArtistryBlocks.OVERGROWN_STONE_TILES.get())
                .add(ArtistryBlocks.ROCKY_DIRT.get())
        ;
        this.tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).remove(ArtistryBlocks.OVERGROWN_STONE_TILES.get(), ArtistryBlocks.ROCKY_DIRT.get());
        this.tag(BlockTags.NETHER_CARVER_REPLACEABLES).remove(ArtistryBlocks.OVERGROWN_STONE_TILES.get(), ArtistryBlocks.ROCKY_DIRT.get());
        this.tag(BlockTags.ENDERMAN_HOLDABLE).remove(ArtistryBlocks.OVERGROWN_STONE_TILES.get(), ArtistryBlocks.ROCKY_DIRT.get());
        this.tag(BlockTags.MOSS_REPLACEABLE).remove(ArtistryBlocks.OVERGROWN_STONE_TILES.get(), ArtistryBlocks.ROCKY_DIRT.get());
        this.tag(BlockTags.AZALEA_ROOT_REPLACEABLE).remove(ArtistryBlocks.OVERGROWN_STONE_TILES.get(), ArtistryBlocks.ROCKY_DIRT.get());
        this.tag(BlockTags.CONVERTABLE_TO_MUD).remove(ArtistryBlocks.OVERGROWN_STONE_TILES.get(), ArtistryBlocks.ROCKY_DIRT.get());


        this.tag(BlockTags.WALLS)
                .add(ArtistryBlocks.POLISHED_CALCITE_WALL.get())
                .add(ArtistryBlocks.CALCITE_BRICK_WALL.get())
        ;

        this.tag(BlockTags.PLANKS)
                .add(ArtistryBlocks.ASPEN_PLANKS.get());
        this.tag(ArtistryTags.Blocks.ASPEN_LOGS)
                .add(ArtistryBlocks.ASPEN_LOG.get())
                .add(ArtistryBlocks.ASPEN_WOOD.get())
                .add(ArtistryBlocks.STRIPPED_ASPEN_LOG.get())
                .add(ArtistryBlocks.STRIPPED_ASPEN_WOOD.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(ArtistryTags.Blocks.ASPEN_LOGS);
        this.tag(Tags.Blocks.STRIPPED_LOGS)
                .add(ArtistryBlocks.STRIPPED_ASPEN_LOG.get());
        this.tag(Tags.Blocks.STRIPPED_WOODS)
                .add(ArtistryBlocks.STRIPPED_ASPEN_WOOD.get());

        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ArtistryBlocks.ASPEN_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS)
                .add(ArtistryBlocks.ASPEN_SLAB.get());
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ArtistryBlocks.ASPEN_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ArtistryBlocks.ASPEN_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_FENCES)
                .add(ArtistryBlocks.ASPEN_FENCE.get());
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ArtistryBlocks.ASPEN_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ArtistryBlocks.ASPEN_TRAPDOOR.get());
        this.tag(BlockTags.STANDING_SIGNS)
                .add(ArtistryBlocks.ASPEN_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS)
                .add(ArtistryBlocks.ASPEN_WALL_SIGN.get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(ArtistryBlocks.ASPEN_HANGING_SIGN.get());
        this.tag(BlockTags.WALL_HANGING_SIGNS)
                .add(ArtistryBlocks.ASPEN_WALL_HANGING_SIGN.get());
        this.tag(BlockTags.SAPLINGS)
                .add(ArtistryBlocks.ASPEN_SAPLING.get());

        this.tag(BlockTags.LEAVES)
                .add(ArtistryBlocks.ASPEN_LEAVES.get()
                );
    }
}
