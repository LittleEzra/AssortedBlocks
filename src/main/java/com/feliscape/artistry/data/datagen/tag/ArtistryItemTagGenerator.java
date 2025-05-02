package com.feliscape.artistry.data.datagen.tag;

import com.feliscape.artistry.registry.ArtistryItems;
import com.feliscape.artistry.registry.ArtistryTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ArtistryItemTagGenerator extends ItemTagsProvider {
    public ArtistryItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ArtistryTags.Items.CAN_APPLY_MOSS)
                .add(Items.MOSS_BLOCK)
                .add(Items.VINE)
                .addOptional(ResourceLocation.parse("immersive_weathering:moss_clump"))
        ;
        this.copy(ArtistryTags.Blocks.ASPEN_LOGS, ArtistryTags.Items.ASPEN_LOGS);
        this.tag(ItemTags.BOATS)
                .add(ArtistryItems.ASPEN_BOAT.get());
        this.tag(ItemTags.CHEST_BOATS)
                .add(ArtistryItems.ASPEN_CHEST_BOAT.get());
    }
}
