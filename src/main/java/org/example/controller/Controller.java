package org.example.controller;

import org.example.Game;
import org.example.gui.KeyHandler;

import java.io.IOException;

public abstract class Controller<T> {

    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException;
}
