package com.feliscape.artistry.content.block;

import com.google.common.annotations.VisibleForTesting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;
import java.util.Optional;

public class EmptyMultifaceSpreader extends MultifaceSpreader {
    public EmptyMultifaceSpreader() {
        super((SpreadConfig) null);
    }

    public boolean canSpreadInAnyDirection(BlockState state, BlockGetter level, BlockPos pos, Direction spreadDirection) {
        return false;
    }

    public Optional<SpreadPos> spreadFromRandomFaceTowardRandomDirection(BlockState state, LevelAccessor level, BlockPos pos, RandomSource random) {
        return Optional.empty();
    }

    public long spreadAll(BlockState state, LevelAccessor level, BlockPos pos, boolean markForPostprocessing) {
        return 0L;
    }

    @VisibleForTesting
    public Optional<SpreadPos> spreadFromFaceTowardDirection(BlockState state, LevelAccessor level, BlockPos pos, Direction spreadDirection, Direction face, boolean markForPostprocessing) {
        return Optional.empty();
    }

    public Optional<SpreadPos> getSpreadFromFaceTowardDirection(BlockState state, BlockGetter level, BlockPos pos, Direction spreadDirection, Direction face, SpreadPredicate predicate) {
        return Optional.empty();
    }

    public Optional<SpreadPos> spreadToFace(LevelAccessor level, SpreadPos pos, boolean markForPostprocessing) {
        return Optional.empty();
    }
}
