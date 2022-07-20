/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 */
package me.wise.w1sehack.api.feature.module;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Map;

import me.wise.w1sehack.api.binds.IBindable;
import me.wise.w1sehack.api.management.BindManager;
import me.wise.w1sehack.api.utils.chat.ChatMessage;
import me.wise.w1sehack.api.utils.chat.ChatUtils;
import me.wise.w1sehack.api.wrapper.IMinecraft;
import net.minecraft.client.Minecraft;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.value.Value;
import me.wise.w1sehack.api.value.builder.ValueBuilder;
import me.wise.w1sehack.api.value.custom.Bind;

public class Module
extends Feature
implements IBindable,
        IMinecraft {
    Bind bind;
    Value<Boolean> chatNotify = new ValueBuilder().withDescriptor("Chat Notify").withValue(true).register(this);

    public Module(String name, Feature.Category category) {
        super(name, category, Feature.FeatureType.Module);
        this.bind = new Bind();
        BindManager.INSTANCE.getBindables().add(this);
    }

    public Value<?> register(Value<?> value) {
        this.getValues().add(value);
        return value;
    }

    public Bind getBind() {
        return this.bind;
    }

    public void setBind(Bind bind) {
        this.bind = bind;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        if (Minecraft.getMinecraft().world != null) {
            this.offset = Math.negateExact(Minecraft.getMinecraft().fontRenderer.getStringWidth(this.getName() + " [" + this.getHudInfo() + "]"));
        }
        if (this.chatNotify.getValue().booleanValue()) {
            ChatUtils.sendMessage(new ChatMessage(ChatFormatting.BOLD + this.getDisplayName() + ChatFormatting.LIGHT_PURPLE + " was " + ChatFormatting.GREEN + "enabled" + ChatFormatting.GREEN + ".", true, 69420));
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        if (this.chatNotify.getValue().booleanValue()) {
            ChatUtils.sendMessage(new ChatMessage(ChatFormatting.BOLD + this.getDisplayName() + ChatFormatting.LIGHT_PURPLE + " was " + ChatFormatting.RED + "disabled" + ChatFormatting.RED + ".", true, 69420));
        }
    }

    @Override
    public void load(Map<String, Object> objects) {
        super.load(objects);
        this.bind.setKey((Integer)objects.get("bind"));
    }

    @Override
    public Map<String, Object> save() {
        Map<String, Object> toSave = super.save();
        toSave.put("bind", this.bind.getKey());
        return toSave;
    }

    @Override
    public int getKey() {
        return this.bind.getKey();
    }

    @Override
    public void onKey() {
        this.toggle();
    }
}

