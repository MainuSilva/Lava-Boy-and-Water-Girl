package org.example.viewer.game.elements.door;

import org.example.gui.GUI;
import org.example.model.game.elements.door.WaterGirlDoor;
import org.example.viewer.game.elements.ElementView;

public class WaterGirlDoorView implements ElementView<WaterGirlDoor> {

    @Override
    public void draw(WaterGirlDoor waterDoor, GUI gui) { gui.drawWaterDoor(waterDoor.getPosition());}

}
