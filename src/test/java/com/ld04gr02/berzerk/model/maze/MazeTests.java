package com.ld04gr02.berzerk.model.maze;

import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.*;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.view.game.Sprites;
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
                new Wall(10, 10, true)
        ));
        maze.setWalls(walls);
        ArrayList<Wall> gates = new ArrayList<>(Arrays.asList(
                new Wall(50, 50, false)
        ));
        maze.setGates(gates);

        assertTrue(maze.collideWall(new Position(14, 10), 5, 5));
        assertFalse(maze.collideWall(new Position(15, 10), 5, 5));
        assertTrue(maze.collideWall(new Position(10, 14), 5, 5));
        assertFalse(maze.collideWall(new Position(10, 15), 5, 5));
        assertTrue(maze.collideWall(new Position(6, 10), 5, 5));
        assertFalse(maze.collideWall(new Position(5, 10), 5, 5));
        assertTrue(maze.collideWall(new Position(10, 6), 5, 5));
        assertFalse(maze.collideWall(new Position(10, 5), 5, 5));
        assertTrue(maze.collideWall(new Position(54, 50), 5, 5));
        assertFalse(maze.collideWall(new Position(55, 50), 5, 5));
        assertTrue(maze.collideWall(new Position(50, 54), 5, 5));
        assertFalse(maze.collideWall(new Position(50, 55), 5, 5));
        assertTrue(maze.collideWall(new Position(46, 50), 5, 5));
        assertFalse(maze.collideWall(new Position(45, 50), 5, 5));
        assertTrue(maze.collideWall(new Position(50, 46), 5, 5));
        assertFalse(maze.collideWall(new Position(50, 45), 5, 5));
    }

    @Test
    public void collideRobotTest() {
        ArrayList<Robot> robots = new ArrayList<>(Arrays.asList(
                new Robot(25, 25, Direction.Up)
        ));
        maze.setRobots(robots);

        assertTrue(maze.collideRobot(new Position(26, 26), 10, 10));
        assertTrue(maze.getRobots().get(0).isCollided());
        assertTrue(maze.collideRobot(new Position(25 + Sprites.getRobotWidth() - 1, 25), 10, 10));
        assertFalse(maze.collideRobot(new Position(25 + Sprites.getRobotWidth(), 25), 10, 10));
        assertTrue(maze.collideRobot(new Position(25, 25 + Sprites.getRobotHeight() - 1), 10, 10));
        assertFalse(maze.collideRobot(new Position(25, 25 + Sprites.getRobotHeight()), 10, 10));
        assertFalse(maze.collideRobot(new Position(15, 25), 10, 10));
        assertTrue(maze.collideRobot(new Position(16, 25), 10, 10));
        assertFalse(maze.collideRobot(new Position(25, 15), 10, 10));
        assertTrue(maze.collideRobot(new Position(25, 16), 10, 10));
    }

    @Test
    public void collideStickManTest() {
        StickMan stickMan = new StickMan(25, 25, Direction.Up);
        maze.setStickMan(stickMan);

        assertTrue(maze.collideStickMan(new Position(25 + Sprites.getStickManWidth() - 1, 25), 10, 10));
        assertTrue(stickMan.isCollided());
        stickMan.setCollided(false);
        assertFalse(maze.collideStickMan(new Position(25 + Sprites.getStickManWidth(), 25), 10, 10));
        assertTrue(maze.collideStickMan(new Position(25, 25 + Sprites.getStickManHeight() - 1), 10, 10));
        assertFalse(maze.collideStickMan(new Position(25, 25 + Sprites.getStickManHeight()), 10, 10));
        assertFalse(maze.collideStickMan(new Position(15, 25), 10, 10));
        assertTrue(maze.collideStickMan(new Position(16, 25), 10, 10));
        assertFalse(maze.collideStickMan(new Position(25, 15), 10, 10));
        assertTrue(maze.collideStickMan(new Position(25, 16), 10, 10));
    }

    @Test
    public void collideEvilSmileTest() {
        EvilSmile evilSmile = new EvilSmile(25, 25, Direction.Up);
        maze.setEvilSmile(evilSmile);
        assertTrue(maze.collideEvilSmile(new Position(25 + Sprites.getEvilSmileWidth() - 1, 25), 10, 10, true));
        assertTrue(evilSmile.isCollided());
        evilSmile.setCollided(false);
        assertFalse(maze.collideEvilSmile(new Position(25 + Sprites.getEvilSmileWidth(), 25), 10, 10, false));
        assertTrue(maze.collideEvilSmile(new Position(25, 25 + Sprites.getEvilSmileHeight() - 1), 10, 10, false));
        assertFalse(maze.collideEvilSmile(new Position(25, 25 + Sprites.getEvilSmileHeight()), 10, 10, false));
        assertFalse(maze.collideEvilSmile(new Position(15, 25), 10, 10, false));
        assertTrue(maze.collideEvilSmile(new Position(16, 25), 10, 10, false));
        assertFalse(maze.collideEvilSmile(new Position(25, 15), 10, 10, false));
        assertTrue(maze.collideEvilSmile(new Position(25, 16), 10, 10, false));
    }

    @Test
    public void collideBulletTest() {
        ArrayList<Bullet> bullets = new ArrayList<>(Arrays.asList(
                new Bullet(10, 10, Direction.Down),
                new Bullet(20, 20, Direction.Right)
        ));
        maze.setBullets(bullets);

        assertTrue(maze.collideBullet(new Position(10 + Sprites.getBulletShort() - 1, 10), 2, 2));
        assertTrue(maze.getBullets().get(0).isCollided());
        maze.getBullets().get(0).setCollided(false);
        assertFalse(maze.collideBullet(new Position(10 + Sprites.getBulletShort(), 10), 2, 2));
        assertTrue(maze.collideBullet(new Position(10, 10 + Sprites.getBulletLong() - 1), 2, 2));
        assertFalse(maze.collideBullet(new Position(10, 10 + Sprites.getBulletLong()), 2, 2));

        assertTrue(maze.collideBullet(new Position(20 + Sprites.getBulletLong() - 1, 20), 2, 2));
        assertFalse(maze.collideBullet(new Position(20 + Sprites.getBulletLong(), 20), 2, 2));
        assertTrue(maze.collideBullet(new Position(20, 20 + Sprites.getBulletShort() - 1), 2, 2));
        assertFalse(maze.collideBullet(new Position(20, 20 + Sprites.getBulletShort()), 2, 2));
        assertTrue(maze.collideBullet(new Position(19, 20), 2, 2));
        assertFalse(maze.collideBullet(new Position(18, 20), 2, 2));
        assertTrue(maze.collideBullet(new Position(20, 19), 2, 2));
        assertFalse(maze.collideBullet(new Position(20, 18), 2, 2));
    }
}
