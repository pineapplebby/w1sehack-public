/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  org.lwjgl.input.Keyboard
 */
package me.wise.w1sehack.api.management;

import java.util.ArrayList;
import java.util.List;

import me.wise.w1sehack.api.binds.IBindable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class BindManager {
    public static BindManager INSTANCE;
    List<IBindable> bindables = new ArrayList<IBindable>();

    public BindManager() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    public List<IBindable> getBindables() {
        return this.bindables;
    }

    public void setBindables(List<IBindable> bindables) {
        this.bindables = bindables;
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        if (!Keyboard.getEventKeyState()) {
            return;
        }
        for (IBindable bindable : this.getBindables()) {
            if (bindable.getKey() != Keyboard.getEventKey()) continue;
            bindable.onKey();
        }
    }
}

