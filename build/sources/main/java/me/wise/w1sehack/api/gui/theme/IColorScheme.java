/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.api.gui.theme;

import java.awt.Color;

public interface IColorScheme {
    public Color getMainColor(int var1);

    public Color getOutlineColor();

    public Color getButtonColor();

    public Color getBackgroundColor();

    public Color getSecondaryBackgroundColor();

    public Color getTertiaryBackgroundColor();

    public Color getTextColor();

    public Color getTextColorHighlight();

    public Color getTextColorActive();

    public boolean doesTextShadow();
}

