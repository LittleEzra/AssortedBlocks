package com.feliscape.artistry.util;

import net.minecraft.util.Mth;

public class FloatEasings {
    private static float pow(float x, float n){
        return (float) Math.pow(x, n);
    }

    public static float easeInPow(float t, float pow) {
        return pow(t, pow);
    }
    public static float easeOutPow(float t, float pow) {
        return 1.0F - (float) pow(1.0F - t, pow);
    }
    public static float easeInOutPow(float t, float pow) {
        return t < 0.5F ? pow(2.0F, t - 1.0F) * pow(t, pow) : 1.0F - (pow(-2.0F * t + 2.0F, pow) * 0.5F);
    }

    public static float easeInQuad(float t) {
        return t * t;
    }
    public static float easeOutQuad(float t) {
        return 1.0F - Mth.square(1.0F - t);
    }
    public static float easeInOutQuad(float t) {
        return t < 0.5F ? 2.0F * t * t : 1.0F - (Mth.square(-2.0F * t + 2.0F) * 0.5F);
    }

    public static float easeInSin(float t) {
        return 1.0F - Mth.cos((t * Mth.PI) * 0.5F);
    }
    public static float easeOutSin(float t) {
        return Mth.sin((t * Mth.PI) * 0.5F);
    }
    public static float easeInOutSin(float t) {
        return -(Mth.cos(t * Mth.PI) - 1.0F) * 0.5F;
    }
}
