package com.feliscape.artistry.content.block.plant;

import com.feliscape.artistry.content.block.properties.TriplePlantPart;
import com.feliscape.artistry.registry.ArtistryParticles;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class CorpseFlowerBlock extends TriplePlantBlock {
    public static final MapCodec<CorpseFlowerBlock> CODEC = simpleCodec(CorpseFlowerBlock::new);
    protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.NYLIUM) || state.is(Blocks.SOUL_SOIL) || state.is(Blocks.NETHERRACK) || super.mayPlaceOn(state, level, pos);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) {
            ParticleOptions particle = ArtistryParticles.FLY.get();

            if (level.dimension() == Level.NETHER) {
                particle = ArtistryParticles.NETHER_FLY.get();
            }

            level.addParticle(particle,
                    pos.getX() + (0.1875D + random.nextDouble() * 0.625D),
                    pos.getY() + random.nextDouble(),
                    pos.getZ() + (0.1875D + random.nextDouble() * 0.625D),
                    0.0D, 0.0D, 0.0D
            );
        }
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends TriplePlantBlock> codec() {
        return CODEC;
    }

    public CorpseFlowerBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("item.artistry.wip").withStyle(ChatFormatting.GRAY));
    }
}
