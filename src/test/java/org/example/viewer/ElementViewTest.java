package org.example.viewer;

import org.example.gui.GUI;
import org.example.model.game.elements.time.Time;
import org.example.model.game.elements.coin.LavaCoins;
import org.example.model.game.elements.coin.WaterCoins;
import org.example.model.game.elements.door.LavaBoyDoor;
import org.example.model.game.elements.door.WaterGirlDoor;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.model.game.elements.monster.LavaMonster;
import org.example.model.game.elements.monster.WaterMonster;
import org.example.model.game.elements.player.LavaBoy;
import org.example.model.game.elements.player.WaterGirl;
import org.example.model.game.elements.power.BossPower;
import org.example.model.game.elements.power.LavaPower;
import org.example.model.game.elements.power.WaterPower;
import org.example.model.game.elements.surface.*;
import org.example.viewer.game.elements.TimeView;
import org.example.viewer.game.elements.coin.LavaCoinView;
import org.example.viewer.game.elements.coin.WaterCoinView;
import org.example.viewer.game.elements.door.LavaBoyDoorView;
import org.example.viewer.game.elements.door.WaterGirlDoorView;
import org.example.viewer.game.elements.monster.FinalBossView;
import org.example.viewer.game.elements.monster.LavaMonsterView;
import org.example.viewer.game.elements.monster.WaterMonsterView;
import org.example.viewer.game.elements.player.LavaBoyView;
import org.example.viewer.game.elements.player.WaterGirlView;
import org.example.viewer.game.elements.power.BossPowerView;
import org.example.viewer.game.elements.power.LavaPowerView;
import org.example.viewer.game.elements.power.WaterPowerView;
import org.example.viewer.game.elements.surface.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ElementViewTest {
    GUI gui;
    WaterGirl girl;
    WaterGirlView girlView;

    Water water;
    WaterView waterView;

    LavaBoy boy;
    LavaBoyView boyView;

    Lava lava;
    LavaView lavaView;

    Elevator elevator;
    ElevatorView elevatorView;

    Button button;
    ButtonView buttonView;

    Wall walls;
    WallsView wallsView;

    WaterCoins waterCoin;
    WaterCoinView waterCoinView;

    LavaCoins lavaCoin;
    LavaCoinView lavaCoinView;

    WaterMonster waterMonster;
    WaterMonsterView waterMonsterView;

    LavaMonster lavaMonster;
    LavaMonsterView lavaMonsterView;

    FinalBoss finalBoss;
    FinalBossView finalBossView;

    WaterPower waterPower;
    WaterPowerView waterPowerView;

    LavaPower lavaPower;
    LavaPowerView lavaPowerView;

    BossPower bossPower;
    BossPowerView bossPowerView;

    WaterGirlDoor waterGirlDoor;
    WaterGirlDoorView waterGirlDoorView;

    LavaBoyDoor lavaBoyDoor;
    LavaBoyDoorView lavaBoyDoorView;

    Time time;
    TimeView timeView;


    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void checkGirlDraw(){
        girl = new WaterGirl(1,1);
        girlView = new WaterGirlView();
        boolean bool=true;
        girlView.draw(girl,gui);
        Mockito.verify(gui, Mockito.times(1)).drawWaterGirl(girl.getPosition(),bool);
    }

    @Test
    void checkBoyDraw(){
        boy = new LavaBoy(1,1);
        boyView = new LavaBoyView();
        boolean bool=true;
        boyView.draw(boy,gui);
        Mockito.verify(gui, Mockito.times(1)).drawLavaBoy(boy.getPosition(),bool);
    }

    @Test
    void checkWaterDraw() {
        water= new Water(1,1);
        waterView= new WaterView();
        waterView.draw(water,gui);
        Mockito.verify(gui, Mockito.times(1)).drawWater(water.getPosition());
    }

    @Test
    void checkLavaDraw() {
        lava = new Lava(1,1);
        lavaView = new LavaView();
        lavaView.draw(lava,gui);
        Mockito.verify(gui, Mockito.times(1)).drawLava(lava.getPosition());
    }

    @Test
    void checkWallDraw(){
        walls = new Wall(1,1);
        wallsView = new WallsView();
        wallsView.draw(walls,gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(walls.getPosition());
    }

    @Test
    void checkElevatorDraw() {
        elevator = new Elevator(1,1);
        elevatorView= new ElevatorView();
        elevatorView.draw(elevator,gui);
        Mockito.verify(gui, Mockito.times(1)).drawElevator(elevator.getPosition());
    }

    @Test
    void checkButtonDraw() {
        button= new Button(1,1);
        buttonView= new ButtonView();
        buttonView.draw(button,gui);
        Mockito.verify(gui, Mockito.times(1)).drawButton(button.getPosition());
    }

    @Test
    void checkWaterCoinDraw() {
        waterCoin= new WaterCoins(1,1);
        waterCoinView= new WaterCoinView();
        waterCoinView.draw(waterCoin,gui);
        Mockito.verify(gui, Mockito.times(1)).drawWaterCoin(waterCoin.getPosition());
    }

    @Test
    void checkLavaCoinDraw(){
        lavaCoin= new LavaCoins(1,1);
        lavaCoinView= new LavaCoinView();
        lavaCoinView.draw(lavaCoin,gui);
        Mockito.verify(gui, Mockito.times(1)).drawLavaCoin(lavaCoin.getPosition());
    }

    @Test
    void checkWaterMonsterDraw(){
        waterMonster= new WaterMonster(1,1);
        waterMonsterView= new WaterMonsterView();
        waterMonsterView.draw(waterMonster,gui);
        Mockito.verify(gui, Mockito.times(1)).drawWaterMonster(waterMonster.getPosition());
    }

    @Test
    void checkLavaMonsterDraw(){
        lavaMonster= new LavaMonster(1,1);
        lavaMonsterView= new LavaMonsterView();
        lavaMonsterView.draw(lavaMonster,gui);
        Mockito.verify(gui, Mockito.times(1)).drawLavaMonster(lavaMonster.getPosition());

    }

    @Test
    void checkWaterDoorDraw(){
        waterGirlDoor= new WaterGirlDoor(1,1);
        waterGirlDoorView= new WaterGirlDoorView();
        waterGirlDoorView.draw(waterGirlDoor,gui);
        Mockito.verify(gui, Mockito.times(1)).drawWaterDoor(waterGirlDoor.getPosition());
    }

    @Test
    void checkLavaDoorDraw() {
        lavaBoyDoor= new LavaBoyDoor(1,1);
        lavaBoyDoorView= new LavaBoyDoorView();
        lavaBoyDoorView.draw(lavaBoyDoor,gui);
        Mockito.verify(gui, Mockito.times(1)).drawLavaDoor(lavaBoyDoor.getPosition());
    }

    @Test
    void checkWaterPowerDraw() {
        waterPower= new WaterPower(1,1);
        waterPowerView= new WaterPowerView();
        waterPowerView.draw(waterPower,gui);
        Mockito.verify(gui, Mockito.times(1)).drawWaterPower(waterPower.getPosition());
    }

    @Test
    void checkLavaPowerDraw(){
        lavaPower= new LavaPower(1,1);
        lavaPowerView= new LavaPowerView();
        lavaPowerView.draw(lavaPower,gui);
        Mockito.verify(gui, Mockito.times(1)).drawLavaPower(lavaPower.getPosition());
    }

    @Test
    void checkBossPowerDraw(){
        bossPower= new BossPower(1,1);
        bossPowerView= new BossPowerView();
        bossPowerView.draw(bossPower,gui);
        Mockito.verify(gui, Mockito.times(1)).drawBossPower(bossPower.getPosition());
    }

    @Test
    void checkFinalBossDraw(){
        finalBoss= new FinalBoss(1,1);
        boolean bool=false;
        finalBossView= new FinalBossView();
        finalBossView.draw(finalBoss,gui);
        Mockito.verify(gui, Mockito.times(1)).drawFinalBoss(finalBoss.getPosition(),bool);

    }

    @Test
    void checkTimeDraw(){
        time = new Time(1, 1);
        timeView = new TimeView();
        timeView.draw(time, gui);
        Mockito.verify(gui, Mockito.times(1)).drawTime(time.getMinutes(),time.getSeconds());
    }

}