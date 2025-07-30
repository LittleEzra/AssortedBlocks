package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.pot.PaintedPotDecorations;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ArtistryDataComponents {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Artistry.MOD_ID);

    public static Supplier<DataComponentType<PaintedPotDecorations>> PAINTED_POT_DECORATIONS = DATA_COMPONENTS.registerComponentType(
            "painted_pot_decorations", b -> b
                    .persistent(PaintedPotDecorations.CODEC)
                    .networkSynchronized(PaintedPotDecorations.STREAM_CODEC)
                    .cacheEncoding()
    );

    public static void register(IEventBus eventBus){
        DATA_COMPONENTS.register(eventBus);
    }
}
