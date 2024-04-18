package org.example.model.game.elements.player;

import org.example.model.game.elements.Element;

public abstract class Player extends Element {

    private boolean isRight = true; // default
    public int life = 3;
    public Player(int x, int y) { super(x, y);}

    public boolean isRight() { return isRight;}

    public void setRight( boolean isRight) { this.isRight = isRight; }

}
