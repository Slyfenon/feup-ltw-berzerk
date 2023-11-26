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
        maze = mazeRenderer.createMaze("maze1.lvl");
    }

    @Test
    public void sizeTest() {
        assertEquals(maze.getWidth(), 495);
        assertEquals(maze.getHeight(), 420);
    }

    @Test
    public void ElementsTest() {
        assertEquals(maze.getStickMan().getPosition().getX(), 16*15);
        assertEquals(maze.getStickMan().getPosition().getY(), 12*30);
        assertEquals(maze.getStickMan().getPosition(), new Position(16*15,12*30));
        assertEquals(maze.getWalls().size(), 82);
        assertEquals(maze.getRobots().size(), 3);
        assertEquals(maze.getRobots().get(0).getPosition(), new Position(7*15,2*30));
    }

}
