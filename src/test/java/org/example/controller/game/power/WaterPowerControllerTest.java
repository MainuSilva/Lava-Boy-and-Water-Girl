package org.example.controller.game.power;

import org.example.Game;
import org.example.controller.game.power.WaterPowerController;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.model.game.elements.player.LavaBoy;
import org.example.model.game.elements.power.WaterPower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class WaterPowerControllerTest {

    Game game;
    WaterPowerController controller;
    WaterPower waterPower;
    List<WaterPower> waterPowers;
    Arena arena;
    LavaBoy boy;
    FinalBoss boss;

    @BeforeEach
    public void setUp() {
        game = mock(Game.class);
        arena = mock(Arena.class);
        controller = new WaterPowerController(arena);

        waterPower = mock(WaterPower.class);
        when(waterPower.getPosition()).thenReturn(new Position(0, 0));
        waterPowers = new ArrayList<>();
        waterPowers.add(waterPower);
        when(arena.getWaterPowers()).thenReturn(waterPowers);

        boss = mock(FinalBoss.class);
        when(boss.getPosition()).thenReturn(new Position(1, 0));
        when(arena.getBoss()).thenReturn(Collections.singletonList(boss));

        boy = mock(LavaBoy.class);
        when(arena.getLavaBoy()).thenReturn(boy);
        when(boy.getPosition()).thenReturn(new Position(2, 0));

    }

    @Test
    public void waterPowerHitsLavaBoy() throws IOException, ClassNotFoundException {
        boy.life = 3;
        when(waterPower.getPosition()).thenReturn(new Position(2, 0));
        controller.step(game, null);
        verify(game, times(1)).playSE(7);
        assertEquals(2, boy.life);
        assertEquals(0, arena.getWaterPowers().size());
    }

    @Test
    public void waterPowerHitsBossTest() throws IOException, ClassNotFoundException {
        boss.lavaLife = 2;
        when(waterPower.getPosition()).thenReturn(new Position(1, 0));
        controller.step(game, null);
        verify(game, times(1)).playSE(7);
        assertEquals(1, boss.lavaLife);
        assertEquals(0, arena.getWaterPowers().size());
    }

    @Test
    public void waterPowerHitsMonsterTest() throws IOException, ClassNotFoundException {
        when(arena.deathLavaMonster(waterPower.getPosition())).thenReturn(true);
        controller.step(game, null);
        verify(game, times(1)).playSE(8);
        assertEquals(0, arena.getWaterPowers().size());
    }

    @Test
    public void removePowerAfterPowerLifeReachesZeroTest() throws IOException, ClassNotFoundException {
        waterPower.life = 0;
        controller.step(game, null);
        assertEquals(0, arena.getWaterPowers().size());
    }

}