package com.feliscape.artistry.client.particle;

import com.feliscape.artistry.util.RandomUtil;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

public class FlyParticle extends TextureSheetParticle {
    protected FlyParticle(ClientLevel level, SpriteSet sprites, double x, double y, double z) {
        super(level, x, y, z);
        this.pickSprite(sprites);
        this.quadSize = 0.03125f;
        this.lifetime = this.random.nextInt(60) + 40;
        this.xd = RandomUtil.centeredDouble(this.random) * 0.05D;
        this.yd = RandomUtil.centeredDouble(this.random) * 0.02D;
        this.zd = RandomUtil.centeredDouble(this.random) * 0.05D;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ < this.lifetime) {
            if (this.random.nextInt(10) == 0){
                this.xd = RandomUtil.centeredDouble(this.random) * 0.05D;
                this.yd = RandomUtil.centeredDouble(this.random) * 0.035D + 0.01D;
                this.zd = RandomUtil.centeredDouble(this.random) * 0.05D;
            }

            this.move(this.xd, this.yd, this.zd);

            this.xd *= 0.97F;
            this.yd *= 0.97F;
            this.zd *= 0.97F;
        } else {
            this.remove();
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new FlyParticle(level, this.sprites, x, y, z);
        }
    }
}
