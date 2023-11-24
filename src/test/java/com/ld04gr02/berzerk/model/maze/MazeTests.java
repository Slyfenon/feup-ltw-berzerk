package com.ld04gr02.berzerk.model.maze;

import com.ld04gr02.berzerk.model.game.maze.Maze;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MazeTests extends Assertions {
    private Maze maze;

    @BeforeEach
    public void setUp() {
        maze = new Maze(50, 75);
    }

    @Test
    public void MazeTest() {
        assertEquals(maze.getWidth(), 50);
        assertEquals(maze.getHeight(), 75);
    }
}
