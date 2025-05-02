package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ArtistryItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Artistry.MOD_ID);

    public static final DeferredItem<SignItem> ASPEN_SIGN = ITEMS.register("aspen_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ArtistryBlocks.ASPEN_SIGN.get(), ArtistryBlocks.ASPEN_WALL_SIGN.get()));
    public static final DeferredItem<HangingSignItem> ASPEN_HANGING_SIGN = ITEMS.register("aspen_hanging_sign",
            () -> new HangingSignItem(ArtistryBlocks.ASPEN_HANGING_SIGN.get(), ArtistryBlocks.ASPEN_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
