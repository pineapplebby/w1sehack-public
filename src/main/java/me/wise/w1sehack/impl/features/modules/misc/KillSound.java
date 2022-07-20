package wtf.cattyn.woo.client.modules.misc;

import java.util.Arrays;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import me.wise.w1sehack.api.event.UpdateEvent;
import me.wise.w1sehack.api.feature.module.Module;
import me.wise.w1sehack.api.feature.setting.Setting;
import me.wise.w1sehack.api.utils.SoundUtil;

public class KillSound
        extends Module {
    private static EntityPlayer currentTarget;
    public Setting.mode sounds = this.registerMode("Sound", Arrays.asList("Neverlose", "Anime", "Metallic", "Girl1", "Girl2", "Girl3", "NNdog"), "Neverlose");

    public KillSound() {
        super("KillSound", Module.Category.Misc);
    }

    @SubscribeEvent
    public void onUpdate(UpdateEvent event) {
        if (this.nullCheck()) {
            return;
        }
        if (currentTarget != null && this.mc.player.getDistanceSq((Entity)currentTarget) < 100.0 && (KillSound.currentTarget.isDead || currentTarget.getHealth() <= 0.0f)) {
            switch (this.sounds.getValue()) {
                case "Neverlose": {
                    SoundUtil.playSound(SoundUtil.INSTANCE.neverlose);
                    break;
                }
                case "Metallic": {
                    SoundUtil.playSound(SoundUtil.INSTANCE.metallic);
                    break;
                }
                case "Anime": {
                    SoundUtil.playSound(SoundUtil.INSTANCE.ya);
                    break;
                }
                case "Mission": {
                    SoundUtil.playSound(SoundUtil.INSTANCE.mission);
                    break;
                }
                case "Girl1": {
                    SoundUtil.playSound(SoundUtil.INSTANCE.kill1);
                    break;
                }
                case "Girl2": {
                    SoundUtil.playSound(SoundUtil.INSTANCE.kill2);
                    break;
                }
                case "Girl3": {
                    SoundUtil.playSound(SoundUtil.INSTANCE.kill3);
                    break;
                }
                case "NNdog": {
                    SoundUtil.playSound(SoundUtil.INSTANCE.sitnndog);
                }
            }
            currentTarget = null;
        }
    }

    public static void setCurrentTarget(EntityPlayer player) {
        currentTarget = player;
    }
}
