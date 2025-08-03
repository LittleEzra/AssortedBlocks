package com.feliscape.artistry.data.loot;

import com.feliscape.artistry.Artistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ArtistryLootTables {
    public static ResourceKey<LootTable> SNIFFER_ADDITIONAL = key("gameplay/sniffer_additional");

    private static ResourceKey<LootTable> key(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, Artistry.location(path));
    }
}
