package org.example;

import org.example.gui.KeyHandler;
import org.example.gui.LanternaGUI;
import org.example.gui.Sound;
import org.example.model.menu.Menu;
import org.example.state.MenuState;
import org.example.state.State;

import java.awt.*;
import java.io.IOException;


public class Game {
    private final LanternaGUI gui;
    private final int fps;
    private State state;
    private final KeyHandler keyH;
    private final Sound music;
    private final Sound soundEffect;

    public Game() throws FontFormatException, IOException, ClassNotFoundException {
        this.gui = new LanternaGUI(60 , 26 );
        this.keyH = new KeyHandler();
        this.state = new MenuState(new Menu());
        this.music = new Sound();
        this.soundEffect = new Sound();
        this.fps = 14;
        playMusic(11);
    }

    public static void main(String[] args) throws IOException, FontFormatException, ClassNotFoundException {
        new Game().run();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void run() throws IOException, ClassNotFoundException {
        gui.addKeyboardListener(keyH);
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (this.state != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                state.step(this, gui, keyH);

                delta--;
            }

        }
        gui.close();
    }

    public Sound getMusic() {
        return music;
    }

    public Sound getSoundEffect() {
        return soundEffect;
    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }

    public void playSE(int i){
        soundEffect.setFile(i);
        soundEffect.play();
    }

    public void stopSE(){
        soundEffect.stop();
    }
}