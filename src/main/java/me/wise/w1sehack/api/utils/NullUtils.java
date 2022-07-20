/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.api.utils;

import me.wise.w1sehack.api.wrapper.IMinecraft;

public class NullUtils
implements IMinecraft {
    public static boolean nullCheck() {
        return NullUtils.mc.player == null || NullUtils.mc.world == null || NullUtils.mc.playerController == null;
    }
}

