package com.feliscape.artistry.content.block.entity;

import com.feliscape.artistry.content.block.SparkFountainBlock;
import com.feliscape.artistry.content.block.WaterFountainBlock;
import com.feliscape.artistry.registry.ArtistryBlockEntityTypes;
import com.feliscape.artistry.registry.ArtistryParticles;
import com.feliscape.artistry.util.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WaterFountainBlockEntity extends BlockEntity {
    public WaterFountainBlockEntity(BlockPos pos, BlockState blockState) {
        super(ArtistryBlockEntityTypes.WATER_FOUNTAIN.get(), pos, blockState);
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, WaterFountainBlockEntity fountain) {
        boolean powered = state.getValue(WaterFountainBlock.POWERED);
        int height = state.getValue(WaterFountainBlock.HEIGHT);
        BlockPos abovePosition = pos.above();
        BlockState above = level.getBlockState(abovePosition);
        if (!powered) {
            RandomSource random = level.getRandom();
            double y = pos.getY() + (above.isCollisionShapeFullBlock(level, abovePosition) ? 2.0D : 1.0D);
            for (int i = 0; i < 2; i++){
                double x = pos.getX() + 0.4375 + random.nextDouble() * 0.125;
                double z = pos.getZ() + 0.4375 + random.nextDouble() * 0.125;

                double theta = random.nextDouble() * Math.TAU;
                double xSpeed = Math.cos(theta) * 0.1D * RandomUtil.centeredDouble(random);
                double ySpeed = random.nextDouble() * 0.4D + (0.2D + 0.2D * height);
                double zSpeed = Math.sin(theta) * 0.1D * RandomUtil.centeredDouble(random);


                level.addParticle(ArtistryParticles.WATER_FOUNTAIN.get(),
                        x, y, z,
                        xSpeed, ySpeed, zSpeed);
            }
        }
    }
}
