package com.ld04gr02.berzerk.gui;

import com.ld04gr02.berzerk.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public interface GUI {
    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    public void drawFrame(int width, int height);

    public void drawWall(Position position, String color);

    public void drawSprite(int posX, int posY, String[] sprite, char symbol, String color);

    public void drawText(int x, int y, String text, String color);

    public void drawBlinkText(int x, int y, String text, String color);

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