/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.api.gui.helpers;

public interface IDraggable {
    default public void drag(Rect dims, int dragX, int dragY, MouseHelper mouse) {
        dims.setX(mouse.getX() - dragX);
        dims.setY(mouse.getY() - dragY);
    }
}

