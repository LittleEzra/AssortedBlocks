package com.feliscape.artistry.data.datagen.recipe;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.FrostedGlassBlock;
import com.feliscape.artistry.registry.ArtistryItems;
import com.feliscape.artistry.registry.ArtistryTags;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.concurrent.CompletableFuture;

public class ArtistryRecipeProvider extends RecipeProvider {

    public ArtistryRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        // Stone Tiles
        twoByTwoConversion(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.STONE_TILES,
                Blocks.STONE_BRICKS);
        stairBuilder(ArtistryBlocks.STONE_TILE_STAIRS, Ingredient.of(ArtistryBlocks.STONE_TILES.get()))
                .unlockedBy(getHasName(ArtistryBlocks.STONE_TILES), has(ArtistryBlocks.STONE_TILES))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.STONE_TILE_SLAB, ArtistryBlocks.STONE_TILES.get());

        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.STONE_TILES,
                Blocks.STONE_BRICKS);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.STONE_TILES,
                Blocks.STONE);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.STONE_TILE_STAIRS,
                ArtistryBlocks.STONE_TILES);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.STONE_TILE_SLAB,
                ArtistryBlocks.STONE_TILES, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.STONE_TILE_STAIRS,
                Blocks.STONE);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.STONE_TILE_SLAB,
                Blocks.STONE, 2);
        // Mossy Stone Tiles
        twoByTwoConversion(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.MOSSY_STONE_TILES,
                Blocks.MOSSY_STONE_BRICKS);
        stairBuilder(ArtistryBlocks.MOSSY_STONE_TILE_STAIRS, Ingredient.of(ArtistryBlocks.MOSSY_STONE_TILES.get()))
                .unlockedBy(getHasName(ArtistryBlocks.MOSSY_STONE_TILES), has(ArtistryBlocks.MOSSY_STONE_TILES))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.MOSSY_STONE_TILE_SLAB, ArtistryBlocks.MOSSY_STONE_TILES.get());

        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.MOSSY_STONE_TILES,
                Blocks.MOSSY_STONE_BRICKS);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.MOSSY_STONE_TILE_STAIRS,
                ArtistryBlocks.MOSSY_STONE_TILES, 2);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.MOSSY_STONE_TILE_SLAB,
                ArtistryBlocks.MOSSY_STONE_TILES);

        applyMoss(recipeOutput, Blocks.BRICKS, ArtistryBlocks.MOSSY_BRICKS);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CRACKED_BRICKS.asItem(), 0.1F, 200)
                .unlockedBy(getHasName(Blocks.BRICKS), has(Blocks.BRICKS))
                .save(recipeOutput);

        applyMoss(recipeOutput, ArtistryBlocks.STONE_TILES, ArtistryBlocks.MOSSY_STONE_TILES);
        applyMoss(recipeOutput, ArtistryBlocks.MOSSY_STONE_TILES, ArtistryBlocks.OVERGROWN_STONE_TILES);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.STONE_PILLAR, 2)
                .define('#', Blocks.STONE_BRICKS)
                .pattern("#")
                .pattern("#")
                .unlockedBy(getHasName(Blocks.STONE_BRICKS), has(Blocks.STONE_BRICKS))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.MOSSY_STONE_PILLAR, 2)
                .define('#', Blocks.MOSSY_STONE_BRICKS)
                .pattern("#")
                .pattern("#")
                .unlockedBy(getHasName(Blocks.MOSSY_STONE_BRICKS), has(Blocks.MOSSY_STONE_BRICKS))
                .save(recipeOutput);
        applyMoss(recipeOutput, ArtistryBlocks.STONE_PILLAR, ArtistryBlocks.MOSSY_STONE_PILLAR);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.STONE_PILLAR, Blocks.STONE_BRICKS);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.STONE_PILLAR, Blocks.STONE);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.MOSSY_STONE_PILLAR, Blocks.MOSSY_STONE_BRICKS);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.OVERGROWN_STONE_TILES)
                .requires(ArtistryBlocks.STONE_TILES)
                .requires(Ingredient.of(ArtistryTags.Items.CAN_APPLY_MOSS), 2)
                .group("overgrown_stone_tiles")
                .unlockedBy("has_mossy_item", has(ArtistryTags.Items.CAN_APPLY_MOSS))
                .save(recipeOutput, Artistry.stringLocation("overgrown_stone_tiles_from_stone_tiles"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ArtistryBlocks.ASPEN_SAPLING)
                .define('o', Items.GOLD_NUGGET)
                .define('#', ItemTags.SAPLINGS)
                .pattern("ooo")
                .pattern("o#o")
                .pattern("ooo")
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ArtistryBlocks.TEARDROP_GRASS, 4)
                .define('o', Items.IRON_NUGGET)
                .define('#', Items.SHORT_GRASS)
                .pattern(" # ")
                .pattern("#o#")
                .pattern(" # ")
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(recipeOutput);

        // Calcite

        stairBuilder(ArtistryBlocks.CALCITE_STAIRS, Ingredient.of(Blocks.CALCITE))
                .unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.CALCITE_SLAB, Blocks.CALCITE);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.CALCITE_WALL, Blocks.CALCITE);

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_STAIRS,
                Blocks.CALCITE);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_SLAB,
                Blocks.CALCITE, 2);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_WALL,
                Blocks.CALCITE);

        // Smooth Calcite
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.CALCITE), RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.SMOOTH_CALCITE, 0.1F, 200)
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .save(recipeOutput);

        twoByTwoConversion(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.POLISHED_CALCITE,
                ArtistryBlocks.SMOOTH_CALCITE);

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.SMOOTH_CALCITE_STAIRS,
                ArtistryBlocks.SMOOTH_CALCITE);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.SMOOTH_CALCITE_SLAB,
                ArtistryBlocks.SMOOTH_CALCITE, 2);

        // Polished Calcite
        twoByTwoConversion(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.POLISHED_CALCITE,
                Blocks.CALCITE);
        stairBuilder(ArtistryBlocks.POLISHED_CALCITE_STAIRS, Ingredient.of(ArtistryBlocks.POLISHED_CALCITE.get()))
                .unlockedBy(getHasName(ArtistryBlocks.POLISHED_CALCITE), has(ArtistryBlocks.POLISHED_CALCITE))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.POLISHED_CALCITE_SLAB, ArtistryBlocks.POLISHED_CALCITE.get());
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.POLISHED_CALCITE_WALL, ArtistryBlocks.POLISHED_CALCITE);
        chiseled(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.CHISELED_CALCITE, ArtistryBlocks.POLISHED_CALCITE_SLAB);

        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.POLISHED_CALCITE,
                Blocks.CALCITE);

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.POLISHED_CALCITE_STAIRS,
                ArtistryBlocks.POLISHED_CALCITE);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.POLISHED_CALCITE_SLAB,
                ArtistryBlocks.POLISHED_CALCITE, 2);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.POLISHED_CALCITE_WALL,
                ArtistryBlocks.POLISHED_CALCITE);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CHISELED_CALCITE,
                ArtistryBlocks.POLISHED_CALCITE);

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.POLISHED_CALCITE_STAIRS,
                Blocks.CALCITE);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.POLISHED_CALCITE_SLAB,
                Blocks.CALCITE, 2);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.POLISHED_CALCITE_WALL,
                Blocks.CALCITE);

        // Calcite Bricks
        twoByTwoConversion(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICKS,
                ArtistryBlocks.POLISHED_CALCITE);
        stairBuilder(ArtistryBlocks.CALCITE_BRICK_STAIRS, Ingredient.of(ArtistryBlocks.CALCITE_BRICKS.get()))
                .unlockedBy(getHasName(ArtistryBlocks.CALCITE_BRICKS), has(ArtistryBlocks.CALCITE_BRICKS))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.CALCITE_BRICK_SLAB, ArtistryBlocks.CALCITE_BRICKS.get());
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.CALCITE_BRICK_WALL, ArtistryBlocks.CALCITE_BRICKS);

        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICKS,
                ArtistryBlocks.POLISHED_CALCITE);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICKS,
                Blocks.CALCITE);

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICK_STAIRS,
                ArtistryBlocks.CALCITE_BRICKS);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICK_SLAB,
                ArtistryBlocks.CALCITE_BRICKS, 2);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICK_WALL,
                ArtistryBlocks.CALCITE_BRICKS);

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICK_STAIRS,
                ArtistryBlocks.POLISHED_CALCITE);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICK_SLAB,
                ArtistryBlocks.POLISHED_CALCITE, 2);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICK_WALL,
                ArtistryBlocks.POLISHED_CALCITE);

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICK_STAIRS,
                Blocks.CALCITE);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.CALCITE_BRICK_SLAB,
                Blocks.CALCITE, 2);
        // Small Calcite Bricks
        twoByTwoConversion(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.SMALL_CALCITE_BRICKS,
                ArtistryBlocks.CALCITE_BRICKS);
        stairBuilder(ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS, Ingredient.of(ArtistryBlocks.SMALL_CALCITE_BRICKS.get()))
                .unlockedBy(getHasName(ArtistryBlocks.SMALL_CALCITE_BRICKS), has(ArtistryBlocks.SMALL_CALCITE_BRICKS))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB, ArtistryBlocks.SMALL_CALCITE_BRICKS.get());

        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.SMALL_CALCITE_BRICKS,
                ArtistryBlocks.CALCITE_BRICKS);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS,
                ArtistryBlocks.SMALL_CALCITE_BRICKS);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB,
                ArtistryBlocks.SMALL_CALCITE_BRICKS, 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS,
                ArtistryBlocks.CALCITE_BRICKS);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB,
                ArtistryBlocks.CALCITE_BRICKS, 2);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.PAINTED_POLISHED_CALCITE, 8)
                .define('#', ArtistryBlocks.POLISHED_CALCITE)
                .define('L', Items.LAPIS_LAZULI)
                .pattern("###")
                .pattern("#L#")
                .pattern("###")
                .unlockedBy(getHasName(Items.LAPIS_LAZULI), has(Items.LAPIS_LAZULI))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.PAINTED_CALCITE_BRICKS, 8)
                .define('#', ArtistryBlocks.CALCITE_BRICKS)
                .define('L', Items.LAPIS_LAZULI)
                .pattern("###")
                .pattern("#L#")
                .pattern("###")
                .unlockedBy(getHasName(Items.LAPIS_LAZULI), has(Items.LAPIS_LAZULI))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.PAINTED_SMALL_CALCITE_BRICKS, 8)
                .define('#', ArtistryBlocks.SMALL_CALCITE_BRICKS)
                .define('L', Items.LAPIS_LAZULI)
                .pattern("###")
                .pattern("#L#")
                .pattern("###")
                .unlockedBy(getHasName(Items.LAPIS_LAZULI), has(Items.LAPIS_LAZULI))
                .save(recipeOutput);

        table(recipeOutput, ArtistryBlocks.OAK_TABLE, Blocks.OAK_SLAB);
        table(recipeOutput, ArtistryBlocks.SPRUCE_TABLE, Blocks.SPRUCE_SLAB);
        table(recipeOutput, ArtistryBlocks.BIRCH_TABLE, Blocks.BIRCH_SLAB);
        table(recipeOutput, ArtistryBlocks.JUNGLE_TABLE, Blocks.JUNGLE_SLAB);
        table(recipeOutput, ArtistryBlocks.ACACIA_TABLE, Blocks.ACACIA_SLAB);
        table(recipeOutput, ArtistryBlocks.CHERRY_TABLE, Blocks.CHERRY_SLAB);
        table(recipeOutput, ArtistryBlocks.DARK_OAK_TABLE, Blocks.DARK_OAK_SLAB);
        table(recipeOutput, ArtistryBlocks.MANGROVE_TABLE, Blocks.MANGROVE_SLAB);
        table(recipeOutput, ArtistryBlocks.ASPEN_TABLE, ArtistryBlocks.ASPEN_SLAB);
        table(recipeOutput, ArtistryBlocks.BAMBOO_TABLE, Blocks.BAMBOO_SLAB);
        table(recipeOutput, ArtistryBlocks.CRIMSON_TABLE, Blocks.CRIMSON_SLAB);
        table(recipeOutput, ArtistryBlocks.WARPED_TABLE, Blocks.WARPED_SLAB);

        stoneTable(recipeOutput, ArtistryBlocks.STONE_TABLE, Blocks.STONE_SLAB, Blocks.STONE, Blocks.STONE);
        stoneTable(recipeOutput, ArtistryBlocks.ANDESITE_TABLE, Blocks.POLISHED_ANDESITE_SLAB, Blocks.POLISHED_ANDESITE, Blocks.POLISHED_ANDESITE);
        stoneTable(recipeOutput, ArtistryBlocks.GRANITE_TABLE, Blocks.POLISHED_GRANITE_SLAB, Blocks.POLISHED_GRANITE, Blocks.POLISHED_GRANITE);
        stoneTable(recipeOutput, ArtistryBlocks.DIORITE_TABLE, Blocks.POLISHED_DIORITE_SLAB, Blocks.POLISHED_DIORITE, Blocks.POLISHED_DIORITE);
        stoneTable(recipeOutput, ArtistryBlocks.DEEPSLATE_TABLE, Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.POLISHED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE);
        stoneTable(recipeOutput, ArtistryBlocks.POLISHED_BLACKSTONE_TABLE, Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
        stoneTable(recipeOutput, ArtistryBlocks.TUFF_TABLE, Blocks.POLISHED_TUFF_SLAB, Blocks.POLISHED_TUFF, Blocks.POLISHED_TUFF);
        stoneTable(recipeOutput, ArtistryBlocks.CALCITE_TABLE, ArtistryBlocks.POLISHED_CALCITE_SLAB, ArtistryBlocks.POLISHED_CALCITE, ArtistryBlocks.POLISHED_CALCITE);

        frostedGlass(recipeOutput, ArtistryBlocks.WHITE_FROSTED_GLASS, Blocks.WHITE_STAINED_GLASS, Items.WHITE_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.LIGHT_GRAY_FROSTED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS, Items.LIGHT_GRAY_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.GRAY_FROSTED_GLASS, Blocks.GRAY_STAINED_GLASS, Items.GRAY_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.BLACK_FROSTED_GLASS, Blocks.BLACK_STAINED_GLASS, Items.BLACK_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.BROWN_FROSTED_GLASS, Blocks.BROWN_STAINED_GLASS, Items.BROWN_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.RED_FROSTED_GLASS, Blocks.RED_STAINED_GLASS, Items.RED_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.ORANGE_FROSTED_GLASS, Blocks.ORANGE_STAINED_GLASS, Items.ORANGE_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.YELLOW_FROSTED_GLASS, Blocks.YELLOW_STAINED_GLASS, Items.YELLOW_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.LIME_FROSTED_GLASS, Blocks.LIME_STAINED_GLASS, Items.LIME_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.GREEN_FROSTED_GLASS, Blocks.GREEN_STAINED_GLASS, Items.GREEN_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.CYAN_FROSTED_GLASS, Blocks.CYAN_STAINED_GLASS, Items.CYAN_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.LIGHT_BLUE_FROSTED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS, Items.LIGHT_BLUE_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.BLUE_FROSTED_GLASS, Blocks.BLUE_STAINED_GLASS, Items.BLUE_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.PURPLE_FROSTED_GLASS, Blocks.PURPLE_STAINED_GLASS, Items.PURPLE_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.MAGENTA_FROSTED_GLASS, Blocks.MAGENTA_STAINED_GLASS, Items.MAGENTA_DYE);
        frostedGlass(recipeOutput, ArtistryBlocks.PINK_FROSTED_GLASS, Blocks.PINK_STAINED_GLASS, Items.PINK_DYE);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.LARGE_LANTERN)
                .define('#', Items.IRON_INGOT)
                .define('o', Items.IRON_NUGGET)
                .define('/', Items.TORCH)
                .pattern("o#o")
                .pattern("#/#")
                .pattern("o#o")
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.LARGE_SOUL_LANTERN)
                .define('#', Items.IRON_INGOT)
                .define('o', Items.IRON_NUGGET)
                .define('/', Items.SOUL_TORCH)
                .pattern("o#o")
                .pattern("#/#")
                .pattern("o#o")
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.ROUND_LANTERN)
                .define('#', Tags.Items.GLASS_BLOCKS)
                .define('I', Items.IRON_INGOT)
                .define('o', Blocks.GLOWSTONE)
                .pattern(" # ")
                .pattern("#o#")
                .pattern(" I ")
                .unlockedBy(getHasName(Blocks.GLOWSTONE), has(Blocks.GLOWSTONE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.FLAT_LIGHT, 4)
                .define('I', Items.IRON_INGOT)
                .define('o', Items.GLOWSTONE_DUST)
                .pattern("o")
                .pattern("I")
                .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryItems.STRING_LIGHTS, 4)
                .define('S', Items.STRING)
                .define('o', Items.GLOWSTONE_DUST)
                .pattern("SSS")
                .pattern("ooo")
                .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.SPARKLER, 2)
                .define('C', Items.COPPER_INGOT)
                .define('A', Items.AMETHYST_SHARD)
                .pattern(" A ")
                .pattern("ACA")
                .pattern(" C ")
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.AMETHYST_STARS, 8)
                .define('A', Items.AMETHYST_SHARD)
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.SPARK_FOUNTAIN)
                .define('P', Items.PAPER)
                .define('B', Blocks.BAMBOO)
                .define('G', Items.GUNPOWDER)
                .pattern("P")
                .pattern("B")
                .pattern("G")
                .unlockedBy(getHasName(Blocks.BAMBOO), has(Blocks.BAMBOO))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.WATER_FOUNTAIN)
                .define('#', Tags.Items.STONES)
                .define('B', Items.WATER_BUCKET)
                .pattern("#B#")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET))
                .save(recipeOutput);

        //region Aspen
        planksFromLog(recipeOutput, ArtistryBlocks.ASPEN_PLANKS.get(), ArtistryTags.Items.ASPEN_LOGS, 4);
        woodFromLogs(recipeOutput, ArtistryBlocks.ASPEN_WOOD.get(), ArtistryBlocks.ASPEN_LOG.get());
        woodFromLogs(recipeOutput, ArtistryBlocks.STRIPPED_ASPEN_WOOD.get(), ArtistryBlocks.STRIPPED_ASPEN_LOG.get());

        Ingredient aspenPlankIngredient = Ingredient.of(ArtistryBlocks.ASPEN_PLANKS.get());

        String hasAspenPlanksName = getHasName(ArtistryBlocks.ASPEN_PLANKS.get());
        var hasAspenPlanks = has(ArtistryBlocks.ASPEN_PLANKS.get());


        stairBuilder(ArtistryBlocks.ASPEN_STAIRS.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks)
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.ASPEN_SLAB.get(), ArtistryBlocks.ASPEN_PLANKS.get());
        doorBuilder(ArtistryBlocks.ASPEN_DOOR.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks)
                .save(recipeOutput);
        trapdoorBuilder(ArtistryBlocks.ASPEN_TRAPDOOR.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks)
                .save(recipeOutput);
        signBuilder(ArtistryItems.ASPEN_SIGN.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks)
                .save(recipeOutput);
        hangingSign(recipeOutput, ArtistryItems.ASPEN_HANGING_SIGN.get(), ArtistryBlocks.ASPEN_PLANKS.get());

        fenceBuilder(ArtistryBlocks.ASPEN_FENCE.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks)
                .save(recipeOutput);
        fenceGateBuilder(ArtistryBlocks.ASPEN_FENCE_GATE.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks)
                .save(recipeOutput);;
        buttonBuilder(ArtistryBlocks.ASPEN_BUTTON.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks)
                .save(recipeOutput);;
        pressurePlate(recipeOutput, ArtistryBlocks.ASPEN_PRESSURE_PLATE.get(), ArtistryBlocks.ASPEN_PLANKS.get());

        woodenBoat(recipeOutput, ArtistryItems.ASPEN_BOAT, ArtistryBlocks.ASPEN_PLANKS.get());
        chestBoat(recipeOutput, ArtistryItems.ASPEN_CHEST_BOAT, ArtistryItems.ASPEN_BOAT);
        //endregion
    }

    private void frostedGlass(RecipeOutput output, ItemLike frostedGlass, ItemLike cleanGlass, ItemLike dye) {
        frostedGlassFromFrostedGlassAndDye(output, frostedGlass, dye);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(cleanGlass), RecipeCategory.BUILDING_BLOCKS, frostedGlass, 0.1F, 200)
                .unlockedBy("has_clean_glass", has(cleanGlass))
                .save(output, getSmeltingRecipeName(frostedGlass));
    }
    protected static void frostedGlassFromFrostedGlassAndDye(RecipeOutput recipeOutput, ItemLike stainedGlass, ItemLike dye) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stainedGlass, 8)
                .define('#', ArtistryTags.Items.FROSTED_GLASS)
                .define('X', dye)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_glass")
                .unlockedBy("has_frosted_glass", has(ArtistryTags.Items.FROSTED_GLASS))
                .save(recipeOutput);
    }

    protected static void stonecutting(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, int count){
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result, count)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput, Artistry.stringLocation(getConversionRecipeName(result, material) + "_stonecutting"));
    }
    protected static void stonecutting(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material){
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput, Artistry.stringLocation(getConversionRecipeName(result, material) + "_stonecutting"));
    }

    protected static void twoByTwoConversion(RecipeOutput recipeOutput, RecipeCategory category, ItemLike packed, ItemLike unpacked) {
        ShapedRecipeBuilder.shaped(category, packed, 4)
                .define('#', unpacked)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(unpacked), has(unpacked))
                .save(recipeOutput, getConversionRecipeName(packed, unpacked));
    }

    protected static void table(RecipeOutput recipeOutput, ItemLike table, ItemLike slab) {
        /*ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, table, 2)
                .define('#', slab)
                .define('/', Items.STICK)
                .pattern("###")
                .pattern("/ /")
                .pattern("/ /")
                .unlockedBy(getHasName(slab), has(slab))
                .save(recipeOutput);*/
        table(recipeOutput, table, slab, Items.STICK);
    }
    protected static void table(RecipeOutput recipeOutput, ItemLike table, ItemLike slab, ItemLike legs) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, table, 2)
                .define('#', slab)
                .define('/', legs)
                .pattern("###")
                .pattern("/ /")
                .pattern("/ /")
                .unlockedBy(getHasName(slab), has(slab))
                .save(recipeOutput);
    }
    protected static void stoneTable(RecipeOutput recipeOutput, ItemLike table, ItemLike slab, ItemLike legs, ItemLike base) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, table, 2)
                .define('#', slab)
                .define('/', legs)
                .pattern("###")
                .pattern("/ /")
                .pattern("/ /")
                .unlockedBy(getHasName(slab), has(slab))
                .save(recipeOutput);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, table, base);
    }

    protected static void applyMoss(RecipeOutput recipeOutput, ItemLike material, ItemLike result){
        applyMoss(recipeOutput, material, result, getItemName(result));
    }
    protected static void applyMoss(RecipeOutput recipeOutput, ItemLike material, ItemLike result, String group){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result)
                .requires(material)
                .requires(ArtistryTags.Items.CAN_APPLY_MOSS)
                .group(group)
                .unlockedBy("has_mossy_item", has(ArtistryTags.Items.CAN_APPLY_MOSS))
                .save(recipeOutput, Artistry.stringLocation("mossify_" + getItemName(material)));
    }

    protected static String getItemName(ItemLike itemLike) {
        return BuiltInRegistries.ITEM.getKey(itemLike.asItem()).getPath();
    }

    protected static String getSimpleRecipeName(ItemLike itemLike) {
        return getItemName(itemLike);
    }

    protected static String getConversionRecipeName(ItemLike result, ItemLike ingredient) {
        String var10000 = getItemName(result);
        return var10000 + "_from_" + getItemName(ingredient);
    }

    protected static String getSmeltingRecipeName(ItemLike itemLike) {
        return getItemName(itemLike) + "_from_smelting";
    }

    protected static String getBlastingRecipeName(ItemLike itemLike) {
        return getItemName(itemLike) + "_from_blasting";
    }
}