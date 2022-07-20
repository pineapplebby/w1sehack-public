/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl.features.modules.client;

import java.awt.Font;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.module.Module;
import me.wise.w1sehack.api.value.Value;
import me.wise.w1sehack.api.value.builder.ValueBuilder;

public class FontModule
extends Module {
    public static FontModule INSTANCE;
    public Font font = new Font("Verdana", 0, 18);
    public Value<Number> fontSize = new ValueBuilder().withDescriptor("Font Size").withValue(18).withRange(10, 25).register(this);
    public Value<Number> fontStyle = new ValueBuilder().withDescriptor("Font Style").withValue(0).withRange(0, 2).register(this);

    public FontModule() {
        super("Font", Feature.Category.Client);
        INSTANCE = this;

        this.font = this.font.deriveFont((fontStyle.getValue()).intValue());
    }
}

