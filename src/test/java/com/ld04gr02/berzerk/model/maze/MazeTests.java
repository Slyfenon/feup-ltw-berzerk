package com.ld04gr02.berzerk.model.maze;

import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.elements.Wall;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeTests extends Assertions {
    private Maze maze;

    @BeforeEach
    public void setUp() {
        maze = new Maze(50, 75);
    }

    @Test
    public void mazeTest() {
        assertEquals(50, maze.getWidth());
        assertEquals(75, maze.getHeight());
    }

    @Test
    public void elementsTest() {
        StickMan stickMan = new StickMan(25, 25, Direction.Up);
        maze.setStickMan(stickMan);
        assertEquals(stickMan.getPosition(), maze.getStickMan().getPosition());

        ArrayList<Wall> walls = new ArrayList<>(Arrays.asList(
                new Wall(10, 15, true),
                new Wall(20, 50, true),
                new Wall(40, 10, true),
                new Wall(15, 65, true),
                new Wall(0, 5, true),
                new Wall(46, 20, true),
                new Wall(20, 10, false)
        ));
        maze.setWalls(walls);
        assertEquals(walls.size(), maze.getWalls().size());

        ArrayList<Robot> robots = new ArrayList<>(Arrays.asList(
                new Robot(15, 10, Direction.Up),
                new Robot(12, 20, Direction.Down),
                new Robot(26, 35, Direction.Left),
                new Robot(15, 65, Direction.Down),
                new Robot(30, 70, Direction.Left),
                new Robot(40, 10, Direction.Right)
        ));
        maze.setRobots(robots);
        assertEquals(robots.size(), maze.getRobots().size());
    }

    @Test
    public void collideWallTest() {
        ArrayList<Wall> walls = new ArrayList<>(Arrays.asList(
                new Wall(10, 15, true),
                new Wall(20, 50, true)
        ));
        maze.setWalls(walls);
        ArrayList<Wall> gates = new ArrayList<>(Arrays.asList(
                new Wall(20, 40, true),
                new Wall(25, 60, true)
        ));
        maze.setGates(gates);

        assertTrue(maze.collideWall(new Position(5, 10), 10, 10));
        assertFalse(maze.collideWall(new Position(50, 100), 100, 200));
    }

    @Test
    public void collideRobotTest() {
        ArrayList<Robot> robots = new ArrayList<>(Arrays.asList(
                new Robot(15, 10, Direction.Up),
                new Robot(12, 20, Direction.Down)
        ));
        maze.setRobots(robots);

        assertTrue(maze.collideRobot(new Position(10, 10), 10, 10));
        assertFalse(maze.collideRobot(new Position(50, 100), 10, 10));
    }

    @Test
    public void collideStickManTest() {
        StickMan stickMan = new StickMan(25, 25, Direction.Up);
        maze.setStickMan(stickMan);

        assertTrue(maze.collideStickMan(new Position(20, 20), 10, 10));
        assertFalse(maze.collideStickMan(new Position(50, 100), 10, 10));
    }
}
