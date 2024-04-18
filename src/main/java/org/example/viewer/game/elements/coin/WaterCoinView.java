package org.example.viewer.game.elements.coin;

import org.example.gui.GUI;
import org.example.model.game.elements.coin.WaterCoins;
import org.example.viewer.game.elements.ElementView;

public class WaterCoinView implements ElementView<WaterCoins> {

    @Override
    public void draw(WaterCoins waterCoin, GUI gui) { gui.drawWaterCoin(waterCoin.getPosition());}

}
