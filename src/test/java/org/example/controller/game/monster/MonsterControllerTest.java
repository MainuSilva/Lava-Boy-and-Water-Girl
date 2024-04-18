package org.example.controller.game.monster;

import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.mockito.Mockito.*;

public class MonsterControllerTest {
    private MonsterController controller;
    private Arena arena;
    private Monster monster;

    @BeforeEach
    public void setUp() {
        arena = mock(Arena.class);
        controller = spy(new WaterMonsterController(arena));
        monster = mock(Monster.class);
        when(monster.getPosition()).thenReturn(new Position(0, 0));
    }

    @Test
    public void moveMonsterLeftTest() {
        Position currentPos = mock(Position.class);
        Position newPos = mock(Position.class);

        when(monster.getPosition()).thenReturn(currentPos);
        when(currentPos.getLeft()).thenReturn(newPos);
        when(arena.canMove(newPos)).thenReturn(true);

        controller.moveMonsterLeft(monster);

        verify(monster).setPosition(newPos);
    }

    @Test
    public void moveMonsterRightTest() {
        Position currentPos = mock(Position.class);
        Position newPos = mock(Position.class);

        when(monster.getPosition()).thenReturn(currentPos);
        when(currentPos.getRight()).thenReturn(newPos);
        when(arena.canMove(newPos)).thenReturn(true);

        controller.moveMonsterRight(monster);

        verify(monster).setPosition(newPos);
    }

    @Test
    public void moveMonsterUpTest() {
        Position currentPos = mock(Position.class);
        Position newPos = mock(Position.class);

        when(monster.getPosition()).thenReturn(currentPos);
        when(currentPos.getUp()).thenReturn(newPos);
        when(arena.canMove(newPos)).thenReturn(true);

        controller.moveMonsterUp(monster);

        verify(monster).setPosition(newPos);
    }

    @Test
    public void moveMonsterDownTest() {
        Position currentPos = mock(Position.class);
        Position newPos = mock(Position.class);

        when(monster.getPosition()).thenReturn(currentPos);
        when(currentPos.getDown()).thenReturn(newPos);
        when(arena.canMove(newPos)).thenReturn(true);

        controller.moveMonsterDown(monster);

        verify(monster).setPosition(newPos);
    }

    @Test
    public void randomMoveUpTest() {
        when(controller.getModel().onSurface(monster.getPosition())).thenReturn(true);

        controller.randomMove(monster, 10);

        verify(controller, times(2)).moveMonsterUp(monster);
        verify(controller, never()).moveMonsterLeft(monster);
        verify(controller, never()).moveMonsterRight(monster);
    }

    @Test
    public void testRandomMoveLeftTest() {
        when(controller.getModel().onSurface(monster.getPosition())).thenReturn(false);

        controller.randomMove(monster, 40);

        verify(controller, never()).moveMonsterUp(monster);
        verify(controller, times(1)).moveMonsterLeft(monster);
        verify(controller, never()).moveMonsterRight(monster);
    }

    @Test
    public void testRandomMoveRightTest() {
        when(controller.getModel().onSurface(monster.getPosition())).thenReturn(false);

        controller.randomMove(monster, 70);

        verify(controller, never()).moveMonsterUp(monster);
        verify(controller, never()).moveMonsterLeft(monster);
        verify(controller, times(1)).moveMonsterRight(monster);
    }
}
