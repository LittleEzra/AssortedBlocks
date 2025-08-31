package com.feliscape.artistry.data.map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

public record Leechable(Block block) {
    public static final Codec<Leechable> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(Leechable::block)
    ).apply(inst, Leechable::new));

    public Leechable(DeferredBlock<?> deferredBlock){
        this(deferredBlock.get());
    }
}
