package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ArtistryTags {
    public static class Blocks{
        public static final TagKey<Block> ASPEN_LOGS = create("aspen_logs");
        public static final TagKey<Block> WOODEN_TABLES = create("wooden_tables");
        public static final TagKey<Block> TABLES = create("tables");
        public static final TagKey<Block> STRING_LIGHTS = create("string_lights");
        public static final TagKey<Block> FROSTED_GLASS = create("frosted_glass");

        public static final TagKey<Block> SNIFFER_HAS_ASPEN_PLANTS = create("sniffer_diggable/has_aspen_plants");
        public static final TagKey<Block> SNIFFER_HAS_TEARDROP_GRASS = create("sniffer_diggable/has_teardrop_grass");
        public static final TagKey<Block> SNIFFER_HAS_LUSH_PLANTS = create("sniffer_diggable/has_lush_plants");

        private static TagKey<Block> create(String name){
            return TagKey.create(Registries.BLOCK, Artistry.location(name));
        }
    }
    public static class EntityTypes{

        private static TagKey<EntityType<?>> create(String name){
            return TagKey.create(Registries.ENTITY_TYPE, Artistry.location(name));
        }
    }
    public static class Items{
        public static final TagKey<Item> ASPEN_LOGS = create("aspen_logs");
        public static final TagKey<Item> CAN_APPLY_MOSS = create("can_apply_moss");
        public static final TagKey<Item> WOODEN_TABLES = create("wooden_tables");
        public static final TagKey<Item> TABLES = create("tables");
        public static final TagKey<Item> FROSTED_GLASS = create("frosted_glass");

        private static TagKey<Item> create(String name){
            return TagKey.create(Registries.ITEM, Artistry.location(name));
        }
    }
}
