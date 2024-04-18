package org.example.model.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreListTest {
    ScoreList scoreListTest ;
    Score i1 = new Score(1, 1);
    Score i2 = new Score(2, 1);
    Score i3 = new Score(1, 2);
    Score i4 = new Score(2, 2);
    Score i5 = new Score(1, 3);
    Score i6 = new Score(2, 3);
    Score i7 = new Score(3, 3);

    Score i8 = new Score(3, 3);
    Score i9 = new Score(3, 3);
    Score i10 = new Score(3, 3);
    Score i11 = new Score(3, 3);

    @BeforeEach
    public void setScoreList(){
        scoreListTest = new ScoreList();
        ArrayList<Score> scoreList= new ArrayList<>();

        scoreList.add(i2);
        scoreList.add(i5);
        scoreList.add(i6);
        scoreList.add(i1);
        scoreList.add(i3);
        scoreList.add(i4);
        scoreList.add(i7);

        scoreListTest.setHighScores(scoreList);

    }

    @Test
    public void addScoreTest(){
        scoreListTest = new ScoreList();
        scoreListTest.addScore(i1);
        scoreListTest.addScore(i2);
        scoreListTest.addScore(i5);
        scoreListTest.addScore(i6);
        scoreListTest.addScore(i3);
        scoreListTest.addScore(i4);
        scoreListTest.addScore(i7);
        scoreListTest.addScore(i8);
        assertEquals(8, scoreListTest.getHighScores().size());
        scoreListTest.addScore(i9);
        scoreListTest.addScore(i10);
        assertEquals(10, scoreListTest.getHighScores().size());
        scoreListTest.addScore(i11);
        assertEquals(10, scoreListTest.getHighScores().size());
    }

    @Test
    public void sortedListTest(){
        scoreListTest.sortBestScores();
        assertEquals(3, scoreListTest.getHighScores().get(0).getStars());
        assertEquals(1, scoreListTest.getHighScores().get(0).getTime());

        assertEquals(1, scoreListTest.getHighScores().get(6).getStars());
        assertEquals(2, scoreListTest.getHighScores().get(6).getTime());
    }

}
