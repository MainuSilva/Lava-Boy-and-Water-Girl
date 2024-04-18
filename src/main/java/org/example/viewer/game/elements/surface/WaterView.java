package org.example.viewer.game.elements.surface;

import org.example.gui.GUI;
import org.example.model.game.elements.surface.Water;
import org.example.viewer.game.elements.ElementView;

public class WaterView implements ElementView<Water> {
    @Override
    public void draw(Water water, GUI gui) {
        gui.drawWater(water.getPosition());
    }
}
