package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.KeyHandler;
import org.example.model.game.Arena;
import org.example.model.score.ScoreList;
import org.example.model.menu.Instructions;
import org.example.model.menu.Menu;
import org.example.model.menu.Options;
import org.example.state.GameState;
import org.example.state.InstructionState;
import org.example.state.OptionsState;
import org.example.state.ScoreListState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public int actionLockCounter = 0;

    public MenuController(Menu menu) {super(menu);}

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException {
        actionLockCounter++;

        if (actionLockCounter > 1) {
            actionLockCounter = 0;

            if (keyH.up) {
                game.playSE(10);
                getModel().previousEntry();
            }

            if (keyH.down) {
                game.playSE(10);
                getModel().nextEntry();
            }

            if (keyH.enter) {
                if (getModel().isSelectedExit()) game.setState(null);

                if (getModel().isSelectedStart()) {
                    game.stopMusic();
                    game.playMusic(0);
                    game.setState(new GameState(new Arena()));
                }

                if (getModel().isSelectedHighScores()) game.setState(new ScoreListState(new ScoreList()));

                if (getModel().isSelectedSettings())
                    game.setState(new OptionsState(new Options(game.getMusic().volumeScale, game.getSoundEffect().volumeScale)));

                if (getModel().isSelectedInstructions()) game.setState(new InstructionState(new Instructions()));

            }
        }
    }
}


