package org.example.controller.state;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.KeyHandler;
import org.example.model.game.Arena;
import org.example.model.state.GameWin;
import org.example.model.menu.Menu;
import org.example.state.GameState;
import org.example.state.MenuState;

import java.io.IOException;

public class GameWinController extends Controller<GameWin> {
    public int actionLockCounter = 0;

    public GameWinController(GameWin gameWin) {
        super(gameWin);
    }

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException {
        actionLockCounter++;
        if(actionLockCounter > 1) {
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
                if (getModel().isSelectedExit()) {
                    game.stopSE();
                    game.setState(new MenuState(new Menu()));
                    game.playMusic(11);
                }
                if (getModel().isSelectedPlayAgain()) {
                    game.stopSE();
                    game.setState(new GameState(new Arena()));
                    game.playMusic(0); //PLAY MUSIC AGAIN}
                }
            }
        }
    }
}
