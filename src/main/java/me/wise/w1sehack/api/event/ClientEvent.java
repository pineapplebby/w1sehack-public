package me.wise.w1sehack.api.event;

import me.wise.w1sehack.api.event.EventStage;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.setting.Setting;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class ClientEvent
        extends EventStage {
    private Feature feature;
    private Setting setting;

    public ClientEvent(int stage, Feature feature) {
        super(stage);
        this.feature = feature;
    }

    public ClientEvent(Setting setting) {
        super(2);
        this.setting = setting;
    }

    public Feature getFeature() {
        return this.feature;
    }

    public Setting getSetting() {
        return this.setting;
    }
}