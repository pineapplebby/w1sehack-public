/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package me.wise.w1sehack.impl.features.modules.player;

import me.wise.w1sehack.api.utils.NullUtils;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.module.Module;

public class Sprint
extends Module {
    public Sprint() {
        super("Sprint", Feature.Category.Player);
    }

    @SubscribeEvent
    public void onUpdate(TickEvent.ClientTickEvent tickEvent) {
        if (NullUtils.nullCheck()) {
            return;
        }
        if (Sprint.mc.player == null || Sprint.mc.world == null) {
            return;
        }
        if (Sprint.mc.player.moveForward > 0.0f) {
            Sprint.mc.player.setSprinting(true);
        }
    }
}

