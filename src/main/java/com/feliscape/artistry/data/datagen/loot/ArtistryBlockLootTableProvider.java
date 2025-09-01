package com.feliscape.artistry.data.datagen.loot;

import com.feliscape.artistry.content.block.UrnBlock;
import com.feliscape.artistry.content.block.plant.TriplePlantBlock;
import com.feliscape.artistry.content.block.properties.TriplePlantPart;
import com.feliscape.artistry.content.pot.PaintedPotDecorations;
import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;

import static net.minecraft.advancements.critereon.StatePropertiesPredicate.Builder.properties;
import static net.minecraft.world.level.storage.loot.LootPool.lootPool;
import static net.minecraft.world.level.storage.loot.entries.LootItem.lootTableItem;
import static net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition.hasBlockStateProperties;

public class ArtistryBlockLootTableProvider extends BlockLootSubProvider {
    public ArtistryBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.dropSelf(ArtistryBlocks.MOSSY_BRICKS.get());
        this.dropSelf(ArtistryBlocks.CRACKED_BRICKS.get());
        this.dropSelf(ArtistryBlocks.STONE_TILES.get());
        this.dropSelf(ArtistryBlocks.STONE_TILE_STAIRS.get());
        this.add(ArtistryBlocks.STONE_TILE_SLAB.get(), this::createSlabItemTable);

        this.dropSelf(ArtistryBlocks.MOSSY_STONE_TILES.get());
        this.dropSelf(ArtistryBlocks.MOSSY_STONE_TILE_STAIRS.get());
        this.add(ArtistryBlocks.MOSSY_STONE_TILE_SLAB.get(), this::createSlabItemTable);

        this.dropSelf(ArtistryBlocks.OVERGROWN_STONE_TILES.get());
        this.dropSelf(ArtistryBlocks.STONE_PILLAR.get());
        this.dropSelf(ArtistryBlocks.MOSSY_STONE_PILLAR.get());

        dropOther(ArtistryBlocks.SUNSPROUT.get(), ArtistryItems.SUNSPROUT);
        dropOther(ArtistryBlocks.LUSH_FERN_CROP.get(), ArtistryItems.FERN_SEED);
        this.add(ArtistryBlocks.SUNBURST_VINES.get(), BlockLootSubProvider::createShearsOnlyDrop);
        this.add(ArtistryBlocks.SUNBURST_VINES_PLANT.get(), BlockLootSubProvider::createShearsOnlyDrop);

        this.add(ArtistryBlocks.BLOOMING_VINES.get(), block -> this.createMultifaceBlockDrops(block, HAS_SHEARS));
        this.add(ArtistryBlocks.WALL_STRING_LIGHTS.get(), this::createWallStringLights);
        this.add(ArtistryBlocks.LUSH_FERN.get(), BlockLootSubProvider::createShearsOnlyDrop);
        this.dropOtherWithoutSilkTouch(ArtistryBlocks.TEARDROP_GRASS_BLOCK.get(), Blocks.DIRT);
        this.add(ArtistryBlocks.SHORT_TEARDROP_GRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);
        this.dropPottedContents(ArtistryBlocks.POTTED_TEARDROP_GRASS.get());
        this.add(ArtistryBlocks.TALL_TEARDROP_GRASS.get(), block -> this.createDoublePlantShearsDrop(ArtistryBlocks.SHORT_TEARDROP_GRASS.get()));
        this.add(ArtistryBlocks.CORPSE_FLOWER.get(), block -> this.createSinglePropConditionTable(block, TriplePlantBlock.PART, TriplePlantPart.BASE));
        this.dropSelf(ArtistryBlocks.FLY_LURE.get());
        this.dropSelf(ArtistryBlocks.HONEYDEW_FRUIT.get());
        this.dropOther(ArtistryBlocks.HONEYDEW_STALK.get(), ArtistryItems.GOLDEN_BULB);

