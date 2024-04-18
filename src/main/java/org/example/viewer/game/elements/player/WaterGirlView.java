package org.example.viewer.game.elements.player;

import org.example.gui.GUI;
import org.example.model.game.elements.player.WaterGirl;
import org.example.viewer.game.elements.ElementView;

public class WaterGirlView  implements ElementView<WaterGirl> {
    @Override
    public void draw(WaterGirl waterGirl, GUI gui) { gui.drawWaterGirl(waterGirl.getPosition(), waterGirl.isRight());}
}
