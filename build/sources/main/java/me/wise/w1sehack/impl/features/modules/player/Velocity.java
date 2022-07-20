/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.network.play.server.SPacketExplosion
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.wise.w1sehack.impl.features.modules.player;

import me.wise.w1sehack.api.event.PacketEvent;
import me.wise.w1sehack.api.event.PushOutOfBlocksEvent;
import me.wise.w1sehack.api.utils.NullUtils;
import me.wise.w1sehack.mixin.mixins.access.ISPacketEntityVelocity;
import me.wise.w1sehack.mixin.mixins.access.ISPacketExplosion;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.module.Module;
import me.wise.w1sehack.api.value.Value;
import me.wise.w1sehack.api.value.builder.ValueBuilder;

public class Velocity
extends Module {
    Value<Boolean> cancelV = new ValueBuilder().withDescriptor("Cancel V").withValue(false).register(this);
    Value<Boolean> cancelE = new ValueBuilder().withDescriptor("Cancel E").withValue(false).register(this);
    Value<Number> horizontal = new ValueBuilder().withDescriptor("Horizontal").withValue(0).withRange(0, 100).register(this);
    Value<Number> vertical = new ValueBuilder().withDescriptor("Vertical").withValue(0).withRange(0, 100).register(this);
    Value<Boolean> noSlow = new ValueBuilder().withDescriptor("No Slow").withValue(true).register(this);

    public Velocity() {
        super("Velocity", Feature.Category.Player);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent event) {
        if (NullUtils.nullCheck()) {
            return;
        }
        if (event.getPacket() instanceof SPacketEntityVelocity && ((SPacketEntityVelocity)event.getPacket()).getEntityID() == Velocity.mc.player.getEntityId()) {
            SPacketEntityVelocity packet = (SPacketEntityVelocity)event.getPacket();
            ISPacketEntityVelocity inter = (ISPacketEntityVelocity) packet;
            if (this.cancelV.getValue().booleanValue()) {
                event.setCanceled(true);
                return;
            }
            inter.setMotionX(packet.getMotionX() * this.horizontal.getValue().intValue());
            inter.setMotionY(packet.getMotionY() * this.vertical.getValue().intValue());
            inter.setMotionZ(packet.getMotionZ() * this.horizontal.getValue().intValue());
        }
        if (event.getPacket() instanceof SPacketExplosion) {
            SPacketExplosion packet = (SPacketExplosion)event.getPacket();
            ISPacketExplosion inter = (ISPacketExplosion)packet;
            if (this.cancelE.getValue().booleanValue()) {
                event.setCanceled(true);
                return;
            }
            inter.setMotionX(packet.getMotionX() * (float)this.horizontal.getValue().intValue());
            inter.setMotionY(packet.getMotionY() * (float)this.vertical.getValue().intValue());
            inter.setMotionZ(packet.getMotionZ() * (float)this.horizontal.getValue().intValue());
        }
    }

    @SubscribeEvent
    public void onInputUpdate(InputUpdateEvent event) {
        if (this.noSlow.getValue().booleanValue() && Velocity.mc.player.isHandActive() && !Velocity.mc.player.isRiding()) {
            event.getMovementInput().moveStrafe *= 5.0f;
            event.getMovementInput().moveForward *= 5.0f;
        }
    }

    @SubscribeEvent
    public void onPushOutOfBlocks(PushOutOfBlocksEvent event) {
        event.setCanceled(true);
    }
}

