package com.feliscape.artistry.content.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Map;

public class AmethystStarsBlock extends MultifaceBlock {
    private static final MapCodec<AmethystStarsBlock> CODEC = simpleCodec(AmethystStarsBlock::new);
    private final MultifaceSpreader spreader = new EmptyMultifaceSpreader();

    public AmethystStarsBlock(Properties properties) {
        super(properties);
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
