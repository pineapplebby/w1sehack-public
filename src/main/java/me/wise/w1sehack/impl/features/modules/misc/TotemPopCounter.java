/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.play.server.SPacketEntityStatus
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package me.wise.w1sehack.impl.features.modules.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import me.wise.w1sehack.api.event.PacketEvent;
import me.wise.w1sehack.api.utils.NullUtils;
import me.wise.w1sehack.api.utils.chat.ChatMessage;
import me.wise.w1sehack.api.utils.chat.ChatUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.module.Module;

public class TotemPopCounter
        extends Module {
    private final Object2IntOpenHashMap<String> registry = new Object2IntOpenHashMap();

    public TotemPopCounter() {
        super("Pop Counter", Feature.Category.Misc);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent event) {
        SPacketEntityStatus packet;
        if (NullUtils.nullCheck()) {
            return;
        }
        if (event.getPacket() instanceof SPacketEntityStatus && event.getTime() == PacketEvent.Time.Receive && (packet = (SPacketEntityStatus)event.getPacket()).getOpCode() == 35 && packet.getEntity((World)TotemPopCounter.mc.world) != null) {
            Entity entity = packet.getEntity((World)TotemPopCounter.mc.world);
            String name = entity.getName();
            boolean isSelf = TotemPopCounter.mc.player == entity;
            this.registry.put(name, this.registry.getInt(name) + 1);
            int pops = this.registry.getInt((Object)name);
            ChatUtils.sendMessage(new ChatMessage(ChatFormatting.LIGHT_PURPLE + (isSelf ? "You" : name) + ChatFormatting.LIGHT_PURPLE + (isSelf ? " have" : " has") + " popped" + (pops == 0 ? "." : (isSelf ? " your " : " their ") + ChatFormatting.DARK_PURPLE + pops + this.appendSuffix(pops) + ChatFormatting.LIGHT_PURPLE + " totem"), true, -entity.getEntityId()));
        }
    }

    public void onDeath(EntityPlayer player) {
        String name = player.getName();
        if (this.registry.containsKey((Object)name)) {
            int pops = this.registry.getInt((Object)name);
            this.registry.removeInt((Object)name);
            ChatUtils.sendMessage(new ChatMessage(ChatFormatting.LIGHT_PURPLE + player.getName() + ChatFormatting.LIGHT_PURPLE + " died after popping" + (pops == 0 ? "." : " their " + ChatFormatting.DARK_PURPLE + pops + this.appendSuffix(pops) + ChatFormatting.LIGHT_PURPLE + " totem"), true, -player.getEntityId()));
        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e) {
        if (NullUtils.nullCheck()) {
            return;
        }
        for (EntityPlayer player : TotemPopCounter.mc.world.playerEntities) {
            if (player == null || player.getHealth() > 0.0f) continue;
            this.onDeath(player);
        }
    }

    public String appendSuffix(int number) {
        if (number == 1) {
            return "st";
        }
        if (number == 2) {
            return "nd";
        }
        if (number == 3) {
            return "rd";
        }
        return "th";
    }
}



