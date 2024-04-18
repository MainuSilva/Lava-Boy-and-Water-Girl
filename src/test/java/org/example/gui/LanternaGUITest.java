package org.example.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LanternaGUITest {
    private TerminalScreen screen;
    private LanternaGUI gui;
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        screen = mock(TerminalScreen.class);
        textGraphics = mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui = Mockito.spy(new LanternaGUI(screen));
    }


    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "hehe", "#336699");
        gui.drawText(new Position(1, 1), "hehe", "#336699", "BOLD");
        gui.drawText(new Position(1, 1), "hehe", "#336699", "BLINK");
        gui.drawText(new Position(1, 1), "hehe", "#336699", " ");

        Mockito.verify(textGraphics, Mockito.times(4)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(textGraphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(textGraphics, Mockito.times(1)).enableModifiers(SGR.BLINK);
        Mockito.verify(textGraphics, Mockito.times(4)).putString(1, 1, "hehe");
    }

    @Test
    void drawWaterGirl(){
        gui.drawWaterGirl(new Position(1,1), true);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(64, 224, 208));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "J");
    }

    @Test
    void drawLavaBoy(){
        gui.drawLavaBoy(new Position(1,1), true);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 36, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "j");
    }

    @Test
    void drawWall(){
        gui.drawWall(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(211, 211, 211));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "g");
    }

    @Test
    void drawElevator(){
        gui.drawElevator(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "r");
    }

    @Test
    void drawButton(){
        gui.drawButton(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "y");
    }

    @Test
    void drawLava(){
        gui.drawLava(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "h");
    }

    @Test
    void drawWater(){
        gui.drawWater(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 255, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "h");
    }

    @Test
    void drawLavaCoin(){
        gui.drawLavaCoin(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "o");
    }

    @Test
    void drawWaterCoin(){
        gui.drawWaterCoin(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 255, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "o");
    }

    @Test
    void drawWaterMonster(){
        gui.drawWaterMonster(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 0, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "~");
    }

    @Test
    void drawLavaMonster(){
        gui.drawLavaMonster(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(139, 0, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "m");
    }

    @Test
    void drawFinalBoss(){
        gui.drawFinalBoss(new Position(1,1), true);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(240, 15, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "+");
    }

    @Test
    void drawWaterPower(){
        gui.drawWaterPower(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 0, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "[");
    }

    @Test
    void drawLavaPower(){
        gui.drawLavaPower(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(139, 0, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "]");
    }

    @Test
    void drawBossPower(){
        gui.drawBossPower(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(240, 15, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "u");
    }

    @Test
    void drawWaterDoor(){
        gui.drawWaterDoor(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 255, 255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "s");
    }

    @Test
    void drawLavaDoor(){
        gui.drawLavaDoor(new Position(1,1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "t");
    }

    @Test
    void drawStar(){
        gui.drawStar(new Position(1,1), "#FFFF00");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "x");
    }

    @Test
    void drawHeart(){
        gui.drawHeart(new Position(1,1), "#FFFF00");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "p");
    }

    @Test
    void drawLittleHeart(){
        gui.drawLittleHeart(new Position(1,1), "#FFFF00");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, ")");
    }

    @Test
    void drawStarScore(){
        gui.drawStarScore(new Position(1, 1), 2);

        Mockito.verify(gui, Mockito.times(1)).drawStar(new Position(1, 1), "#FFD700");
        Mockito.verify(gui, Mockito.times(1)).drawStar(new Position(3, 1), "#FFD700");
        Mockito.verify(gui, Mockito.times(1)).drawStar(new Position(5, 1), "#808080");

    }

    @Test
    public void drawTime() {
        String playtime = "10:15";
        Position position = new Position((gui.getWidth()- playtime.length())/2, 1);
        gui.drawTime(10, 15);
        Mockito.verify(gui).drawText(position, "10:15", "#F5F5DC", "BOLD");
    }

    @Test
    void testClear(){
        gui.clear();

        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    void testRefresh() throws IOException {
        gui.refresh();

        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void testClose() throws IOException {
        gui.close();

        Mockito.verify(screen, Mockito.times(1)).close();
    }


}
