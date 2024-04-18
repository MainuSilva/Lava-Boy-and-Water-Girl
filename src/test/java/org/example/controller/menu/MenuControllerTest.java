package org.example.controller.menu;

import org.example.Game;
import org.example.controller.menu.MenuController;
import org.example.gui.KeyHandler;
import org.example.gui.Sound;
import org.example.model.menu.Menu;
import org.example.state.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuControllerTest {

    Game game;
    KeyHandler keyH;
    MenuController controller;
    Menu menu;
    MenuState state;

    @BeforeEach
    public void setUp() throws IOException, ClassNotFoundException {
        game = mock(Game.class);
        menu = mock(Menu.class);
        keyH = mock(KeyHandler.class);
        state = new MenuState(menu);
        controller = new MenuController(menu);
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
        verify(menu, times(1)).previousEntry();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void downTest() throws IOException, ClassNotFoundException {
        keyH.down = true;
        controller.step(game, keyH);
        verify(menu, times(1)).nextEntry();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void exitTest() throws IOException, ClassNotFoundException {
        Mockito.when(menu.isSelectedExit()).thenReturn(true);
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).setState(null);
    }

    @Test
    public void startTest() throws IOException, ClassNotFoundException {
        Mockito.when(menu.isSelectedStart()).thenReturn(true);
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).setState(Mockito.any(GameState.class));
        verify(game, times(1)).stopMusic();
        verify(game, times(1)).playMusic(0);
    }

    @Test
    public void scoreListTest() throws IOException, ClassNotFoundException {
        Mockito.when(menu.isSelectedHighScores()).thenReturn(true);
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).setState(Mockito.any(ScoreListState.class));
    }


    @Test
    void optionState() throws IOException, ClassNotFoundException {
        Sound music = Mockito.mock(Sound.class);
        Sound soundEffect = Mockito.mock(Sound.class);

        Mockito.when(game.getMusic()).thenReturn(music);
        Mockito.when(game.getSoundEffect()).thenReturn(soundEffect);
        Mockito.when(menu.isSelectedSettings()).thenReturn(true);

        keyH.enter = true;
        controller.step(game, keyH);

        Mockito.verify(game).setState(Mockito.any(OptionsState.class));
    }

    @Test
    public void instructionsState() throws IOException, ClassNotFoundException {
        Mockito.when(menu.isSelectedInstructions()).thenReturn(true);
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).setState(Mockito.any(InstructionState.class));
    }

}



