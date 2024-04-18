package org.example.viewer.game.elements.door;

import org.example.gui.GUI;
import org.example.model.game.elements.door.LavaBoyDoor;
import org.example.viewer.game.elements.ElementView;

public class LavaBoyDoorView implements ElementView<LavaBoyDoor> {

    @Override
    public void draw(LavaBoyDoor lavaDoor, GUI gui) { gui.drawLavaDoor(lavaDoor.getPosition());}

}
