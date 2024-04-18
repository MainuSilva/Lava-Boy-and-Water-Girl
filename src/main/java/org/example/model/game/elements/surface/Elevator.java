package org.example.model.game.elements.surface;

import org.example.model.game.elements.Element;

public class Elevator extends Element {
    //FIRST POSITION
    private final int first_y;

    public Elevator(int x, int y) {
        super(x, y);
        this.first_y = y;
    }

    public int getFirst_y() { return first_y;}
}