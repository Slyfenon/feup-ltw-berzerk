package com.ld04gr02.berzerk.model.game.maze;

import java.io.IOException;

public interface MazeBuilder {
    Maze createMaze(String name) throws IOException;
}