/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl;

import me.wise.w1sehack.api.utils.color.RainbowUtil;
import me.wise.w1sehack.api.utils.player.RotationUtil;
import me.wise.w1sehack.impl.features.commands.Bind;
import me.wise.w1sehack.impl.features.commands.Friend;
import me.wise.w1sehack.impl.features.commands.Help;
import me.wise.w1sehack.impl.features.modules.client.FontModule;
import me.wise.w1sehack.impl.features.modules.client.HudColors;
import me.wise.w1sehack.impl.features.modules.client.Manager;
import me.wise.w1sehack.impl.features.modules.client.Safety;
import me.wise.w1sehack.impl.features.modules.client.gui.ClickGUI;
import me.wise.w1sehack.impl.features.modules.client.gui.ClickGuiModule;
import me.wise.w1sehack.impl.features.modules.render.*;
import me.wise.w1sehack.impl.gui.ClickGui;
import me.wise.w1sehack.api.management.BindManager;
import me.wise.w1sehack.api.management.CommandManager;
import me.wise.w1sehack.api.management.FeatureManager;
import me.wise.w1sehack.api.management.FriendManager;
import me.wise.w1sehack.api.management.SavableManager;
import me.wise.w1sehack.impl.features.hud.ArmorHud;
import me.wise.w1sehack.impl.features.hud.Coords;
import me.wise.w1sehack.impl.features.hud.FeatureList;
import me.wise.w1sehack.impl.features.hud.Info;
import me.wise.w1sehack.impl.features.hud.Watermark;
import me.wise.w1sehack.impl.features.modules.combat.AutoTrap;
import me.wise.w1sehack.impl.features.modules.combat.Burrow;
import me.wise.w1sehack.impl.features.modules.combat.HoleFill;
import me.wise.w1sehack.impl.features.modules.combat.Offhand;
import me.wise.w1sehack.impl.features.modules.combat.Surround;
import me.wise.w1sehack.impl.features.modules.misc.ChatSuffix;
import me.wise.w1sehack.impl.features.modules.misc.FakePlayer;
import me.wise.w1sehack.impl.features.modules.misc.HotbarRefill;
import me.wise.w1sehack.impl.features.modules.misc.MultiTask;
import me.wise.w1sehack.impl.features.modules.misc.NoMiningTrace;
import me.wise.w1sehack.impl.features.modules.misc.SpeedMine;
import me.wise.w1sehack.impl.features.modules.misc.Timestamps;
import me.wise.w1sehack.impl.features.modules.misc.TotemPopCounter;
import me.wise.w1sehack.impl.features.modules.player.Holesnap;
import me.wise.w1sehack.impl.features.modules.player.MiddleClick;
import me.wise.w1sehack.impl.features.modules.player.PacketFly;
import me.wise.w1sehack.impl.features.modules.player.ReverseStep;
import me.wise.w1sehack.impl.features.modules.player.Sprint;
import me.wise.w1sehack.impl.features.modules.player.Step;
import me.wise.w1sehack.impl.features.modules.player.Velocity;
import me.wise.w1sehack.impl.features.modules.render.PopESP;

public class Register {
    public static Register INSTANCE;

    public void registerAll() {
        this.registerManagers();
        this.registerFeatures();
        this.registerGui();
    }

    public void registerManagers() {
        SavableManager.INSTANCE = new SavableManager();
        BindManager.INSTANCE = new BindManager();
        FeatureManager.INSTANCE = new FeatureManager();
        RainbowUtil.INSTANCE = new RainbowUtil();
        FriendManager.INSTANCE = new FriendManager();
        RotationUtil.INSTANCE = new RotationUtil();
        CommandManager.INSTANCE = new CommandManager();
    }

    public void registerFeatures() {
        FeatureManager.INSTANCE.getFeatures().add(new Safety());
        FeatureManager.INSTANCE.getFeatures().add(new FontModule());
        FeatureManager.INSTANCE.getFeatures().add(new Manager());
        FeatureManager.INSTANCE.getFeatures().add(new HudColors());
        FeatureManager.INSTANCE.getFeatures().add(new ClickGUI());
        FeatureManager.INSTANCE.getFeatures().add(new Timestamps());
        FeatureManager.INSTANCE.getFeatures().add(new ClickGuiModule());
        FeatureManager.INSTANCE.getFeatures().add(new Sprint());
        FeatureManager.INSTANCE.getFeatures().add(new Step());
        FeatureManager.INSTANCE.getFeatures().add(new ReverseStep());
        FeatureManager.INSTANCE.getFeatures().add(new PacketFly());
        FeatureManager.INSTANCE.getFeatures().add(new Velocity());
        FeatureManager.INSTANCE.getFeatures().add(new MiddleClick());
        FeatureManager.INSTANCE.getFeatures().add(new Holesnap());
        FeatureManager.INSTANCE.getFeatures().add(new FakePlayer());
        FeatureManager.INSTANCE.getFeatures().add(new PopESP());
        FeatureManager.INSTANCE.getFeatures().add(new ChatSuffix());
        FeatureManager.INSTANCE.getFeatures().add(new SpeedMine());
        FeatureManager.INSTANCE.getFeatures().add(new MultiTask());
        FeatureManager.INSTANCE.getFeatures().add(new HotbarRefill());
        FeatureManager.INSTANCE.getFeatures().add(new TotemPopCounter());
        FeatureManager.INSTANCE.getFeatures().add(new NoMiningTrace());
        FeatureManager.INSTANCE.getFeatures().add(new Chams());
        FeatureManager.INSTANCE.getFeatures().add(new ViewModel());
        FeatureManager.INSTANCE.getFeatures().add(new Nametags());
        FeatureManager.INSTANCE.getFeatures().add(new ChorusViewer());
        FeatureManager.INSTANCE.getFeatures().add(new BurrowESP());
        FeatureManager.INSTANCE.getFeatures().add(new BlockHighlight());
        FeatureManager.INSTANCE.getFeatures().add(new Offhand());
        FeatureManager.INSTANCE.getFeatures().add(new HoleFill());
        FeatureManager.INSTANCE.getFeatures().add(new Burrow());
        FeatureManager.INSTANCE.getFeatures().add(new Surround());
        FeatureManager.INSTANCE.getFeatures().add(new AutoTrap());
        FeatureManager.INSTANCE.getFeatures().add(new Watermark());
        FeatureManager.INSTANCE.getFeatures().add(new FeatureList());
        FeatureManager.INSTANCE.getFeatures().add(new Info());
        FeatureManager.INSTANCE.getFeatures().add(new Coords());
        FeatureManager.INSTANCE.getFeatures().add(new ArmorHud());
        CommandManager.INSTANCE.getCommands().add(new Help());
        CommandManager.INSTANCE.getCommands().add(new Bind());
        CommandManager.INSTANCE.getCommands().add(new Friend());
    }

    public void registerGui() {
        ClickGui.INSTANCE = new ClickGui();
    }
}

