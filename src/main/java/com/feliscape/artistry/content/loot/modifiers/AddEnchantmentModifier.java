package com.feliscape.artistry.content.loot.modifiers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class AddEnchantmentModifier extends LootModifier {
    public static final MapCodec<AddEnchantmentModifier> CODEC = RecordCodecBuilder.mapCodec(instance ->
            LootModifier.codecStart(instance).and(instance.group(
                ResourceKey.codec(Registries.ENCHANTMENT).fieldOf("enchantment_key").forGetter(e -> e.enchantmentKey),
                Codec.INT.fieldOf("min_level").forGetter(e -> e.minLevel),
                Codec.INT.fieldOf("max_level").forGetter(e -> e.maxLevel)
            )).apply(instance, AddEnchantmentModifier::new)
    );

    private final ResourceKey<Enchantment> enchantmentKey;
    private final int minLevel;
    private final int maxLevel;

    public AddEnchantmentModifier(LootItemCondition[] conditionsIn, ResourceKey<Enchantment> enchantmentKey, int minLevel, int maxLevel) {
        super(conditionsIn);
        this.enchantmentKey = enchantmentKey;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {
        Holder<Enchantment> enchantment = lootContext.getResolver().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(enchantmentKey);
        generatedLoot.add(EnchantedBookItem.createForEnchantment(
                new EnchantmentInstance(
                        enchantment,
                        lootContext.getRandom().nextInt(minLevel, maxLevel))
        ));

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
