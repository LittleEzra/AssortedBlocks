package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.content.block.entity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ArtistryBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Artistry.MOD_ID);

    public static final Supplier<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () -> BlockEntityType.Builder.of(ModSignBlockEntity::new,
                    ArtistryBlocks.ASPEN_SIGN.get(), ArtistryBlocks.ASPEN_WALL_SIGN.get(),
                    ArtistryBlocks.ROTTEN_SIGN.get(), ArtistryBlocks.ROTTEN_WALL_SIGN.get()
            ).build(null));
    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                    ArtistryBlocks.ASPEN_HANGING_SIGN.get(), ArtistryBlocks.ASPEN_WALL_HANGING_SIGN.get(),
                    ArtistryBlocks.ROTTEN_HANGING_SIGN.get(), ArtistryBlocks.ROTTEN_WALL_HANGING_SIGN.get()
            ).build(null));
    public static final Supplier<BlockEntityType<SparkFountainBlockEntity>> SPARK_FOUNTAIN =
            BLOCK_ENTITIES.register("spark_fountain", () -> BlockEntityType.Builder.of(SparkFountainBlockEntity::new,
                    ArtistryBlocks.SPARK_FOUNTAIN.get()).build(null));
    public static final Supplier<BlockEntityType<WaterFountainBlockEntity>> WATER_FOUNTAIN =
            BLOCK_ENTITIES.register("water_fountain", () -> BlockEntityType.Builder.of(WaterFountainBlockEntity::new,
                    ArtistryBlocks.WATER_FOUNTAIN.get()).build(null));
    public static final Supplier<BlockEntityType<PaintedPotBlockEntity>> PAINTED_POT =
            BLOCK_ENTITIES.register("painted_pot", () -> BlockEntityType.Builder.of(PaintedPotBlockEntity::new,
                    ArtistryBlocks.PAINTED_POT.get()).build(null));
    public static final Supplier<BlockEntityType<UrnBlockEntity>> URN =
            BLOCK_ENTITIES.register("urn", () -> BlockEntityType.Builder.of(UrnBlockEntity::new,
                    ArtistryBlocks.URN.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
