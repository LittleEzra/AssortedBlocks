package com.feliscape.artistry.compat.jei.leeching;

import com.feliscape.artistry.compat.jei.sniffer.SnifferDigEntry;
import com.feliscape.artistry.compat.jei.sniffer.SnifferDigEntryCollector;
import com.feliscape.artistry.data.map.Leechable;
import com.feliscape.artistry.registry.ArtistryDataMapTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeechingEntryCollector {
    private static LeechingEntryCollector instance;
    private final List<LeechingEntry> entries = new ArrayList<>();

    public static LeechingEntryCollector getInstance(){
        if (instance == null)
            instance = new LeechingEntryCollector();
        return instance;
    }

    public LeechingEntryCollector() {

    }

    public void collect(Level level){
        var dataMap = BuiltInRegistries.BLOCK.getDataMap(ArtistryDataMapTypes.LEECHABLES);
        var lookup = level.registryAccess().lookupOrThrow(Registries.BLOCK);
        var hashMap = new HashMap<ItemLike, List<Holder<Block>>>();
        dataMap.forEach((key, value) -> {
            if (value.block().asItem() == Items.AIR) return;

            if (hashMap.containsKey(value.block())){
                ArrayList<Holder<Block>> list = new ArrayList<>(hashMap.get(value.block()));
                list.add(lookup.getOrThrow(key));
                hashMap.put(value.block(), list);
            } else{
                hashMap.put(value.block(), List.of(lookup.getOrThrow(key)));
            }
        });
        hashMap.forEach((key, blocks) -> {
            entries.add(new LeechingEntry(key, blocks));
        });
    }

    public List<LeechingEntry> getEntries() {
        return entries;
    }
}
