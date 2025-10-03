package com.feliscape.artistry.compat.jei.leeching;

import net.minecraft.core.Holder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.List;

public record LeechingEntry(ItemLike item, List<Holder<Block>> unleeched) {
}
