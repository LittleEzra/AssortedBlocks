package com.feliscape.artistry.content.loot.modifiers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.Objects;

public class ReplaceWithTableLootModifier extends LootModifier {
    public static final MapCodec<ReplaceWithTableLootModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> LootModifier.codecStart(instance).and(
            ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("table").forGetter(ReplaceWithTableLootModifier::table)).apply(instance, ReplaceWithTableLootModifier::new));

    private final ResourceKey<LootTable> table;

    public ReplaceWithTableLootModifier(LootItemCondition[] conditionsIn, ResourceKey<LootTable> table) {
        super(conditionsIn);
        this.table = table;
    }

    public ResourceKey<LootTable> table() {
        return this.table;
    }

    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        context.getResolver().get(Registries.LOOT_TABLE, this.table).ifPresent((extraTable) -> {
            LootTable table = (LootTable)extraTable.value();
            ServerLevel serverLevel = context.getLevel();
            Objects.requireNonNull(generatedLoot);
            generatedLoot.clear();
            table.getRandomItems(context, LootTable.createStackSplitter(serverLevel, generatedLoot::add));
        });
        return generatedLoot;
    }

    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
