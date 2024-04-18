package org.example.model.game.elements;

import org.example.model.Position;

public abstract class Element {

    private Position pos;

    public Element(int x, int y){ pos = new Position(x,y);}

    public Position getPosition() { return pos;}

    public void setPosition(Position position) { this.pos = position;}

}
