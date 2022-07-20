/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketChatMessage
 */
package me.wise.w1sehack.mixin.mixins.access;

import net.minecraft.network.play.client.CPacketChatMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketChatMessage.class})
public interface ICPacketChat {
    @Accessor(value="message")
    public void setMessage(String var1);
}

