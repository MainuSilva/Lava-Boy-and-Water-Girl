package org.example.viewer.game.elements.power;

import org.example.gui.GUI;
import org.example.model.game.elements.power.WaterPower;
import org.example.viewer.game.elements.ElementView;

public class WaterPowerView implements ElementView<WaterPower> {

    @Override
    public void draw(WaterPower waterPower, GUI gui) {gui.drawWaterPower(waterPower.getPosition());}
}
