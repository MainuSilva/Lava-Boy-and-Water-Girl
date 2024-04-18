package org.example.model.game.elements.time;

import org.example.model.game.elements.Element;

public class Time extends Element {
    private double playTime;

    public Time(int x, int y) {
        super(x, y);
        playTime = 0;
    }

    public void countTime(){
        //TIME = (1/FPS)
        playTime += (double) 1/14;
    }

    public double getPlayTime(){ return playTime;}

    public int getMinutes(){return (int) playTime/60;}

    public int getSeconds(){return (int) playTime % 60;}
}
