package org.example.controller.game.monster;

import org.example.Game;
import org.example.controller.game.monster.FinalBossController;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.model.game.elements.player.LavaBoy;
import org.example.model.game.elements.player.WaterGirl;
import org.example.model.game.elements.power.BossPower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class FinalBossControllerTest {

    Arena arena;
    FinalBoss boss;
    LavaBoy boy;
    WaterGirl girl;
    FinalBossController controller;
    Game game;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        controller = spy(new FinalBossController(arena));
        boss = mock(FinalBoss.class);
        game = mock(Game.class);
        when(boss.getPosition()).thenReturn(new Position(5, 5));

        List<FinalBoss> bosses = new ArrayList<>();
        bosses.add(boss);
        when(arena.getBoss()).thenReturn(bosses);

        boy = mock(LavaBoy.class);
        when(arena.getLavaBoy()).thenReturn(boy);
        when(boy.getPosition()).thenReturn(new Position(1, 1));

        girl = mock(WaterGirl.class);
        when(arena.getWaterGirl()).thenReturn(girl);
        when(girl.getPosition()).thenReturn(new Position(1, 1));
    }

    @Test
    public void powerBossTest() {
        //Right
        when(boss.isRight()).thenReturn(true);
        List<BossPower> bossPowers = new ArrayList<>();
        when(arena.getBossPowers()).thenReturn(bossPowers);

        controller.powerBoss(boss);

        assertEquals(1, bossPowers.size());
        BossPower bossPower = bossPowers.get(0);
        assertEquals(new Position(6, 5), bossPower.getPosition());
        assertTrue(bossPower.isRight);

        //Left
        when(boss.isRight()).thenReturn(false);
        bossPowers.clear();
        controller.powerBoss(boss);

        assertEquals(1, bossPowers.size());
        bossPower = bossPowers.get(0);
        assertEquals(new Position(4, 5), bossPower.getPosition());
        assertFalse(bossPower.isRight);
    }

    @Test
    public void randomMoveSleepyTest() {
        //right
        controller.randomMoveSleepy(boss, 45);
        verify(boss).setRight(false);
        verify(controller).moveMonsterLeft(boss);

        //left
        controller.randomMoveSleepy(boss, 55);
        verify(boss).setRight(true);
        verify(controller).moveMonsterRight(boss);
    }

    @Test
    public void randomMoveAlertTest() {
        WaterGirl girl = new WaterGirl(7, 5);

        when(boss.isRight()).thenReturn(true);
        controller.cooldown = 4;
        controller.randomMoveAlert(boss, girl, 74, game);
        verify(game).playSE(9);
        verify(controller).powerBoss(boss);

        LavaBoy boy = new LavaBoy(7, 5);

        when(boss.isRight()).thenReturn(true);
        when(arena.onSurface(any(Position.class))).thenReturn(true);
        controller.randomMoveAlert(boss, boy, 55, game);
        verify(controller).moveMonsterUp(boss);
    }

    @Test
    public void bossDeathTest() throws IOException, ClassNotFoundException {
        boss.lavaLife = 0;
        boss.waterLife = 0;

        controller.step(game, null);

        verify(game, times(1)).playSE(13);
        assertEquals(0, arena.getBoss().size());
    }

}