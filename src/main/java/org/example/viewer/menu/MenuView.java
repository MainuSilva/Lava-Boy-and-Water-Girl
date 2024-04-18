package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;
import org.example.viewer.View;

public class MenuView extends View<Menu> {

    public MenuView(Menu menu) { super(menu);}

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui, "#CC0000", "#00FFFF" );

        for (int i = 0; i < getModel().getNumberEntries(); i++) {

            if (getModel().isSelected(i))
                gui.drawText(new Position(getCol(getModel().getEntry(i), gui.getWidth()) - 1, 12 + (i * 2)), ">" + getModel().getEntry(i), "#FFD700", "BLINK");

            else
                gui.drawText(new Position(getCol(getModel().getEntry(i), gui.getWidth()), 12 + (i * 2)), getModel().getEntry(i), "#FFFFFF");

        }
    }

    public void drawTitle(GUI gui, String textColor1, String textColor2) {
        String s1 = "f|  _     _  _  _      _   |   | _ _ _ _  _  _ _ | f ";

        String s10 ="deeeeeeeeeeeeeeeeeeeeeee";
        String s15 ="f                       ";
        String s4 = "f |  _     _  _  _      ";
        String s5 = "f | |_|| ||_||_|| ||_| |_";
        String s6 = "f |_| ||_|| ||_||_| |  |";
        String s11 ="aeeeeeeeeeeeeeeeeeeeeeee";

        String s12 ="eeeeeeeeeeeeeeeeeeeeeeeeeeeec";
        String s16 ="                            f";
        String s7 = "_   |   | _ _ _ _  _  _ _ | f ";
        String s8 = "|  | | ||_|||_|_|| _ ||_|| f ";
        String s9 = "_|_ |_|_|| |||_|/ |_| ||/ |_f";
        String s13 ="eeeeeeeeeeeeeeeeeeeeeeeeeeeeb";

        int x = (gui.getWidth()-s1.length())/2;

        gui.drawText(new Position(x , 2), s10, textColor1 , "BOLD");
        gui.drawText(new Position(x , 3), s15, textColor1);
        gui.drawText(new Position(x , 4), s4, textColor1);
        gui.drawText(new Position(x , 5) , s5, textColor1);
        gui.drawText(new Position(x , 6 ) , s6, textColor1);
        gui.drawText(new Position(x , 7), s15, textColor1);
        gui.drawText(new Position(x, 8), s11, textColor1, "BOLD");

        gui.drawText(new Position(x + s10.length(), 2), s12, textColor2, "BOLD");
        gui.drawText(new Position(x + s15.length(), 3), s16, textColor2);
        gui.drawText(new Position(x + s4.length(), 4), s7, textColor2);
        gui.drawText(new Position(x + s5.length(), 5) , s8, textColor2);
        gui.drawText(new Position(x + s6.length(), 6 ) , s9, textColor2);
        gui.drawText(new Position(x + s15.length(), 7), s16, textColor2);
        gui.drawText(new Position(x + s11.length(), 8), s13, textColor2, "BOLD");

    }

}
