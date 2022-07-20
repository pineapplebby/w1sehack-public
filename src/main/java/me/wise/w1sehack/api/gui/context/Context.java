/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 */
package me.wise.w1sehack.api.gui.context;

import java.util.ArrayList;
import java.util.List;

import me.wise.w1sehack.api.gui.component.IComponent;
import me.wise.w1sehack.api.gui.helpers.MouseHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import me.wise.w1sehack.api.gui.render.IRenderer;
import me.wise.w1sehack.api.gui.theme.IColorScheme;
import me.wise.w1sehack.api.gui.theme.IMetrics;

public class Context {
    List<IComponent> components = new ArrayList<IComponent>();
    IColorScheme colorScheme;
    IMetrics metrics;
    IRenderer renderer;
    float partialTicks = 0.0f;

    public Context(IColorScheme colorScheme, IMetrics metrics, IRenderer renderer) {
        this.colorScheme = colorScheme;
        this.metrics = metrics;
        this.renderer = renderer;
    }

    public List<IComponent> getComponents() {
        return this.components;
    }

    public IColorScheme getColorScheme() {
        return this.colorScheme;
    }

    public IMetrics getMetrics() {
        return this.metrics;
    }

    public void setComponents(List<IComponent> components) {
        this.components = components;
    }

    public void setColorScheme(IColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }

    public void setMetrics(IMetrics metrics) {
        this.metrics = metrics;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IRenderer renderer) {
        this.renderer = renderer;
    }

    public float getPartialTicks() {
        return this.partialTicks;
    }

    public void setPartialTicks(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public IComponent getHovering(MouseHelper mouseHelper) {
        IComponent hovering = null;
        for (IComponent component : this.getComponents()) {
            if (!component.getDims().collideWithMouse(mouseHelper)) continue;
            hovering = component;
        }
        return hovering;
    }

    public ScaledResolution getScaledResolution() {
        return new ScaledResolution(Minecraft.getMinecraft());
    }
}

