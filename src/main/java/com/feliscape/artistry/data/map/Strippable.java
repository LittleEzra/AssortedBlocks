package com.feliscape.artistry.data.map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public record Strippable(Block stripped) {
    public static final Codec<Strippable> STRIPPABLE_CODEC = BuiltInRegistries.BLOCK.byNameCodec()
            .xmap(Strippable::new, Strippable::stripped);
    public static final Codec<Strippable> CODEC = Codec.withAlternative(
            RecordCodecBuilder.create(in -> in.group(
                    BuiltInRegistries.BLOCK.byNameCodec().fieldOf("stripped").forGetter(Strippable::stripped)).apply(in, Strippable::new)),
            STRIPPABLE_CODEC);

    public Strippable(Supplier<? extends Block> stripped){
        this(stripped.get());
    }
}
