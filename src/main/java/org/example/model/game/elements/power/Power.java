package org.example.model.game.elements.power;

import org.example.model.game.elements.Element;

public abstract class Power extends Element {
    public int life = 10;
    public boolean isRight; //If the hero is right, the boolean is true
    public Power(int x, int y) { super(x, y);}
}
