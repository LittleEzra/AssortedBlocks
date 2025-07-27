package com.feliscape.artistry.registry;

import com.feliscape.artistry.Artistry;
import com.feliscape.artistry.client.particle.FountainParticle;
import com.feliscape.artistry.client.particle.SparkParticle;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

@EventBusSubscriber(modid = Artistry.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ArtistryParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(Registries.PARTICLE_TYPE, Artistry.MOD_ID);

    public static final Supplier<ParticleType<ColorParticleOption>> SPARK = register("spark",
            false, ColorParticleOption::codec, ColorParticleOption::streamCodec);
    public static final Supplier<SimpleParticleType> WATER_FOUNTAIN = PARTICLE_TYPES.register("water_fountain",
            () -> new SimpleParticleType(false));

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event)
    {
        event.registerSpriteSet(ArtistryParticles.SPARK.get(), SparkParticle.Provider::new);
        event.registerSprite(ArtistryParticles.WATER_FOUNTAIN.get(), FountainParticle::createWaterFountainParticle);
    }

    private static <T extends ParticleOptions> Supplier<ParticleType<T>> register(
            String name,
            boolean overrideLimiter,
            final Function<ParticleType<T>, MapCodec<T>> codecGetter,
            final Function<ParticleType<T>, StreamCodec<? super RegistryFriendlyByteBuf, T>> streamCodecGetter
    ) {
        return PARTICLE_TYPES.register(name, () -> new ParticleType<T>(overrideLimiter) {
            @Override
            public MapCodec<T> codec() {
                return codecGetter.apply(this);
            }

            @Override
            public StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec() {
                return streamCodecGetter.apply(this);
            }
        });
    }

    public static void register(IEventBus eventBus){
        PARTICLE_TYPES.register(eventBus);
    }
}
