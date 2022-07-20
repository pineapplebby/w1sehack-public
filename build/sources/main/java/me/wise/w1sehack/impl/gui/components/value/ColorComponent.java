/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl.gui.components.value;

import java.awt.Color;

import me.wise.w1sehack.api.gui.helpers.Rect;
import me.wise.w1sehack.api.gui.widget.impl.ColorWidget;
import me.wise.w1sehack.api.value.Value;

public class ColorComponent
extends ColorWidget {
    Value<Color> colorValue;

    public ColorComponent(Value<Color> colorValue) {
        super(colorValue.getName(), colorValue.getValue(), new Rect(0, 0, 0, 0));
        this.colorValue = colorValue;
    }

    @Override
    public Color getValue() {
        return this.colorValue.getValue();
    }

    @Override
    public void setValue(Color value) {
        this.colorValue.setValue(value);
    }

    @Override
    public boolean isActive() {
        return this.colorValue.isActive();
    }
}

