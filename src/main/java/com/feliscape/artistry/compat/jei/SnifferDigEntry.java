package com.feliscape.artistry.compat.jei;

import com.jcraft.jorbis.Block;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;

public class SnifferDigEntry {
    private final ItemLike item;
    @Nullable
    private final BlockPredicate block;

    private SnifferDigEntry(ItemLike item, @Nullable BlockPredicate block) {
        this.item = item;
        this.block = block;
    }

    public ItemLike item() {
        return item;
    }

    @Nullable
    public BlockPredicate block() {
        return block;
    }
}
