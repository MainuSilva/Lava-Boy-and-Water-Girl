package org.example.controller.game.monster;

import org.example.controller.game.GameController;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.Monster;

import java.util.Random;

public abstract class MonsterController extends GameController {

    public MonsterController(Arena arena) { super(arena);}

    public void moveMonsterLeft(Monster monster) {
        if (!getModel().canMove(monster.getPosition().getLeft().getDown()))
            moveMonster(monster , monster.getPosition().getLeft());
    }

    public void moveMonsterRight(Monster monster) {
        if(!getModel().canMove(monster.getPosition().getRight().getDown()))
            moveMonster( monster, monster.getPosition().getRight());
    }

    public void moveMonsterUp(Monster monster) { moveMonster(monster, monster.getPosition().getUp());}

    public void moveMonsterDown(Monster monster) { moveMonster( monster, monster.getPosition().getDown());}

    private void moveMonster(Monster monster, Position new_position) {
        if(getModel().canMove(new_position)){
            monster.setPosition(new_position);
        }
    }

    public void randomMove(Monster monster, int rd){
        if(rd <= 20 && getModel().onSurface(monster.getPosition()))
            for(int i = 0; i < 2; i++)
                moveMonsterUp(monster);

        else if(rd > 20 && rd <= 60) moveMonsterLeft(monster);

        else moveMonsterRight(monster);

    }

}
