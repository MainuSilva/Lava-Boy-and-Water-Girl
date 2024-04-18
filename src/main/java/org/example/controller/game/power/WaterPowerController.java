package org.example.controller.game.power;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.model.game.elements.power.WaterPower;

import java.io.IOException;
import java.util.Iterator;

public class WaterPowerController extends PowerController{

    public WaterPowerController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException {
        //WATERPOWER
        Iterator<WaterPower> itr = getModel().getWaterPowers().iterator();

        while(itr.hasNext()) {
            WaterPower waterPower = itr.next();
            waterPower.life--;;

            //IF WATERPOWER HITS LAVABOY
            if(waterPower.getPosition().equals(getModel().getLavaBoy().getPosition())){
                game.playSE(7);
                getModel().getLavaBoy().life--;
                waterPower.life = 0;
            }

            //IF WATERPOWER HITS LAVAMONSTER
            if(getModel().deathLavaMonster(waterPower.getPosition())){
                game.playSE(8);
                waterPower.life = 0;
            }

            //IF WATERPOWER HITS A BOSS
            for(FinalBoss boss : getModel().getBoss()) {
                if (waterPower.getPosition().equals(boss.getPosition())) {
                    game.playSE(7);
                    if (boss.lavaLife > 0) boss.lavaLife--;
                    waterPower.life = 0;
                }
            }

            //IF WATERPOWER HITS A WALL OR POWER LIFE = 0
            if(!getModel().canMove(waterPower.getPosition()) || waterPower.life <= 0){
                itr.remove();
            }

            else{
                movePower(waterPower);
            }

        }
    }
}
