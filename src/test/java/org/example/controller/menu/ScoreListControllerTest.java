package org.example.controller.menu;

import org.example.Game;
import org.example.controller.menu.ScoreListController;
import org.example.gui.KeyHandler;
import org.example.model.score.ScoreList;
import org.example.state.MenuState;
import org.example.state.ScoreListState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ScoreListControllerTest {

    Game game;
    KeyHandler keyH;
    ScoreListController controller;
    ScoreList scoreList;
    ScoreListState state;

    @BeforeEach
    public void setUp() throws IOException, ClassNotFoundException {
        game = mock(Game.class);
        scoreList = mock(ScoreList.class);
        keyH = mock(KeyHandler.class);
        state = new ScoreListState(scoreList);
        controller = new ScoreListController(scoreList);
        controller.actionLockCounter = 2;
    }

    @Test
    public void actionLockCounterTest() throws IOException, ClassNotFoundException {
        controller.step(game, keyH);
        assertEquals(0, controller.actionLockCounter);

        controller.step(game, keyH);
        assertEquals(1, controller.actionLockCounter);
    }

    @Test
    public void exitTest() throws IOException, ClassNotFoundException {
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).setState(any(MenuState.class));
    }


}
