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
        assertEquals(maze.getWidth(), 33);
        assertEquals(maze.getHeight(), 238);
    }

    @Test
    public void elementsTest() {
        assertEquals(maze.getStickMan().getPosition().getX(), 16);
        assertEquals(maze.getStickMan().getPosition().getY(), 12);
        assertEquals(maze.getStickMan().getPosition(), new Position(16,12));
        assertEquals(maze.getWalls().size(), 82);
        assertEquals(maze.getRobots().size(), 3);
        assertEquals(maze.getRobots().get(0).getPosition(), new Position(7,2));
    }

    @Test
    public void emptyMazeTest() throws IOException {
        maze = mazeRenderer.createMaze("empty_maze_test.lvl");
        assertNull(maze.getStickMan());
        assertEquals(maze.getWalls().size(), 0);
        assertEquals(maze.getRobots().size(), 0);
    }

}
