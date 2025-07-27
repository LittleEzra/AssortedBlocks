package com.feliscape.artistry.util;

import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class RandomUtil {
    public static Vec3 randomPositionOnSphere(RandomSource source, double radius){
        // From https://extremelearning.com.au/how-to-generate-uniformly-random-points-on-n-spheres-and-n-balls/
        double u = source.nextDouble();
        double v = source.nextDouble();
        double theta = 2 * Math.PI * u;
        double phi = Math.acos(2.0D * v - 1.0D);

        double x = Math.sin(theta) * Math.cos(phi);
        double y = Math.sin(theta) * Math.sin(phi);
        double z = Math.cos(theta);
        return new Vec3(x * radius, y * radius, z * radius);
    }
    public static Vec3 randomPositionOnSphereGaussian(RandomSource source, double radius){
        // From https://extremelearning.com.au/how-to-generate-uniformly-random-points-on-n-spheres-and-n-balls/
        double x = source.nextGaussian();
        double y = source.nextGaussian();
        double z = source.nextGaussian();

        return new Vec3(x,y,z).normalize().scale(radius);
    }
    public static Vec3 randomInAABB(RandomSource source, AABB area){
        double x = source.nextDouble() * (area.maxX - area.minX) + area.minX;
        double y = source.nextDouble() * (area.maxY - area.minY) + area.minY;
        double z = source.nextDouble() * (area.maxZ - area.minZ) + area.minZ;

        return new Vec3(x,y,z);
    }

    public static double centeredDouble(RandomSource source) {
        return source.nextDouble() * 2.0D - 1.0D;
    }

    public static float centeredFloat(RandomSource source) {
        return source.nextFloat() * 2.0F - 1.0F;
    }
}
