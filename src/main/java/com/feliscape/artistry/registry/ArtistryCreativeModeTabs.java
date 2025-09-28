package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class ArtistryCreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Artistry.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BASE_CREATIVE_TAB = REGISTER.register("base",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.artistry.base"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .icon(() -> new ItemStack(ArtistryBlocks.MOSSY_BRICKS.get()))
                    .displayItems(new ManuallyOrderedItemsGenerator())
                    .build());

    public static void register(IEventBus eventBus){
        REGISTER.register(eventBus);
    }

    private static class ManuallyOrderedItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {

        @Override
        public void accept(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
            output.accept(ArtistryBlocks.STONE_TILES);
            output.accept(ArtistryBlocks.STONE_TILE_STAIRS);
            output.accept(ArtistryBlocks.STONE_TILE_SLAB);
            output.accept(ArtistryBlocks.MOSSY_STONE_TILES);
            output.accept(ArtistryBlocks.MOSSY_STONE_TILE_STAIRS);
            output.accept(ArtistryBlocks.MOSSY_STONE_TILE_SLAB);
            output.accept(ArtistryBlocks.OVERGROWN_STONE_TILES);
            output.accept(ArtistryBlocks.STONE_PILLAR);
            output.accept(ArtistryBlocks.MOSSY_STONE_PILLAR);

            output.accept(ArtistryBlocks.MOSSY_BRICKS);
            output.accept(ArtistryBlocks.CRACKED_BRICKS);

            output.accept(ArtistryItems.SNIFFER_CAKE);
            output.accept(ArtistryItems.SUNSPROUT);
            output.accept(ArtistryItems.SUNBURST_VINES);
            output.accept(ArtistryBlocks.BLOOMING_VINES);
            output.accept(ArtistryItems.FERN_SEED);
            output.accept(ArtistryBlocks.LUSH_FERN);
            output.accept(ArtistryItems.ANCIENT_TEAR);
            output.accept(ArtistryBlocks.TEARDROP_GRASS_BLOCK);
            output.accept(ArtistryBlocks.SHORT_TEARDROP_GRASS);
            output.accept(ArtistryBlocks.TALL_TEARDROP_GRASS);
            output.accept(ArtistryBlocks.CORPSE_FLOWER);
            output.accept(ArtistryBlocks.FLY_LURE);
            output.accept(ArtistryBlocks.GLOWING_MUSHROOM);
            output.accept(ArtistryBlocks.GLOWING_MUSHROOM_BLOCK);

            output.accept(ArtistryBlocks.OAK_TABLE);
            output.accept(ArtistryBlocks.SPRUCE_TABLE);
            output.accept(ArtistryBlocks.BIRCH_TABLE);
            output.accept(ArtistryBlocks.JUNGLE_TABLE);
            output.accept(ArtistryBlocks.ACACIA_TABLE);
            output.accept(ArtistryBlocks.CHERRY_TABLE);
            output.accept(ArtistryBlocks.DARK_OAK_TABLE);
            output.accept(ArtistryBlocks.MANGROVE_TABLE);
            output.accept(ArtistryBlocks.ASPEN_TABLE);
            output.accept(ArtistryBlocks.ROTTEN_TABLE);
            output.accept(ArtistryBlocks.BAMBOO_TABLE);
            output.accept(ArtistryBlocks.CRIMSON_TABLE);
            output.accept(ArtistryBlocks.WARPED_TABLE);

            output.accept(ArtistryBlocks.STONE_TABLE);
            output.accept(ArtistryBlocks.ANDESITE_TABLE);
            output.accept(ArtistryBlocks.GRANITE_TABLE);
            output.accept(ArtistryBlocks.DIORITE_TABLE);
            output.accept(ArtistryBlocks.DEEPSLATE_TABLE);
            output.accept(ArtistryBlocks.POLISHED_BLACKSTONE_TABLE);
            output.accept(ArtistryBlocks.TUFF_TABLE);
            output.accept(ArtistryBlocks.CALCITE_TABLE);

            output.accept(ArtistryBlocks.WHITE_FROSTED_GLASS);
            output.accept(ArtistryBlocks.LIGHT_GRAY_FROSTED_GLASS);
            output.accept(ArtistryBlocks.GRAY_FROSTED_GLASS);
            output.accept(ArtistryBlocks.BLACK_FROSTED_GLASS);
            output.accept(ArtistryBlocks.BROWN_FROSTED_GLASS);
            output.accept(ArtistryBlocks.RED_FROSTED_GLASS);
            output.accept(ArtistryBlocks.ORANGE_FROSTED_GLASS);
            output.accept(ArtistryBlocks.YELLOW_FROSTED_GLASS);
            output.accept(ArtistryBlocks.LIME_FROSTED_GLASS);
            output.accept(ArtistryBlocks.GREEN_FROSTED_GLASS);
            output.accept(ArtistryBlocks.CYAN_FROSTED_GLASS);
            output.accept(ArtistryBlocks.LIGHT_BLUE_FROSTED_GLASS);
            output.accept(ArtistryBlocks.BLUE_FROSTED_GLASS);
            output.accept(ArtistryBlocks.PURPLE_FROSTED_GLASS);
            output.accept(ArtistryBlocks.MAGENTA_FROSTED_GLASS);
            output.accept(ArtistryBlocks.PINK_FROSTED_GLASS);

            output.accept(ArtistryBlocks.SPARKLER);
            output.accept(ArtistryBlocks.AMETHYST_STARS);
            output.accept(ArtistryItems.SPARK_FOUNTAIN);
            output.accept(ArtistryBlocks.WATER_FOUNTAIN);

            output.accept(ArtistryBlocks.CALCITE_STAIRS);
            output.accept(ArtistryBlocks.CALCITE_SLAB);
            output.accept(ArtistryBlocks.CALCITE_WALL);

            output.accept(ArtistryBlocks.SMOOTH_CALCITE);
            output.accept(ArtistryBlocks.SMOOTH_CALCITE_STAIRS);
            output.accept(ArtistryBlocks.SMOOTH_CALCITE_SLAB);

            output.accept(ArtistryBlocks.POLISHED_CALCITE);
            output.accept(ArtistryBlocks.POLISHED_CALCITE_STAIRS);
            output.accept(ArtistryBlocks.POLISHED_CALCITE_SLAB);
            output.accept(ArtistryBlocks.POLISHED_CALCITE_WALL);
            output.accept(ArtistryBlocks.CHISELED_CALCITE);

            output.accept(ArtistryBlocks.CALCITE_BRICKS);
            output.accept(ArtistryBlocks.CALCITE_BRICK_STAIRS);
            output.accept(ArtistryBlocks.CALCITE_BRICK_SLAB);
            output.accept(ArtistryBlocks.CALCITE_BRICK_WALL);

            output.accept(ArtistryBlocks.SMALL_CALCITE_BRICKS);
            output.accept(ArtistryBlocks.SMALL_CALCITE_BRICK_STAIRS);
            output.accept(ArtistryBlocks.SMALL_CALCITE_BRICK_SLAB);

            output.accept(ArtistryBlocks.PAINTED_SMOOTH_CALCITE);
            output.accept(ArtistryBlocks.PAINTED_POLISHED_CALCITE);
            output.accept(ArtistryBlocks.PAINTED_CALCITE_BRICKS);
            output.accept(ArtistryBlocks.PAINTED_SMALL_CALCITE_BRICKS);

            output.accept(ArtistryBlocks.DRIPSTONE_STAIRS);
            output.accept(ArtistryBlocks.DRIPSTONE_SLAB);
            output.accept(ArtistryBlocks.DRIPSTONE_WALL);

            output.accept(ArtistryBlocks.POLISHED_DRIPSTONE);
            output.accept(ArtistryBlocks.POLISHED_DRIPSTONE_STAIRS);
            output.accept(ArtistryBlocks.POLISHED_DRIPSTONE_SLAB);
            output.accept(ArtistryBlocks.POLISHED_DRIPSTONE_WALL);

            output.accept(ArtistryBlocks.DRIPSTONE_BRICKS);
            output.accept(ArtistryBlocks.DRIPSTONE_BRICK_STAIRS);
            output.accept(ArtistryBlocks.DRIPSTONE_BRICK_SLAB);
            output.accept(ArtistryBlocks.DRIPSTONE_BRICK_WALL);

            output.accept(ArtistryBlocks.CHISELED_DRIPSTONE);

            output.accept(ArtistryBlocks.COPPER_CHAIN);
            output.accept(ArtistryBlocks.EXPOSED_COPPER_CHAIN);
            output.accept(ArtistryBlocks.WEATHERED_COPPER_CHAIN);
            output.accept(ArtistryBlocks.OXIDIZED_COPPER_CHAIN);
            output.accept(ArtistryBlocks.WAXED_COPPER_CHAIN);
            output.accept(ArtistryBlocks.WAXED_EXPOSED_COPPER_CHAIN);
            output.accept(ArtistryBlocks.WAXED_WEATHERED_COPPER_CHAIN);
            output.accept(ArtistryBlocks.WAXED_OXIDIZED_COPPER_CHAIN);

            output.accept(ArtistryBlocks.ASPEN_LOG);
            output.accept(ArtistryBlocks.ASPEN_WOOD);
            output.accept(ArtistryBlocks.STRIPPED_ASPEN_LOG);
            output.accept(ArtistryBlocks.STRIPPED_ASPEN_WOOD);
            output.accept(ArtistryBlocks.ASPEN_PLANKS);
            output.accept(ArtistryBlocks.ASPEN_STAIRS);
            output.accept(ArtistryBlocks.ASPEN_SLAB);
            output.accept(ArtistryBlocks.ASPEN_FENCE);
            output.accept(ArtistryBlocks.ASPEN_FENCE_GATE);
            output.accept(ArtistryBlocks.ASPEN_DOOR);
            output.accept(ArtistryBlocks.ASPEN_TRAPDOOR);
            output.accept(ArtistryBlocks.ASPEN_PRESSURE_PLATE);
            output.accept(ArtistryBlocks.ASPEN_BUTTON);
            output.accept(ArtistryItems.ASPEN_SIGN);
            output.accept(ArtistryItems.ASPEN_HANGING_SIGN);
            output.accept(ArtistryItems.ASPEN_BOAT);
            output.accept(ArtistryItems.ASPEN_CHEST_BOAT);
            output.accept(ArtistryBlocks.ASPEN_LEAVES);
            output.accept(ArtistryBlocks.ASPEN_SAPLING);

            output.accept(ArtistryBlocks.LEECHING_SOIL);
            output.accept(ArtistryBlocks.WAXED_LEECHING_SOIL);
            output.accept(ArtistryBlocks.HEADSTONE);
            output.accept(ArtistryBlocks.URN);
            output.accept(ArtistryBlocks.MARIGOLD);

            output.accept(ArtistryBlocks.TALL_CANDLE);
            output.accept(ArtistryBlocks.WHITE_TALL_CANDLE);
            output.accept(ArtistryBlocks.LIGHT_GRAY_TALL_CANDLE);
            output.accept(ArtistryBlocks.GRAY_TALL_CANDLE);
            output.accept(ArtistryBlocks.BLACK_TALL_CANDLE);
            output.accept(ArtistryBlocks.BROWN_TALL_CANDLE);
            output.accept(ArtistryBlocks.RED_TALL_CANDLE);
            output.accept(ArtistryBlocks.ORANGE_TALL_CANDLE);
            output.accept(ArtistryBlocks.YELLOW_TALL_CANDLE);
            output.accept(ArtistryBlocks.LIME_TALL_CANDLE);
            output.accept(ArtistryBlocks.GREEN_TALL_CANDLE);
            output.accept(ArtistryBlocks.CYAN_TALL_CANDLE);
            output.accept(ArtistryBlocks.LIGHT_BLUE_TALL_CANDLE);
            output.accept(ArtistryBlocks.BLUE_TALL_CANDLE);
            output.accept(ArtistryBlocks.PURPLE_TALL_CANDLE);
            output.accept(ArtistryBlocks.MAGENTA_TALL_CANDLE);
            output.accept(ArtistryBlocks.PINK_TALL_CANDLE);

            output.accept(ArtistryItems.CARVING_KNIFE);
            output.accept(ArtistryBlocks.WICKED_CARVED_PUMPKIN);
            output.accept(ArtistryBlocks.HUNGRY_CARVED_PUMPKIN);
            output.accept(ArtistryBlocks.HAPPY_CARVED_PUMPKIN);
            output.accept(ArtistryBlocks.STALWART_CARVED_PUMPKIN);
            output.accept(ArtistryBlocks.PEEKING_CARVED_PUMPKIN);
            output.accept(ArtistryBlocks.BELLOWING_CARVED_PUMPKIN);

            output.accept(ArtistryBlocks.WICKED_JACK_O_LANTERN);
            output.accept(ArtistryBlocks.HUNGRY_JACK_O_LANTERN);
            output.accept(ArtistryBlocks.HAPPY_JACK_O_LANTERN);
            output.accept(ArtistryBlocks.STALWART_JACK_O_LANTERN);
            output.accept(ArtistryBlocks.PEEKING_JACK_O_LANTERN);
            output.accept(ArtistryBlocks.BELLOWING_JACK_O_LANTERN);

            output.accept(ArtistryBlocks.ROTTEN_LOG);
            output.accept(ArtistryBlocks.ROTTEN_WOOD);
            output.accept(ArtistryBlocks.STRIPPED_ROTTEN_LOG);
            output.accept(ArtistryBlocks.STRIPPED_ROTTEN_WOOD);
            output.accept(ArtistryBlocks.ROTTEN_PLANKS);
            output.accept(ArtistryBlocks.ROTTEN_STAIRS);
            output.accept(ArtistryBlocks.ROTTEN_SLAB);
            output.accept(ArtistryBlocks.ROTTEN_FENCE);
            output.accept(ArtistryBlocks.ROTTEN_FENCE_GATE);
            output.accept(ArtistryBlocks.ROTTEN_DOOR);
            output.accept(ArtistryBlocks.ROTTEN_TRAPDOOR);
            output.accept(ArtistryBlocks.ROTTEN_PRESSURE_PLATE);
            output.accept(ArtistryBlocks.ROTTEN_BUTTON);
            output.accept(ArtistryItems.ROTTEN_SIGN);
            output.accept(ArtistryItems.ROTTEN_HANGING_SIGN);
            output.accept(ArtistryItems.ROTTEN_BOAT);
            output.accept(ArtistryItems.ROTTEN_CHEST_BOAT);
            output.accept(ArtistryBlocks.ROTTEN_LEAVES);
            output.accept(ArtistryBlocks.ROTTEN_SAPLING);
        }
    }

    // BASE
    private static class DisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {

        private static Predicate<Item> makeExclusionPredicate() {
            Set<Item> exclusions = new ReferenceOpenHashSet<>();

            // Items to exclude from all tabs
            List<ItemLike> simpleExclusions = List.of(
                ArtistryBlocks.PAINTED_POT
            );

            for (ItemLike entry : simpleExclusions) {
                exclusions.add(entry.asItem());
            }

            return exclusions::contains;
        }

        private List<Item> collectBlocks(Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();
            for (DeferredHolder<Block, ?> entry : ArtistryBlocks.BLOCKS.getEntries()) {
                Item item = entry.get()
                        .asItem();
                if (item == Items.AIR)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            items = new ReferenceArrayList<>(new ReferenceLinkedOpenHashSet<>(items));
            return items;
        }

        private List<Item> collectItems(Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();
            for (DeferredHolder<Item, ?> entry : ArtistryItems.ITEMS.getEntries()) {
                Item item = entry.get();
                if (item instanceof BlockItem)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            return items;
        }

        @Override
        public void accept(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
            Predicate<Item> exclusionPredicate = makeExclusionPredicate();

            List<Item> items = new LinkedList<>();
            items.addAll(collectBlocks(exclusionPredicate));
            items.addAll(collectItems(exclusionPredicate));

            outputAll(output, items);
        }
        private static void outputAll(CreativeModeTab.Output output, List<Item> items) {
            for (Item item : items) {
                output.accept(item);
            }
        }
    }
}
