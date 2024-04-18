package org.example.model.score;

import org.example.model.SelectClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreList extends SelectClass implements Serializable{
    private List<Score> highScores;

    public ScoreList(){
        highScores = new ArrayList<>();
    }

    public void setHighScores(List<Score> highScores) {
        this.highScores = highScores;
    }

    public List<Score> getHighScores(){
        return highScores;
    }

    public void addScore(Score score){
        highScores.add(score);
        sortBestScores();
    }

    public void sortBestScores(){
        highScores = highScores.stream().sorted(Comparator.comparing(Score::getStars, Comparator.reverseOrder()).
                        thenComparingDouble(Score::getTime))
                .limit(10)
                .collect(Collectors.toList());
    }

    //LOAD SCORES
    public void loadScores(){
        try{
            highScores = new ScoreRead().read().highScores;
        }

        catch(Exception e) {

        }
    }
}
