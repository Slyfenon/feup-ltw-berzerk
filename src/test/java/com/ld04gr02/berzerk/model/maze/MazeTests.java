package com.ld04gr02.berzerk.model.maze;

import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.*;
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
                new Wall(10, 15, false),
                new Wall(20, 50, false)
        ));
        maze.setGates(gates);

        assertTrue(maze.collideWall(new Position(5, 10), 10, 10));
        assertFalse(maze.collideWall(new Position(50, 100), 100, 200));
        maze.getWalls().clear();
        assertTrue(maze.collideWall(new Position(5, 10), 10, 10));
        assertFalse(maze.collideWall(new Position(50, 100), 100, 200));
    }

    @Test
    public void collideRobotTest() {
        ArrayList<Robot> robots = new ArrayList<>(Arrays.asList(
                new Robot(15, 10, Direction.Up),
                new Robot(12, 20, Direction.Down),
                new Robot(100, 100, Direction.Left)
        ));
        maze.setRobots(robots);

        assertTrue(maze.collideRobot(new Position(10, 10), 10, 10));
        assertTrue(maze.getRobots().get(0).isCollided());
        assertFalse(maze.getRobots().get(2).isCollided());
        assertFalse(maze.collideRobot(new Position(50, 100), 10, 10));
    }

    @Test
    public void collideStickManTest() {
        StickMan stickMan = new StickMan(25, 25, Direction.Up);
        maze.setStickMan(stickMan);
        assertTrue(maze.collideStickMan(new Position(20, 20), 10, 10));
        assertFalse(maze.collideStickMan(new Position(50, 100), 10, 10));
        assertFalse(maze.collideStickMan(new Position(20, 15), 10, 10));
        assertFalse(maze.collideStickMan(new Position(-10, 15), 20, 20));
        assertTrue(maze.collideStickMan(new Position(30, 25), 10, 10));
    }

    @Test
    public void collideEvilSmileTest() {
        EvilSmile evilSmile = new EvilSmile(25, 25, Direction.Up);
        maze.setEvilSmile(evilSmile);
        assertTrue(maze.collideEvilSmile(new Position(20, 20), 10, 10, true));
        assertTrue(evilSmile.isCollided());
        evilSmile.setCollided(false);
        assertFalse(maze.collideEvilSmile(new Position(50, 100), 10, 10, true));
        assertFalse(evilSmile.isCollided());
        assertFalse(maze.collideEvilSmile(new Position(20, 15), 10, 10, false));
        assertFalse(maze.collideEvilSmile(new Position(-10, 15), 20, 20, false));
        assertTrue(maze.collideEvilSmile(new Position(30, 25), 10, 10, false));
    }

    @Test
    public void collideBulletTest() {
        ArrayList<Bullet> bullets = new ArrayList<>(Arrays.asList(
                new Bullet(25, 8, Direction.Up),
                new Bullet(15, 20, Direction.Left),
                new Bullet(484, 292, Direction.Right),
                new Bullet(440, 292, Direction.Down),
                new Bullet(25, 40, Direction.Up),
                new Bullet(20, 40, Direction.Up),
                new Bullet(50, 20, Direction.Left),
                new Bullet(50, 25, Direction.Left),
                new Bullet(470, 292, Direction.Right),
                new Bullet(470, 284, Direction.Right),
                new Bullet(440, 280, Direction.Down),
                new Bullet(430, 280, Direction.Down)
        ));
        maze.setBullets(bullets);

        assertTrue(maze.collideBullet(new Position(25, 10), 10, 10));
        assertFalse(maze.collideBullet(new Position(50, 100), 10, 10));
        assertFalse(maze.collideBullet(new Position(20, 15), 10, 10));
        assertFalse(maze.collideBullet(new Position(-10, 15), 20, 20));
        assertTrue(maze.collideBullet(new Position(472, 292), 10, 10));
    }
}
