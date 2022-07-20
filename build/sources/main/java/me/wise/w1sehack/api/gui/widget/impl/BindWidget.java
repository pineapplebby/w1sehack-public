/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.api.gui.widget.impl;

import me.wise.w1sehack.api.gui.component.IComponent;
import me.wise.w1sehack.api.gui.context.Context;
import me.wise.w1sehack.api.gui.helpers.MouseHelper;
import me.wise.w1sehack.api.gui.helpers.Rect;
import me.wise.w1sehack.api.gui.widget.IWidget;
import me.wise.w1sehack.api.value.custom.Bind;

public class BindWidget
implements IWidget<Bind>,
        IComponent {
    Bind value;
    String title;
    Rect dims;
    boolean binding;

    public BindWidget(String title, Bind value) {
        this.title = title;
        this.value = value;
        this.dims = new Rect(0, 0, 0, 0);
    }

    @Override
    public Bind getValue() {
        return this.value;
    }

    @Override
    public void setValue(Bind value) {
        this.value = value;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Rect getDisplayDims() {
        return this.dims;
    }

    @Override
    public void draw(Context context, MouseHelper mouse) {
        this.getDims().setHeight(context.getMetrics().getButtonHeight());
        context.getRenderer().renderBindWidget(this, context, this.getDisplayDims(), mouse);
    }

    @Override
    public void click(Context context, MouseHelper mouse, int button) {
        if (this.getDims().collideWithMouse(mouse)) {
            if (button == 0) {
                this.binding = true;
            }
            if (button == 1) {
                this.getValue().setKey(-1);
            }
        }
    }

    @Override
    public void release(Context context, MouseHelper mouse, int state) {
    }

    @Override
    public void key(Context context, int key, char character) {
        if (this.binding) {
            if (key != 1) {
                this.getValue().setKey(key);
            }
            this.binding = false;
        }
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public Rect getDims() {
        return this.dims;
    }

    @Override
    public boolean isDraggable() {
        return false;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    public boolean isBinding() {
        return this.binding;
    }

    public void setBinding(boolean binding) {
        this.binding = binding;
    }
}

