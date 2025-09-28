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
        public static final TagKey<Block> ROTTEN_LOGS = create("rotten_logs");

        public static final TagKey<Block> WOODEN_TABLES = create("wooden_tables");
        public static final TagKey<Block> TABLES = create("tables");
        public static final TagKey<Block> STRING_LIGHTS = create("string_lights");
        public static final TagKey<Block> FROSTED_GLASS = create("frosted_glass");
        public static final TagKey<Block> TALL_CANDLES = create("tall_candles");

        public static final TagKey<Block> LEECHABLE_SAPLINGS = create("leechable_saplings");
        public static final TagKey<Block> LEECHABLE_FLOWERS = create("leechable_flowers");
        public static final TagKey<Block> CARVABLE_PUMPKINS = create("carvable_pumpkins");
        public static final TagKey<Block> NON_GLOWING_MUSHROOMS = create("non_glowing_mushrooms");
        public static final TagKey<Block> GLOWING_MUSHROOM_SUBSTRATE = create("glowing_mushroom_substrate");

        public static final TagKey<Block> UNDERGROUND_PLANT_SOIL = create("underground_plant_soil");

        public static final TagKey<Block> SNIFFER_HAS_ASPEN_PLANTS = create("sniffer_diggable/has_aspen_plants");
        public static final TagKey<Block> SNIFFER_HAS_TEARDROP_GRASS = create("sniffer_diggable/has_teardrop_grass");
        public static final TagKey<Block> SNIFFER_HAS_LUSH_PLANTS = create("sniffer_diggable/has_lush_plants");
        public static final TagKey<Block> SNIFFER_HAS_NYLIUM_PLANTS = create("sniffer_diggable/has_nylium_plants");

        private static TagKey<Block> create(String name){
            return TagKey.create(Registries.BLOCK, Artistry.location(name));
        }
    }
    public static class EntityTypes{
        public static final TagKey<EntityType<?>> NOT_SCARED_OF_CORPSE_FLOWER = create("not_scared_of_corpse_flower");

        private static TagKey<EntityType<?>> create(String name){
            return TagKey.create(Registries.ENTITY_TYPE, Artistry.location(name));
        }
    }
    public static class Items{
        public static final TagKey<Item> ASPEN_LOGS = create("aspen_logs");
        public static final TagKey<Item> ROTTEN_LOGS = create("rotten_logs");
        public static final TagKey<Item> CAN_APPLY_MOSS = create("can_apply_moss");
        public static final TagKey<Item> WOODEN_TABLES = create("wooden_tables");
        public static final TagKey<Item> TABLES = create("tables");
        public static final TagKey<Item> FROSTED_GLASS = create("frosted_glass");
        public static final TagKey<Item> TALL_CANDLES = create("tall_candles");

        private static TagKey<Item> create(String name){
            return TagKey.create(Registries.ITEM, Artistry.location(name));
        }
    }
}
