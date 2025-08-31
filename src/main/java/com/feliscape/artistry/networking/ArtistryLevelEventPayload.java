package com.feliscape.artistry.networking;

import com.feliscape.artistry.Artistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ArtistryLevelEventPayload(int id, double x, double y, double z, int data) implements CustomPacketPayload {

    public ArtistryLevelEventPayload(int id, Vec3 location){
        this(id, location.x, location.y, location.z, 0);
    }
    public ArtistryLevelEventPayload(int id, Vec3 location, int data){
        this(id, location.x, location.y, location.z, data);
    }
    public ArtistryLevelEventPayload(int id, double x, double y, double z){
        this(id, x, y, z, 0);
    }

    public static void send(int id, double x, double y, double z, int data){
        PacketDistributor.sendToAllPlayers(new ArtistryLevelEventPayload(id, x, y, z, data));
    }
    public static void send(int id, double x, double y, double z){
        send(id, x, y, z, 0);
    }
    public static void send(int id, Vec3 position){
        send(id, position.x, position.y, position.z);
    }
    public static void send(int id, BlockPos blockPos){
        send(id, blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }
    public static void send(int id, Vec3 position, int data){
        send(id, position.x, position.y, position.z, data);
    }
    public static void send(int id, BlockPos blockPos, int data){
        send(id, blockPos.getBottomCenter(), data);
    }

    public static final Type<ArtistryLevelEventPayload> TYPE =
            new Type<>(Artistry.location("client_level_event"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ArtistryLevelEventPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            ArtistryLevelEventPayload::id,
            ByteBufCodecs.DOUBLE,
            ArtistryLevelEventPayload::x,
            ByteBufCodecs.DOUBLE,
            ArtistryLevelEventPayload::y,
            ByteBufCodecs.DOUBLE,
            ArtistryLevelEventPayload::z,
            ByteBufCodecs.INT,
            ArtistryLevelEventPayload::data,
            ArtistryLevelEventPayload::new
    );

    public static void handle(ArtistryLevelEventPayload payload, IPayloadContext context) {
        Level level = context.player().level();
        Player player = context.player();
        RandomSource random = level.random;
        double x = payload.x;
        double y = payload.y;
        double z = payload.z;
        Vec3 location = new Vec3(x, y, z);
        switch (payload.id()){
            case ArtistryLevelEvents.SPIRAL_FUNGUS_BOUNCE: {
                int particleCount = random.nextInt(4) + 6;
                for (int i = 0; i < particleCount; i++){
                    double theta = random.nextDouble() * Math.TAU;
                    double xVelocity = Math.cos(theta) * (random.nextDouble() * 0.4D + 0.1D);
                    double yVelocity = random.nextDouble() * 0.2D + 0.1D;
                    double zVelocity = Math.cos(theta) * (random.nextDouble() * 0.4D + 0.1D);

                    level.addParticle(ParticleTypes.CLOUD, location.x + 0.5D, location.z + 0.5D, location.y + 0.5D,
                            xVelocity, yVelocity, zVelocity);
                }
                break;
            }
            case ArtistryLevelEvents.LEECHING_SOIL_LEECH: {
                int particleCount = random.nextInt(8) + 10;
                for (int i = 0; i < particleCount; i++) {
                    level.addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                            location.x + random.nextDouble(),
                            location.y + random.nextDouble(),
                            location.z + random.nextDouble(),
                            0.0D, 0.0D, 0.0D
                    );
                }
            }
            default:
                break;
        }
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
