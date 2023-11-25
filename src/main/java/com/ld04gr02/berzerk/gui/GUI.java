package com.ld04gr02.berzerk.gui;

import com.googlecode.lanterna.screen.Screen;
import com.ld04gr02.berzerk.model.Position;

import java.io.IOException;

public interface GUI {
    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    public void drawStickMan(Position position);
    public void drawWall(Position position);
    public void drawRobot(Position position);
    public KEY getPressedKey() throws IOException;

    enum KEY {
        ARROW_LEFT,
        ARROW_RIGHT,
        ARROW_UP,
        ARROW_DOWN,
        ENTER,
        ESC,
        SPACE,
        NONE;
    }
}