package org.example.controller.game;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.game.Arena;

import java.io.IOException;

public class TimeController extends GameController{

    public TimeController(Arena arena) { super(arena);}

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException {
        getModel().getTime().countTime();
    }
}
