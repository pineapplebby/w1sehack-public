/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl.gui.components.value;

import me.wise.w1sehack.api.gui.helpers.Rect;
import me.wise.w1sehack.api.gui.widget.impl.TextEntryWidget;
import me.wise.w1sehack.api.value.Value;

public class StringComponent
extends TextEntryWidget {
    Value<String> stringValue;

    public StringComponent(Value<String> stringValue) {
        super(new Rect(0, 0, 0, 0), stringValue.getValue());
        this.stringValue = stringValue;
    }

    @Override
    public String getValue() {
        return this.stringValue.getValue();
    }

    @Override
    public void setValue(String value) {
        this.stringValue.setValue(value);
        super.setValue(value);
    }

    @Override
    public boolean isActive() {
        return this.stringValue.isActive();
    }
}

