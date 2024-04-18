package org.example.controller.game.player;

import org.example.Game;
import org.example.controller.game.player.WaterGirlController;
import org.example.gui.KeyHandler;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.LavaMonster;
import org.example.model.game.elements.player.LavaBoy;
import org.example.model.game.elements.player.WaterGirl;
import org.example.model.game.elements.power.WaterPower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WaterGirlControllerTest {
    Game game;
    KeyHandler keyH;
    Arena arena;
    WaterGirlController controller;
    WaterGirl waterGirl;
    LavaBoy lavaBoy;

    @BeforeEach
    void setUp(){
        game = mock(Game.class);
        keyH = mock(KeyHandler.class);
        arena = mock(Arena.class);
        controller = spy(new WaterGirlController(arena));

        waterGirl = mock(WaterGirl.class);
        when(arena.getWaterGirl()).thenReturn(waterGirl);
        when(arena.getWaterGirl().getPosition()).thenReturn(new Position(1, 1));

        lavaBoy = mock(LavaBoy.class);
        when(arena.getLavaBoy()).thenReturn(lavaBoy);
        when(arena.getLavaBoy().getPosition()).thenReturn(new Position(0, 0));
    }

    @Test
    public void powerPlayerTest() {
        when(waterGirl.isRight()).thenReturn(true);
        List<WaterPower> waterPowers = new ArrayList<>();
        when(arena.getWaterPowers()).thenReturn(waterPowers);

        controller.powerPlayer();

        assertEquals(1, waterPowers.size());
        WaterPower waterPower = waterPowers.get(0);
        assertEquals(new Position(2, 1), waterPower.getPosition());
        assertTrue(waterPower.isRight);
    }

    @Test
    public void moveWaterGirlUpTest() {
        keyH.up = true;
        Position surfacePos = mock(Position.class);
        Position lavaBoyPos = mock(Position.class);
        when(arena.onSurface(surfacePos)).thenReturn(true);
        when(arena.onSurface(lavaBoyPos)).thenReturn(false);
        when(lavaBoyPos.getDown()).thenReturn(surfacePos);
        when(arena.getWaterGirl()).thenReturn(waterGirl);
        when(waterGirl.getPosition()).thenReturn(surfacePos).thenReturn(lavaBoyPos);

        controller.step(game, keyH);
        controller.step(game, keyH);

        verify(controller, times(2)).movePlayerUp(waterGirl);
        verify(game, times(1)).playSE(5);
    }

    @Test
    public void moveWaterGirlRightTest() {
        keyH.right = true;

        controller.step(game, keyH);

        verify(waterGirl, times(1)).setRight(true);
        verify(controller, times(1)).movePlayerRight(waterGirl);
    }

    @Test
    public void moveWaterGirlLeftTest() {
        keyH.left = true;

        controller.step(game, keyH);

        verify(waterGirl, times(1)).setRight(false);
        verify(controller, times(1)).movePlayerLeft(waterGirl);
    }

    @Test
    public void waterGirlPressedPower() {
        keyH.p1Power = true;
        controller.cooldown = 10;

        controller.step(game, keyH);

        verify(game, times(1)).playSE(9);
        verify(controller, times(1)).powerPlayer();
    }

    @Test
    public void retrieveWaterCoinTest() {
        Position waterCoinPos = mock(Position.class);
        when(waterGirl.getPosition()).thenReturn(waterCoinPos);
        when(arena.retrieveWaterCoin(waterCoinPos)).thenReturn(true);

        controller.step(game, keyH);

        verify(game, times(1)).playSE(3);
        verify(arena, times(1)).retrieveWaterCoin(waterCoinPos);
    }

    @Test
    public void decreaseLifeTest() {
        LavaMonster lavaMonster = mock(LavaMonster.class);

        Position pos = mock(Position.class);
        when(arena.getLavaMonsters()).thenReturn(Collections.singletonList(lavaMonster));
        when(lavaMonster.getPosition()).thenReturn(pos);
        when(waterGirl.getPosition()).thenReturn(pos);
        waterGirl.life = 1;

        // Call step() method
        controller.step(game, keyH);

        assertEquals(0, waterGirl.life);
        verify(game, times(1)).playSE(7);
    }
}


