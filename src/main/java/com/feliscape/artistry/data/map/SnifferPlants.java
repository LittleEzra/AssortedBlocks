package com.feliscape.artistry.data.map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.datamaps.DataMapValueMerger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public record SnifferPlants(List<Item> items, boolean hasDefault) {
    public static final Codec<SnifferPlants> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            BuiltInRegistries.ITEM.byNameCodec().listOf().fieldOf("items").forGetter(SnifferPlants::items),
            Codec.BOOL.optionalFieldOf("hasDefault", true).forGetter(SnifferPlants::hasDefault)
    ).apply(inst, SnifferPlants::new));


    public static SnifferPlants create(List<ItemLike> items){
        return new SnifferPlants(createList(items), true);
    }

    public static SnifferPlants create(ItemLike... items){
        return new SnifferPlants(createList(items), true);
    }
    public static SnifferPlants create(boolean hasDefault, List<ItemLike> items){
        return new SnifferPlants(createList(items), hasDefault);
    }

    public static SnifferPlants create(boolean hasDefault, ItemLike... items){
        return new SnifferPlants(createList(items), hasDefault);
    }

    public static List<Item> createList(List<ItemLike> items){
        return items.stream().map(ItemLike::asItem).toList();
    }
    public static List<Item> createList(ItemLike... items){
        return Stream.of(items).map(ItemLike::asItem).toList();
    }

    public static <R> DataMapValueMerger<R, SnifferPlants> merger() {
        return (registry, first, firstValue, second, secondValue) -> {
            final List<Item> list = new ArrayList<>(firstValue.items());
            list.addAll(secondValue.items());
            return new SnifferPlants(list, secondValue.hasDefault());
        };
    }
}
