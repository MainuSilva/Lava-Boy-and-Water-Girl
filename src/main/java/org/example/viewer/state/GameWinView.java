package org.example.viewer.state;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.state.GameWin;
import org.example.viewer.View;

public class GameWinView extends View<GameWin> {

    public GameWinView(GameWin gamewin) {super(gamewin);}

    @Override
    public void drawElements(GUI gui) {
        //TITLE
        drawTitle(gui);

        //STARS
        gui.drawStarScore(new Position(getCol(" ", gui.getWidth()) - 2, 9), getModel().getStars());

        //PROCESS
        drawProcess(gui);

        //OPTIONS
        for (int i = 0; i < getModel().getNumberEntries(); i++) {

            if (getModel().isSelected(i)) {
                gui.drawText(new Position(getCol(getModel().getEntry(i), gui.getWidth())-1, 18 + (i * 2)),  ">" + getModel().getEntry(i), "#FFD700" , "BLINK");
            }
            else
                gui.drawText(new Position(getCol(getModel().getEntry(i), gui.getWidth()), 18 + (i * 2)), getModel().getEntry(i), "#FFFFFF" );
        }
    }

    private void drawTitle(GUI gui){
        String s1 = "    _           _      |";
        String s2 = "|_|| || | |   || ||/ | |";
        String s3 = " | |_||_| |_|_||_|| /| o";

        gui.drawText(new Position(getCol(s1, gui.getWidth()), 2), s1, "#FFD700" );
        gui.drawText(new Position(getCol(s2, gui.getWidth()), 3) , s2, "#FFD700" );
        gui.drawText(new Position(getCol(s3, gui.getWidth()), 4 ) , s3, "#FFD700" );

    }

    private void drawProcess(GUI gui){
        int center = getCol(" ", gui.getWidth());

        //COINS
        gui.drawText(new Position(center - 2, 12), "o", "#FF0000");
        gui.drawText(new Position(center - 1, 12), "o", "#00FFFF");
        gui.drawText(new Position(center + 1, 12), (getModel().getCoinsLeft() == 0) ? "w" : "v",
                (getModel().getCoinsLeft() == 0) ? "#00FF00" : "#FF0000");

        //PLAYTIME
        gui.drawText(new Position(center - 1, 14), "q", "#f5f5dc");
        gui.drawText(new Position(center + 1, 14), (getModel().getPlayTime() < getModel().getMaxTime()) ? "w" : "v",
                (getModel().getPlayTime() < getModel().getMaxTime()) ? "#00FF00" : "#FF0000");

    }

}