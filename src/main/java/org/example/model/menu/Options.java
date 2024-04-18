package org.example.model.menu;

import org.example.model.SelectClass;

import java.util.Arrays;

public class Options extends SelectClass {
    public int musicVolume;
    public int seVolume;

    public Options(int musicVolume, int seVolume) {
        this.musicVolume = musicVolume;
        this.seVolume = seVolume;
        setButtons(Arrays.asList(
                "{ MUSIC",
                "z SPECIAL EFFECTS",
                "BACK"));
    }

    public boolean isSelectedMusic() { return isSelected(0);}

    public boolean isSelectedSE() { return isSelected(1);}

    public boolean isSelectedBack() { return isSelected(2);}

}
