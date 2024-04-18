package org.example.controller.game.monster;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.Monster;

import java.util.Random;

public class WaterMonsterController extends MonsterController{
    private int actionLockCounter = 0;

    public WaterMonsterController(Arena arena) { super(arena);}

    @Override
    public void step(Game game, KeyHandler keyH) {
        actionLockCounter++;

        if (actionLockCounter == 6) {

            Random random = new Random();
            int rd = random.nextInt(100) +1; //pick up a number from 1 to 100

            for (Monster monster : getModel().getWaterMonsters()) {
                randomMove(monster, rd);
            }

            actionLockCounter = 0;
        }
    }
}
