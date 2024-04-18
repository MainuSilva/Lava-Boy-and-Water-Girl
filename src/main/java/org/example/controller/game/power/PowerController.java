package org.example.controller.game.power;

import org.example.controller.game.GameController;
import org.example.model.game.Arena;
import org.example.model.game.elements.power.Power;


public  abstract class PowerController extends GameController {

    public PowerController(Arena arena) {super(arena);}

    public void movePowerLeft(Power power) { power.setPosition(power.getPosition().getLeft());}

    public void movePowerRight(Power power) { power.setPosition(power.getPosition().getRight());}

    public void movePower(Power power){
        if(power.isRight)  movePowerRight(power);

        else  movePowerLeft(power);
    }



}
