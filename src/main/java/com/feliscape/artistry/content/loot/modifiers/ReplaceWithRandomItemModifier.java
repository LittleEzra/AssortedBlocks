package com.feliscape.artistry.content.loot.modifiers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ReplaceWithRandomItemModifier extends LootModifier {
    public static final MapCodec<ReplaceWithRandomItemModifier> CODEC = RecordCodecBuilder.mapCodec(instance ->
            LootModifier.codecStart(instance).and(
                    BuiltInRegistries.ITEM.byNameCodec().listOf().fieldOf("items").forGetter(modifier -> modifier.items)
            ).apply(instance, ReplaceWithRandomItemModifier::new));

    private final List<Item> items;

    public ReplaceWithRandomItemModifier(LootItemCondition[] conditionsIn, List<Item> items) {
        super(conditionsIn);
        this.items = items;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {

        return ObjectArrayList.of(new ItemStack(this.items.get(lootContext.getRandom().nextInt(this.items.size()))));
    }

    @Override
    public @NotNull MapCodec<ReplaceWithRandomItemModifier> codec() {
        return CODEC;
    }
}
