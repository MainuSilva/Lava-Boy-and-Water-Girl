package org.example.controller.game;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.state.GameOverState;
import org.example.state.GameWinState;
import org.example.state.PauseState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ArenaControllerTest {

    Game game;
    KeyHandler keyH;
    ArenaController controller;
    Arena arena;

    @BeforeEach
    public void setUp(){
        char[][] map = new char[3][3];
        map[0][0] = 'a'; // water
        map[0][1] = 'l'; // lava
        map[1][0] = 'F'; // lavaBoy
        map[1][1] = 'W'; // waterGirl
        map[0][2] = 'D'; // waterDoor
        map[1][2] = 'L'; // LavaDoor

        arena = new Arena(map);
        game = mock(Game.class);
        keyH = mock(KeyHandler.class);
        controller = new ArenaController(arena);
    }

    @Test
    public void pauseTest() throws IOException, ClassNotFoundException {
        keyH.pause = true;
        controller.step(game, keyH);

        verify(game).setState(Mockito.any(PauseState.class));
        verify(game).stopMusic();
        verify(game).playSE(12);
    }


    @Test
    public void lossTest() throws IOException, ClassNotFoundException {
        arena.getLavaBoy().setPosition(new Position(0, 0));
        controller.step(game, keyH);

        verify(game, times(1)).setState(Mockito.any(GameOverState.class));
        verify(game).stopMusic();
        verify(game).playSE(6);
        verify(game).playSE(2);
    }

    @Test
    public void winTest() throws IOException, ClassNotFoundException {
        arena.getLavaBoy().setPosition(new Position(2, 1));
        arena.getWaterGirl().setPosition(new Position(2, 0));

        controller.step(game, keyH);

        verify(game , times(1)).setState(Mockito.any(GameWinState.class));
        verify(game).stopMusic();
        verify(game).playSE(1);
    }

}
