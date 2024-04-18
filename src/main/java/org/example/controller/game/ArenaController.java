package org.example.controller.game;

import org.example.Game;
import org.example.controller.game.monster.FinalBossController;
import org.example.controller.game.monster.LavaMonsterController;
import org.example.controller.game.monster.WaterMonsterController;
import org.example.controller.game.player.LavaBoyController;
import org.example.controller.game.player.WaterGirlController;
import org.example.controller.game.power.BossPowerController;
import org.example.controller.game.power.LavaPowerController;
import org.example.controller.game.power.WaterPowerController;
import org.example.controller.game.surface.ElevatorController;
import org.example.gui.KeyHandler;
import org.example.model.game.Arena;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.model.game.elements.monster.LavaMonster;
import org.example.model.game.elements.monster.WaterMonster;
import org.example.model.state.GamePause;
import org.example.model.state.GameWin;
import org.example.model.state.GameOver;
import org.example.state.GameOverState;
import org.example.state.GameWinState;
import org.example.state.PauseState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final LavaBoyController boyController;
    private final WaterGirlController girlController;
    private final WaterMonsterController waterMonsterController;
    private final LavaMonsterController lavaMonsterController;
    private final FinalBossController finalBossController;
    private final WaterPowerController waterPowerController;
    private final LavaPowerController lavaPowerController;
    private final BossPowerController bossPowerController;
    private final TimeController timeController;
    private final ElevatorController elevatorController;
    public int gravityCount = 0; // COUNT OF GRAVITY

    public ArenaController(Arena arena) {
        super(arena);

        this.boyController = new LavaBoyController(arena);
        this.girlController = new WaterGirlController(arena);
        this.waterMonsterController = new WaterMonsterController(arena);
        this.lavaMonsterController = new LavaMonsterController(arena);
        this.finalBossController = new FinalBossController(arena);
        this.waterPowerController = new WaterPowerController(arena);
        this.lavaPowerController = new LavaPowerController(arena);
        this.bossPowerController = new BossPowerController(arena);
        this.timeController = new TimeController(arena);
        this.elevatorController= new ElevatorController(arena);
    }

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException, ClassNotFoundException {
        // PAUSE THE GAME
        if (keyH.pause) {
            game.stopMusic();
            game.setState(new PauseState(new GamePause(getModel())));
            game.playSE(12);
        }

        // GAME LOSS
        else if (getModel().checkLavaDeath(getModel().getWaterGirl().getPosition()) ||
                getModel().checkWaterDeath(getModel().getLavaBoy().getPosition()) ||
                getModel().getWaterGirl().life == 0 ||
                getModel().getLavaBoy().life == 0) {

            game.stopMusic(); // STOP GAME MUSIC LOOP
            game.playSE(6); // SOUND OF DEATH
            game.setState(new GameOverState(new GameOver()));
            game.playSE(2); // SOUND OF GAMEOVER

        }

        //GAME WIN
        else if (getModel().getWaterDoor().getPosition().equals(getModel().getWaterGirl().getPosition()) &&
                getModel().getLavaDoor().getPosition().equals(getModel().getLavaBoy().getPosition()) &&
                getModel().getBoss().isEmpty()){

            game.stopMusic(); // STOP GAME MUSIC LOOP
            GameWin gameWin = new GameWin(getModel().getTime().getPlayTime() , getModel().getWaterCoins().size() + getModel().getWaterCoins().size());
            gameWin.saveScores();
            game.setState(new GameWinState(gameWin));
            game.playSE(1); // SOUND OF GAMEWIN
        }


        else {
            gravityCount++;
            boyController.step(game, keyH);
            girlController.step(game,  keyH);
            lavaMonsterController.step(game, keyH);
            waterMonsterController.step(game, keyH);
            waterPowerController.step(game, keyH);
            lavaPowerController.step(game, keyH);
            bossPowerController.step(game, keyH);
            timeController.step(game, keyH);
            elevatorController.step(game, keyH);
            finalBossController.step(game, keyH);

            if(gravityCount > 2) { // gravity number
                gravity();
                gravityCount = 0;
            }
        }
    }

    // THE GRAVITY OF THE ARENA
    public void gravity() {
        this.boyController.movePlayerDown(getModel().getLavaBoy());
        this.girlController.movePlayerDown(getModel().getWaterGirl());

        for(FinalBoss boss : getModel().getBoss())
            this.finalBossController.moveMonsterDown(boss);

        for(LavaMonster lavaMonster: getModel().getLavaMonsters())
            this.lavaMonsterController.moveMonsterDown(lavaMonster);

        for(WaterMonster waterMonster: getModel().getWaterMonsters())
            this.waterMonsterController.moveMonsterDown(waterMonster);

    }

}



