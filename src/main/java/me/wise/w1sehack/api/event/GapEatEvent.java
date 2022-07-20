/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.wise.w1sehack.api.event;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.Event;

public class GapEatEvent
extends Event {
    public ItemStack stack;

    public GapEatEvent(ItemStack itemStack) {
        this.stack = itemStack;
    }
}

