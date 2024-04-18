package org.example.viewer.state;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.state.GameOver;
import org.example.viewer.View;


public class GameOverView extends View<GameOver> {

    public GameOverView(GameOver gameover) {super(gameover);}

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);

        for (int i = 0; i < getModel().getNumberEntries(); i++) {

            if (getModel().isSelected(i)) {
                gui.drawText(new Position(getCol(getModel().getEntry(i), gui.getWidth())-1 , 15 + (i * 2)),  ">" + getModel().getEntry(i), "#FFD700", "BLINK");
            }

            else gui.drawText(new Position(getCol(getModel().getEntry(i), gui.getWidth()), 15 + (i * 2)), getModel().getEntry(i), "#FFFFFF");
        }
    }

    private void drawTitle(GUI gui){
        String s1 = " __  _     _  _     _  _ ";
        String s2 = "| _ |_||/||_ | || ||_ |_|";
        String s3 = "|__|| || ||_ |_||_||_ |/ ";

        gui.drawText(new Position(getCol(s1, gui.getWidth()), 2), s1, "#FFD700" );
        gui.drawText(new Position(getCol(s2, gui.getWidth()), 3) , s2, "#FFD700" );
        gui.drawText(new Position(getCol(s3, gui.getWidth()), 4 ) , s3, "#FFD700" );
    }

}

