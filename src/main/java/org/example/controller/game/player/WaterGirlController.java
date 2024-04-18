package org.example.controller.game.player;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.LavaMonster;
import org.example.model.game.elements.power.WaterPower;

public class WaterGirlController extends PlayerController {

    public WaterGirlController(Arena arena) {
        super(arena);
    }

    @Override
    public void powerPlayer() {
        Position pos;

        if (getModel().getWaterGirl().isRight()) pos = new Position(getModel().getWaterGirl().getPosition().getRight());

        else pos = new Position(getModel().getWaterGirl().getPosition().getLeft());

        WaterPower newWaterPower = new WaterPower(pos.getX(), pos.getY());
        newWaterPower.isRight = getModel().getWaterGirl().isRight();
        getModel().getWaterPowers().add(newWaterPower);
    }

    @Override
    public void step(Game game, KeyHandler keyH){
        cooldown++;

        if (keyH.up && (getModel().onSurface(getModel().getWaterGirl().getPosition()) ||
                getModel().getLavaBoy().getPosition().equals(getModel().getWaterGirl().getPosition().getDown()))) {

            game.playSE(5);
            for (int i = 0; i < 2; i++)
                movePlayerUp(getModel().getWaterGirl());
        }
        if (keyH.right){
            getModel().getWaterGirl().setRight(true);
            movePlayerRight(getModel().getWaterGirl());
        }
        if (keyH.left) {
            getModel().getWaterGirl().setRight(false);
            movePlayerLeft(getModel().getWaterGirl());
        }
        if (keyH.p1Power && cooldown > 10) {
            game.playSE(9);
            powerPlayer();
            cooldown = 0;
        }

        //IF WATERGIRL IN WATERCOIN
        if(getModel().retrieveWaterCoin(getModel().getWaterGirl().getPosition()))
            game.playSE(3);

        //IF WATERGIRL IN LAVA MONSTER
        for(LavaMonster lavamonster: getModel().getLavaMonsters() ){
            if(getModel().getWaterGirl().getPosition().equals(lavamonster.getPosition())){
                game.playSE(7);
                getModel().getWaterGirl().life--;
            }
        }
    }
}
