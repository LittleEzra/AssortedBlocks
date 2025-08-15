package com.feliscape.artistry.compat.jei;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

public record SnifferDigEntry(ItemLike item, List<Holder<Block>> block) {
}
