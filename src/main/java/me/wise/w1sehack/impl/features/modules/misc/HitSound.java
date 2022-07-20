package me.wise.w1sehack.impl.features.modules.misc;

import java.util.Arrays;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import me.wise.w1sehack.api.feature.module.Module;
import me.wise.w1sehack.api.feature.setting.Setting;
import me.wise.w1sehack.api.utils.SoundUtil;

public class HitSound
        extends Module {
    public Setting.mode sounds = this.registerMode("Sound", Arrays.asList("Neverlose", "Metallic", "Hit"), "Neverlose");

    public HitSound() {
        super("HitSound", Module.Category.Misc);
    }

    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
    }

    @SubscribeEvent
    public void onAttackEntity(AttackEntityEvent event) {
        if (!event.getEntity().equals((Object)this.mc.player)) {
            return;
        }
        switch (this.sounds.getValue()) {
            case "Neverlose": {
                SoundUtil.playSound(SoundUtil.INSTANCE.neverlose);
                break;
            }
            case "Metallic": {
                SoundUtil.playSound(SoundUtil.INSTANCE.metallic);
                break;
            }
            case "Hit": {
                SoundUtil.playSound(SoundUtil.INSTANCE.hitsound);
            }
        }
    }
}

