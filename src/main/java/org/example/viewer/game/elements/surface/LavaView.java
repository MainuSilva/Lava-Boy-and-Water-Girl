package org.example.viewer.game.elements.surface;

import org.example.gui.GUI;
import org.example.model.game.elements.surface.Lava;
import org.example.viewer.game.elements.ElementView;

public class LavaView  implements ElementView<Lava> {
    @Override
    public void draw(Lava lava, GUI gui) {
        gui.drawLava(lava.getPosition());
    }
}
