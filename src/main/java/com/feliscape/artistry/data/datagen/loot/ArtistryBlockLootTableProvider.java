package com.feliscape.artistry.data.datagen.loot;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Arrays;
import java.util.Set;

public class ArtistryBlockLootTableProvider extends BlockLootSubProvider {
    public ArtistryBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ArtistryBlocks.MOSSY_BRICKS.get());
        dropSelf(ArtistryBlocks.CRACKED_BRICKS.get());
        dropSelf(ArtistryBlocks.STONE_TILES.get());
        dropSelf(ArtistryBlocks.MOSSY_STONE_TILES.get());
        dropSelf(ArtistryBlocks.OVERGROWN_STONE_TILES.get());
        dropSelf(ArtistryBlocks.STONE_PILLAR.get());
        dropSelf(ArtistryBlocks.MOSSY_STONE_PILLAR.get());

        this.add(ArtistryBlocks.BLOOMING_VINES.get(), block -> this.createBloomingVinesDrops(block, HAS_SHEARS));

        dropSelf(ArtistryBlocks.OAK_TABLE.get());
        dropSelf(ArtistryBlocks.SPRUCE_TABLE.get());
        dropSelf(ArtistryBlocks.BIRCH_TABLE.get());
        dropSelf(ArtistryBlocks.JUNGLE_TABLE.get());
        dropSelf(ArtistryBlocks.ACACIA_TABLE.get());
        dropSelf(ArtistryBlocks.CHERRY_TABLE.get());
        dropSelf(ArtistryBlocks.DARK_OAK_TABLE.get());
        dropSelf(ArtistryBlocks.MANGROVE_TABLE.get());
        dropSelf(ArtistryBlocks.ASPEN_TABLE.get());
        dropSelf(ArtistryBlocks.BAMBOO_TABLE.get());
        dropSelf(ArtistryBlocks.CRIMSON_TABLE.get());
        dropSelf(ArtistryBlocks.WARPED_TABLE.get());

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

        dropSelf(ArtistryBlocks.ASPEN_STAIRS.get());
        dropSelf(ArtistryBlocks.ASPEN_BUTTON.get());
        dropSelf(ArtistryBlocks.ASPEN_PRESSURE_PLATE.get());
        dropSelf(ArtistryBlocks.ASPEN_TRAPDOOR.get());
        dropSelf(ArtistryBlocks.ASPEN_FENCE.get());
        dropSelf(ArtistryBlocks.ASPEN_FENCE_GATE.get());
        dropSelf(ArtistryBlocks.ASPEN_SAPLING.get());

        this.add(ArtistryBlocks.ASPEN_SLAB.get(),
                block -> createSlabItemTable(ArtistryBlocks.ASPEN_SLAB.get()));
        this.add(ArtistryBlocks.ASPEN_DOOR.get(),
                block -> createDoorTable(ArtistryBlocks.ASPEN_DOOR.get()));

        this.add(ArtistryBlocks.ASPEN_LEAVES.get(),
                block -> createLeavesDrops(ArtistryBlocks.ASPEN_LEAVES.get(), ArtistryBlocks.ASPEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }


    @SuppressWarnings("unchecked")
    protected LootTable.Builder createBloomingVinesDrops(Block block, LootItemCondition.Builder builder) {
        return LootTable.lootTable().withPool(LootPool.lootPool().add((LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(block, ((LootPoolSingletonContainer.Builder)((LootPoolSingletonContainer.Builder)
                        LootItem.lootTableItem(block)
                        .when(builder))
                        .apply(Direction.Plane.HORIZONTAL, (d) -> SetItemCountFunction.setCount(ConstantValue.exactly(1.0F), true)
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MultifaceBlock.getFaceProperty((Direction) d), true)))))
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
