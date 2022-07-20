/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.NetworkManager
 */
package me.wise.w1sehack.mixin.mixins.access;

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetworkManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={NetHandlerPlayClient.class})
public interface INetHandlerPlayClient {
    @Accessor(value="netManager")
    public void setNetManager(NetworkManager var1);
}

