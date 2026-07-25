package com.feliscape.artistry.content.block.plant;

import com.feliscape.artistry.registry.ArtistryBlocks;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class ThornHuskBlock extends MultifaceBlock implements BonemealableBlock {
    public static final MapCodec<ThornHuskBlock> CODEC = simpleCodec(ThornHuskBlock::new);
    private final MultifaceSpreader spreader = new MultifaceSpreader(this);

    private static final VoxelShape UP_AABB = Block.box(0.0F, 8.0F, 0.0F, 16.0F, 16.0F, 16.0F);
    private static final VoxelShape DOWN_AABB = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 8.0F, 16.0F);
    private static final VoxelShape WEST_AABB = Block.box(0.0F, 0.0F, 0.0F, 8.0F, 16.0F, 16.0F);
    private static final VoxelShape EAST_AABB = Block.box(8.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F);
    private static final VoxelShape NORTH_AABB = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 8.0F);
    private static final VoxelShape SOUTH_AABB = Block.box(0.0F, 0.0F, 8.0F, 16.0F, 16.0F, 16.0F);
    private static final Map<Direction, VoxelShape> SHAPE_BY_DIRECTION = Util.make(Maps.newEnumMap(Direction.class), p_153923_ -> {
        p_153923_.put(Direction.NORTH, NORTH_AABB);
        p_153923_.put(Direction.EAST, EAST_AABB);
        p_153923_.put(Direction.SOUTH, SOUTH_AABB);
        p_153923_.put(Direction.WEST, WEST_AABB);
        p_153923_.put(Direction.UP, UP_AABB);
        p_153923_.put(Direction.DOWN, DOWN_AABB);
    });
    private final ImmutableMap<BlockState, VoxelShape> shapesCache;

    public ThornHuskBlock(Properties properties) {
        super(properties);
        this.shapesCache = this.getShapeForEachState(ThornHuskBlock::calculateMultifaceShape);
    }

    private static VoxelShape calculateMultifaceShape(BlockState state) {
        VoxelShape voxelshape = Shapes.empty();

        for(Direction direction : DIRECTIONS) {
            if (hasFace(state, direction)) {
                voxelshape = Shapes.or(voxelshape, SHAPE_BY_DIRECTION.get(direction));
            }
        }

        return voxelshape.isEmpty() ? Shapes.block() : voxelshape;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            if (!level.isClientSide()) {
                entity.hurt(level.damageSources().sweetBerryBush(), 1.0F);
            }
        }
    }

    @Override
    protected @Nullable VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.shapesCache.get(state);
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.getItemInHand().is(ArtistryBlocks.THORN_HUSK.asItem()) || super.canBeReplaced(state, useContext);
    }

    @Override
    protected MapCodec<? extends ThornHuskBlock> codec() {
        return CODEC;
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return spreader;
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
