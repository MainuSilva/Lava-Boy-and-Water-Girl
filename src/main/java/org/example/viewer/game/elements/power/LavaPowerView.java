package org.example.viewer.game.elements.power;

import org.example.gui.GUI;
import org.example.model.game.elements.power.LavaPower;
import org.example.viewer.game.elements.ElementView;

public class LavaPowerView implements ElementView<LavaPower> {

    @Override
    public void draw(LavaPower lavaPower, GUI gui) {gui.drawLavaPower(lavaPower.getPosition());}
}
