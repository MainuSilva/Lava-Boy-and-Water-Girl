package org.example.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import org.example.model.Position;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class LanternaGUI implements GUI{

    private final TerminalScreen screen;
    private int width;
    private int height;

    public LanternaGUI(TerminalScreen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int x_size, int y_size) throws IOException, FontFormatException{
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(x_size, y_size, fontConfig);
        this.screen = createScreen(terminal);
        this.width = x_size;
        this.height = y_size;
        addCloseScreenListener();
    }

    private TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    public Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfiguration) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setTerminalEmulatorTitle("LavaBoy & WaterGirl")
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfiguration);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    public AWTTerminalFontConfiguration loadFont() throws FontFormatException, IOException {
        File fontFile = new File("src/main/resources/font/LastFont.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    public void addKeyboardListener(KeyHandler observer) { ((AWTTerminalFrame) screen.getTerminal()).getComponent(0).addKeyListener(observer);}

    private void addCloseScreenListener() {
        ((AWTTerminalFrame) screen.getTerminal()).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ((AWTTerminalFrame) screen.getTerminal()).dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public int getWidth(){ return width; }
    @Override
    public int getHeight(){ return height; }

    //PLAYERS
    @Override
    public void drawWaterGirl(Position position, Boolean isRight) { drawText(position, isRight ? "J" : "i", "#40E0D0");}
    @Override
    public void drawLavaBoy(Position position, Boolean isRight) { drawText(position, isRight ? "j" : "k", "#FF2400");}

    //SURFACES
    @Override
    public void drawWall(Position position) { drawText(position,  "g", "#D3D3D3", "BOLD");}
    @Override
    public void drawElevator(Position position)  { drawText(position,  "r", "#FFFF00", "BOLD");}
    @Override
    public void drawButton(Position position)  { drawText(position,  "y", "#FFFF00", "BOLD");}
    @Override
    public void drawLava(Position position) { drawText(position, "h", "#ff0000", "BOLD");}
    @Override
    public void drawWater(Position position) { drawText(position, "h", "#00FFFF", "BOLD");}

    //COINS
    @Override
    public void drawLavaCoin(Position position) { drawText(position, "o", "#ff0000", "BOLD");}
    @Override
    public void drawWaterCoin(Position position) { drawText(position, "o", "#00FFFF", "BOLD");}

    //MONSTERS
    @Override
    public void drawLavaMonster(Position position) {drawText(position, "m", "#8B0000");}
    @Override
    public void drawWaterMonster(Position position) { drawText(position, "~", "#0000FF");}
    @Override
    public void drawFinalBoss(Position position, Boolean isRight) { drawText(position, isRight ? "+" : "*", "#F00FFF");}

    //POWERS
    @Override
    public void drawWaterPower(Position position){ drawText(position, "[", "#0000FF");}
    @Override
    public void drawLavaPower(Position position) { drawText(position, "]", "#8B0000");}
    @Override
    public void drawBossPower(Position position) { drawText(position, "u", "#F00FFF");}

    //HEARTS
    @Override
    public void drawHeart(Position position, String color) { drawText(position, "p", color);}
    @Override
    public void drawLittleHeart(Position position, String color) { drawText(position, ")", color);}

    //DOORS
    @Override
    public void drawWaterDoor(Position position) { drawText(position, "s", "#00FFFF", "BOLD");}
    @Override
    public void drawLavaDoor(Position position) { drawText(position, "t", "#CC0000", "BOLD");}

    //TIME - ALREADY HAVE A POSITION
    @Override
    public void drawTime(int minutes, int seconds) {
        String playtime = String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
        drawText( new Position((this.width- playtime.length())/2, 1), playtime, "#F5F5DC", "BOLD");
    }

    //STAR
    public void drawStar(Position position, String color) { drawText(position, "x", color, "BOLD");}

    //WITHOUT TEXT TYPE- DEFAULT
    @Override
    public void drawText(Position position, String text, String color) {
        drawText(position, text, color, "");
    }

    @Override
    public void drawStarScore(Position position, int starsNumber){
        //STARS
        for(int i = 0; i < starsNumber; i++){
            drawStar(new Position( position.getX() + i*2, position.getY()), "#FFD700");
        }

        //NO STARS
        for(int i = starsNumber; i < 3; i++){
            drawStar(new Position(position.getX() + i*2, position.getY()), "#808080");
        }

    }

    //WITH TEXT TYPE
    @Override
    public void drawText(Position position, String text, String color, String type) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        if(type.equals("BOLD")) tg.enableModifiers(SGR.BOLD);
        if(type.equals("BLINK")) tg.enableModifiers(SGR.BLINK);
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void clear() { screen.clear();}

    @Override
    public void refresh() throws IOException { screen.refresh();}

    @Override
    public void close() throws IOException { screen.close();}

}



