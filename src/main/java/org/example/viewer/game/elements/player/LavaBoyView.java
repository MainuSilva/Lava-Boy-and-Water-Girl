package org.example.viewer.game.elements.player;

import org.example.gui.GUI;
import org.example.model.game.elements.player.LavaBoy;
import org.example.viewer.game.elements.ElementView;

public class LavaBoyView implements ElementView<LavaBoy> {
    @Override
    public void draw(LavaBoy lavaBoy, GUI gui) { gui.drawLavaBoy(lavaBoy.getPosition(), lavaBoy.isRight());}
}
