package me.wise.w1sehack.api.event;

import me.wise.w1sehack.api.event.EventStage;
import net.minecraft.entity.player.EntityPlayer;

public class DeathEvent
        extends EventStage {
    public EntityPlayer player;

    public DeathEvent(EntityPlayer player) {
        this.player = player;
    }
}
