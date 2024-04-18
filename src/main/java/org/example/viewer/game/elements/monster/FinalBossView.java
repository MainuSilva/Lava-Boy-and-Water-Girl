package org.example.viewer.game.elements.monster;

import org.example.gui.GUI;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.viewer.game.elements.ElementView;

public class FinalBossView implements ElementView<FinalBoss> {

    @Override
    public void draw(FinalBoss finalBoss, GUI gui) { gui.drawFinalBoss(finalBoss.getPosition(), finalBoss.isRight());}
}
