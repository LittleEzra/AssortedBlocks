package com.feliscape.artistry.compat.jei.sniffer;

import net.minecraft.core.Holder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.List;

public record SnifferDigEntry(ItemLike item, List<Holder<Block>> block) {
}
