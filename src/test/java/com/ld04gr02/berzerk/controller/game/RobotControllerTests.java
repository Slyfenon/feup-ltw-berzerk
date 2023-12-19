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

public class RobotControllerTests extends Assertions {
    private RobotController robotController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze_test2.lvl");
        robotController = new RobotController(maze);
        game = new Game(null);
    }

    @Test
    public void moveRobotTest() throws IOException, URISyntaxException, FontFormatException {
        robotController.update(game, ARROW_RIGHT, System.currentTimeMillis());
        assertEquals(7, robotController.getModel().getRobots().size());
        assertTrue(robotController.getModel().getRobots().get(4).isCollided());
        assertTrue(robotController.getModel().getRobots().get(5).isCollided());
    }

    @Test
    public void moveRobotCollidedTest() throws IOException, URISyntaxException, FontFormatException {
        robotController.getModel().getRobots().get(0).setCollided(true);
        assertEquals(7, robotController.getModel().getRobots().size());
        robotController.update(game, ARROW_RIGHT, System.currentTimeMillis());
        assertEquals(6, robotController.getModel().getRobots().size());
    }
}