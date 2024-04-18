package org.example.model.game;
import org.example.model.Position;
import org.example.model.game.elements.time.Time;
import org.example.model.game.elements.coin.LavaCoins;
import org.example.model.game.elements.coin.WaterCoins;
import org.example.model.game.elements.door.LavaBoyDoor;
import org.example.model.game.elements.door.WaterGirlDoor;
import org.example.model.game.elements.monster.FinalBoss;
import org.example.model.game.elements.monster.LavaMonster;
import org.example.model.game.elements.monster.WaterMonster;
import org.example.model.game.elements.power.BossPower;
import org.example.model.game.elements.power.LavaPower;
import org.example.model.game.elements.power.WaterPower;
import org.example.model.game.elements.surface.*;
import org.example.model.game.elements.player.LavaBoy;
import org.example.model.game.elements.player.WaterGirl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private final Time time;
    private LavaBoy boy;
    private WaterGirl girl;
    private WaterGirlDoor waterDoor;
    private LavaBoyDoor lavaDoor;
    private List<Wall> walls;
    private List<LavaCoins> lavaCoins;
    private List<WaterCoins> waterCoins;
    private List<LavaMonster> lavaMonsters;
    private List<WaterMonster> waterMonsters;
    private List<FinalBoss> finalBosses;
    private List<Lava> lava;
    private List<Water> water;
    private List<LavaPower> lavaPowers;
    private List<WaterPower> waterPowers;
    private List<BossPower> bossPowers;
    private List<Elevator> elevators;
    private List<Button> buttons;


    public Arena() throws IOException {
        ReadArena mapReader = new ReadArena(new File("src/main/resources/Maps/map.txt"));
        char[][] gameMap = mapReader.readMap();

        this.width = gameMap[0].length;
        this.height = gameMap.length;
        this.time = new Time(0, 0);
        createMap(gameMap);
    }

    public Arena(char[][] gameMap){
        this.width = gameMap[0].length;
        this.height = gameMap.length;
        this.time = new Time(0, 0);
        createMap(gameMap);
    }


    public void createMap(char[][] gameMap) {

        walls = new ArrayList<>();
        lava = new ArrayList<>();
        water = new ArrayList<>();
        elevators = new ArrayList<>();
        buttons = new ArrayList<>();

        lavaCoins = new ArrayList<>();
        waterCoins = new ArrayList<>();

        waterMonsters = new ArrayList<>();
        lavaMonsters = new ArrayList<>();
        finalBosses = new ArrayList<>();

        lavaPowers = new ArrayList<>();
        waterPowers = new ArrayList<>();
        bossPowers = new ArrayList<>();


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                //SURFACES
                if (gameMap[i][j] == 'o') walls.add(new Wall(j, i));
                else if (gameMap[i][j] == 'l') lava.add(new Lava(j, i));
                else if (gameMap[i][j] == 'a') water.add(new Water(j, i));
                else if (gameMap[i][j] == 'E') elevators.add(new Elevator(j, i));
                else if (gameMap[i][j] == 'B') buttons.add(new Button(j, i));

                //PLAYERS
                else if (gameMap[i][j] == 'F') boy = new LavaBoy(j, i);
                else if (gameMap[i][j] == 'W') girl = new WaterGirl(j, i);

                //COINS
                else if (gameMap[i][j] == 'v') waterCoins.add(new WaterCoins(j, i));
                else if (gameMap[i][j] == 'p') lavaCoins.add(new LavaCoins(j, i));

                //MONSTERS
                else if (gameMap[i][j] == 'M') waterMonsters.add(new WaterMonster(j, i));
                else if (gameMap[i][j] == 'n') lavaMonsters.add(new LavaMonster(j, i));
                else if (gameMap[i][j] == 'P') finalBosses.add(new FinalBoss(j, i));

                //FINAL DOORS
                else if (gameMap[i][j] == 'D') waterDoor = new WaterGirlDoor(j, i);
                else if (gameMap[i][j] == 'L') lavaDoor = new LavaBoyDoor(j, i);

            }
        }
    }

    //GET PLAYERS
    public LavaBoy getLavaBoy() {
        return boy;
    }
    public WaterGirl getWaterGirl() {
        return girl;
    }

    //GET FINAL DOORS
    public WaterGirlDoor getWaterDoor() {
        return waterDoor;
    }
    public LavaBoyDoor getLavaDoor() {
        return lavaDoor;
    }

    //GET SURFACES
    public List<Wall> getWalls() {
        return walls;
    }
    public List<Water> getWater() {
        return water;
    }
    public List<Lava> getLava() {
        return lava;
    }
    public List<Button> getButtons() {
        return buttons;
    }
    public List<Elevator> getElevators() { return elevators;}

    //GET COINS
    public List<WaterCoins> getWaterCoins() {
        return waterCoins;
    }
    public List<LavaCoins> getLavaCoins() {
        return lavaCoins;
    }

    //GET MONSTERS
    public List<WaterMonster> getWaterMonsters() {
        return waterMonsters;
    }
    public List<LavaMonster> getLavaMonsters() {
        return lavaMonsters;
    }
    public List<FinalBoss> getBoss() {
        return finalBosses;
    }

    //GET POWERS
    public List<LavaPower> getLavaPowers() {
        return lavaPowers;
    }
    public List<WaterPower> getWaterPowers() {
        return waterPowers;
    }
    public List<BossPower> getBossPowers() { return bossPowers;}

    //GET TIME
    public Time getTime() {
        return time;
    }

    public boolean canMove(Position new_pos) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(new_pos)) return false;

        for (Elevator elevator : elevators)
            if (elevator.getPosition().equals(new_pos)) return false;

        for (Button button : buttons)
            if (button.getPosition().equals(new_pos)) return false;

        return true;
    }

    public boolean onSurface(Position pos) {
        Position under = new Position(pos.getDown());
        return !canMove(under);
    }

    //ELEVATOR FUNCTIONS
    public boolean canAllMoveDown() {
        for (Elevator elevator : elevators) {
            Position new_position = elevator.getPosition().getDown();
            if (!canMove(new_position) || boy.getPosition().equals(new_position) || girl.getPosition().equals(new_position))
                return false;
        }
        return true;
    }

    public boolean canAllMoveUp() {
        for (Elevator elevator : elevators) {
            Position new_position = elevator.getPosition().getUp();
            if (!canMove(new_position) || elevator.getFirst_y() == elevator.getPosition().getY())
                return false;
        }
        return true;
    }

    public boolean onElevator(Position pos) {
        Position under = new Position(pos.getX(), pos.getY() + 1);
        for (Elevator elevator : elevators) {
            if (elevator.getPosition().equals(under)) return true;
        }
        return false;
    }

    public boolean isButtonPressed(Position pos) {
        Position under = new Position(pos.getX(), pos.getY() + 1);
        for (Button button : buttons) {
            if (button.getPosition().equals(under)) return true;
        }
        return false;
    }

    // LAVAMONSTER DEATH
    public boolean deathLavaMonster(Position pos) {
        for (LavaMonster monster : lavaMonsters) {
            if (monster.getPosition().equals(pos)) {
                lavaMonsters.remove(monster);
                return true;
            }
        }
        return false;
    }

    //WATERMONSTER DEATH
    public boolean deathWaterMonster(Position pos) {
        for (WaterMonster monster : waterMonsters) {
            if (monster.getPosition().equals(pos)) {
                waterMonsters.remove(monster);
                return true;
            }
        }
        return false;
    }

    public boolean retrieveWaterCoin(Position pos) {
        for (WaterCoins coin : waterCoins) {
            if (coin.getPosition().equals(pos)) {
                waterCoins.remove(coin);
                return true;
            }
        }
        return false;
    }

    public boolean retrieveLavaCoin(Position pos) {
        for (LavaCoins coin : lavaCoins) {
            if (coin.getPosition().equals(pos)) {
                lavaCoins.remove(coin);
                return true;
            }
        }
        return false;
    }

    public boolean checkLavaDeath(Position pos) {
        for (Lava oneLava : lava) {
            if (oneLava.getPosition().equals(pos)) return true;
        }
        return false;
    }

    public boolean checkWaterDeath(Position pos) {
        for (Water oneWater : water) {
            if (oneWater.getPosition().equals(pos)) return true;
        }
        return false;
    }


    public boolean bossView( FinalBoss boss, Position position) {

        for (int x = 0; x < width; x++) {
            if (position.equals(new Position(x, boss.getPosition().getY()))) {
                return true;
            }
        }
        return false;
    }
}