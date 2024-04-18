package org.example.viewer.game.elements;

import org.example.gui.GUI;
import org.example.model.game.elements.time.Time;

public class TimeView implements ElementView<Time> {

    @Override
    public void draw(Time time, GUI gui) { gui.drawTime(time.getMinutes(), time.getSeconds());}
}