        this.dropSelf(ArtistryBlocks.OAK_TABLE.get());
        this.dropSelf(ArtistryBlocks.SPRUCE_TABLE.get());
        this.dropSelf(ArtistryBlocks.BIRCH_TABLE.get());
        this.dropSelf(ArtistryBlocks.JUNGLE_TABLE.get());
        this.dropSelf(ArtistryBlocks.ACACIA_TABLE.get());
        this.dropSelf(ArtistryBlocks.CHERRY_TABLE.get());
        this.dropSelf(ArtistryBlocks.DARK_OAK_TABLE.get());
        this.dropSelf(ArtistryBlocks.MANGROVE_TABLE.get());
        this.dropSelf(ArtistryBlocks.ASPEN_TABLE.get());
        this.dropSelf(ArtistryBlocks.ROTTEN_TABLE.get());
        this.dropSelf(ArtistryBlocks.BAMBOO_TABLE.get());
        this.dropSelf(ArtistryBlocks.CRIMSON_TABLE.get());
        this.dropSelf(ArtistryBlocks.WARPED_TABLE.get());

        this.dropSelf(ArtistryBlocks.STONE_TABLE.get());
        this.dropSelf(ArtistryBlocks.ANDESITE_TABLE.get());
        this.dropSelf(ArtistryBlocks.GRANITE_TABLE.get());
        this.dropSelf(ArtistryBlocks.DIORITE_TABLE.get());
        this.dropSelf(ArtistryBlocks.DEEPSLATE_TABLE.get());
        this.dropSelf(ArtistryBlocks.POLISHED_BLACKSTONE_TABLE.get());
        this.dropSelf(ArtistryBlocks.TUFF_TABLE.get());
        this.dropSelf(ArtistryBlocks.CALCITE_TABLE.get());

        this.dropWhenSilkTouch(ArtistryBlocks.WHITE_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.LIGHT_GRAY_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.GRAY_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.BLACK_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.BROWN_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.RED_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.ORANGE_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.YELLOW_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.LIME_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.GREEN_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.CYAN_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.LIGHT_BLUE_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.BLUE_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.PURPLE_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.MAGENTA_FROSTED_GLASS.get());
        this.dropWhenSilkTouch(ArtistryBlocks.PINK_FROSTED_GLASS.get());

        this.dropSelf(ArtistryBlocks.STRING_LIGHTS.get());

        this.dropSelf(ArtistryBlocks.COPPER_CHAIN.get());
        this.dropSelf(ArtistryBlocks.EXPOSED_COPPER_CHAIN.get());
        this.dropSelf(ArtistryBlocks.WEATHERED_COPPER_CHAIN.get());
        this.dropSelf(ArtistryBlocks.OXIDIZED_COPPER_CHAIN.get());

        this.dropSelf(ArtistryBlocks.WAXED_COPPER_CHAIN.get());
        this.dropSelf(ArtistryBlocks.WAXED_EXPOSED_COPPER_CHAIN.get());
        this.dropSelf(ArtistryBlocks.WAXED_WEATHERED_COPPER_CHAIN.get());
        this.dropSelf(ArtistryBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get());

        this.add(ArtistryBlocks.LARGE_LANTERN.get(), this::createSingleItemTable);
        this.add(ArtistryBlocks.LARGE_SOUL_LANTERN.get(), this::createSingleItemTable);
        this.add(ArtistryBlocks.ROUND_LANTERN.get(), this::createSingleItemTable);
        this.add(ArtistryBlocks.FLAT_LIGHT.get(), this::createSingleItemTable);

        this.dropSelf(ArtistryBlocks.SPARKLER.get());
        this.add(ArtistryBlocks.AMETHYST_STARS.get(), this::createMultifaceBlockDrops);

        this.add(ArtistryBlocks.SPARK_FOUNTAIN.get(), this::createSparkFountain);
        this.dropSelf(ArtistryBlocks.WATER_FOUNTAIN.get());

        this.dropSelf(ArtistryBlocks.ROCKY_DIRT.get());

        this.add(ArtistryBlocks.PAINTED_POT.get(), this::createPaintedPotTable);


        this.dropSelf(ArtistryBlocks.CALCITE_STAIRS.get());
        this.dropSelf(ArtistryBlocks.CALCITE_WALL.get());
        this.add(ArtistryBlocks.CALCITE_SLAB.get(), this::createSlabItemTable);

