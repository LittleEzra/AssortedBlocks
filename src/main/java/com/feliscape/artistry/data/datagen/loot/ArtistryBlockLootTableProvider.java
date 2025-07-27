package com.feliscape.artistry.data.datagen.loot;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;

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
        this.add(ArtistryBlocks.SUNBURST_VINES.get(), BlockLootSubProvider::createShearsOnlyDrop);
        this.add(ArtistryBlocks.SUNBURST_VINES_PLANT.get(), BlockLootSubProvider::createShearsOnlyDrop);

        this.add(ArtistryBlocks.BLOOMING_VINES.get(), block -> this.createMultifaceBlockDrops(block, HAS_SHEARS));
        this.add(ArtistryBlocks.WALL_STRING_LIGHTS.get(), this::createWallStringLights);
        this.add(ArtistryBlocks.LUSH_FERN.get(), BlockLootSubProvider::createShearsOnlyDrop);

        this.dropSelf(ArtistryBlocks.OAK_TABLE.get());
        this.dropSelf(ArtistryBlocks.SPRUCE_TABLE.get());
        this.dropSelf(ArtistryBlocks.BIRCH_TABLE.get());
        this.dropSelf(ArtistryBlocks.JUNGLE_TABLE.get());
        this.dropSelf(ArtistryBlocks.ACACIA_TABLE.get());
        this.dropSelf(ArtistryBlocks.CHERRY_TABLE.get());
        this.dropSelf(ArtistryBlocks.DARK_OAK_TABLE.get());
        this.dropSelf(ArtistryBlocks.MANGROVE_TABLE.get());
        this.dropSelf(ArtistryBlocks.ASPEN_TABLE.get());
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

        this.dropSelf(ArtistryBlocks.STRING_LIGHTS.get());

        this.add(ArtistryBlocks.LARGE_LANTERN.get(), this::createSingleItemTable);
        this.add(ArtistryBlocks.LARGE_SOUL_LANTERN.get(), this::createSingleItemTable);
        this.add(ArtistryBlocks.ROUND_LANTERN.get(), this::createSingleItemTable);
        this.add(ArtistryBlocks.FLAT_LIGHT.get(), this::createSingleItemTable);

        this.dropSelf(ArtistryBlocks.SPARKLER.get());
        this.add(ArtistryBlocks.AMETHYST_STARS.get(), this::createMultifaceBlockDrops);

        this.dropSelf(ArtistryBlocks.SPARK_FOUNTAIN.get());
        this.dropSelf(ArtistryBlocks.WATER_FOUNTAIN.get());

        this.dropSelf(ArtistryBlocks.ROCKY_DIRT.get());

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
        dropPottedContents(ArtistryBlocks.POTTED_ASPEN_SAPLING.get());

        this.add(ArtistryBlocks.ASPEN_SLAB.get(), this::createSlabItemTable);
        this.add(ArtistryBlocks.ASPEN_DOOR.get(), this::createDoorTable);

        this.add(ArtistryBlocks.ASPEN_LEAVES.get(),
                block -> createLeavesDrops(ArtistryBlocks.ASPEN_LEAVES.get(), ArtistryBlocks.ASPEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder createWallStringLights(Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().add(
                        this.applyExplosionDecay(
                                block,
                                LootItem.lootTableItem(block)
                                        .apply(
                                                Direction.Plane.HORIZONTAL,
                                                faceProperty -> SetItemCountFunction.setCount(ConstantValue.exactly(1.0F), true)
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MultifaceBlock.getFaceProperty(faceProperty), true))
                                                        )
                            )
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(-1.0F), true))
                    )
                )
            );
    }

    protected LootTable.Builder createMultifaceBlockDrops(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add(
                this.applyExplosionDecay(block, LootItem.lootTableItem(block)
                        .apply(
                                Direction.values(), direction -> SetItemCountFunction.setCount(ConstantValue.exactly(1.0F), true)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
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
