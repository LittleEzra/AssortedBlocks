package com.feliscape.artistry.compat.jei;


import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryDataMapTypes;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class SnifferDigEntryCollector {
    private static SnifferDigEntryCollector instance;
    private final List<SnifferDigEntry> entries = new ArrayList<>();

    public static SnifferDigEntryCollector getInstance(){
        if (instance == null)
            instance = new SnifferDigEntryCollector();
        return instance;
    }

    public SnifferDigEntryCollector() {

    }

    public void collect(Level level){
        var dataMap = BuiltInRegistries.BLOCK.getDataMap(ArtistryDataMapTypes.SNIFFER_PLANTS);
        var lookup = level.registryAccess().lookupOrThrow(Registries.BLOCK);
        var hashMap = new HashMap<ItemLike, List<Holder<Block>>>();
        dataMap.forEach((key, value) -> {
            for (ItemLike item : value){
                if (!hashMap.containsKey(item)){
                    hashMap.put(item, List.of(lookup.getOrThrow(key)));
                } else{
                    ArrayList<Holder<Block>> list = new ArrayList<>(hashMap.get(item));
                    list.add(lookup.getOrThrow(key));
                    hashMap.put(item, list);
                }
            }
        });
        hashMap.forEach((key, blocks) -> {
            entries.add(new SnifferDigEntry(key, blocks));
        });
    }

    public List<SnifferDigEntry> getEntries() {
        return entries;
    }
}