        this.dropSelf(ArtistryBlocks.SMOOTH_CALCITE.get());
        this.dropSelf(ArtistryBlocks.SMOOTH_CALCITE_STAIRS.get());
        this.add(ArtistryBlocks.SMOOTH_CALCITE_SLAB.get(), this::createSlabItemTable);

        this.dropSelf(ArtistryBlocks.POLISHED_CALCITE.get());
        this.dropSelf(ArtistryBlocks.CHISELED_CALCITE.get());
        this.dropSelf(ArtistryBlocks.POLISHED_CALCITE_STAIRS.get());
        this.dropSelf(ArtistryBlocks.POLISHED_CALCITE_WALL.get());
        this.add(ArtistryBlocks.POLISHED_CALCITE_SLAB.get(), this::createSlabItemTable);

        this.dropSelf(ArtistryBlocks.CALCITE_BRICKS.get());
        this.dropSelf(ArtistryBlocks.CALCITE_BRICK_STAIRS.get());
        this.dropSelf(ArtistryBlocks.CALCITE_BRICK_WALL.get());
        this.add(ArtistryBlocks.CALCITE_BRICK_SLAB.get(), this::createSlabItemTable);

        this.dropSelf(ArtistryBlocks.SMALL_CALCITE_BRICKS.get());
        this.dropSelf(ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS.get());
        this.add(ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB.get(), this::createSlabItemTable);

        this.dropSelf(ArtistryBlocks.PAINTED_SMOOTH_CALCITE.get());
        this.dropSelf(ArtistryBlocks.PAINTED_POLISHED_CALCITE.get());
        this.dropSelf(ArtistryBlocks.PAINTED_CALCITE_BRICKS.get());
        this.dropSelf(ArtistryBlocks.PAINTED_SMALL_CALCITE_BRICKS.get());

        this.dropSelf(ArtistryBlocks.DRIPSTONE_STAIRS.get());
        this.dropSelf(ArtistryBlocks.DRIPSTONE_WALL.get());
        this.add(ArtistryBlocks.DRIPSTONE_SLAB.get(), this::createSlabItemTable);

        this.dropSelf(ArtistryBlocks.POLISHED_DRIPSTONE.get());
        this.dropSelf(ArtistryBlocks.CHISELED_DRIPSTONE.get());
        this.dropSelf(ArtistryBlocks.POLISHED_DRIPSTONE_STAIRS.get());
        this.dropSelf(ArtistryBlocks.POLISHED_DRIPSTONE_WALL.get());
        this.add(ArtistryBlocks.POLISHED_DRIPSTONE_SLAB.get(), this::createSlabItemTable);

        this.dropSelf(ArtistryBlocks.DRIPSTONE_BRICKS.get());
        this.dropSelf(ArtistryBlocks.DRIPSTONE_BRICK_STAIRS.get());
        this.dropSelf(ArtistryBlocks.DRIPSTONE_BRICK_WALL.get());
        this.add(ArtistryBlocks.DRIPSTONE_BRICK_SLAB.get(), this::createSlabItemTable);

        // Aspen

        this.dropSelf(ArtistryBlocks.ASPEN_LOG.get());
        this.dropSelf(ArtistryBlocks.ASPEN_WOOD.get());
        this.dropSelf(ArtistryBlocks.STRIPPED_ASPEN_LOG.get());
        this.dropSelf(ArtistryBlocks.STRIPPED_ASPEN_WOOD.get());
        this.dropSelf(ArtistryBlocks.ASPEN_PLANKS.get());

