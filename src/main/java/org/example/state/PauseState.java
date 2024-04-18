package org.example.state;

import org.example.controller.Controller;
import org.example.controller.state.PauseController;
import org.example.model.state.GamePause;
import org.example.viewer.View;
import org.example.viewer.state.PauseView;

import java.io.IOException;

public class PauseState extends State<GamePause>{
    public PauseState(GamePause pause) throws IOException, ClassNotFoundException { super(pause);}

    @Override
    protected View<GamePause> getViewer() { return new PauseView(getModel());}

    @Override
    protected Controller<GamePause> getController() { return new PauseController(getModel());}
}
