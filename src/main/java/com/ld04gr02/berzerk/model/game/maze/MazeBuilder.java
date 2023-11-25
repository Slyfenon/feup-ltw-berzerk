package com.ld04gr02.berzerk.model.game.maze;

import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.elements.Wall;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface MazeBuilder {
    Maze createMaze(String name) throws IOException;
}