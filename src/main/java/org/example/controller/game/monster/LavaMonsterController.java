package org.example.controller.game.monster;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.Monster;

import java.io.IOException;
import java.util.Random;

public class LavaMonsterController extends MonsterController{
    private int actionLockCounter = 0;

    public LavaMonsterController(Arena arena) { super(arena);}

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException {
        actionLockCounter++;

        if (actionLockCounter == 6) {
            Random random = new Random();
            int rd = random.nextInt(100) +1; //pick up a number from 1 to 100

            for (Monster monster : getModel().getLavaMonsters()) {
                randomMove(monster, rd);
            }

            actionLockCounter = 0;
        }
    }
}
