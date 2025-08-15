package com.feliscape.artistry.content.block.plant;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class BloomingVinesBlock extends MultifaceBlock implements BonemealableBlock {
    public static final MapCodec<BloomingVinesBlock> CODEC = simpleCodec(BloomingVinesBlock::new);
    private final MultifaceSpreader spreader = new MultifaceSpreader(this);

    public BloomingVinesBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.getItemInHand().is(ArtistryBlocks.BLOOMING_VINES.asItem()) || super.canBeReplaced(state, useContext);
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 15;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 100;
    }

    /*@Override
    protected boolean isFaceSupported(Direction face) {
        return face.getAxis().isHorizontal();
    }*/

    @Override
    protected MapCodec<? extends MultifaceBlock> codec() {
        return CODEC;
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return this.spreader;
    }


    @Override
    protected boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return Direction.stream().anyMatch(face -> this.spreader.canSpreadInAnyDirection(blockState, levelReader, blockPos, face.getOpposite()));
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        this.spreader.spreadFromRandomFaceTowardRandomDirection(blockState, serverLevel, blockPos, randomSource);
    }
}
