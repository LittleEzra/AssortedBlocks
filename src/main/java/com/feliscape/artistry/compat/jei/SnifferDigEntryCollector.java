package com.feliscape.artistry.compat.jei;


import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SnifferDigEntryCollector {
    private final Map<Item, BlockPredicate> rawRegistry = new HashMap<>();
    private final Set<SnifferDigEntry> entries = new LinkedHashSet<>();

    public SnifferDigEntryCollector() {

    }

    public void register(SnifferDigEntry entry){
        entries.add(entry);
    }

    public Set<SnifferDigEntry> getAll(){
        return entries;
    }
}
