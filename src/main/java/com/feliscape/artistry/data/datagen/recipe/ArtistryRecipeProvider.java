package com.feliscape.artistry.data.datagen.recipe;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryItems;
import com.feliscape.artistry.registry.ArtistryTags;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

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
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.STONE_TILES,
                Blocks.STONE_BRICKS);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.STONE_TILES,
                Blocks.STONE);
        // Mossy Stone Tiles
        twoByTwoConversion(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.MOSSY_STONE_TILES,
                Blocks.MOSSY_STONE_BRICKS);
        stonecutting(recipeOutput, RecipeCategory.BUILDING_BLOCKS,
                ArtistryBlocks.MOSSY_STONE_TILES,
                Blocks.MOSSY_STONE_BRICKS);

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


        //region Aspen
        planksFromLog(recipeOutput, ArtistryBlocks.ASPEN_PLANKS.get(), ArtistryTags.Items.ASPEN_LOGS, 4);
        woodFromLogs(recipeOutput, ArtistryBlocks.ASPEN_WOOD.get(), ArtistryBlocks.ASPEN_LOG.get());
        woodFromLogs(recipeOutput, ArtistryBlocks.STRIPPED_ASPEN_WOOD.get(), ArtistryBlocks.STRIPPED_ASPEN_LOG.get());

        Ingredient aspenPlankIngredient = Ingredient.of(ArtistryBlocks.ASPEN_PLANKS.get());

        String hasAspenPlanksName = getHasName(ArtistryBlocks.ASPEN_PLANKS.get());
        var hasAspenPlanks = has(ArtistryBlocks.ASPEN_PLANKS.get());

        stairBuilder(ArtistryBlocks.ASPEN_STAIRS.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ArtistryBlocks.ASPEN_SLAB.get(), ArtistryBlocks.ASPEN_PLANKS.get());
        doorBuilder(ArtistryBlocks.ASPEN_DOOR.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks)
                .save(recipeOutput);
        trapdoorBuilder(ArtistryBlocks.ASPEN_TRAPDOOR.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks)
                .save(recipeOutput);
        /*signBuilder(ArtistryItems.ASPEN_SIGN.get(), aspenPlankIngredient)
                .unlockedBy(hasAspenPlanksName, hasAspenPlanks)
                .save(recipeOutput);
        hangingSign(recipeOutput, ArtistryItems.ASPEN_HANGING_SIGN.get(), ArtistryBlocks.ASPEN_PLANKS.get());*/

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
        //endregion
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
                .save(recipeOutput);
    }

    protected static void table(RecipeOutput recipeOutput, ItemLike table, ItemLike planks) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, table, 2)
                .define('#', planks)
                .define('/', Items.STICK)
                .pattern("###")
                .pattern("/ /")
                .pattern("/ /")
                .unlockedBy(getHasName(planks), has(planks))
                .save(recipeOutput);
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