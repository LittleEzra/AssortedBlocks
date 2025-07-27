package com.feliscape.artistry.client.particle;

import com.feliscape.artistry.util.FloatEasings;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SparkParticle extends TextureSheetParticle {
    private final float rotSpeed;
    private final SpriteSet sprites;
    private final double gravity;

    protected SparkParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, double gravity, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ);
        this.setParticleSpeed(pXSpeed * 0.2D, pYSpeed * 0.2D, pZSpeed * 0.2D);
        this.lifetime = 75 + this.random.nextInt(40);
        this.sprites = pSprites;
        this.rotSpeed = ((float)Math.random() - 0.5F) * 0.1F;
        this.setSpriteFromAge(pSprites);
        //this.alpha = 1.0F;
        this.scale(0.5F);
        this.gravity = gravity;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ < this.lifetime) {
            //float f = FloatEasings.easeOutPow(1.0F - ((float) this.age / (float) this.lifetime), 4.0F);
            //this.setSize(defaultSize * f, defaultSize * f);
            this.setSpriteFromAge(this.sprites);
            //float f = ((float)age / (float)lifetime);
            //this.alpha = FloatEasings.easeOutQuad(1.0F - f);

            this.oRoll = this.roll;
            this.roll += (float)Math.PI * this.rotSpeed * 2.0F;
            if (this.onGround) {
                this.oRoll = this.roll = 0.0F;
            }

            this.move(this.xd, this.yd, this.zd);

            this.xd *= 0.97F;
            this.yd *= 0.97F;
            this.zd *= 0.97F;

            this.yd -= gravity;
            this.yd = Math.max(this.yd, (double)-0.05F);
        } else {
            this.remove();
        }
    }

    @Override
    public int getLightColor(float partialTick) {
        int original = super.getLightColor(partialTick);
        int j = original & 0xFF;
        int k = original >> 16 & 0xFF;
        j += 240;
        if (j > 240) {
            j = 240;
        }

        return j | k << 16;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<ColorParticleOption> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(ColorParticleOption type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            SparkParticle particle = new SparkParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, 0.004D, this.sprites);
            particle.setColor(type.getRed(), type.getGreen(), type.getBlue());
            particle.setAlpha(type.getAlpha());
            return particle;
        }
    }
}
