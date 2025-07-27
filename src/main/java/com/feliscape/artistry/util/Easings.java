package com.feliscape.artistry.util;

import net.minecraft.util.Mth;

public class Easings {

    public static double easeInPow(double t, double pow) {
        return Math.pow(t, pow);
    }
    public static double easeOutPow(double t, double pow) {
        return 1.0F - (double) Math.pow(1.0F - t, pow);
    }
    public static double easeInOutPow(double t, double pow) {
        return t < 0.5F ? Math.pow(2.0F, t - 1.0F) * Math.pow(t, pow) : 1.0F - (Math.pow(-2.0F * t + 2.0F, pow) * 0.5F);
    }

    public static double easeInQuad(double t) {
        return t * t;
    }
    public static double easeOutQuad(double t) {
        return 1.0F - Mth.square(1.0F - t);
    }
    public static double easeInOutQuad(double t) {
        return t < 0.5F ? 2.0F * t * t : 1.0F - (Mth.square(-2.0F * t + 2.0F) * 0.5F);
    }

    public static double easeInSin(double t) {
        return 1.0F - Math.cos((t * Math.PI) * 0.5F);
    }
    public static double easeOutSin(double t) {
        return Math.sin((t * Math.PI) * 0.5F);
    }
    public static double easeInOutSin(double t) {
        return -(Math.cos(t * Math.PI) - 1.0F) * 0.5F;
    }
}
