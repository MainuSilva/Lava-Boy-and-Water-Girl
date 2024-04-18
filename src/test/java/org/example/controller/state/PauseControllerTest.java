package org.example.controller.state;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.state.GamePause;
import org.example.state.GameState;
import org.example.state.MenuState;
import org.example.state.PauseState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PauseControllerTest {

    Game game;
    KeyHandler keyH;
    PauseController controller;
    GamePause pause;
    PauseState state;

    @BeforeEach
    public void setUp() throws IOException, ClassNotFoundException {
        game = mock(Game.class);
        pause = mock(GamePause.class);
        keyH = mock(KeyHandler.class);
        state = new PauseState(pause);
        controller = new PauseController(pause);
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
        verify(pause, times(1)).previousEntry();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void downTest() throws IOException, ClassNotFoundException {
        keyH.down = true;
        controller.step(game, keyH);
        verify(pause, times(1)).nextEntry();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void continueStateTest() throws IOException, ClassNotFoundException {
        Mockito.when(pause.isSelectedContinue()).thenReturn(true);
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).setState(Mockito.any(GameState.class));
        verify(game, times(1)).playMusic(0);
    }

    @Test
    public void tryAgainStateTest() throws IOException, ClassNotFoundException {
        Mockito.when(pause.isSelectedTryAgain()).thenReturn(true);
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).setState(Mockito.any(GameState.class));
        verify(game, times(1)).playMusic(0);
    }

    @Test
    public void backStateTest() throws IOException, ClassNotFoundException {
        Mockito.when(pause.isSelectedBack()).thenReturn(true);
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).setState(Mockito.any(MenuState.class));
        verify(game, times(1)).playMusic(11);
    }


}
