package org.example.controller.game.power;

import org.example.Game;
import org.example.controller.game.power.LavaPowerController;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.model.game.elements.player.WaterGirl;
import org.example.model.game.elements.power.LavaPower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LavaPowerControllerTest {

    Game game;
    LavaPowerController controller;
    LavaPower power;
    List<LavaPower> lavaPowers;
    Arena arena;
    WaterGirl girl;
    FinalBoss boss;

    @BeforeEach
    public void setUp() {
        game = mock(Game.class);
        arena = mock(Arena.class);
        controller = new LavaPowerController(arena);

        power = mock(LavaPower.class);
        when(power.getPosition()).thenReturn(new Position(0, 0));
        lavaPowers = new ArrayList<>();
        lavaPowers.add(power);
        when(arena.getLavaPowers()).thenReturn(lavaPowers);

        boss = mock(FinalBoss.class);
        when(boss.getPosition()).thenReturn(new Position(1, 0));
        when(arena.getBoss()).thenReturn(Collections.singletonList(boss));

        girl = mock(WaterGirl.class);
        when(arena.getWaterGirl()).thenReturn(girl);
        when(girl.getPosition()).thenReturn(new Position(2, 0));

    }

    @Test
    public void lavaPowerHitsWaterGirl() throws IOException, ClassNotFoundException {
        girl.life = 3;
        when(power.getPosition()).thenReturn(new Position(2, 0));
        controller.step(game, null);
        verify(game, times(1)).playSE(7);
        assertEquals(2, girl.life);
        assertEquals(0, arena.getLavaPowers().size());
    }

    @Test
    public void lavaPowerHitsBossTest() throws IOException, ClassNotFoundException {
        boss.waterLife = 2;
        when(power.getPosition()).thenReturn(new Position(1, 0));
        controller.step(game, null);
        verify(game, times(1)).playSE(7);
        assertEquals(1, boss.waterLife);
        assertEquals(0, arena.getLavaPowers().size());
    }

    @Test
    public void lavaPowerHitsMonsterTest() throws IOException, ClassNotFoundException {
        when(arena.deathWaterMonster(power.getPosition())).thenReturn(true);
        controller.step(game, null);
        verify(game, times(1)).playSE(8);
        assertEquals(0, arena.getLavaPowers().size());
    }

    @Test
    public void removePowerAfterPowerLifeReachesZeroTest() throws IOException, ClassNotFoundException {
        power.life = 0;
        controller.step(game, null);
        assertEquals(0, arena.getLavaPowers().size());
    }

}
