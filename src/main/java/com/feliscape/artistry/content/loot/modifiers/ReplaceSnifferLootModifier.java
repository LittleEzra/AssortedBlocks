package com.feliscape.artistry.content.loot.modifiers;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.registry.ArtistryDataMapTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class ReplaceSnifferLootModifier extends LootModifier {
    public static final MapCodec<ReplaceSnifferLootModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> LootModifier.codecStart(instance).apply(instance, ReplaceSnifferLootModifier::new));

    public ReplaceSnifferLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        /*context.getResolver().get(Registries.LOOT_TABLE, this.table).ifPresent((extraTable) -> {
            var entity = context.getParam(LootContextParams.THIS_ENTITY);

            LootTable table = (LootTable)extraTable.value();
            ServerLevel serverLevel = context.getLevel();
            Objects.requireNonNull(generatedLoot);
            List<ItemStack> items = new ArrayList<>();
            table.getRandomItems(context, LootTable.createStackSplitter(serverLevel, items::add));
            if (!items.isEmpty()){
                generatedLoot.clear();
                generatedLoot.addAll(items);
            }
        });*/
        if (!context.hasParam(LootContextParams.THIS_ENTITY)) {
            return generatedLoot;
        }

        var entity = context.getParam(LootContextParams.THIS_ENTITY);
        BlockState state = entity.getBlockStateOn();

        @SuppressWarnings("deprecation") var data = state.getBlock().builtInRegistryHolder().getData(ArtistryDataMapTypes.SNIFFER_PLANTS);
        if (data == null) {
            return generatedLoot;
        }

        float chance = ((float) data.size() / ((float) data.size() + 2.0F));
        if (context.getRandom().nextFloat() <= chance){
            var item = data.get(context.getRandom().nextInt(data.size()));
            generatedLoot.clear();
            generatedLoot.add(item.getDefaultInstance());
        }

        return generatedLoot;
    }

    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
