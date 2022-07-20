/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventHandler
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPostInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 */
package me.wise.loader;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import me.wise.w1sehack.impl.KamiMod;

@Mod(name="w1sehack", modid="w1sehack", version="1.1.0")
public class ModLoader {
    KamiMod kami;

    public ModLoader() {
        System.out.println("Starting to load");
        System.out.println("Loaded client");
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        this.kami = new KamiMod();
        this.kami.init(null);
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        this.kami.postInit(event);
    }
}

