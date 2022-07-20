/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl.gui.components.module;

import java.awt.Color;

import me.wise.w1sehack.api.gui.component.IComponent;
import me.wise.w1sehack.api.gui.context.Context;
import me.wise.w1sehack.api.gui.flow.Flow;
import me.wise.w1sehack.api.gui.flow.impl.LinearFlow;
import me.wise.w1sehack.api.gui.helpers.MouseHelper;
import me.wise.w1sehack.api.gui.helpers.Rect;
import me.wise.w1sehack.api.gui.widget.impl.BindWidget;
import me.wise.w1sehack.api.gui.widget.impl.BooleanWidget;
import me.wise.w1sehack.impl.gui.components.value.StringComponent;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.feature.module.Module;
import me.wise.w1sehack.api.value.Value;
import me.wise.w1sehack.impl.gui.components.value.BooleanComponent;
import me.wise.w1sehack.impl.gui.components.value.ColorComponent;
import me.wise.w1sehack.impl.gui.components.value.ComboBoxComponent;
import me.wise.w1sehack.impl.gui.components.value.SliderComponent;

public class FeatureButton
extends BooleanWidget {
    Feature feature;
    public boolean open;
    Rect header;
    public Flow flow;

    public FeatureButton(Feature feature, Rect dims) {
        super(feature.getName(), dims);
        this.feature = feature;
        this.open = false;
        this.header = new Rect(0, 0, 0, 0);
        this.flow = new LinearFlow(new Rect(0, 0, 0, 0), 2);
        if (feature instanceof Module) {
            this.flow.getComponents().add(new BindWidget("Module Bind", ((Module)feature).getBind()));
        }
        for (Value<?> value : feature.getValues()) {
            IComponent component = value.getComponent();
            if (component == null) {
                if (value.getValue() instanceof Boolean) {
                    this.flow.getComponents().add(new BooleanComponent((Value<Boolean>) value));
                }
                if (value.getValue() instanceof String) {
                    if (value.getModes() != null) {
                        this.flow.getComponents().add(new ComboBoxComponent((Value<String>) value));
                    } else {
                        this.flow.getComponents().add(new StringComponent((Value<String>) value));
                    }
                }
                if (value.getValue() instanceof Number) {
                    this.flow.getComponents().add(new SliderComponent((Value<Number>) value));
                }
                if (!(value.getValue() instanceof Color)) continue;
                this.flow.getComponents().add(new ColorComponent((Value<Color>) value));
                continue;
            }
            this.flow.getComponents().add(component);
        }
    }

    @Override
    public void draw(Context context, MouseHelper mouse) {
        this.setValue(this.feature.isEnabled());
        this.header.setX(this.getDims().getX());
        this.header.setY(this.getDims().getY());
        this.header.setWidth(this.getDims().getWidth());
        this.header.setHeight(context.getMetrics().getButtonHeight());
        this.flow.getDims().setX(this.getDims().getX() + context.getMetrics().getSpacing());
        this.flow.getDims().setY(this.getDims().getY() + this.header.getHeight() + context.getMetrics().getBetweenSpacing());
        this.flow.getDims().setWidth(this.getDims().getWidth() - context.getMetrics().getSpacing() * 2);
        this.flow.positionComponents(context);
        this.getDims().setHeight(context.getMetrics().getButtonHeight());
        if (this.open) {
            this.getDims().setHeight(this.header.getHeight() + this.flow.getDims().getHeight());
        }
        context.getRenderer().renderFeatureButton(this, context, this.getDisplayDims(), mouse);
        if (this.open) {
            this.flow.draw(context, mouse);
        }
    }

    @Override
    public void click(Context context, MouseHelper mouse, int button) {
        super.click(context, mouse, button);
        if (this.getDisplayDims().collideWithMouse(mouse)) {
            if (button == 0) {
                this.feature.setEnabled(this.getValue());
            }
            if (button == 1) {
                boolean bl = this.open = !this.open;
            }
        }
        if (this.open) {
            this.flow.click(context, mouse, button);
        }
    }

    @Override
    public void release(Context context, MouseHelper mouse, int state) {
        super.release(context, mouse, state);
        if (this.open) {
            this.flow.release(context, mouse, state);
        }
    }

    @Override
    public void key(Context context, int key, char character) {
        super.key(context, key, character);
        if (this.open) {
            this.flow.key(context, key, character);
        }
    }

    @Override
    public Rect getDims() {
        return super.getDims();
    }

    @Override
    public Rect getDisplayDims() {
        return this.header;
    }
}

