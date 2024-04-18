package org.example.state;

import org.example.controller.Controller;
import org.example.controller.state.GameWinController;
import org.example.model.state.GameWin;
import org.example.viewer.View;
import org.example.viewer.state.GameWinView;

import java.io.IOException;

public class GameWinState extends State<GameWin>{

    public GameWinState(GameWin gameWin) throws IOException, ClassNotFoundException { super(gameWin);}

    @Override
    protected View<GameWin> getViewer() { return new GameWinView(getModel());}

    @Override
    protected Controller<GameWin> getController(){ return new GameWinController(getModel());}
}
