package org.example.controller.state;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.KeyHandler;
import org.example.model.game.Arena;
import org.example.model.state.GamePause;
import org.example.model.menu.Menu;
import org.example.state.GameState;
import org.example.state.MenuState;

import java.io.IOException;

public class PauseController extends Controller<GamePause> {
    public int actionLockCounter = 0;

    public PauseController(GamePause pause) { super(pause);}

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException {
        actionLockCounter++;

        if (actionLockCounter > 1) {
            actionLockCounter=0;

            if (keyH.up) {
                game.playSE(10);
                getModel().previousEntry();
            }

            if (keyH.down) {
                game.playSE(10);
                getModel().nextEntry();
            }

            if (keyH.enter) {
                if (getModel().isSelectedContinue()) {
                    game.setState(new GameState(getModel().getArena()));
                    game.playMusic(0);
                }

                if (getModel().isSelectedTryAgain()) {
                    game.setState(new GameState(new Arena()));
                    game.playMusic(0);
                }

                if (getModel().isSelectedBack()) {
                    game.setState(new MenuState(new Menu()));
                    game.playMusic(11);
                }

            }
        }
    }
}
