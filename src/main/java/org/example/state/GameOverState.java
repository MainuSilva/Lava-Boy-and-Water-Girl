package org.example.state;

import org.example.controller.Controller;
import org.example.controller.state.GameOverController;
import org.example.model.state.GameOver;
import org.example.viewer.View;
import org.example.viewer.state.GameOverView;

import java.io.IOException;

public class GameOverState extends State<GameOver> {

    public GameOverState(GameOver gameOver) throws IOException, ClassNotFoundException { super(gameOver);}

    @Override
    protected View<GameOver> getViewer() { return new GameOverView(getModel());}

    @Override
    protected Controller<GameOver> getController() { return new GameOverController(getModel());}
}
