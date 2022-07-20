/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl.features.commands;

import me.wise.w1sehack.api.utils.chat.ChatMessage;
import me.wise.w1sehack.api.utils.chat.ChatUtils;
import me.wise.w1sehack.api.command.Command;
import me.wise.w1sehack.api.management.CommandManager;

public class Help
extends Command {
    public Help() {
        super("Help", "Shows you all the commands", new String[]{"help", "commands"});
    }

    @Override
    public void run(String[] args) {
        for (Command command : CommandManager.INSTANCE.getCommands()) {
            ChatUtils.sendMessage(new ChatMessage(command.getName() + " - " + command.getDesc(), false, 0));
        }
    }
}

