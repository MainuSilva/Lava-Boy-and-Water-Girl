package org.example.state;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.gui.KeyHandler;
import org.example.viewer.View;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final View<T> view;

    public State(T model) throws IOException, ClassNotFoundException {
        this.model = model;
        this.view = getViewer();
        this.controller = getController();
    }

    protected abstract View<T> getViewer();

    protected abstract Controller<T> getController() throws IOException, ClassNotFoundException;

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, KeyHandler keyH) throws IOException, ClassNotFoundException {
        controller.step(game, keyH);
        view.draw(gui);
    }
}
