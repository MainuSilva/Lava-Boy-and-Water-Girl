package org.example.model.menu;

import org.example.model.SelectClass;

import java.util.Arrays;

public class Menu extends SelectClass {

    public Menu() {
        setButtons(Arrays.asList(
                "NEW GAME",
                "INSTRUCTIONS",
                "HIGHSCORES",
                "SETTINGS",
                "EXIT"));
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedInstructions() {return isSelected(1);}

    public boolean isSelectedHighScores() {
        return isSelected(2);
    }

    public boolean isSelectedSettings() {
        return isSelected(3);
    }

    public boolean isSelectedExit() {
        return isSelected(4);
    }

}
