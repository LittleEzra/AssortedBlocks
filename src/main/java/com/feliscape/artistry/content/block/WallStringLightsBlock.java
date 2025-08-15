package com.feliscape.artistry.content.block;

import com.feliscape.artistry.content.block.plant.EmptyMultifaceSpreader;
import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Map;

public class WallStringLightsBlock extends MultifaceBlock {
    private static final MapCodec<WallStringLightsBlock> CODEC = simpleCodec(WallStringLightsBlock::new);
    EmptyMultifaceSpreader spreader = new EmptyMultifaceSpreader();

    public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION
            .entrySet()
            .stream()
            .filter(entry -> entry.getKey().getAxis().isHorizontal())
            .collect(Util.toMap());

    public WallStringLightsBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isFaceSupported(Direction face) {
        return face.getAxis().isHorizontal();
    }

    @Override
    protected MapCodec<? extends MultifaceBlock> codec() {
        return CODEC;
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return spreader;
    }
}
