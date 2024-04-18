package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.Instructions;
import org.example.viewer.View;

public class InstructionsView extends View<Instructions> {
    public InstructionsView(Instructions instructions) { super(instructions);}

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);

        drawKeys(gui);

        gui.drawText(new Position(getCol(">"+ "BACK", gui.getWidth()), 23), ">" + "BACK","#FFD700" );
    }

    private void drawTitle(GUI gui){
        String s4 = "m";
        String s1 = "      _ ___ _     _ _   _      _  ";
        String s2 = "||/ ||_  | |_|| ||  | || ||/ ||_  ";
        String s3 = "|| /| _| | |/ |_||_ | ||_|| /| _| ";

        gui.drawText(new Position(getCol(s1, gui.getWidth()), 2), s1, "#FFD700" );
        gui.drawText(new Position(getCol(s1, gui.getWidth()), 2), s4, "#FF0000" );
        gui.drawText(new Position(getCol(s2, gui.getWidth()), 3) , s2, "#FFD700" );
        gui.drawText(new Position(getCol(s3, gui.getWidth()), 4 ) , s3, "#FFD700" );
    }

    private void drawKeys(GUI gui) {
        String s0 = "                LAVA BOY";
        String s16= "          WATER GIRL         ";
        String s1 = "                   ___                ___            ";
        String s2 = "                  | W |              | ^ |           ";
        String s3 = "                  |___|              |_l_|           ";
        String s4 = " MOVEMENT:      ___   ___          ___   ___         ";
        String s5 = "               | A | | D |        | <e| |e> |        ";
        String s6 = "               |___| |___|        |___| |___|        ";
        String s7 = "                   ___                ___            ";
        String s8 = "  POWERS:         | E |              | l |           ";
        String s9=  "                  |___|              |_?_|           ";

        String s11= "USE THESE CONTROLS TO KILL MONSTERS AND PASS ALL THE ";
        String s12= "OBSTACLES UP UNTIL THE MARKED DOORS AT THE TOP. TO WIN";
        String s13= "BOTH PLAYERS MUST BE INSIDE THE DOORS AND KILL THE BOSS.";
        String s14= "COLLECT ALL COINS AND FINISH AS FAST AS YOU CAN TO SCORE";
        String s15= "x x x";

        gui.drawText(new Position(getCol(s2, gui.getWidth()), 6), s0, "#FF0000");
        gui.drawText(new Position(getCol(s2, gui.getWidth()) + s0.length(), 6), s16,"#00FFFF");
        gui.drawText(new Position(getCol(s1, gui.getWidth()), 7), s1, "#F5F5DC");
        gui.drawText(new Position(getCol(s2, gui.getWidth()), 8), s2, "#F5F5DC");
        gui.drawText(new Position(getCol(s3, gui.getWidth()), 9), s3, "#F5F5DC");
        gui.drawText(new Position(getCol(s4, gui.getWidth()), 10), s4, "#F5F5DC");
        gui.drawText(new Position(getCol(s5, gui.getWidth()), 11), s5, "#F5F5DC");
        gui.drawText(new Position(getCol(s6, gui.getWidth()), 12), s6, "#F5F5DC");
        gui.drawText(new Position(getCol(s7, gui.getWidth()), 13), s7, "#F5F5DC");
        gui.drawText(new Position(getCol(s8, gui.getWidth()), 14), s8, "#F5F5DC");
        gui.drawText(new Position(getCol(s9, gui.getWidth()), 15), s9, "#F5F5DC");

        gui.drawText(new Position(getCol(s11, gui.getWidth()), 17), s11, "#F5F5DC");
        gui.drawText(new Position(getCol(s12, gui.getWidth()), 18), s12, "#F5F5DC");
        gui.drawText(new Position(getCol(s13, gui.getWidth()), 19), s13, "#F5F5DC");
        gui.drawText(new Position(getCol(s14, gui.getWidth()), 20), s14, "#F5F5DC");
        gui.drawText(new Position(getCol(s15, gui.getWidth()), 21), s15, "#FFFF00");
    }

}