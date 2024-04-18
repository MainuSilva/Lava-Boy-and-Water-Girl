package org.example.viewer.game.elements.surface;

import org.example.gui.GUI;
import org.example.model.game.elements.surface.Wall;
import org.example.viewer.game.elements.ElementView;

public class WallsView implements ElementView<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
