package com.feliscape.artistry.content.pot;

import com.feliscape.artistry.content.block.entity.PaintedPotBlockEntity;
import com.feliscape.artistry.data.pot.PaintedPotDecoration;
import com.feliscape.artistry.data.registry.ArtistryDatapackRegistries;
import com.feliscape.artistry.registry.ArtistryDataComponents;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.PotDecorations;

import javax.annotation.Nullable;
import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

public record PaintedPotDecorations(Optional<DyeColor> base, Optional<ResourceKey<PaintedPotDecoration>> trim, int trimColor, Optional<ResourceKey<PaintedPotDecoration>> pattern, int patternColor) {
    public static final PaintedPotDecorations EMPTY = new PaintedPotDecorations(Optional.empty(), Optional.empty(), -1, Optional.empty(), -1);


    public static final Codec<PaintedPotDecorations> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            DyeColor.CODEC.optionalFieldOf("base").forGetter(PaintedPotDecorations::base),
            ResourceKey.codec(ArtistryDatapackRegistries.PAINTED_POT_TRIM).optionalFieldOf("trim").forGetter(PaintedPotDecorations::trim),
            Codec.INT.fieldOf("trim_color").forGetter(PaintedPotDecorations::trimColor),
            ResourceKey.codec(ArtistryDatapackRegistries.PAINTED_POT_PATTERN).optionalFieldOf("pattern").forGetter(PaintedPotDecorations::pattern),
            Codec.INT.fieldOf("pattern_color").forGetter(PaintedPotDecorations::patternColor)

            ).apply(inst, PaintedPotDecorations::new)
    );

    private static final StreamCodec<ByteBuf, ResourceKey<PaintedPotDecoration>> TRIM_CODEC =
            ResourceKey.streamCodec(ArtistryDatapackRegistries.PAINTED_POT_TRIM);
    private static final StreamCodec<ByteBuf, ResourceKey<PaintedPotDecoration>> PATTERN_CODEC =
            ResourceKey.streamCodec(ArtistryDatapackRegistries.PAINTED_POT_PATTERN);

    public static final StreamCodec<RegistryFriendlyByteBuf, PaintedPotDecorations> STREAM_CODEC =
            StreamCodec.of(PaintedPotDecorations::encode, PaintedPotDecorations::decode);

    public static void encode(RegistryFriendlyByteBuf byteBuf, PaintedPotDecorations decorations){
        byteBuf.writeBoolean(decorations.base.isPresent());
        if (decorations.base.isPresent()){
            DyeColor.STREAM_CODEC.encode(byteBuf, decorations.base.get());
        }
        byteBuf.writeBoolean(decorations.trim.isPresent());
        if (decorations.trim.isPresent()){
            TRIM_CODEC.encode(byteBuf, decorations.trim.get());
        }
        byteBuf.writeInt(decorations.trimColor);
        byteBuf.writeBoolean(decorations.pattern.isPresent());
        if (decorations.pattern.isPresent()){
            PATTERN_CODEC.encode(byteBuf, decorations.pattern.get());
        }
        byteBuf.writeInt(decorations.patternColor);
    }
    public static PaintedPotDecorations decode(RegistryFriendlyByteBuf byteBuf){
        Optional<DyeColor> base = Optional.empty();
        Optional<ResourceKey<PaintedPotDecoration>> trim = Optional.empty();
        Optional<ResourceKey<PaintedPotDecoration>> pattern = Optional.empty();
        int trimColor;
        int patternColor;

        if (byteBuf.readBoolean()) {
            base = Optional.of(DyeColor.STREAM_CODEC.decode(byteBuf));
        }
        if (byteBuf.readBoolean()){
            trim = Optional.of(TRIM_CODEC.decode(byteBuf));
        }
        trimColor = byteBuf.readInt();

        if (byteBuf.readBoolean()){
            pattern = Optional.of(PATTERN_CODEC.decode(byteBuf));
        }
        patternColor = byteBuf.readInt();
        return new PaintedPotDecorations(base, trim, trimColor, pattern, patternColor);
    }


    public CompoundTag save(CompoundTag tag) {
        if (this == EMPTY) {
            return tag;
        } else {
            tag.put("layers", (Tag)CODEC.encodeStart(NbtOps.INSTANCE, this).getOrThrow());
            return tag;
        }
    }
    public static PaintedPotDecorations load(@Nullable CompoundTag tag) {
        return tag != null && tag.contains("layers") ? (PaintedPotDecorations)CODEC.parse(NbtOps.INSTANCE, tag.get("layers")).result().orElse(EMPTY) : EMPTY;
    }

    public static DataComponentType<PaintedPotDecorations> type(){
        return ArtistryDataComponents.PAINTED_POT_DECORATIONS.get();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else {
            return other instanceof PaintedPotDecorations potDecorations &&
                    base.equals(potDecorations.base) &&
                    trim.equals(potDecorations.trim) &&
                    pattern.equals(potDecorations.pattern) &&
                    potDecorations.trimColor == trimColor &&
                    potDecorations.patternColor == patternColor;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, trim, trimColor, pattern, patternColor);
    }
}
