/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl.gui.components.value;

import me.wise.w1sehack.api.gui.context.Context;
import me.wise.w1sehack.api.gui.helpers.MouseHelper;
import me.wise.w1sehack.api.gui.helpers.Rect;
import me.wise.w1sehack.api.gui.widget.impl.BooleanWidget;
import me.wise.w1sehack.api.value.Value;

public class BooleanComponent
extends BooleanWidget {
    Value<Boolean> value;

    public BooleanComponent(Value<Boolean> booleanValue) {
        super(booleanValue.getName(), new Rect(0, 0, 0, 0));
        this.value = booleanValue;
    }

    @Override
    public void draw(Context context, MouseHelper mouse) {
        this.setValue(this.value.getValue());
        super.draw(context, mouse);
    }

    @Override
    public void setValue(Boolean value) {
        super.setValue(value);
        this.value.setValue(value);
    }

    @Override
    public boolean isActive() {
        return this.value.isActive();
    }
}

