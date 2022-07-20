/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl.gui;

import me.wise.w1sehack.api.gui.GUI;
import me.wise.w1sehack.api.gui.context.Context;
import me.wise.w1sehack.api.gui.helpers.Rect;
import me.wise.w1sehack.impl.features.modules.client.gui.ClickGuiModule;
import me.wise.w1sehack.impl.gui.components.CategoryFrame;
import me.wise.w1sehack.impl.gui.renderer.Renderer;
import me.wise.w1sehack.api.feature.Feature;

public class ClickGui
        extends GUI {
    public static Context CONTEXT = new Context(ClickGuiModule.INSTANCE, ClickGuiModule.INSTANCE, new Renderer());
    public static ClickGui INSTANCE;

    public ClickGui() {
        super(CONTEXT);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        int offset = 100;
        for (Feature.Category category : Feature.Category.values()) {
            this.getContext().getComponents().add(new CategoryFrame(category, new Rect(offset, 40, 100, 200)));
            offset += this.getContext().getMetrics().getFrameWidth() + 10;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}

