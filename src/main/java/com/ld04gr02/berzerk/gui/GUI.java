package com.ld04gr02.berzerk.gui;

import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.model.menu.MainMenu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public interface GUI {
    void clear();

    void refresh() throws IOException;

    void close() throws IOException;


    public void drawStickMan(Position position, String[] sprite, boolean collided);

    public void drawWall(Position position);
    public void drawRobot(Position position);

    public void drawLives(int lives);
    public void drawScore();
    public void drawNumbers(int score);

    public void drawMainMenu(MainMenu model);
    public void drawGameOverMenu(GameOverMenu model);
    public KEY getPressedKey() throws IOException;
    public String getCharPressedKey() throws IOException;


    public void createGameScreen(int width, int height) throws URISyntaxException, IOException, FontFormatException;
    public void createMenuScreen(int width, int height) throws IOException, URISyntaxException, FontFormatException;

    enum KEY {
        ARROW_LEFT,
        ARROW_RIGHT,
        ARROW_UP,
        ARROW_DOWN,
        ENTER,
        ESC,
        SPACE,
        CHAR,
        NONE;
    }
}