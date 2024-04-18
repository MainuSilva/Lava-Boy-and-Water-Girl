package org.example.viewer;

import org.example.gui.GUI;

import java.io.IOException;

public abstract class View<T> {

    private final T model;

    public View(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    //Collumn to the string be at the center of the screen
    public int getCol(String s, int size_x){
        return (size_x - s.length()) /2;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui);
}
