package org.example.controller.game.power;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.model.game.elements.power.LavaPower;

import java.io.IOException;
import java.util.Iterator;

public class LavaPowerController extends PowerController{

    public LavaPowerController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException {
        //LAVAPOWER
        Iterator<LavaPower> itr = getModel().getLavaPowers().iterator();

        while(itr.hasNext()) {
            LavaPower lavaPower = itr.next();
            lavaPower.life--;

            //IF LAVAPOWER HITS WATERGIRL
            if (lavaPower.getPosition().equals(getModel().getWaterGirl().getPosition())) {
                game.playSE(7);
                getModel().getWaterGirl().life--;
                lavaPower.life = 0;
            }

            //IF LAVAPOWER HITS WATERMONSTER
            if (getModel().deathWaterMonster(lavaPower.getPosition())) {
                game.playSE(8);
                lavaPower.life = 0;
            }

            //IF LAVAPOWER HITS A BOSS
            for (FinalBoss boss : getModel().getBoss()){
                if (lavaPower.getPosition().equals(boss.getPosition())) {
                    game.playSE(7);
                    if (boss.waterLife > 0) boss.waterLife--;
                    lavaPower.life = 0;
                }
            }

            //IF LAVAPOWER HITS A WALL - ELSE TO AVOID ERROR
            if(!getModel().canMove(lavaPower.getPosition()) || lavaPower.life <= 0){
                itr.remove();
            }

            else {
                movePower(lavaPower);
            }
        }
    }
}
