/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.MathHelper
 */
package me.wise.w1sehack.impl.features.modules.client;

import java.awt.Color;

import me.wise.w1sehack.api.utils.color.ColorUtil;
import net.minecraft.util.math.MathHelper;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.module.Module;
import me.wise.w1sehack.api.value.Value;
import me.wise.w1sehack.api.value.builder.ValueBuilder;

public class HudColors
extends Module {
    Value<Boolean> step = new ValueBuilder().withDescriptor("Step").withValue(false).register(this);
    Value<Number> stepLength = new ValueBuilder().withDescriptor("Step Length").withValue(30).withRange(10, 130).register(this);
    Value<Number> stepSpeed = new ValueBuilder().withDescriptor("Step Speed").withValue(30).withRange(1, 130).register(this);
    Value<Color> mainColor = new ValueBuilder().withDescriptor("Main Color").withValue(new Color(148, 0, 211)).register(this);
    Value<Color> stepColor = new ValueBuilder().withDescriptor("Step Color").withValue(new Color(148, 0, 211)).register(this);
    static HudColors INSTANCE;

    public HudColors() {
        super("Hud Colors", Feature.Category.Client);
        INSTANCE = this;
    }

    public static Color getTextColor(int y) {
        if (HudColors.INSTANCE.step.getValue().booleanValue()) {
            double roundY = Math.sin(Math.toRadians((long)(y * HudColors.INSTANCE.stepLength.getValue().intValue()) + System.currentTimeMillis() / (long)HudColors.INSTANCE.stepSpeed.getValue().intValue()));
            roundY = Math.abs(roundY);
            return ColorUtil.interpolate((float)MathHelper.clamp((double)roundY, (double)0.0, (double)1.0), HudColors.INSTANCE.mainColor.getValue(), HudColors.INSTANCE.stepColor.getValue());
        }
        return HudColors.INSTANCE.mainColor.getValue();
    }
}

