package com.feliscape.artistry.content.block.entity;

import com.feliscape.artistry.content.block.SparkFountainBlock;
import com.feliscape.artistry.registry.ArtistryBlockEntityTypes;
import com.feliscape.artistry.registry.ArtistryParticles;
import com.feliscape.artistry.util.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SparkFountainBlockEntity extends BlockEntity {
    public SparkFountainBlockEntity(BlockPos pos, BlockState blockState) {
        super(ArtistryBlockEntityTypes.SPARK_FOUNTAIN.get(), pos, blockState);
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, SparkFountainBlockEntity fountain) {
        boolean powered = state.getValue(SparkFountainBlock.POWERED);
        if (powered) {
            RandomSource random = level.getRandom();
            for (int i = 0; i < 2; i++){
                double x = pos.getX() + 0.4375 + random.nextDouble() * 0.125;
                double z = pos.getZ() + 0.4375 + random.nextDouble() * 0.125;

                double theta = random.nextDouble() * Math.TAU;
                double xSpeed = Math.cos(theta) * 0.3D * RandomUtil.centeredDouble(random);
                double ySpeed = random.nextDouble() * 0.7D + 2.0D;
                double zSpeed = Math.sin(theta) * 0.3D * RandomUtil.centeredDouble(random);

                level.addParticle(ColorParticleOption.create(ArtistryParticles.SPARK.get(), 0xffffe68a),
                        x, pos.getY() + 1, z,
                        xSpeed, ySpeed, zSpeed);
            }
        }
    }
}
