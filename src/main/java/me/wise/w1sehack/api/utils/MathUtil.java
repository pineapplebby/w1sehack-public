/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.api.utils;

public class MathUtil {
    public static double normalize(double value, double min, double max) {
        return (value - min) / (max - min);
    }
}

