package com.feliscape.artistry.data.loot;

import com.feliscape.artistry.Artistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ArtistryLootTables {
    public static final ResourceKey<LootTable> GOLDEN_BULB_DROP = key("glm/block/gold_ore_extra");

    private static ResourceKey<LootTable> key(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, Artistry.location(path));
    }
}
