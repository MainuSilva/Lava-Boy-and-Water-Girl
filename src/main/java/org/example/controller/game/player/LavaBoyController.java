package org.example.controller.game.player;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.WaterMonster;
import org.example.model.game.elements.power.LavaPower;

public class LavaBoyController extends PlayerController {

    public LavaBoyController(Arena arena) { super(arena);}

    @Override
    public void powerPlayer() {
        Position pos;
        if (getModel().getLavaBoy().isRight()) pos = new Position(getModel().getLavaBoy().getPosition().getRight());

        else pos = new Position(getModel().getLavaBoy().getPosition().getLeft());

        LavaPower newLavaPower = new LavaPower(pos.getX(), pos.getY());
        newLavaPower.isRight = getModel().getLavaBoy().isRight();
        getModel().getLavaPowers().add(newLavaPower);
    }

    @Override
    public void step(Game game, KeyHandler keyH) {
        cooldown++;

        if (keyH.p2Up && (getModel().onSurface(getModel().getLavaBoy().getPosition()) ||
                getModel().getWaterGirl().getPosition().equals(getModel().getLavaBoy().getPosition().getDown()))){

            game.playSE(4);
            for (int i = 0; i < 2; i++)
                movePlayerUp(getModel().getLavaBoy());
        }

        if (keyH.p2Right) {
            getModel().getLavaBoy().setRight(true);
            movePlayerRight(getModel().getLavaBoy());
        }

        if (keyH.p2Left){
            getModel().getLavaBoy().setRight(false);
            movePlayerLeft(getModel().getLavaBoy());
        }

        if (keyH.p2Power && cooldown > 10) {
            game.playSE(9);
            powerPlayer();
            cooldown = 0;
        }

        //IF LAVABOY IN LAVACOIN
        if(getModel().retrieveLavaCoin(getModel().getLavaBoy().getPosition()))
            game.playSE(3);

        //IF LAVABOY IN WATERMONSTER
        for(WaterMonster watermonster: getModel().getWaterMonsters() ){
            if(getModel().getLavaBoy().getPosition().equals(watermonster.getPosition())){
                game.playSE(7);
                getModel().getLavaBoy().life--;
            }
        }

    }


}
