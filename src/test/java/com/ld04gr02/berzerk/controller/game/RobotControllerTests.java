package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.Robot;
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
        //assertFalse(robotController.getModel().getBullets().isEmpty());
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
        robotController.getModel().getStickMan().setCollided(false);

        Robot robot = new Robot(40, 150, Direction.Left);
        robotController.moveRobot(robot, new Position(10, 150));
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
        robotController.update(game, ARROW_DOWN, 2002);
        assertTrue(robotController.getModel().getBullets().size() >= bullets);
        robotController.update(game, ARROW_DOWN, 2002);
        assertTrue(robotController.getModel().getBullets().size() >= bullets);
    }

    @Test
    public void newBulletTest() {
        Robot robot = new Robot(50, 50, Direction.Up);
        assertEquals(new Position(56, 46), robotController.getNewBulletPosition(robot));

        robot.setDirection(Direction.Down);
        assertEquals(new Position(56, 64), robotController.getNewBulletPosition(robot));

        robot.setDirection(Direction.Left);
        assertEquals(new Position(46, 56), robotController.getNewBulletPosition(robot));

        robot.setDirection(Direction.Right);
        assertEquals(new Position(64, 56), robotController.getNewBulletPosition(robot));

        robot.setDirection(Direction.None);
        assertNull(robotController.getNewBulletPosition(robot));
    }

    @Test
    public void hasViewTest() {
        Robot robot = new Robot(50, 50, Direction.Up);
        assertFalse(robotController.hasView(robot));

        robot.setPosition(new Position(10, 50));
        robot.setDirection(Direction.Down);
        assertTrue(robotController.hasView(robot));

        robot.setPosition(new Position(50, 150));
        robot.setDirection(Direction.Left);
        assertTrue(robotController.hasView(robot));
    }

    @Test
    public void closerTest() {
        Position positionStickMan = robotController.getModel().getStickMan().getPosition();
        Position currentPosition = new Position(50, 50);
        Position newPosition = new Position(50, 50);

        assertFalse(robotController.closer(positionStickMan, currentPosition, newPosition));

        newPosition = new Position(49, 50);
        assertTrue(robotController.closer(positionStickMan, currentPosition, newPosition));

        newPosition = new Position(50, 51);
        assertTrue(robotController.closer(positionStickMan, currentPosition, newPosition));

        newPosition = new Position(51, 49);
        assertFalse(robotController.closer(positionStickMan, currentPosition, newPosition));
    }

    @Test
    public void getNextPositionTest() {
        Position positionStickMan = robotController.getModel().getStickMan().getPosition();
        Robot robot = new Robot(40, 150, Direction.Left);

        assertEquals(new Position(35, 150), robotController.getNextPosition(robot, 0, positionStickMan));
        assertEquals(Direction.Left, robot.getCurrentDirection());

        robot.setPosition(new Position (-40, 150));
        assertEquals(new Position(-35, 150), robotController.getNextPosition(robot, 0, positionStickMan));
        assertEquals(Direction.Right, robot.getCurrentDirection());

        robot.setPosition(new Position (10, 30));
        assertEquals(new Position(10, 35), robotController.getNextPosition(robot, 1, positionStickMan));
        assertEquals(Direction.Down, robot.getCurrentDirection());

        robot.setPosition(new Position (10, 200));
        assertEquals(new Position(10, 195), robotController.getNextPosition(robot, 1, positionStickMan));
        assertEquals(Direction.Up, robot.getCurrentDirection());
    }
}