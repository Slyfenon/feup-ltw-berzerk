package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.gui.GUI.KEY.ARROW_RIGHT;
import static org.mockito.Mockito.mock;

public class RobotControllerTests extends Assertions {
    private RobotController robotController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze_test2.lvl");
        robotController = new RobotController(maze);
        game = mock(Game.class);
    }

    @Test
    public void moveRobotTest() throws IOException, URISyntaxException, FontFormatException, InterruptedException {
        Thread.sleep(2000);
        robotController.update(game, ARROW_RIGHT, System.currentTimeMillis());
        assertEquals(7, robotController.getModel().getRobots().size());
        Thread.sleep(500);
        robotController.update(game, ARROW_RIGHT, System.currentTimeMillis());
        assertEquals(5, robotController.getModel().getRobots().size());
    }
}