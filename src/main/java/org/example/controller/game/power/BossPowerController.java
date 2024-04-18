package org.example.controller.game.power;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.game.Arena;
import org.example.model.game.elements.power.BossPower;

import java.io.IOException;
import java.util.Iterator;

public class BossPowerController extends PowerController {

    public BossPowerController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException {

        Iterator<BossPower> itr = getModel().getBossPowers().iterator();

        while(itr.hasNext()) {

            BossPower power = itr.next();

            //BOSS POWER HIT WALLS, BOSS POWER DOESN'T LOSE LIFE
            if(!getModel().canMove(power.getPosition())) itr.remove();

            //BOSS POWER HIT PLAYERS
            else if(power.getPosition().equals(getModel().getLavaBoy().getPosition())){
                game.playSE(7);
                getModel().getLavaBoy().life--;
                itr.remove();
            }
            else if(power.getPosition().equals(getModel().getWaterGirl().getPosition()) ){
                game.playSE(7);
                getModel().getWaterGirl().life--;
                itr.remove();// remove powers if they hit watergirl or lava boy
            }

            else{
                movePower(power);
            }
        }

    }

}
