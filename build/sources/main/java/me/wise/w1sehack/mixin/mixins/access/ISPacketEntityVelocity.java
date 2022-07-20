/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 */
package me.wise.w1sehack.mixin.mixins.access;

import net.minecraft.network.play.server.SPacketEntityVelocity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketEntityVelocity.class})
public interface ISPacketEntityVelocity {
    @Accessor(value="motionX")
    public void setMotionX(int var1);

    @Accessor(value="motionY")
    public void setMotionY(int var1);

    @Accessor(value="motionZ")
    public void setMotionZ(int var1);
}

