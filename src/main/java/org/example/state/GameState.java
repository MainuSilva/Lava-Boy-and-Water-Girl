package org.example.state;

import org.example.controller.Controller;
import org.example.controller.game.ArenaController;
import org.example.model.game.Arena;
import org.example.viewer.View;
import org.example.viewer.game.GameView;

import java.io.IOException;

public class GameState extends State<Arena>{

    public GameState(Arena arena) throws IOException, ClassNotFoundException { super(arena);}

    @Override
    protected View<Arena> getViewer() { return new GameView(getModel());}

    @Override
    protected Controller<Arena> getController() { return new ArenaController(getModel());}
}
