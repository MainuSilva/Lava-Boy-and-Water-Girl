package org.example.viewer.game.elements.surface;

import org.example.gui.GUI;
import org.example.model.game.elements.surface.Button;
import org.example.viewer.game.elements.ElementView;

public class ButtonView implements ElementView<Button> {
    @Override
    public void draw(Button button, GUI gui) {
        gui.drawButton(button.getPosition());
    }
}

