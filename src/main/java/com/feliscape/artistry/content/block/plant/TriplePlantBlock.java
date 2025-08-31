package com.feliscape.artistry.content.block.plant;

import com.feliscape.artistry.content.block.properties.TriplePlantPart;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;

public class TriplePlantBlock extends BushBlock {
    public static final MapCodec<TriplePlantBlock> CODEC = simpleCodec(TriplePlantBlock::new);
    public static final EnumProperty<TriplePlantPart> PART = EnumProperty.create("part", TriplePlantPart.class);

    @Override
    protected MapCodec<? extends TriplePlantBlock> codec() {
        return CODEC;
    }

    protected TriplePlantBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, TriplePlantPart.BASE));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        return blockpos.getY() < level.getMaxBuildHeight() - 2 &&
                level.getBlockState(blockpos.above()).canBeReplaced(context) &&
                level.getBlockState(blockpos.above(2)).canBeReplaced(context)
                ? super.getStateForPlacement(context)
                : null;
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        TriplePlantPart part = state.getValue(PART);
        if (facing.getAxis() != Direction.Axis.Y
                || part == TriplePlantPart.TIP == (part.getOtherDirections().contains(facing))
                || facingState.is(this) && facingState.getValue(PART) != part) {
            return part == TriplePlantPart.BASE && facing == Direction.DOWN && !state.canSurvive(level, currentPos)
                    ? Blocks.AIR.defaultBlockState()
                    : super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(PART) == TriplePlantPart.BASE) {
            return super.canSurvive(state, level, pos);
        } else {
            BlockState blockstate = level.getBlockState(pos.below());
            if (state.getBlock() != this) return super.canSurvive(state, level, pos);
            return blockstate.is(this) && blockstate.getValue(PART).isBelow(state.getValue(PART));
        }
    }

    public static void placeAt(LevelAccessor level, BlockState state, BlockPos pos, int flags) {
        BlockPos above = pos.above();
        BlockPos above2 = pos.above(2);
        level.setBlock(pos, copyWaterloggedFrom(level, pos, state.setValue(PART, TriplePlantPart.BASE)), flags);
        level.setBlock(above, copyWaterloggedFrom(level, above, state.setValue(PART, TriplePlantPart.MIDDLE)), flags);
        level.setBlock(above2, copyWaterloggedFrom(level, above2, state.setValue(PART, TriplePlantPart.TIP)), flags);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        BlockPos above = pos.above();
        BlockPos above2 = pos.above(2);
        level.setBlock(above, copyWaterloggedFrom(level, above, this.defaultBlockState().setValue(PART, TriplePlantPart.MIDDLE)), 3);
        level.setBlock(above2, copyWaterloggedFrom(level, above2, this.defaultBlockState().setValue(PART, TriplePlantPart.TIP)), 3);
    }
    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                preventDropsFromBase(level, pos, state, player);
            } else {
                dropResources(state, level, pos, null, player, player.getMainHandItem());
            }
        }

        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity te, ItemStack stack) {
        super.playerDestroy(level, player, pos, Blocks.AIR.defaultBlockState(), te, stack);
    }

    protected static void preventDropsFromBase(Level level, BlockPos pos, BlockState state, Player player) {
        TriplePlantPart part = state.getValue(PART);
        if (part == TriplePlantPart.BASE) return;


        BlockPos basePos = pos.below(part.distanceToBase());
        BlockState baseState = level.getBlockState(basePos);
        if (baseState.is(state.getBlock()) && baseState.getValue(PART) == TriplePlantPart.BASE) {
            BlockState emptyState = baseState.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
            level.setBlock(basePos, emptyState, 0b100011);
            level.levelEvent(player, 2001, basePos, Block.getId(baseState));
        }
    }

    public static BlockState copyWaterloggedFrom(LevelReader level, BlockPos pos, BlockState state) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED)
                ? state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(level.isWaterAt(pos)))
                : state;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART);
    }

    @Override
    protected long getSeed(BlockState state, BlockPos pos) {
        return Mth.getSeed(pos.getX(), pos.below(state.getValue(PART).distanceToBase()).getY(), pos.getZ());
    }
}
