package org.example.controller.state;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.state.GameWin;
import org.example.state.GameState;
import org.example.state.GameWinState;
import org.example.state.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameWinControllerTest {
    Game game;
    KeyHandler keyH;
    GameWinController controller;
    GameWin win;
    GameWinState state;

    @BeforeEach
    public void setUp() throws IOException, ClassNotFoundException {
        game = mock(Game.class);
        win = mock(GameWin.class);
        keyH = mock(KeyHandler.class);
        state = new GameWinState(win);
        controller = new GameWinController(win);
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
    public void upTest() throws IOException, ClassNotFoundException {
        keyH.up = true;
        controller.step(game, keyH);
        verify(win, times(1)).previousEntry();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void downTest() throws IOException, ClassNotFoundException {
        keyH.down = true;
        controller.step(game, keyH);
        verify(win, times(1)).nextEntry();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void exitStateTest() throws IOException, ClassNotFoundException {
        Mockito.when(win.isSelectedExit()).thenReturn(true);
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).stopSE();
        verify(game, times(1)).setState(Mockito.any(MenuState.class));
        verify(game, times(1)).playMusic(11);
    }

    @Test
    public void playAgaintateTest() throws IOException, ClassNotFoundException {
        Mockito.when(win.isSelectedPlayAgain()).thenReturn(true);
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).stopSE();
        verify(game, times(1)).setState(Mockito.any(GameState.class));
        verify(game, times(1)).playMusic(0);
    }
}