        this.add(ArtistryBlocks.ASPEN_SIGN.get(), block ->
                createSingleItemTable(ArtistryItems.ASPEN_SIGN.get()));
        this.add(ArtistryBlocks.ASPEN_WALL_SIGN.get(), block ->
                createSingleItemTable(ArtistryItems.ASPEN_SIGN.get()));
        this.add(ArtistryBlocks.ASPEN_HANGING_SIGN.get(), block ->
                createSingleItemTable(ArtistryItems.ASPEN_HANGING_SIGN.get()));
        this.add(ArtistryBlocks.ASPEN_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ArtistryItems.ASPEN_HANGING_SIGN.get()));

        this.dropSelf(ArtistryBlocks.ASPEN_STAIRS.get());
        this.dropSelf(ArtistryBlocks.ASPEN_BUTTON.get());
        this.dropSelf(ArtistryBlocks.ASPEN_PRESSURE_PLATE.get());
        this.dropSelf(ArtistryBlocks.ASPEN_TRAPDOOR.get());
        this.dropSelf(ArtistryBlocks.ASPEN_FENCE.get());
        this.dropSelf(ArtistryBlocks.ASPEN_FENCE_GATE.get());
        this.dropSelf(ArtistryBlocks.ASPEN_SAPLING.get());
        this.dropPottedContents(ArtistryBlocks.POTTED_ASPEN_SAPLING.get());

        this.add(ArtistryBlocks.ASPEN_SLAB.get(), this::createSlabItemTable);
        this.add(ArtistryBlocks.ASPEN_DOOR.get(), this::createDoorTable);

        this.add(ArtistryBlocks.ASPEN_LEAVES.get(),
                block -> createLeavesDrops(block, ArtistryBlocks.ASPEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ArtistryBlocks.HEADSTONE.get());
        this.dropSelf(ArtistryBlocks.LEECHING_SOIL.get());
        this.dropSelf(ArtistryBlocks.WAXED_LEECHING_SOIL.get());
        this.add(ArtistryBlocks.URN.get(), this::createUrnTable);
        this.dropSelf(ArtistryBlocks.MARIGOLD.get());
        this.dropPottedContents(ArtistryBlocks.POTTED_MARIGOLD.get());

        this.dropSelf(ArtistryBlocks.WICKED_CARVED_PUMPKIN.get());
        this.dropSelf(ArtistryBlocks.HUNGRY_CARVED_PUMPKIN.get());
        this.dropSelf(ArtistryBlocks.HAPPY_CARVED_PUMPKIN.get());
        this.dropSelf(ArtistryBlocks.STALWART_CARVED_PUMPKIN.get());
        this.dropSelf(ArtistryBlocks.PEEKING_CARVED_PUMPKIN.get());
        this.dropSelf(ArtistryBlocks.BELLOWING_CARVED_PUMPKIN.get());

        this.dropSelf(ArtistryBlocks.WICKED_JACK_O_LANTERN.get());
        this.dropSelf(ArtistryBlocks.HUNGRY_JACK_O_LANTERN.get());
        this.dropSelf(ArtistryBlocks.HAPPY_JACK_O_LANTERN.get());
        this.dropSelf(ArtistryBlocks.STALWART_JACK_O_LANTERN.get());
        this.dropSelf(ArtistryBlocks.PEEKING_JACK_O_LANTERN.get());
        this.dropSelf(ArtistryBlocks.BELLOWING_JACK_O_LANTERN.get());

        this.add(ArtistryBlocks.TALL_CANDLE.get(), this::createCandleDrops);

        this.add(ArtistryBlocks.WHITE_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.LIGHT_GRAY_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.GRAY_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.BLACK_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.BROWN_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.RED_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.ORANGE_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.YELLOW_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.LIME_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.GREEN_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.CYAN_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.LIGHT_BLUE_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.BLUE_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.PURPLE_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.MAGENTA_TALL_CANDLE.get(), this::createCandleDrops);
        this.add(ArtistryBlocks.PINK_TALL_CANDLE.get(), this::createCandleDrops);

        // Aspen

        this.dropSelf(ArtistryBlocks.ROTTEN_LOG.get());
        this.dropSelf(ArtistryBlocks.ROTTEN_WOOD.get());
        this.dropSelf(ArtistryBlocks.STRIPPED_ROTTEN_LOG.get());
        this.dropSelf(ArtistryBlocks.STRIPPED_ROTTEN_WOOD.get());
        this.dropSelf(ArtistryBlocks.ROTTEN_PLANKS.get());

        this.add(ArtistryBlocks.ROTTEN_SIGN.get(), block ->
                createSingleItemTable(ArtistryItems.ROTTEN_SIGN.get()));
        this.add(ArtistryBlocks.ROTTEN_WALL_SIGN.get(), block ->
                createSingleItemTable(ArtistryItems.ROTTEN_SIGN.get()));
        this.add(ArtistryBlocks.ROTTEN_HANGING_SIGN.get(), block ->
                createSingleItemTable(ArtistryItems.ROTTEN_HANGING_SIGN.get()));
        this.add(ArtistryBlocks.ROTTEN_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ArtistryItems.ROTTEN_HANGING_SIGN.get()));

        this.dropSelf(ArtistryBlocks.ROTTEN_STAIRS.get());
        this.dropSelf(ArtistryBlocks.ROTTEN_BUTTON.get());
        this.dropSelf(ArtistryBlocks.ROTTEN_PRESSURE_PLATE.get());
        this.dropSelf(ArtistryBlocks.ROTTEN_TRAPDOOR.get());
        this.dropSelf(ArtistryBlocks.ROTTEN_FENCE.get());
        this.dropSelf(ArtistryBlocks.ROTTEN_FENCE_GATE.get());
        this.dropSelf(ArtistryBlocks.ROTTEN_SAPLING.get());
        this.dropPottedContents(ArtistryBlocks.POTTED_ROTTEN_SAPLING.get());

        this.add(ArtistryBlocks.ROTTEN_SLAB.get(), this::createSlabItemTable);
        this.add(ArtistryBlocks.ROTTEN_DOOR.get(), this::createDoorTable);

        this.add(ArtistryBlocks.ROTTEN_LEAVES.get(),
                block -> createLeavesDrops(block, ArtistryBlocks.ROTTEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder createSingleTriplePlantShearsDrop(Block sheared) {
        return LootTable.lootTable()
                .withPool(
                        lootPool().when(HAS_SHEARS).add(lootTableItem(sheared).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))
                );
    }

    private LootTable.Builder createUrnTable(Block block){
        return LootTable.lootTable().withPool(lootPool().add(lootTableItem(block))
                .when(hasBlockStateProperties(block)
                        .setProperties(properties().hasProperty(UrnBlock.CRACKED, false))));
    }

    private LootTable.Builder createPaintedPotTable(Block block) {
        return LootTable.lootTable().withPool(lootPool()
                        .setRolls(ConstantValue.exactly(1.0F)).add(
                                lootTableItem(Items.BRICK).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))) // No sherds can be applied, so just drop 4 bricks
                                        .when(hasBlockStateProperties(block)
                                                                .setProperties(properties().hasProperty(DecoratedPotBlock.CRACKED, true)))
                                        .otherwise(
                                                lootTableItem(block)
                                                        .apply(
                                                                CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
                                                                        .include(PaintedPotDecorations.type())
                                                        )
                                        )
                                )
                );
    }
    private LootTable.Builder createSparkFountain(Block block) {
        return LootTable.lootTable().withPool(lootPool()
                        .setRolls(ConstantValue.exactly(1.0F)).add(
                                lootTableItem(block)
                                        .apply(
                                                CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
                                                        .include(DataComponents.DYED_COLOR)
                                        )
                ));
    }

    protected LootTable.Builder createWallStringLights(Block block) {
        return LootTable.lootTable()
                .withPool(lootPool().add(
                        this.applyExplosionDecay(
                                block,
                                lootTableItem(block)
                                        .apply(
                                                Direction.Plane.HORIZONTAL,
                                                faceProperty -> SetItemCountFunction.setCount(ConstantValue.exactly(1.0F), true)
                                                        .when(hasBlockStateProperties(block)
                                                                        .setProperties(properties().hasProperty(MultifaceBlock.getFaceProperty(faceProperty), true))
                                                        )
                            )
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(-1.0F), true))
                    )
                )
            );
    }

    protected LootTable.Builder createMultifaceBlockDrops(Block block) {
        return LootTable.lootTable().withPool(lootPool().add(
                this.applyExplosionDecay(block, lootTableItem(block)
                        .apply(
                                Direction.values(), direction -> SetItemCountFunction.setCount(ConstantValue.exactly(1.0F), true)
                                        .when(hasBlockStateProperties(block)
                                                .setProperties(properties()
                                                        .hasProperty(MultifaceBlock.getFaceProperty(direction), true))))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(-1.0F), true)))));
    }

    protected void dropOtherWithoutSilkTouch(Block block, ItemLike other){
        this.add(block, b -> this.createSingleItemTableWithSilkTouch(b, other));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ArtistryBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
