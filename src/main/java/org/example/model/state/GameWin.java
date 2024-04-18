package org.example.model.state;
import org.example.model.SelectClass;
import org.example.model.score.Score;
import org.example.model.score.ScoreList;
import org.example.model.score.ScoreSave;

import java.io.IOException;
import java.util.Arrays;

public class GameWin extends SelectClass {
    private final double playTime;
    private final int coinsLeft;
    private final int maxTime = 70;
    private int stars = 1; //one default star

    public GameWin(double playTime, int coinsLeft) throws IOException {
        this.playTime = playTime;
        this.coinsLeft = coinsLeft;
        setButtons(Arrays.asList(
                "PLAY AGAIN",
                "BACK TO MENU"));
    }

    public boolean isSelectedPlayAgain() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public int getCoinsLeft() { return this.coinsLeft;}

    public double getPlayTime() { return this.playTime;}

    public int getMaxTime() { return this.maxTime; }

    public int getStars(){
        if (coinsLeft == 0 && playTime < maxTime)
            stars = 3;
        else if (coinsLeft == 0)
            stars = 2;
        else if(playTime < maxTime)
            stars = 2;

        return stars;
    }

    //SAVE SCORE
    public void saveScores() throws IOException{
        ScoreList scoreList = new ScoreList();
        scoreList.loadScores();
        scoreList.addScore(new Score(playTime, getStars()));
        new ScoreSave().writeInFile(scoreList);
    }
}
