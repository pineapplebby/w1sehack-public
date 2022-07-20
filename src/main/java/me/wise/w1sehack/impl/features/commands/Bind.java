/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package me.wise.w1sehack.impl.features.commands;

import me.wise.w1sehack.api.utils.chat.ChatMessage;
import me.wise.w1sehack.api.utils.chat.ChatUtils;
import org.lwjgl.input.Keyboard;
import me.wise.w1sehack.api.command.Command;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.module.Module;
import me.wise.w1sehack.api.management.FeatureManager;

public class Bind
extends Command {
    public Bind() {
        super("Bind", "binds a module", new String[]{"bind", "b"});
    }

    @Override
    public void run(String[] args) {
        if (args.length > 2) {
            for (Feature feature : FeatureManager.INSTANCE.getFeatures()) {
                Module module;
                String modName;
                if (!(feature instanceof Module) || !(modName = (module = (Module)feature).getName().replace(" ", "")).equalsIgnoreCase(args[1])) continue;
                module.getBind().setKey(Keyboard.getKeyIndex((String)args[2].toUpperCase()));
                ChatUtils.sendMessage(new ChatMessage("Bound " + module.getName() + " to " + Keyboard.getKeyName((int)module.getBind().getKey()), false, 0));
            }
        } else {
            ChatUtils.sendMessage(new ChatMessage("Please input a valid command", false, 0));
        }
    }
}

