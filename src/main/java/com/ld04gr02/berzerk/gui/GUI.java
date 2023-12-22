package com.ld04gr02.berzerk.gui;

import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.model.menu.InstructionsMenu;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.model.menu.PauseMenu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public interface GUI {
    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    public void drawFrame(int width, int height);

    public void drawWall(Position position, String color);

    public void drawSprite(Position position, String[] sprite, char symbol, String color);

    public void drawSprite2(int posX, int posY, String[] sprite, char symbol, String color);

    void drawText(Position position, String text, String color);

    public void drawText2(int x, int y, String text, String color);

    void drawBlinkText(Position position, String text, String color);

    public void drawBlinkText2(int x, int y, String text, String color);

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