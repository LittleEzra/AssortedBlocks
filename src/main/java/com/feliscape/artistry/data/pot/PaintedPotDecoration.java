package com.feliscape.artistry.data.pot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

public record PaintedPotDecoration(ResourceLocation texture) {
    public static final Codec<PaintedPotDecoration> DIRECT_CODEC = RecordCodecBuilder.create(inst -> inst.group(
            ResourceLocation.CODEC.fieldOf("texture").forGetter(PaintedPotDecoration::texture)
    ).apply(inst, PaintedPotDecoration::new));
}
