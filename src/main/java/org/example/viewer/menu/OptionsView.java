package org.example.viewer.menu;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.Options;
import org.example.viewer.View;

public class OptionsView extends View<Options>{

    public OptionsView(Options options) { super(options);}

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);

        //DRAW OPTIONS
        if (getModel().isSelected(0)) {
            //SELECTED
            gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth())-1, 11 ),  ">" + getModel().getEntry(0), "#FFD700" );
            gui.drawText(new Position(getCol( getModel().getEntry(1), gui.getWidth()), 15 ),  getModel().getEntry(1), "#FFFFFF");
            gui.drawText(new Position(getCol(getModel().getEntry(2), gui.getWidth()), 20 ), getModel().getEntry(2), "#FFFFFF");
        }
        else if (getModel().isSelected(1)) {
            gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth()), 11 ),  getModel().getEntry(0), "#FFFFFF");
            //SELECTED
            gui.drawText(new Position(getCol( getModel().getEntry(1), gui.getWidth())-1, 15 ), ">" + getModel().getEntry(1), "#FFD700");
            gui.drawText(new Position(getCol(getModel().getEntry(2), gui.getWidth()), 20 ), getModel().getEntry(2), "#FFFFFF");
        }
        else if (getModel().isSelected(2)) {
            gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth()), 11), getModel().getEntry(0), "#FFFFFF");
            gui.drawText(new Position(getCol(getModel().getEntry(1), gui.getWidth()) , 15),  getModel().getEntry(1), "#FFFFFF");
            //SELECTED
            gui.drawText(new Position(getCol(getModel().getEntry(2), gui.getWidth()) - 1, 20), ">" + getModel().getEntry(2), "#FFD700");
        }

        drawSoundBoxes(gui);

    }
    private void drawTitle(GUI gui){
        //TITLE
        String s1 = " _  _ ______  u    _  _ ";
        String s2 = "|_ |_  |  | | |/ || _|_ ";
        String s3 = " _||_  |  | | | /||_| _|";

        gui.drawText(new Position(getCol(s1, gui.getWidth()), 2), s1, "#FFD700" );
        gui.drawText(new Position(getCol(s2, gui.getWidth()), 3) , s2, "#FFD700" );
        gui.drawText(new Position(getCol(s3, gui.getWidth()), 4 ) , s3, "#FFD700" );
    }

    private void drawSoundBoxes(GUI gui){
        //BOXES
        String s4 = "deeeeec";
        String s5 = "f     f";
        String s6 = "aeeeeeb";

        //DRAW MUSIC BOXES
        gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth())+13, 10 ), s4, "#FFFFFF" , "BOLD");
        gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth())+13, 11 ) , s5, "#FFFFFF" , "BOLD");
        gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth())+13, 12 ) , s6, "#FFFFFF", "BOLD");
        //INSIDE MUSIC
        for(int i = 0; i < getModel().musicVolume; i++)
            gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth())+14+i, 11 ) , "n", "#FFD700", "BOLD");

        //DRAW SE BOXES
        gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth())+13, 14 ), s4, "#FFFFFF", "BOLD");
        gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth())+13, 15 ) , s5, "#FFFFFF" , "BOLD" );
        gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth())+13, 16 ) , s6, "#FFFFFF" , "BOLD" );
        //INSIDE SE
        for(int i = 0; i < getModel().seVolume; i++)
            gui.drawText(new Position(getCol(getModel().getEntry(0), gui.getWidth())+14+i, 15 ) , "n", "#FFD700" , "BOLD");
    }


}
