package com.feliscape.artistry.content.block.plant;

import com.feliscape.artistry.data.worldgen.registry.ArtistryConfiguredFeatures;
import com.feliscape.artistry.registry.ArtistryBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.lighting.LightEngine;

import java.util.Optional;

public class TeardropGrassBlock extends Block implements BonemealableBlock {
    public TeardropGrassBlock(Properties properties) {
        super(properties);
    }

    private static boolean canBeGrass(BlockState state, LevelReader reader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = reader.getBlockState(blockpos);
        int light = LightEngine.getLightBlockInto(reader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(reader, blockpos));
        return light < reader.getMaxLightLevel();
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canBeGrass(state, level, pos)) {
            level.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return levelReader.getBlockState(blockPos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {

        Optional<Direction> optionalDirection = Direction.allShuffled(random).stream().filter(d -> {
            BlockPos blockPos = pos.relative(d);
            BlockState blockState = level.getBlockState(blockPos);

            return blockState.is(Blocks.DIRT) && canBeGrass(blockState, level, blockPos);
        }).findFirst();
        if (optionalDirection.isPresent()){
            BlockPos blockPos = pos.relative(optionalDirection.get());
            level.setBlockAndUpdate(blockPos, ArtistryBlocks.TEARDROP_GRASS_BLOCK.get().defaultBlockState());
        } else{
            BlockPos abovePos = pos.above();
            BlockState aboveState = level.getBlockState(abovePos);

            ChunkGenerator chunkgenerator = level.getChunkSource().getGenerator();
            Registry<ConfiguredFeature<?, ?>> registry = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);

            this.place(registry, ArtistryConfiguredFeatures.TEARDROP_GRASS_BONEMEAL, level, chunkgenerator, random, abovePos);
        }
    }

    private void place(
            Registry<ConfiguredFeature<?, ?>> featureRegistry,
            ResourceKey<ConfiguredFeature<?, ?>> featureKey,
            ServerLevel level,
            ChunkGenerator chunkGenerator,
            RandomSource random,
            BlockPos pos
    ) {
        featureRegistry.getHolder(featureKey).ifPresent(p_255920_ -> p_255920_.value().place(level, chunkGenerator, random, pos));
    }

    @Override
    public Type getType() {
        return Type.NEIGHBOR_SPREADER;
    }
}
