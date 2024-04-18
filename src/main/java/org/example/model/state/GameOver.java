package org.example.model.state;

import org.example.model.SelectClass;

import java.util.Arrays;

public class GameOver extends SelectClass {

    public GameOver() {
        setButtons(Arrays.asList(
                "PLAY AGAIN",
                "BACK TO MENU"));
    }

    public boolean isSelectedTryAgain() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

}
