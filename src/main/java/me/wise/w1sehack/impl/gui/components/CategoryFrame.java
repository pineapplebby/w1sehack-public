/*
 * Decompiled with CFR 0.151.
 */
package me.wise.w1sehack.impl.gui.components;

import me.wise.w1sehack.api.gui.component.impl.FrameComponent;
import me.wise.w1sehack.api.gui.helpers.Rect;
import me.wise.w1sehack.impl.gui.components.module.FeatureButton;
import me.wise.w1sehack.api.feature.Feature;
import me.wise.w1sehack.api.management.FeatureManager;

public class CategoryFrame
extends FrameComponent {
    Feature.Category category;

    public CategoryFrame(Feature.Category category, Rect dims) {
        super(category.toString(), dims);
        this.category = category;
        for (Feature feature : FeatureManager.INSTANCE.getFeatures()) {
            if (feature.getCategory() != this.category) continue;
            this.getFlow().getComponents().add(new FeatureButton(feature, new Rect(0, 0, 0, 0)));
        }
    }

    public Feature.Category getCategory() {
        return this.category;
    }

    public void setCategory(Feature.Category category) {
        this.category = category;
    }
}

