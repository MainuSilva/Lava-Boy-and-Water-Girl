package org.example.model.state;

import org.example.model.game.Arena;
import org.example.model.SelectClass;

import java.util.Arrays;

public class GamePause extends SelectClass {
    private final Arena backArena;

    public GamePause( Arena arena) {
        this.backArena = arena;
        setButtons(Arrays.asList(
                "CONTINUE",
                "PLAY AGAIN",
                "BACK TO MENU"));
    }

    public boolean isSelectedContinue() { return isSelected(0);}

    public boolean isSelectedTryAgain() { return isSelected(1);}

    public boolean isSelectedBack() { return isSelected(2);}

    public Arena getArena() { return backArena;}

}
