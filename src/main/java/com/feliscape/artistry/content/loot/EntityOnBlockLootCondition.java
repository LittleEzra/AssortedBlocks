package com.feliscape.artistry.content.loot;

import com.feliscape.artistry.registry.ArtistryLootConditions;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public record EntityOnBlockLootCondition(BlockPredicate block) implements LootItemCondition {
    public static final MapCodec<EntityOnBlockLootCondition> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            BlockPredicate.CODEC.fieldOf("block").forGetter(EntityOnBlockLootCondition::block)
    ).apply(inst, EntityOnBlockLootCondition::new));

    public static LootItemCondition.Builder onBlock(TagKey<Block> tag){
        return () -> new EntityOnBlockLootCondition(BlockPredicate.Builder.block().of(tag).build());
    }
    public static LootItemCondition.Builder onBlock(Block... blocks){
        return () -> new EntityOnBlockLootCondition(BlockPredicate.Builder.block().of(blocks).build());
    }

    @Override
    public boolean test(LootContext lootContext) {
        if (lootContext.hasParam(LootContextParams.THIS_ENTITY)){
            Entity entity = lootContext.getParam(LootContextParams.THIS_ENTITY);
            return block.matches(lootContext.getLevel(), entity.getOnPos());
        }
        return false;
    }

    @Override
    public LootItemConditionType getType() {
        return ArtistryLootConditions.ENTITY_ON_BLOCK.get();
    }
}
