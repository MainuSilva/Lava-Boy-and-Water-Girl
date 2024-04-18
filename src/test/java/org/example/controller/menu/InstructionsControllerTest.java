package org.example.controller.menu;

import org.example.Game;
import org.example.controller.menu.InstructionsController;
import org.example.gui.KeyHandler;
import org.example.model.menu.Instructions;
import org.example.state.InstructionState;
import org.example.state.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class InstructionsControllerTest {
    Game game;
    KeyHandler keyH;
    InstructionsController controller;
    Instructions instructions;
    InstructionState state;

    @BeforeEach
    public void setUp() throws IOException, ClassNotFoundException {
        game = mock(Game.class);
        instructions = mock(Instructions.class);
        keyH = mock(KeyHandler.class);
        state = new InstructionState(instructions);
        controller = new InstructionsController(instructions);
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
    public void exitTest() throws IOException, ClassNotFoundException {
        keyH.enter = true;
        controller.step(game, keyH);
        verify(game, times(1)).setState(any(MenuState.class));
    }
}
