/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.api.gui.component;

import me.wise.w1sehack.api.gui.context.Context;
import me.wise.w1sehack.api.gui.helpers.MouseHelper;
import me.wise.w1sehack.api.gui.helpers.Rect;

public interface IComponent {
    public void draw(Context var1, MouseHelper var2);

    public void click(Context var1, MouseHelper var2, int var3);

    public void release(Context var1, MouseHelper var2, int var3);

    public void key(Context var1, int var2, char var3);

    public int getLevel();

    public Rect getDims();

    public boolean isDraggable();

    public boolean isActive();
}

