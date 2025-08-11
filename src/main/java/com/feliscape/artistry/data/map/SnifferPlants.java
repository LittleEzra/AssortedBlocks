package com.feliscape.artistry.data.map;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.stream.Stream;

public class SnifferPlants {
    public static List<Item> create(List<ItemLike> items){
        return items.stream().map(ItemLike::asItem).toList();
    }
    public static List<Item> create(ItemLike... items){
        return Stream.of(items).map(ItemLike::asItem).toList();
    }
}
