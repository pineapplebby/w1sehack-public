/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemPickaxe
 */
package me.wise.w1sehack.impl.features.modules.misc;

import net.minecraft.item.ItemPickaxe;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.module.Module;
import me.wise.w1sehack.api.value.Value;
import me.wise.w1sehack.api.value.builder.ValueBuilder;

public class NoMiningTrace
extends Module {
    private static NoMiningTrace INSTANCE;
    Value<Boolean> Pickaxe = new ValueBuilder().withDescriptor("Pickaxe").withValue(false).withAction(s -> {}).register(this);

    public NoMiningTrace() {
        super("NoMiningTrace", Feature.Category.Misc);
        INSTANCE = this;
    }

    public static boolean spoofTrace() {
        if (!INSTANCE.isEnabled()) {
            return false;
        }
        return NoMiningTrace.INSTANCE.Pickaxe.getValue() == false || NoMiningTrace.mc.player.getHeldItemMainhand().getItem() instanceof ItemPickaxe;
    }
}

