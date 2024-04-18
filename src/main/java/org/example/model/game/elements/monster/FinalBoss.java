package org.example.model.game.elements.monster;

public class FinalBoss extends Monster{
    public int lavaLife = 2;
    public int waterLife = 2;

    private boolean isRight = false; // default
    public FinalBoss(int x, int y) { super(x, y);}

    public boolean isRight() { return isRight;}

    public void setRight(boolean isRight){ this.isRight = isRight;}
}
