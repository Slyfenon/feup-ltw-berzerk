package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LanternaGUI screen = new LanternaGUI(100, 100);
        Maze maze = new Maze(screen.getColumns(), screen.getRows());
    }
}
