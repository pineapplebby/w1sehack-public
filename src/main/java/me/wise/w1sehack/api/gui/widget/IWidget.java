/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.api.gui.widget;

import me.wise.w1sehack.api.gui.helpers.Rect;

public interface IWidget<Type> {
    public Type getValue();

    public void setValue(Type var1);

    public String getTitle();

    public void setTitle(String var1);

    public Rect getDisplayDims();
}

