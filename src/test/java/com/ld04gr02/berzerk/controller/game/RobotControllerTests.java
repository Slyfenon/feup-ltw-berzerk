package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.gui.GUI.KEY.*;
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
        StickMan.setScore(0);
    }

    @Test
    public void moveRobotTest() throws IOException, URISyntaxException, FontFormatException {
        robotController.update(game, ARROW_RIGHT, 501);
        assertEquals(7, robotController.getModel().getRobots().size());
        assertTrue(robotController.getModel().getRobots().get(4).isCollided());
        assertTrue(robotController.getModel().getRobots().get(5).isCollided());

        int x = robotController.getModel().getRobots().get(0).getPosition().getX();
        int y = robotController.getModel().getRobots().get(0).getPosition().getY();
        robotController.update(game, ARROW_RIGHT, 1001);
        assertEquals(5, robotController.getModel().getRobots().size());
        assertEquals(x, robotController.getModel().getRobots().get(0).getPosition().getX());
        assertEquals(y, robotController.getModel().getRobots().get(0).getPosition().getY());

        x = robotController.getModel().getRobots().get(4).getPosition().getX();
        y = robotController.getModel().getRobots().get(4).getPosition().getY();
        robotController.update(game, ARROW_RIGHT, 1502);
        assertTrue(x != robotController.getModel().getRobots().get(4).getPosition().getX() || y != robotController.getModel().getRobots().get(4).getPosition().getY());
        assertFalse(robotController.getModel().getBullets().isEmpty());
    }

    @Test
    public void moveRobotCollidedTest() throws IOException, URISyntaxException, FontFormatException {
        robotController.getModel().getRobots().get(0).setCollided(true);
        assertEquals(7, robotController.getModel().getRobots().size());
        robotController.update(game, ARROW_UP, 1001);
        assertEquals(6, robotController.getModel().getRobots().size());
        assertEquals(50, StickMan.getScore());
        robotController.update(game, ARROW_UP, 2001);
    }

    @Test
    public void collideStickManTest() throws IOException, URISyntaxException, FontFormatException {
        robotController.getModel().getRobots().get(0).setPosition(new Position(10, 150));
        robotController.update(game, ARROW_DOWN, 4000);
        assertTrue(robotController.getModel().getRobots().get(0).isCollided());
        assertTrue(robotController.getModel().getStickMan().isCollided());
    }

    @Test
    public void sideTest() throws IOException, URISyntaxException, FontFormatException {
        int initialX = robotController.getModel().getRobots().get(0).getPosition().getX();
        int initialY = robotController.getModel().getRobots().get(0).getPosition().getY();

        robotController.update(game, ARROW_DOWN, 351);
        assertEquals(initialX, robotController.getModel().getRobots().get(0).getPosition().getX());
        assertTrue(initialY <= robotController.getModel().getRobots().get(0).getPosition().getY());
        robotController.update(game, ARROW_DOWN, 702);
        assertEquals(initialX, robotController.getModel().getRobots().get(0).getPosition().getX());
        assertTrue(initialY <= robotController.getModel().getRobots().get(0).getPosition().getY());
        robotController.update(game, ARROW_DOWN, 1053);
        assertEquals(initialX, robotController.getModel().getRobots().get(0).getPosition().getX());
        assertTrue(initialY <= robotController.getModel().getRobots().get(0).getPosition().getY());
    }

    @Test
    public void sideTest2() throws IOException, URISyntaxException, FontFormatException {
        int initialX = robotController.getModel().getRobots().get(1).getPosition().getX();
        int initialY = robotController.getModel().getRobots().get(1).getPosition().getY();

        robotController.update(game, ARROW_DOWN, 351);
        assertEquals(initialY, robotController.getModel().getRobots().get(1).getPosition().getY());
        assertTrue(initialX >= robotController.getModel().getRobots().get(1).getPosition().getX());
        robotController.update(game, ARROW_DOWN, 702);
        assertEquals(initialY, robotController.getModel().getRobots().get(1).getPosition().getY());
        assertTrue(initialX >= robotController.getModel().getRobots().get(1).getPosition().getX());
        robotController.update(game, ARROW_DOWN, 1053);
        assertEquals(initialY, robotController.getModel().getRobots().get(1).getPosition().getY());
        assertTrue(initialX >= robotController.getModel().getRobots().get(1).getPosition().getX());
    }

    @Test
    public void shootTest() throws IOException, URISyntaxException, FontFormatException {
        robotController.update(game, ARROW_DOWN, 1001);
        int bullets = robotController.getModel().getBullets().size();
        robotController.update(game, ARROW_DOWN, 2001);
        robotController.update(game, ARROW_DOWN, 2001);
        robotController.update(game, ARROW_DOWN, 2001);
        assertEquals(bullets, robotController.getModel().getBullets().size());
    }
}