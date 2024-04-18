package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.KeyHandler;
import org.example.model.score.ScoreList;
import org.example.model.menu.Menu;
import org.example.state.MenuState;

import java.io.IOException;

public class ScoreListController extends Controller<ScoreList> {
    public int actionLockCounter = 0;

    public ScoreListController(ScoreList score) { super(score);}

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException {
        actionLockCounter++;

        if(actionLockCounter > 1) {
            actionLockCounter=0;

            if (keyH.enter)
                game.setState(new MenuState(new Menu()));
        }
    }
}
