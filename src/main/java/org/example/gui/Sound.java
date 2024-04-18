package org.example.gui;

import javax.sound.sampled.*;
import java.net.URL;

public class Sound {

    private Clip clip;
    private final URL[] soundURL = new URL[30];
    FloatControl fc;
    public int volumeScale = 3;
    private float volume;

    public Sound(){
        //GAME SOUND
        soundURL[0] = getClass().getResource("/sound/Level-Music.wav");
        //GAMEWIN
        soundURL[1] = getClass().getResource("/sound/Level-Music-Finish_1.wav");
        //GAMELOSS
        soundURL[2] = getClass().getResource("/sound/Level-Music-Over.wav");

        soundURL[3] = getClass().getResource("/sound/Diamond.wav");

        soundURL[4] = getClass().getResource("/sound/Jump-fb.wav");
        soundURL[5] = getClass().getResource("/sound/Jump-wg.wav");

        soundURL[6] = getClass().getResource("/sound/Death.wav");
        soundURL[7] = getClass().getResource("/sound/receivedamage.wav");
        soundURL[8] = getClass().getResource("/sound/hitmonster.wav");
        soundURL[9] = getClass().getResource("/sound/boom_c_06-102838.wav");

        soundURL[10] = getClass().getResource("/sound/button-124476.wav");
        //MENU MUSIC
        soundURL[11] = getClass().getResource("/sound/Menu-Music.wav");

        soundURL[12] = getClass().getResource("/sound/back-tick-107822.wav");
        soundURL[13] = getClass().getResource("/sound/success-fanfare-trumpets-6185.wav");

    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume();

        } catch (Exception e){
        }
    }

    public void play(){ clip.start();}

    public void loop(){ clip.loop(Clip.LOOP_CONTINUOUSLY);}

    public void stop(){ clip.stop();}

    //TO  CHANGE THE VOLUME
    public void checkVolume(){

        switch (volumeScale) {
            case 0 -> volume = -80f;
            case 1 -> volume = -20f;
            case 2 -> volume = -12f;
            case 3 -> volume = -5f;
            case 4 -> volume = 1f;
            case 5 -> volume = 6f;
        }
        fc.setValue(volume);
    }


}
