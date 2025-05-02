package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.entity.ModBoat;
import com.feliscape.artistry.content.entity.ModChestBoat;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ArtistryEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, Artistry.MOD_ID);

    /* Registering an Entity:
    public static final RegistryObject<EntityType<ENTITY>> ENTITY_NAME = ENTITY_TYPES.register("ENTITY",
            () -> EntityType.Builder.of(ENTITY::new, MobCategory.AMBIENT).sized(1.0f, 1.0f)
                    .build(new ResourceLocation(Template.MOD_ID, "ENTITY").toString()));
                    */

    public static final Supplier<EntityType<ModBoat>> MOD_BOAT = ENTITY_TYPES.register("mod_boat",
            () -> EntityType.Builder.<ModBoat>of(ModBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f)
                    .build(Artistry.stringLocation("mod_boat")));
    public static final Supplier<EntityType<ModChestBoat>> MOD_CHEST_BOAT = ENTITY_TYPES.register("mod_chest_boat",
            () -> EntityType.Builder.<ModChestBoat>of(ModChestBoat::new, MobCategory.MISC).sized(1.375f, 0.5625f)
                    .build(Artistry.stringLocation("mod_chest_boat")));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
