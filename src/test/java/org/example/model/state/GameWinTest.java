package org.example.model.state;

import org.example.model.score.Score;
import org.example.model.score.ScoreList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameWinTest{

    GameWin gameWinTest;

    @Test
    void checkStarsNumber() throws IOException {
        gameWinTest = new GameWin(20, 1);
        assertEquals(2, gameWinTest.getStars());

        gameWinTest = new GameWin(20, 0);
        assertEquals(3, gameWinTest.getStars());

        gameWinTest = new GameWin(100, 0);
        assertEquals(2, gameWinTest.getStars());

        gameWinTest = new GameWin(100, 3);
        assertEquals(1, gameWinTest.getStars());
    }
}
