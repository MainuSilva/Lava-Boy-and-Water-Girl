package org.example.viewer.game.elements.monster;

import org.example.gui.GUI;
import org.example.model.game.elements.monster.LavaMonster;
import org.example.viewer.game.elements.ElementView;

public class LavaMonsterView implements ElementView<LavaMonster> {
    @Override
    public void draw(LavaMonster lavaMonster, GUI gui) { gui.drawLavaMonster(lavaMonster.getPosition());}
}
