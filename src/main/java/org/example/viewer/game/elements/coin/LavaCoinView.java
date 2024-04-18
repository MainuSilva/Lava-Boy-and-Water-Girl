package org.example.viewer.game.elements.coin;

import org.example.gui.GUI;
import org.example.model.game.elements.coin.LavaCoins;
import org.example.viewer.game.elements.ElementView;

public class LavaCoinView implements ElementView<LavaCoins> {

    @Override
    public void draw(LavaCoins lavaCoin, GUI gui) { gui.drawLavaCoin(lavaCoin.getPosition());}

}
