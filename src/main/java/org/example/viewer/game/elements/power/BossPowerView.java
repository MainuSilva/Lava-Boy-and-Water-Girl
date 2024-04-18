package org.example.viewer.game.elements.power;

import org.example.gui.GUI;
import org.example.model.game.elements.power.BossPower;
import org.example.viewer.game.elements.ElementView;

public class BossPowerView implements ElementView<BossPower> {

    @Override
    public void draw(BossPower bossPower, GUI gui) { gui.drawBossPower(bossPower.getPosition());}
}
