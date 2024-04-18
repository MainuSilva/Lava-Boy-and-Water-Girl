package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.gui.KeyHandler;
import org.example.model.menu.Menu;
import org.example.model.menu.Options;
import org.example.state.MenuState;

import java.io.IOException;

public class OptionsController extends Controller<Options> {
    public int actionLockCounter = 0;

    public OptionsController(Options options) { super(options);}

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

            if (getModel().isSelectedMusic()) {
                //DECREASE SOUND OF MUSIC
                if (keyH.left && game.getMusic().volumeScale > 0) {
                    getModel().musicVolume--;
                    game.getMusic().volumeScale--;
                    game.getMusic().checkVolume();
                    game.playSE(10);

                }

                //INCREASE SOUND OF MUSIC
                if (keyH.right && game.getMusic().volumeScale < 5) {
                    getModel().musicVolume++;
                    game.getMusic().volumeScale++;
                    game.getMusic().checkVolume();
                    game.playSE(10);

                }
            }

            if (getModel().isSelectedSE()) {
                //DECREASE SOUND OF SE
                if (keyH.left && game.getSoundEffect().volumeScale > 0) {
                    getModel().seVolume--;
                    game.getSoundEffect().volumeScale--;
                    game.getSoundEffect().checkVolume();
                    game.playSE(10);

                }

                //INCREASE SOUND OF SE
                if (keyH.right && game.getSoundEffect().volumeScale < 5) {
                    getModel().seVolume++;
                    game.getSoundEffect().volumeScale++;
                    game.getSoundEffect().checkVolume();
                    game.playSE(10);

                }
            }
        }

        if (keyH.enter && getModel().isSelectedBack()) {
            game.setState(new MenuState(new Menu()));
        }
    }

}
