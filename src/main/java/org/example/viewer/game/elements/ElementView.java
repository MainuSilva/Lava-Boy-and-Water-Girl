package org.example.viewer.game.elements;

import org.example.gui.GUI;
import org.example.model.game.elements.Element;

public interface ElementView <T extends Element>{

    void draw(T element, GUI gui);
}
