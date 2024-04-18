package org.example.model.game;

import org.example.model.Position;
import org.example.model.game.elements.monster.FinalBoss;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArena {

    Arena arenaTest;

    @BeforeEach
    void setUp() {
        char[][] map = new char[3][4];
        map[0][0] = 'o'; // wall
        map[0][1] = 'l'; // lava
        map[0][2] = 'E'; // elevator
        map[0][3] = 'a'; // water
        map[1][0] = 'B'; // button
        map[1][1] = 'v'; // waterCoin
        map[1][2] = 'p'; // lavaCoin
        map[1][3] = 'M'; // waterMonster
        map[2][0] = 'n'; // lavaMonster
        map[2][1] = 'W'; // waterGirl
        map[2][2] = 'F'; // lavaBoy
        map[2][3] = 'o'; // wall

        arenaTest = new Arena(map);
    }

    @Test
    public void createMapTest() {
        assertEquals(2, arenaTest.getWalls().size());
        assertEquals(1, arenaTest.getLava().size());
        assertEquals(1, arenaTest.getWater().size());
        assertEquals(1, arenaTest.getElevators().size());
        assertEquals(1, arenaTest.getButtons().size());
        assertEquals(1, arenaTest.getWaterCoins().size());
        assertEquals(1, arenaTest.getLavaCoins().size());
        assertEquals(1, arenaTest.getWaterMonsters().size());
        assertEquals(1, arenaTest.getLavaMonsters().size());
        assertEquals(new Position(2, 2), arenaTest.getLavaBoy().getPosition());
        assertEquals(new Position(1, 2), arenaTest.getWaterGirl().getPosition());
    }

    @Test
    void elevatorTest(){
        char[][] map = new char[3][3];
        map[1][1] = 'E'; // watergirl
        map[0][1] = 'E'; // elevator
        map[1][0] = 'o'; // wall
        map[0][0] = 'F'; // waterBoy

        arenaTest = new Arena(map);

        assertFalse(arenaTest.canAllMoveDown());
        assertFalse(arenaTest.canAllMoveUp());
    }

    @Test
    void onSurface() {
        assertTrue(arenaTest.onSurface(new Position(0, -1)));
        assertFalse(arenaTest.onSurface(new Position(0, -2)));
    }

    @Test
    void canMoveTest(){
        assertFalse(arenaTest.canMove(new Position(0, 0)));
        assertFalse(arenaTest.canMove(new Position(2, 0)));
        assertFalse(arenaTest.canMove(new Position(0, 1)));
    }

    @Test
    void onElevatorTest() {
        assertTrue(arenaTest.onElevator(new Position(2, -1)));

        assertFalse(arenaTest.onElevator(new Position(0, 0)));
    }

    @Test
    void isButtonPressedTest(){
        assertTrue(arenaTest.isButtonPressed(new Position(0, 0)));

        assertFalse(arenaTest.isButtonPressed(new Position(1, 0)));
    }

    @Test
    void deathLavaMonsterTest(){
        assertTrue(arenaTest.deathLavaMonster(new Position(0, 2)));
        assertEquals(0, arenaTest.getLavaMonsters().size());

        assertFalse(arenaTest.deathLavaMonster(new Position(0, 0)));
    }

    @Test
    void deathWaterMonsterTest(){
        assertTrue(arenaTest.deathWaterMonster(new Position(3, 1)));
        assertEquals(0, arenaTest.getWaterMonsters().size());

        assertFalse(arenaTest.deathWaterMonster(new Position(0, 0)));
    }

    @Test
    void retrieveWaterCoin(){
        assertTrue(arenaTest.retrieveWaterCoin(new Position(1, 1)));
        assertEquals(0, arenaTest.getWaterCoins().size());

        assertFalse(arenaTest.retrieveWaterCoin(new Position(0, 0)));
    }

    @Test
    void retrieveLavaCoin(){
        assertTrue(arenaTest.retrieveLavaCoin(new Position(2, 1)));
        assertEquals(0, arenaTest.getLavaCoins().size());

        assertFalse(arenaTest.retrieveLavaCoin(new Position(0, 0)));
    }

    @Test
    void checkLavaDeathTest(){
        assertTrue(arenaTest.checkLavaDeath(new Position(1, 0)));
        assertFalse(arenaTest.checkLavaDeath(new Position(0, 0)));
    }

    @Test
    void checkWaterDeathTest(){
        assertTrue(arenaTest.checkWaterDeath(new Position(3, 0)));
        assertFalse(arenaTest.checkWaterDeath(new Position(0, 0)));
    }

    @Test
    void bossViewTest(){
        FinalBoss finalBossTest;
        finalBossTest = new FinalBoss(1, 1);
        assertTrue(arenaTest.bossView( finalBossTest, new Position(1, 1)));

        assertTrue(arenaTest.bossView( finalBossTest, new Position( 3, 1))); // xMAX = 3, xMIN = 0
        assertTrue(arenaTest.bossView( finalBossTest, new Position( 0, 1)));

        assertFalse(arenaTest.bossView( finalBossTest, new Position( -1, 1)));
        assertFalse(arenaTest.bossView( finalBossTest, new Position( 4, 1)));
    }

}
