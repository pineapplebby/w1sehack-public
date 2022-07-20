/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.wise.w1sehack.impl.features.modules.misc;

import me.wise.w1sehack.api.event.PacketEvent;
import me.wise.w1sehack.api.utils.NullUtils;
import me.wise.w1sehack.api.utils.chat.ChatUtils;
import me.wise.w1sehack.mixin.mixins.access.ICPacketChat;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.module.Module;
import me.wise.w1sehack.api.value.Value;
import me.wise.w1sehack.api.value.builder.ValueBuilder;
import me.wise.w1sehack.impl.KamiMod;

public class ChatSuffix
extends Module {
    Value<String> mode = new ValueBuilder().withDescriptor("Mode").withValue(KamiMod.NAME).register(this);
    String[] filters = new String[]{".", "/", ",", ":", "`", "-"};

    public ChatSuffix() {
        super("ChatSuffix", Feature.Category.Misc);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent event) {
        if (NullUtils.nullCheck()) {
            return;
        }
        if (event.getTime() == PacketEvent.Time.Send && event.getPacket() instanceof CPacketChatMessage && this.allowMessage(((CPacketChatMessage)event.getPacket()).getMessage())) {
            ((ICPacketChat)((CPacketChatMessage)event.getPacket())).setMessage(((CPacketChatMessage)event.getPacket()).getMessage() + ChatUtils.hephaestus(" | " + this.mode.getValue().toLowerCase()));
        }
    }

    boolean allowMessage(String message) {
        boolean allow = true;
        for (String s : this.filters) {
            if (!message.startsWith(s)) continue;
            allow = false;
            break;
        }
        return allow;
    }
}

