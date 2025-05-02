package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.entity.ModBoat;
import com.feliscape.artistry.content.item.ModBoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ArtistryItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Artistry.MOD_ID);

    public static final DeferredItem<SignItem> ASPEN_SIGN = ITEMS.registerItem("aspen_sign",
            p -> new SignItem(p.stacksTo(16), ArtistryBlocks.ASPEN_SIGN.get(), ArtistryBlocks.ASPEN_WALL_SIGN.get()));
    public static final DeferredItem<HangingSignItem> ASPEN_HANGING_SIGN = ITEMS.registerItem("aspen_hanging_sign",
            p -> new HangingSignItem(ArtistryBlocks.ASPEN_HANGING_SIGN.get(), ArtistryBlocks.ASPEN_WALL_HANGING_SIGN.get(), p.stacksTo(16)));

    public static final DeferredItem<ModBoatItem> ASPEN_BOAT = ITEMS.registerItem("aspen_boat",
            p -> new ModBoatItem(false, ModBoat.Type.ASPEN, new Item.Properties().stacksTo(1)));
    public static final DeferredItem<ModBoatItem> ASPEN_CHEST_BOAT = ITEMS.register("aspen_chest_boat",
            p -> new ModBoatItem(true, ModBoat.Type.ASPEN, new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
