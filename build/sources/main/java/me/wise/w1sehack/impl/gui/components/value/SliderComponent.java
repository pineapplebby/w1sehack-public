/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl.gui.components.value;

import me.wise.w1sehack.api.gui.context.Context;
import me.wise.w1sehack.api.gui.helpers.MouseHelper;
import me.wise.w1sehack.api.gui.widget.impl.SliderWidget;
import me.wise.w1sehack.api.value.Value;

public class SliderComponent
extends SliderWidget {
    Value<Number> val;

    public SliderComponent(Value<Number> value) {
        super(value.getName(), value.getValue(), value.getMin(), value.getMax());
        this.val = value;
    }

    @Override
    public void draw(Context context, MouseHelper mouse) {
        super.draw(context, mouse);
        this.setValue(this.val.getValue());
        this.min = this.val.getMin();
        this.max = this.val.getMax();
    }

    @Override
    public void setValue(Number value) {
        super.setValue(value);
        this.val.setValue(value);
    }

    @Override
    public boolean isActive() {
        return this.val.isActive();
    }
}

