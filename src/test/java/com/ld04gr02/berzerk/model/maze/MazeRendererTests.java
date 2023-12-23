package com.ld04gr02.berzerk.model.maze;

import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MazeRendererTests extends Assertions {
    private MazeRenderer mazeRenderer;
    private Maze maze;

    @BeforeEach
    public void setUp() throws IOException {
        mazeRenderer = new MazeRenderer();
        maze = mazeRenderer.createMaze("maze_test.lvl");
    }

    @Test
    public void sizeTest() {
        assertEquals(32, maze.getWidth());
        assertEquals(238, maze.getHeight());
    }

    @Test
    public void elementsTest() {
        assertEquals(10, maze.getStickMan().getPosition().getX());
        assertEquals(111, maze.getStickMan().getPosition().getY());
        assertEquals(new Position(10,111), maze.getStickMan().getPosition());
        assertEquals(81, maze.getWalls().size());
        assertEquals(3, maze.getRobots().size());
        assertEquals(new Position(7,2), maze.getRobots().get(0).getPosition());
        assertEquals(new Position(-20,119), maze.getEvilSmile().getPosition());
    }

    @Test
    public void emptyMazeTest() throws IOException {
        maze = mazeRenderer.createMaze("empty_maze_test.lvl");
        assertEquals(0, maze.getWalls().size());
        assertEquals(0, maze.getGates().size());
        assertEquals(0, maze.getRobots().size());
    }

}
