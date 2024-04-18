package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.score.ScoreList;
import org.example.viewer.View;

public class ScoreListView extends View<ScoreList> {

    public ScoreListView(ScoreList scoreList) {
        super(scoreList);
        getModel().loadScores();
    }

    @Override
    public void drawElements(GUI gui) {

        drawTitle(gui);

        drawHighScores(gui);

        gui.drawText(new Position(getCol(">"+ "BACK", gui.getWidth()), 22), ">" + "BACK","#FFD700" );

    }

    private void drawTitle(GUI gui){
        //TITLE
        String s1 = "     _     _  _  _  _  _ _ ";
        String s2 = "|_||| _|_||_ |  | ||_||_|_ ";
        String s3 = "| |||_|| | _||_ |_||/ |_ _|";

        gui.drawText(new Position(getCol(s1, gui.getWidth()), 2), s1, "#FFD700" );
        gui.drawText(new Position(getCol(s2, gui.getWidth()), 3) , s2, "#FFD700" );
        gui.drawText(new Position(getCol(s3, gui.getWidth()), 4 ) , s3, "#FFD700" );
    }

    private void drawHighScores(GUI gui){
        int center = getCol(" ", gui.getWidth());

        for(int i = 0; i < getModel().getHighScores().size(); i ++){

            //MINUTES : SECONDS
            String playtime = String.format("%02d", (int) getModel().getHighScores().get(i).getTime() / 60) + ":"
                    + String.format("%02d", (int) getModel().getHighScores().get(i).getTime() % 60);

            String scoreString = getModel().getHighScores().get(i).getFormatTimeStamp() + "          " + playtime;

            gui.drawText(new Position(getCol(scoreString, gui.getWidth()), 7), "     DAY     STARS   TIME", "#FF0000");


            if(i == 0) {
                gui.drawText(new Position(getCol(scoreString, gui.getWidth()) - 1, 9 + i), Integer.toString(i + 1) + "ST ","#FFD700"  );
                gui.drawText(new Position(getCol(scoreString, gui.getWidth()) + 3, 9 + i), scoreString, "#FFFFFF");
                gui.drawStarScore(new Position(center + 2, 9 + i ), getModel().getHighScores().get(i).getStars());
            }

            else if(i == 1){
                gui.drawText(new Position(getCol(scoreString, gui.getWidth()) - 1, 10 + i), Integer.toString(i + 1) + "ND ","#808080"  );
                gui.drawText(new Position(getCol(scoreString, gui.getWidth()) + 3, 10 + i), scoreString, "#FFFFFF");
                gui.drawStarScore(new Position(center + 2, 10 + i), getModel().getHighScores().get(i).getStars());
            }

            else if( i == 2){
                gui.drawText(new Position(getCol(scoreString, gui.getWidth()) - 1, 10 + i), Integer.toString(i + 1) + "RD ","#CD7F32"  );
                gui.drawText(new Position(getCol(scoreString, gui.getWidth()) + 3, 10 + i), scoreString, "#FFFFFF");
                gui.drawStarScore(new Position(center + 2, 10 + i), getModel().getHighScores().get(i).getStars());
            }

            else if(i == 9){
                gui.drawText(new Position(getCol(scoreString, gui.getWidth()) - 2, 11 + i), Integer.toString(i + 1) + "TH ","#FF0000"  );
                gui.drawText(new Position(getCol(scoreString, gui.getWidth()) + 3, 11 + i), scoreString, "#FFFFFF");
                gui.drawStarScore(new Position(center + 2, 11 + i), getModel().getHighScores().get(i).getStars());
            }

            else {
                gui.drawText(new Position(getCol(scoreString, gui.getWidth()) - 1, 11 + i), Integer.toString(i + 1) + "TH ","#FF0000"  );
                gui.drawText(new Position(getCol(scoreString, gui.getWidth()) + 3, 11 + i), scoreString, "#FFFFFF");
                gui.drawStarScore(new Position(center + 2, 11 + i), getModel().getHighScores().get(i).getStars());
            }
        }
    }
}
