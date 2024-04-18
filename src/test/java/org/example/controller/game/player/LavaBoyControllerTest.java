package org.example.controller.game.player;

import org.example.Game;
import org.example.controller.game.player.LavaBoyController;
import org.example.gui.KeyHandler;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.WaterMonster;
import org.example.model.game.elements.player.LavaBoy;
import org.example.model.game.elements.player.WaterGirl;
import org.example.model.game.elements.power.LavaPower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LavaBoyControllerTest {

    Game game;
    KeyHandler keyH;
    Arena arena;
    LavaBoyController controller;
    LavaBoy lavaBoy;
    WaterGirl waterGirl;

    @BeforeEach
    void setUp(){
        game = mock(Game.class);
        keyH = mock(KeyHandler.class);
        arena = mock(Arena.class);
        controller = spy(new LavaBoyController(arena));

        lavaBoy = mock(LavaBoy.class);
        when(arena.getLavaBoy()).thenReturn(lavaBoy);
        when(arena.getLavaBoy().getPosition()).thenReturn(new Position(1, 1));

        waterGirl = mock(WaterGirl.class);
        when(arena.getWaterGirl()).thenReturn(waterGirl);
        when(arena.getWaterGirl().getPosition()).thenReturn(new Position(0, 0));
    }

    @Test
    public void powerPlayerTest() {
        when(lavaBoy.isRight()).thenReturn(true);
        List<LavaPower> lavaPowers = new ArrayList<>();
        when(arena.getLavaPowers()).thenReturn(lavaPowers);

        controller.powerPlayer();

        assertEquals(1, lavaPowers.size());
        LavaPower lavaPower = lavaPowers.get(0);
        assertEquals(new Position(2, 1), lavaPower.getPosition());
        assertTrue(lavaPower.isRight);
    }

    @Test
    public void moveLavaBoyUpTest() {
        keyH.p2Up = true;
        Position surfacePos = mock(Position.class);
        Position waterGirlPos = mock(Position.class);
        when(arena.onSurface(surfacePos)).thenReturn(true);
        when(arena.onSurface(waterGirlPos)).thenReturn(false);
        when(waterGirlPos.getDown()).thenReturn(surfacePos);
        when(arena.getLavaBoy()).thenReturn(lavaBoy);
        when(lavaBoy.getPosition()).thenReturn(surfacePos).thenReturn(waterGirlPos);

        controller.step(game, keyH);
        controller.step(game, keyH);

        verify(controller, times(2)).movePlayerUp(lavaBoy);
        verify(game, times(1)).playSE(4);
    }

    @Test
    public void moveLavaBoyRightTest() {
        keyH.p2Right = true;

        controller.step(game, keyH);

        verify(lavaBoy, times(1)).setRight(true);
        verify(controller, times(1)).movePlayerRight(lavaBoy);
    }

    @Test
    public void moveLavaBoyLeftTest() {
        keyH.p2Left = true;

        controller.step(game, keyH);

        verify(lavaBoy, times(1)).setRight(false);
        verify(controller, times(1)).movePlayerLeft(lavaBoy);
    }

    @Test
    public void lavaBoyPressedPower() {
        keyH.p2Power = true;
        controller.cooldown = 10;

        controller.step(game, keyH);

        verify(game, times(1)).playSE(9);
        verify(controller, times(1)).powerPlayer();
    }

    @Test
    public void retrieveLavaCoinTest() {
        Position lavaCoinPos = mock(Position.class);
        when(lavaBoy.getPosition()).thenReturn(lavaCoinPos);
        when(arena.retrieveLavaCoin(lavaCoinPos)).thenReturn(true);

        controller.step(game, keyH);

        verify(game, times(1)).playSE(3);
        verify(arena, times(1)).retrieveLavaCoin(lavaCoinPos);
    }

    @Test
    public void decreaseLifeTest() {
        WaterMonster waterMonster = mock(WaterMonster.class);

        Position pos = mock(Position.class);
        when(arena.getWaterMonsters()).thenReturn(Collections.singletonList(waterMonster));
        when(waterMonster.getPosition()).thenReturn(pos);
        when(lavaBoy.getPosition()).thenReturn(pos);
        lavaBoy.life = 1;

        // Call step() method
        controller.step(game, keyH);

        assertEquals(0, lavaBoy.life);
        verify(game, times(1)).playSE(7);
    }
}
