package org.example.controller.game.player;

import org.example.controller.game.player.LavaBoyController;
import org.example.controller.game.player.WaterGirlController;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
    private Arena arena;
    private WaterGirlController girlController;
    private LavaBoyController boyController;

    @BeforeEach
    void setUp(){
        char[][] map = new char[2][2];
        map[0][0] = 'W'; // watergirl
        map[0][1] = 'F'; // lavaboy
        map[1][0] = 'o'; // wall
        map[1][1] = 'o'; // wall

        arena = new Arena(map);
        girlController = new WaterGirlController(arena);
        boyController = new LavaBoyController(arena);
    }

    @Test
    public void moveNotEmpty() {
        Position boyFirstPosition =  arena.getLavaBoy().getPosition();
        boyController.movePlayerDown(arena.getLavaBoy());
        assertEquals( boyFirstPosition, arena.getLavaBoy().getPosition());
    }

    @Test
    public void moveAllEmpty(){
        girlController.movePlayerUp(arena.getWaterGirl());
        assertEquals( new Position(0, -1), arena.getWaterGirl().getPosition());

        girlController.movePlayerLeft(arena.getWaterGirl());
        assertEquals( new Position(-1, -1), arena.getWaterGirl().getPosition());

        girlController.movePlayerRight(arena.getWaterGirl());
        assertEquals( new Position(0, -1), arena.getWaterGirl().getPosition());

        girlController.movePlayerDown(arena.getWaterGirl());
        assertEquals( new Position(0, 0), arena.getWaterGirl().getPosition());

    }

    @Test
    public void moveToEachOther(){
        Position boyFirstPosition =  arena.getLavaBoy().getPosition();
        Position girlFirstPosition = arena.getWaterGirl().getPosition();
        girlController.movePlayerRight(arena.getWaterGirl());
        boyController.movePlayerLeft(arena.getLavaBoy());
        assertEquals( boyFirstPosition, arena.getLavaBoy().getPosition());
        assertEquals( girlFirstPosition, arena.getWaterGirl().getPosition());
    }

}
