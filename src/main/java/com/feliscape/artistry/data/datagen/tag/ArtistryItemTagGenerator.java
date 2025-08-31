package com.feliscape.artistry.data.datagen.tag;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.feliscape.artistry.registry.ArtistryItems;
import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class ArtistryItemTagGenerator extends ItemTagsProvider {
    public ArtistryItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.copy(ArtistryTags.Blocks.ASPEN_LOGS, ArtistryTags.Items.ASPEN_LOGS);
        this.copy(ArtistryTags.Blocks.ROTTEN_LOGS, ArtistryTags.Items.ROTTEN_LOGS);
        this.copy(ArtistryTags.Blocks.WOODEN_TABLES, ArtistryTags.Items.WOODEN_TABLES);
        this.copy(ArtistryTags.Blocks.TABLES, ArtistryTags.Items.TABLES);
        this.copy(ArtistryTags.Blocks.FROSTED_GLASS, ArtistryTags.Items.FROSTED_GLASS);

        this.tag(ItemTags.SNIFFER_FOOD)
                .add(ArtistryItems.SNIFFER_CAKE.get());

        this.tag(ItemTags.CHICKEN_FOOD)
                .add(ArtistryItems.FERN_SEED.get());
        this.tag(ItemTags.PARROT_FOOD)
                .add(ArtistryItems.FERN_SEED.get());
        this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(ArtistryItems.FERN_SEED.get());

        this.tag(ItemTags.DYEABLE)
                .add(ArtistryBlocks.SPARK_FOUNTAIN.asItem());

        this.tag(ItemTags.PLANKS)
                .add(ArtistryBlocks.ASPEN_PLANKS.asItem())
                .add(ArtistryBlocks.ROTTEN_PLANKS.asItem())
        ;

        this.tag(ItemTags.LOGS_THAT_BURN)
                .addTag(ArtistryTags.Items.ASPEN_LOGS)
                .addTag(ArtistryTags.Items.ROTTEN_LOGS)
        ;
        this.tag(Tags.Items.STRIPPED_LOGS)
                .add(ArtistryBlocks.STRIPPED_ASPEN_LOG.asItem())
                .add(ArtistryBlocks.STRIPPED_ROTTEN_LOG.asItem())
        ;
        this.tag(Tags.Items.STRIPPED_WOODS)
                .add(ArtistryBlocks.STRIPPED_ASPEN_WOOD.asItem())
                .add(ArtistryBlocks.STRIPPED_ROTTEN_WOOD.asItem())
        ;

        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ArtistryBlocks.ASPEN_STAIRS.asItem())
                .add(ArtistryBlocks.ROTTEN_STAIRS.asItem())
        ;
        this.tag(ItemTags.WOODEN_SLABS)
                .add(ArtistryBlocks.ASPEN_SLAB.asItem())
                .add(ArtistryBlocks.ROTTEN_SLAB.asItem())
        ;
        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ArtistryBlocks.ASPEN_BUTTON.asItem())
                .add(ArtistryBlocks.ROTTEN_BUTTON.asItem())
        ;
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ArtistryBlocks.ASPEN_PRESSURE_PLATE.asItem())
                .add(ArtistryBlocks.ROTTEN_PRESSURE_PLATE.asItem())
        ;
        this.tag(ItemTags.WOODEN_FENCES)
                .add(ArtistryBlocks.ASPEN_FENCE.asItem())
                .add(ArtistryBlocks.ROTTEN_FENCE.asItem())
        ;
        this.tag(ItemTags.WOODEN_DOORS)
                .add(ArtistryBlocks.ASPEN_DOOR.asItem())
                .add(ArtistryBlocks.ROTTEN_DOOR.asItem())
        ;
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ArtistryBlocks.ASPEN_TRAPDOOR.asItem())
                .add(ArtistryBlocks.ROTTEN_TRAPDOOR.asItem())
        ;
        this.tag(ItemTags.SIGNS)
                .add(ArtistryBlocks.ASPEN_SIGN.asItem())
                .add(ArtistryBlocks.ASPEN_WALL_SIGN.asItem())
                .add(ArtistryBlocks.ROTTEN_SIGN.asItem())
                .add(ArtistryBlocks.ROTTEN_WALL_SIGN.asItem())
        ;
        this.tag(ItemTags.HANGING_SIGNS)
                .add(ArtistryBlocks.ASPEN_HANGING_SIGN.asItem())
                .add(ArtistryBlocks.ASPEN_WALL_HANGING_SIGN.asItem())
                .add(ArtistryBlocks.ROTTEN_HANGING_SIGN.asItem())
                .add(ArtistryBlocks.ROTTEN_WALL_HANGING_SIGN.asItem())
        ;
        this.tag(ItemTags.SAPLINGS)
                .add(ArtistryBlocks.ASPEN_SAPLING.asItem())
                .add(ArtistryBlocks.ROTTEN_SAPLING.asItem())
        ;

        this.tag(ItemTags.LEAVES)
                .add(ArtistryBlocks.ASPEN_LEAVES.asItem())
                .add(ArtistryBlocks.ROTTEN_LEAVES.asItem())
        ;

        this.tag(ArtistryTags.Items.CAN_APPLY_MOSS)
                .add(Items.MOSS_BLOCK)
                .add(Items.VINE)
                .addOptional(ResourceLocation.parse("immersive_weathering:moss_clump"))
        ;
        this.tag(ItemTags.BOATS)
                .add(ArtistryItems.ASPEN_BOAT.get())
                .add(ArtistryItems.ROTTEN_BOAT.get())
        ;
        this.tag(ItemTags.CHEST_BOATS)
                .add(ArtistryItems.ASPEN_CHEST_BOAT.get())
                .add(ArtistryItems.ROTTEN_CHEST_BOAT.get())
        ;
    }
}
