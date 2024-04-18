package org.example.gui;

import org.example.model.Position;

import java.io.IOException;

public interface GUI {

    int getWidth();
    int getHeight();

    //PLAYERS
    void drawLavaBoy(Position position, Boolean isRight);
    void drawWaterGirl(Position position, Boolean isRight);

    //SURFACES
    void drawWall(Position position);
    void drawElevator(Position position);
    void drawButton(Position position);
    void drawLava(Position position);
    void drawWater(Position position);

    //COINS
    void drawLavaCoin(Position position);
    void drawWaterCoin(Position position);

    //MONSTERS
    void drawLavaMonster(Position position);
    void drawWaterMonster(Position position);
    void drawFinalBoss(Position position, Boolean isRight);

    //POWERS
    void drawWaterPower(Position position);
    void drawLavaPower(Position position);
    void drawBossPower(Position position);

    //HEARTS
    void drawHeart(Position position, String color);
    void drawLittleHeart(Position position, String color);

    //DOORS
    void drawWaterDoor(Position position);
    void drawLavaDoor(Position position);

    //TIME
    void drawTime(int minutes, int seconds);

    //STAR
    void drawStar(Position position, String color);

    void drawStarScore(Position position, int starsNumber);

    void drawText(Position position, String text, String color);

    void drawText(Position position, String text, String color, String type);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}
