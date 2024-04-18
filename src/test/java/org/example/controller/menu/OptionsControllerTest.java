package org.example.controller.menu;

import org.example.Game;
import org.example.controller.menu.OptionsController;
import org.example.gui.KeyHandler;
import org.example.gui.Sound;
import org.example.model.menu.Options;
import org.example.state.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OptionsControllerTest {

    Game game;
    KeyHandler keyH;
    Sound music;
    Sound soundEffect;
    OptionsController controller;
    Options options;
    OptionsState state;

    @BeforeEach
    public void setUp() throws IOException, ClassNotFoundException {
        game = mock(Game.class);
        options = mock(Options.class);
        music = mock(Sound.class);
        when(game.getMusic()).thenReturn(music);
        soundEffect = mock(Sound.class);
        when(game.getSoundEffect()).thenReturn(soundEffect);
        keyH = mock(KeyHandler.class);
        state = new OptionsState(options);
        controller = new OptionsController(options);
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
        verify(options, times(1)).previousEntry();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void downTest() throws IOException, ClassNotFoundException {
        keyH.down = true;
        controller.step(game, keyH);
        verify(options, times(1)).nextEntry();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void backStateTest() throws IOException, ClassNotFoundException {
        Mockito.when(options.isSelectedBack()).thenReturn(true);
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).setState(any(MenuState.class));
    }

    @Test
    public void decreaseMusicVolumeTest() throws IOException, ClassNotFoundException {
        game.getMusic().volumeScale = 1;
        options.musicVolume = 1;
        keyH.left = true;
        Mockito.when(options.isSelectedMusic()).thenReturn(true);

        controller.step(game, keyH);

        assertEquals(0, game.getMusic().volumeScale);
        assertEquals(0, options.musicVolume);
        verify(music, times(1)).checkVolume();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void decreaseSEVolumeTest() throws IOException, ClassNotFoundException {
        game.getSoundEffect().volumeScale = 1;
        options.seVolume = 1;
        keyH.left = true;
        Mockito.when(options.isSelectedSE()).thenReturn(true);

        controller.step(game, keyH);

        assertEquals(0, game.getSoundEffect().volumeScale);
        assertEquals(0, options.seVolume);
        verify(soundEffect, times(1)).checkVolume();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void increaseMusicVolumeTest() throws IOException, ClassNotFoundException {
        game.getMusic().volumeScale = 4;
        options.musicVolume = 4;
        keyH.right = true;
        Mockito.when(options.isSelectedMusic()).thenReturn(true);

        controller.step(game, keyH);

        assertEquals(5, game.getMusic().volumeScale);
        assertEquals(5, options.musicVolume);
        verify(music, times(1)).checkVolume();
        verify(game, times(1)).playSE(10);
    }

    @Test
    public void increaseSEVolumeTest() throws IOException, ClassNotFoundException {
        game.getSoundEffect().volumeScale = 4;
        options.seVolume = 4;
        keyH.right = true;
        Mockito.when(options.isSelectedSE()).thenReturn(true);

        controller.step(game, keyH);

        assertEquals(5, game.getSoundEffect().volumeScale);
        assertEquals(5, options.seVolume);
        verify(soundEffect, times(1)).checkVolume();
        verify(game, times(1)).playSE(10);
    }


    @Test
    public void limitsMusicVolumeTest() throws IOException, ClassNotFoundException {
        game.getMusic().volumeScale = 5;
        keyH.right = true;
        Mockito.when(options.isSelectedMusic()).thenReturn(true);

        controller.step(game, keyH);

        assertEquals(5, game.getMusic().volumeScale);

        keyH.right = false;

        game.getMusic().volumeScale = 0;
        keyH.left = true;
        Mockito.when(options.isSelectedMusic()).thenReturn(true);

        controller.step(game, keyH);

        assertEquals(0, game.getMusic().volumeScale);
    }

    @Test
    public void limitsSEVolumeTest() throws IOException, ClassNotFoundException {
        game.getSoundEffect().volumeScale = 5;
        keyH.right = true;
        Mockito.when(options.isSelectedSE()).thenReturn(true);

        controller.step(game, keyH);

        assertEquals(5, game.getSoundEffect().volumeScale);

        keyH.right = false;

        game.getSoundEffect().volumeScale = 0;
        keyH.left = true;
        Mockito.when(options.isSelectedSE()).thenReturn(true);

        controller.step(game, keyH);

        assertEquals(0, game.getSoundEffect().volumeScale);
    }



}
