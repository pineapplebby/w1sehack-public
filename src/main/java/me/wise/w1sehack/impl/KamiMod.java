/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraftforge.fml.common.Mod$Instance
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPostInitializationEvent
 */
package me.wise.w1sehack.impl;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import me.wise.w1sehack.api.management.SavableManager;

public class KamiMod {
    public static String NAME = "w1sehack";
    public static final String MOD_ID = "w1sehack";
    public static String VERSION = "1.1.1 - BETA";
    public static final String NAME_VERSION = NAME + " " + VERSION;
    public static String NAME_VERSION_COLORED = NAME + " " + VERSION;
    @Mod.Instance
    public KamiMod INSTANCE;

    public static void updateName() {
        NAME_VERSION_COLORED = NAME + " " + VERSION;
    }

    public void init(FMLInitializationEvent event) {
        System.out.println("Initialzied");
        Register.INSTANCE = new Register();
        Register.INSTANCE.registerAll();
        ShutdownHook.setup();
    }

    public void postInit(FMLPostInitializationEvent event) {
        SavableManager.INSTANCE.load();
    }

    static class ShutdownHook
    extends Thread {
        ShutdownHook() {
        }

        public static void setup() {
            Runtime.getRuntime().addShutdownHook(new ShutdownHook());
        }

        @Override
        public void run() {
            super.run();
            try {
                SavableManager.INSTANCE.save();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

