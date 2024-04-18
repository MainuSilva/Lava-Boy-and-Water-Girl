package org.example.controller.game.monster;

import org.example.Game;
import org.example.gui.KeyHandler;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.model.game.elements.player.Player;
import org.example.model.game.elements.power.BossPower;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

public class FinalBossController extends MonsterController {
    public int cooldown = 0;

    private int actionLockCounter = 0;

    public FinalBossController(Arena arena) {
        super(arena);
    }

    public void powerBoss(FinalBoss boss) {
        Position pos;

        if (boss.isRight()) pos = new Position(boss.getPosition().getRight());

        else pos = new Position(boss.getPosition().getLeft());

        BossPower newPower = new BossPower(pos.getX(), pos.getY());
        newPower.isRight = boss.isRight();
        getModel().getBossPowers().add(newPower);

    }

    public void randomMoveSleepy(FinalBoss boss, int rd) {

        if (rd < 50) {
            boss.setRight(false);
            moveMonsterLeft(boss);
        } else {
            boss.setRight(true);
            moveMonsterRight(boss);
        }

    }

    public void randomMoveAlert(FinalBoss boss, Player player, int rd, Game game) {
        cooldown++;

        //IF THE ENEMY IS LEFT
        if (rd < 50 && player.getPosition().getX() + 1 < boss.getPosition().getX()){
            boss.setRight(false);
            moveMonsterLeft(boss);
        }

        //IF THE ENEMY IS RIGHT
        else if (rd < 50 && player.getPosition().getX() - 1 > boss.getPosition().getX()) {
            boss.setRight(true);
            moveMonsterRight(boss);
        }

        else if (rd < 75 && cooldown > 3) {
            cooldown = 0;
            powerBoss(boss);
            game.playSE(9);
        }

        else if (getModel().onSurface(boss.getPosition()))
            moveMonsterUp(boss);

    }

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException {
        actionLockCounter++;

        Iterator<FinalBoss> itr = getModel().getBoss().iterator();

        while(itr.hasNext()) {
            Random random = new Random();
            int rd = random.nextInt(100) + 1;

            FinalBoss boss = itr.next();

            //FOLLOWS LAVABOY
            if (getModel().bossView(boss, getModel().getLavaBoy().getPosition())) {
                randomMoveAlert(boss, getModel().getLavaBoy(), rd,  game);
            }

            //FOLLOWS WATERGIRL
            else if (getModel().bossView(boss, getModel().getWaterGirl().getPosition())) {
                randomMoveAlert(boss, getModel().getWaterGirl(), rd,  game);
            }

            else if (actionLockCounter > 10) {
                actionLockCounter = 0;
                randomMoveSleepy(boss, rd);
            }

            //BOSS DEATH
            if (boss.lavaLife <= 0 && boss.waterLife <= 0){
                game.playSE(13);
                itr.remove();
            }
        }
    }
}
