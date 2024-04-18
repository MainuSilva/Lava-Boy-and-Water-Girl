package org.example.controller.game.surface;

import org.example.Game;
import org.example.controller.game.surface.ElevatorController;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.player.LavaBoy;
import org.example.model.game.elements.player.WaterGirl;
import org.example.model.game.elements.surface.Elevator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class ElevatorControllerTest {
    Game game;
    ElevatorController controller;
    Elevator elevator;
    LavaBoy boy;
    WaterGirl girl;
    Arena arena;

    @BeforeEach
    public void setUp(){
        arena = mock(Arena.class);
        game = mock(Game.class);
        controller = spy(new ElevatorController(arena));

        boy = mock(LavaBoy.class);
        when(arena.getLavaBoy()).thenReturn(boy);
        when(boy.getPosition()).thenReturn(new Position(1, 0));

        girl = mock(WaterGirl.class);
        when(arena.getWaterGirl()).thenReturn(girl);
        when(girl.getPosition()).thenReturn(new Position(2, 0));

        elevator = mock(Elevator.class);
        when(elevator.getPosition()).thenReturn(new Position(0, 0));
        when(arena.getElevators()).thenReturn(Collections.singletonList(elevator));

        controller.actionLockCounter = 2;
    }

    @Test
    public void moveElevatorDownTest() throws IOException {
        when(arena.canAllMoveDown()).thenReturn(true);
        when(arena.isButtonPressed(boy.getPosition())).thenReturn(true);

        controller.step(game, null);

        verify(elevator, times(1)).setPosition(new Position(0, 1));
    }

    @Test
    public void moveElevatorUpTest() throws IOException {
        when(arena.canAllMoveUp()).thenReturn(true);
        when(arena.isButtonPressed(boy.getPosition())).thenReturn(false);
        when(arena.isButtonPressed(girl.getPosition())).thenReturn(false);

        controller.step(game, null);

        verify(elevator, times(1)).setPosition(new Position(0, -1));
    }

    @Test
    public void movePlayersUpTest() throws IOException {
        when(arena.canAllMoveUp()).thenReturn(true);
        when(arena.isButtonPressed(boy.getPosition())).thenReturn(false);
        when(arena.isButtonPressed(girl.getPosition())).thenReturn(false);

        when(arena.onElevator(boy.getPosition())).thenReturn(true);
        when(arena.onElevator(girl.getPosition())).thenReturn(true);

        when(arena.canMove(any(Position.class))).thenReturn(true);

        controller.step(game, null);

        verify(girl, times(1)).setPosition(new Position(2, -1));
        verify(boy, times(1)).setPosition(new Position(1, -1));
    }
}
