package com.feliscape.artistry.util;

import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public class MathUtil {
    private static final float DEGREES_TO_RADIANS = 0.017453292519943295F;

    /**
     * Stable Angle Lerp - lerps between two angles (in radians), always clockwise
     * @param delta A value usually between 0 and 1 that indicates the percentage of
     *              the lerp. (0 will give the start value and 1 will give the end
     *              value)
     * @param start Start value for the lerp.
     * @param end   End value for the lerp.
     */
    public static float stableAngleLerpCW(float delta, float start, float end){
        if (start < end){
            return Mth.lerp(delta, start, end - Mth.TWO_PI);
        }
        return Mth.lerp(delta, start, end);
    }
    /**
     * Stable Angle Lerp - lerps between two angles (in radians), always counter-clockwise
     * @param delta A value usually between 0 and 1 that indicates the percentage of
     *              the lerp. (0 will give the start value and 1 will give the end
     *              value)
     * @param start Start value for the lerp.
     * @param end   End value for the lerp.
     */
    public static float stableAngleLerpCCW(float delta, float start, float end){
        if (start > end){
            return Mth.lerp(delta, start, end + Mth.TWO_PI);
        }
        return Mth.lerp(delta, start, end);
    }

    /**
     * Stable Angle Lerp - lerps between two angles (in radians), always clockwise
     * @param delta A value usually between 0 and 1 that indicates the percentage of
     *              the lerp. (0 will give the start value and 1 will give the end
     *              value)
     * @param start Start value for the lerp.
     * @param end   End value for the lerp.
     */
    public static float stableDegreeLerpCW(float delta, float start, float end){
        if (start < end){
            return Mth.lerp(delta, start, end - 360.0F);
        }
        return Mth.lerp(delta, start, end);
    }
    /**
     * Stable Angle Lerp - lerps between two angles (in radians), always counter-clockwise
     * @param delta A value usually between 0 and 1 that indicates the percentage of
     *              the lerp. (0 will give the start value and 1 will give the end
     *              value)
     * @param start Start value for the lerp.
     * @param end   End value for the lerp.
     */
    public static float stableDegreeLerpCCW(float delta, float start, float end){
        if (start > end){
            return Mth.lerp(delta, start, end + 360.0F);
        }
        return Mth.lerp(delta, start, end);
    }

    /**
     * Stable Angle Lerp - lerps between two angles (in radians), always clockwise
     * @param delta A value usually between 0 and 1 that indicates the percentage of
     *              the lerp. (0 will give the start value and 1 will give the end
     *              value)
     * @param start Start value for the lerp.
     * @param end   End value for the lerp.
     */
    public static double stableAngleLerpCW(double delta, double start, double end){
        if (start < end){
            return Mth.lerp(delta, start, end - Mth.TWO_PI);
        }
        return Mth.lerp(delta, start, end);
    }
    /**
     * Stable Angle Lerp - lerps between two angles (in radians), always counter-clockwise
     * @param delta A value usually between 0 and 1 that indicates the percentage of
     *              the lerp. (0 will give the start value and 1 will give the end
     *              value)
     * @param start Start value for the lerp.
     * @param end   End value for the lerp.
     */
    public static double stableAngleLerpCCW(double delta, double start, double end){
        if (start > end){
            return Mth.lerp(delta, start, end + Mth.TWO_PI);
        }
        return Mth.lerp(delta, start, end);
    }

    /**
     * Stable Angle Lerp - lerps between two angles (in radians), always clockwise
     * @param delta A value usually between 0 and 1 that indicates the percentage of
     *              the lerp. (0 will give the start value and 1 will give the end
     *              value)
     * @param start Start value for the lerp.
     * @param end   End value for the lerp.
     */
    public static double stableDegreeLerpCW(double delta, double start, double end){
        if (start < end){
            return Mth.lerp(delta, start, end - 360.0F);
        }
        return Mth.lerp(delta, start, end);
    }
    /**
     * Stable Angle Lerp - lerps between two angles (in radians), always counter-clockwise
     * @param delta A value usually between 0 and 1 that indicates the percentage of
     *              the lerp. (0 will give the start value and 1 will give the end
     *              value)
     * @param start Start value for the lerp.
     * @param end   End value for the lerp.
     */
    public static double stableDegreeLerpCCW(double delta, double start, double end){
        if (start > end){
            return Mth.lerp(delta, start, end + 360.0F);
        }
        return Mth.lerp(delta, start, end);
    }

    public static double wrapRadians(double value) {
        double d0 = value % Math.TAU;
        if (d0 >= Math.PI) {
            d0 -= Math.TAU;
        }

        if (d0 < -Math.PI) {
            d0 += Math.TAU;
        }

        return d0;
    }

    public static double moveToward(double from, double to, double maxDelta){
        if (Math.abs(to - from) < maxDelta){
            return to;
        } else{
            return from + Mth.sign(to - from) * maxDelta;
        }
    }
    public static float moveToward(float from, float to, float maxDelta){
        if (Math.abs(to - from) < maxDelta){
            return to;
        } else{
            return from + Mth.sign(to - from) * maxDelta;
        }
    }
    public static Vec3 moveToward(Vec3 from, Vec3 to, double maxDelta){
        if (from.distanceTo(to) < maxDelta){
            return to;
        } else{
            return from.add(to.subtract(from).normalize().scale(maxDelta));
        }
    }

    // I literally have zero clue what this function even is
    public static float smin(float a, float b, float k) {
        float h = Math.max(k - Math.abs(a - b), 0.0F) / k;
        return Math.min(a, b) - h * h * k * (1.0F / 4.0F);
    }


    public static float toRadians(float degrees){
        return degrees * DEGREES_TO_RADIANS;
    }
}
