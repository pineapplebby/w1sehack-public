/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl.features.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.wise.w1sehack.api.utils.chat.ChatMessage;
import me.wise.w1sehack.api.utils.chat.ChatUtils;
import me.wise.w1sehack.api.command.Command;
import me.wise.w1sehack.api.management.FriendManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class Friend
extends Command {
    public Friend() {
        super("Friend", "Friends someone", new String[]{"f", "friend"});
    }

    @Override
    public void run(String[] args) {
        if (args.length > 2) {
            if (args[1].equalsIgnoreCase("add")) {
                FriendManager.INSTANCE.getFriends().add(new me.wise.w1sehack.api.friends.Friend(args[2]));
                ChatUtils.sendMessage(new ChatMessage(ChatFormatting.LIGHT_PURPLE + "Added  " + ChatFormatting.BLUE + args[2], false, 0));
            } else if (args[1].equalsIgnoreCase("del")) {
                FriendManager.INSTANCE.getFriends().remove(new me.wise.w1sehack.api.friends.Friend(args[2]));
                ChatUtils.sendMessage(new ChatMessage("Removed " + args[2], false, 0));
            } else {
                ChatUtils.sendMessage(new ChatMessage("Invalid format", false, 0));
            }
        } else {
            ChatUtils.sendMessage(new ChatMessage("Invalid format", false, 0));
        }
    }
}

