package com.feliscape.artistry.content.block;

import com.feliscape.artistry.registry.ArtistryItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Map;
import java.util.function.Supplier;

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
