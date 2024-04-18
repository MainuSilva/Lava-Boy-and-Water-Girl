package org.example.viewer.game.elements.monster;

import org.example.gui.GUI;
import org.example.model.game.elements.monster.WaterMonster;
import org.example.viewer.game.elements.ElementView;

public class WaterMonsterView implements ElementView<WaterMonster> {
    @Override
    public void draw(WaterMonster waterMonster, GUI gui) { gui.drawWaterMonster(waterMonster.getPosition());}
}
