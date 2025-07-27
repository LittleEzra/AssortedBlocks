package com.feliscape.artistry.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class FountainParticle extends DripParticle {
    protected FountainParticle(ClientLevel level, double x, double y, double z, Fluid type) {
        super(level, x, y, z, type);
    }

    public static TextureSheetParticle createWaterFountainParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        DripParticle dripparticle = new FallAndLandParticle(level, x, y, z, Fluids.WATER, ParticleTypes.FALLING_WATER);
        dripparticle.setColor(0.2F, 0.3F, 1.0F);
        dripparticle.setParticleSpeed(xSpeed, ySpeed, zSpeed);
        return dripparticle;
    }

    @OnlyIn(Dist.CLIENT)
    static class FallingParticle extends DripParticle {
        FallingParticle(ClientLevel level, double x, double y, double z, Fluid type) {
            this(level, x, y, z, type, (int)((double)64.0F / (Math.random() * 0.8 + 0.2)));
        }

        FallingParticle(ClientLevel level, double x, double y, double z, Fluid type, int lifetime) {
            super(level, x, y, z, type);
            this.lifetime = lifetime;
        }

        protected void postMoveUpdate() {
            if (this.onGround) {
                this.remove();
            }

        }
    }

    @OnlyIn(Dist.CLIENT)
    static class FallAndLandParticle extends FallingParticle {
        protected final ParticleOptions landParticle;

        FallAndLandParticle(ClientLevel level, double x, double y, double z, Fluid type, ParticleOptions landParticle) {
            super(level, x, y, z, type);
            this.landParticle = landParticle;
        }

        protected void postMoveUpdate() {
            if (this.onGround) {
                this.remove();
                this.level.addParticle(this.landParticle, this.x, this.y, this.z, (double)0.0F, (double)0.0F, (double)0.0F);
            }
        }
    }
}
