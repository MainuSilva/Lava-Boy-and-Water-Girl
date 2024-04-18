package org.example.viewer;


import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.menu.Instructions;
import org.example.model.menu.Menu;
import org.example.model.menu.Options;
import org.example.model.score.ScoreList;
import org.example.model.state.*;
import org.example.viewer.menu.InstructionsView;
import org.example.viewer.menu.MenuView;
import org.example.viewer.menu.OptionsView;
import org.example.viewer.menu.ScoreListView;
import org.example.viewer.state.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class StateViewTest {
    GUI gui;
    MenuView menuView;
    GameOverView overView;
    GameWinView winView;
    OptionsView optionsView;
    InstructionsView instructionsView;
    ScoreListView scoreView;
    PauseView pauseView;

    @BeforeEach
    void setUp() {
        gui = mock(GUI.class);
    }

    @Test
    void menuViewTest(){
        menuView = new MenuView(new Menu());
        menuView.drawElements(gui);

        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-5 , 12),">NEW GAME","#FFD700","BLINK");
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-6 , 14),"INSTRUCTIONS","#FFFFFF");
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-5 , 16),"HIGHSCORES","#FFFFFF");
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-4 , 18),"SETTINGS","#FFFFFF");
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-2 , 20),"EXIT","#FFFFFF");

    }

    @Test
    void gameWinViewTest() throws IOException {
        winView = new GameWinView(new GameWin(0.0,0));
        winView.drawElements(gui);

        Mockito.verify(gui, Mockito.atLeast(1)).drawStarScore(new Position(-2,9),3);
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-6 , 18),">PLAY AGAIN","#FFD700","BLINK");
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-6 , 20),"BACK TO MENU","#FFFFFF");

    }

    @Test
    void gameOverViewTest() {
        overView = new GameOverView(new GameOver());
        overView.drawElements(gui);

        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-6 , 15),">PLAY AGAIN","#FFD700","BLINK");
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-6 , 17),"BACK TO MENU","#FFFFFF");
    }

    @Test
    void instructionsViewTest() {
        instructionsView = new InstructionsView(new Instructions());
        instructionsView.drawElements(gui);

        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-2,23), ">" + "BACK","#FFD700" );
    }

    @Test
    void scoreListViewTest(){
        scoreView = new ScoreListView(new ScoreList());
        scoreView.drawElements(gui);

        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-2,22), ">" + "BACK","#FFD700" );

    }
    @Test
    void pauseViewTest() throws IOException {
        pauseView = new PauseView(new GamePause(new Arena()));
        pauseView.drawElements(gui);

        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-5,12), ">CONTINUE","#FFD700","BLINK" );
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-5,14), "PLAY AGAIN","#FFFFFF" );
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-6,16), "BACK TO MENU","#FFFFFF" );
    }

    @Test
    void optionsViewTest(){
        optionsView = new OptionsView(new Options(0,0));
        optionsView.drawElements(gui);

        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-4,11),">{ MUSIC","#FFD700");
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-8,15), "z SPECIAL EFFECTS","#FFFFFF");
        Mockito.verify(gui, Mockito.atLeast(1)).drawText(new Position(-2,20), "BACK","#FFFFFF");

    }

}