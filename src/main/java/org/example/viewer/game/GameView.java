package org.example.viewer.game;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.Element;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.viewer.View;
import org.example.viewer.game.elements.ElementView;
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

import java.util.List;

public class GameView extends View<Arena> {
    public GameView(Arena arena) { super(arena);}

    @Override
    public void drawElements(GUI gui) {
        //DRAW TIME
        drawElement(gui, getModel().getTime(), new TimeView());

        //DRAW SURFACES
        drawElements(gui, getModel().getWalls(), new WallsView());
        drawElements(gui, getModel().getLava(), new LavaView());
        drawElements(gui, getModel().getWater(), new WaterView());
        drawElements(gui, getModel().getElevators(), new ElevatorView());
        drawElements(gui, getModel().getButtons(), new ButtonView());

        //DRAW COINS
        drawElements(gui, getModel().getWaterCoins(), new WaterCoinView());
        drawElements(gui, getModel().getLavaCoins(), new LavaCoinView());

        //DRAW PLAYERS
        drawElement(gui, getModel().getLavaBoy(), new LavaBoyView());
        drawElement(gui, getModel().getWaterGirl(), new WaterGirlView());

        //DRAW MONSTERS
        drawElements(gui, getModel().getWaterMonsters(), new WaterMonsterView());
        drawElements(gui, getModel().getLavaMonsters(), new LavaMonsterView());
        drawElements(gui, getModel().getBoss(), new FinalBossView());

        //DRAW POWERS
        drawElements(gui, getModel().getLavaPowers(), new LavaPowerView());
        drawElements(gui, getModel().getWaterPowers(), new WaterPowerView());
        drawElements(gui, getModel().getBossPowers(), new BossPowerView());

        //DRAW DOORS
        drawElement(gui, getModel().getLavaDoor(), new LavaBoyDoorView());
        drawElement(gui, getModel().getWaterDoor(), new WaterGirlDoorView());

        //LAVABOY HEARTS
        drawHearts(gui, getModel().getLavaBoy().life, new Position(4, gui.getHeight()-2), "#FF0000" );

        //WATERGIRL HEARTS
        drawHearts(gui, getModel().getWaterGirl().life, new Position(gui.getWidth()- 8 , gui.getHeight()-2), "#00FFFF" );

        //BOSS HEARTS (smaller hearts)
        for(FinalBoss boss : getModel().getBoss()) {
            drawBossHearts(gui, boss, new Position(boss.getPosition().getX() - 1, boss.getPosition().getUp().getY()),
                    new Position(boss.getPosition().getX() + 1, boss.getPosition().getUp().getY()));
        }

        drawPause(gui);
    }

    // DRAW PAUSE SYMBOL
    private void drawPause(GUI gui){ gui.drawText(new Position(gui.getWidth()-4, 1), "}", "#00FFFF");}

    // DRAW LIFE HEARTS
    private void drawHearts(GUI gui, int life, Position first_position, String color){
        for(int i = 0; i < life; i++){
            gui.drawHeart(new Position(first_position.getX() + 2*i, first_position.getY()), color );
        }

        for(int i = life; i < 3; i++){
            gui.drawHeart(new Position(first_position.getX() + 2*i, first_position.getY()), "#D3D3D3" );
        }

    }

    //DRAW BOSS LIFE HEARTS
    private void drawBossHearts(GUI gui,  FinalBoss boss, Position lava_position, Position water_position){
        for(int i = 0; i < boss.lavaLife; i++){
            gui.drawLittleHeart(new Position(lava_position.getX() + i, lava_position.getY()), "#FF0000");
        }

        for(int i = 0; i < boss.waterLife; i++){
            gui.drawLittleHeart(new Position(water_position.getX() + i, water_position.getY()), "#00FFFF");
        }
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementView<T> view) {
        for (T element : elements)
            drawElement(gui, element, view);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementView<T> view) {
        view.draw(element, gui);
    }

}
