package me.wise.w1sehack.api.utils;

import java.io.InputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundUtil {
    public static final SoundUtil INSTANCE = new SoundUtil();
    public ResourceLocation kill1 = new ResourceLocation("audio/kill1.wav");
    public ResourceLocation kill2 = new ResourceLocation("audio/kill2.wav");
    public ResourceLocation kill3 = new ResourceLocation("audio/kill3.wav");
    public ResourceLocation metallic = new ResourceLocation("audio/metallic.wav");
    public ResourceLocation mission = new ResourceLocation("audio/mission.wav");
    public ResourceLocation neverlose = new ResourceLocation("audio/neverlose.wav");
    public ResourceLocation sitnndog = new ResourceLocation("audio/sitnndog.wav");
    public ResourceLocation ya = new ResourceLocation("audio/ya.wav");
    public ResourceLocation hitsound = new ResourceLocation("audio/hitsoundlol.wav");

    public static void playSound(ResourceLocation rl) {
        try {
            InputStream sound = Minecraft.getMinecraft().getResourceManager().getResource(rl).getInputStream();
            AudioStream as = new AudioStream(sound);
            AudioPlayer.player.start((InputStream)as);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
