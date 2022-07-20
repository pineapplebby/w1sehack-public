/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package me.wise.w1sehack.impl.features.modules.client;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.module.Module;
import me.wise.w1sehack.api.value.Value;
import me.wise.w1sehack.api.value.builder.ValueBuilder;
import me.wise.w1sehack.impl.KamiMod;

public class Manager
extends Module {
    Value<String> clientName = new ValueBuilder().withDescriptor("Client Name").withValue(KamiMod.NAME).register(this);

    public Manager() {
        super("Manager", Feature.Category.Client);
        this.setEnabled(true);
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {
    }

    @SubscribeEvent
    public void onUpdate(TickEvent.ClientTickEvent event) {
        KamiMod.NAME = this.clientName.getValue();
        KamiMod.updateName();
    }
}

