package com.feliscape.artistry.content.block.plant;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.networking.ArtistryLevelEventPayload;
import com.feliscape.artistry.networking.ArtistryLevelEvents;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpiralFungusBlock extends Block {

    protected static final VoxelShape SHAPE = Shapes.or(
            Block.box(6.0, 0.0, 6.0, 10.0, 4.0, 10.0),
            Block.box(2.0, 4.0, 2.0, 14.0, 8.0, 14.0));

    public SpiralFungusBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.isSuppressingBounce()) {
            super.fallOn(level, state, pos, entity, fallDistance);
        } else {
            entity.causeFallDamage(fallDistance, 0.0F, level.damageSources().fall());
        }
    }
    /*@Override
    public void updateEntityAfterFallOn(BlockGetter level, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(level, entity);
        } else {
            this.bounceUp(entity, 1.0D, entity.getBlockPosBelowThatAffectsMyMovement());
        }
    }*/

    private void bounceUp(Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.y < 0.0) {
            double d0 = entity instanceof LivingEntity ? 1.0 : 0.8;
            entity.setDeltaMovement(vec3.x, -vec3.y * d0, vec3.z);
        }
    }
    private void bounceUp(Entity entity, double minVelocity, BlockPos pos) {
        Vec3 vec3 = entity.getDeltaMovement();
        double cor = entity instanceof LivingEntity ? 1.0 : 0.8;
        entity.setDeltaMovement(vec3.x, Math.max(-vec3.y * cor, minVelocity), vec3.z);
        if (entity.level().isClientSide()){
            makeBounceParticles(pos, entity.level());
        }
    }

    private void makeBounceParticles(BlockPos pos, Level level){
        RandomSource random = level.getRandom();
        int particleCount = random.nextInt(4) + 6;
        for (int i = 0; i < particleCount; i++){
            double theta = random.nextDouble() * Math.TAU;
            double xVelocity = Math.cos(theta) * (random.nextDouble() * 0.2D + 0.05D);
            double yVelocity = random.nextDouble() * 0.2D + 0.1D;
            double zVelocity = Math.sin(theta) * (random.nextDouble() * 0.2D + 0.05D);

            level.addParticle(ParticleTypes.CLOUD, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
                    xVelocity, yVelocity, zVelocity);
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity.getType() == EntityType.EXPERIENCE_ORB) return;

        double d0 = Math.abs(entity.getDeltaMovement().y);
        if (d0 < 0.1 && !entity.isSteppingCarefully()) {
            bounceUp(entity, 1.0D, pos);
        }

        super.stepOn(level, pos, state, entity);
    }
}
