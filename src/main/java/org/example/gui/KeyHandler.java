package org.example.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean up , left, right, down, p1Power,  p2Up, p2Left, p2Right, p2Power, enter, pause;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code =  e.getKeyCode();

        //LAVA BOY CONTROLS
        if(code == KeyEvent.VK_W){
            p2Up = true;
        }
        if(code == KeyEvent.VK_A ){
            p2Left = true;
        }
        if(code == KeyEvent.VK_D ){
            p2Right = true;
        }
        if(code == KeyEvent.VK_E){
            p2Power = true;
        }

        //WATERGIRL CONTROLS AND OTHER STATES
        if(code == KeyEvent.VK_LEFT){
            left = true;
        }
        if(code == KeyEvent.VK_UP){
            up = true;
        }
        if(code == KeyEvent.VK_DOWN){
            p1Power = true; //power p1
        }
        if(code == KeyEvent.VK_RIGHT){
            right = true;
        }

        if(code == KeyEvent.VK_DOWN){
            down = true;
        }
        //TO PAUSE THE GAME
        if(code == KeyEvent.VK_ESCAPE){
            pause = true;
        }

        if(code == KeyEvent.VK_ENTER){
            enter = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code =  e.getKeyCode();

        if(code == KeyEvent.VK_W){
            p2Up = false;
        }
        if(code == KeyEvent.VK_UP){
            up = false;
        }
        if(code == KeyEvent.VK_A ){
            p2Left = false;
        }
        if(code == KeyEvent.VK_E){
            p2Power = false;
        }
        if(code == KeyEvent.VK_LEFT){
            left = false;
        }
        if(code == KeyEvent.VK_DOWN){
            down = false;
        }
        if(code == KeyEvent.VK_DOWN){
            p1Power = false; //power watergirl
        }
        if(code == KeyEvent.VK_D ){
            p2Right = false;
        }
        if(code == KeyEvent.VK_ESCAPE){
            pause = false;
        }
        if(code == KeyEvent.VK_RIGHT){
            right = false;
        }
        if(code == KeyEvent.VK_ENTER){
            enter = false;
        }
    }
}
