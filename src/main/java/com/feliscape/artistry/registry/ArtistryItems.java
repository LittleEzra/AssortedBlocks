package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.entity.SparkFountainBlockEntity;
import com.feliscape.artistry.content.entity.ModBoat;
import com.feliscape.artistry.content.item.ModBoatItem;
import com.feliscape.artistry.content.pot.PaintedPotDecorations;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ArtistryItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Artistry.MOD_ID);

    public static final DeferredItem<BlockItem> PAINTED_POT = ITEMS.registerItem("painted_pot",
            p -> new BlockItem(ArtistryBlocks.PAINTED_POT.get(), p
                    .component(PaintedPotDecorations.type(), PaintedPotDecorations.EMPTY)));

    public static final DeferredItem<ItemNameBlockItem> SUNBURST_VINES = ITEMS.registerItem("sunburst_vines",
            p -> new ItemNameBlockItem(ArtistryBlocks.SUNBURST_VINES.get(), p));
    public static final DeferredItem<ItemNameBlockItem> SUNSPROUT = ITEMS.registerItem("sunsprout",
            p -> new ItemNameBlockItem(ArtistryBlocks.SUNSPROUT.get(), p));
    public static final DeferredItem<ItemNameBlockItem> FERN_SEED = ITEMS.registerItem("fern_seed",
            p -> new ItemNameBlockItem(ArtistryBlocks.LUSH_FERN_CROP.get(), p));

    public static final DeferredItem<StandingAndWallBlockItem> STRING_LIGHTS = ITEMS.registerItem("string_lights",
            p -> new StandingAndWallBlockItem(ArtistryBlocks.STRING_LIGHTS.get(), ArtistryBlocks.WALL_STRING_LIGHTS.get(), p.stacksTo(16), Direction.UP));

    public static final DeferredItem<BlockItem> SPARK_FOUNTAIN = ITEMS.registerItem("spark_fountain",
            p -> new BlockItem(ArtistryBlocks.SPARK_FOUNTAIN.get(), p.component(DataComponents.DYED_COLOR, new DyedItemColor(SparkFountainBlockEntity.DEFAULT_SPARK_COLOR_RGB, true))));

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
