package com.ld04gr02.berzerk.model.maze;

import com.ld04gr02.berzerk.model.Direction;
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
    public void MazeTest() {
        assertEquals(maze.getWidth(), 50);
        assertEquals(maze.getHeight(), 75);
    }

    @Test
    public void ElementsTest() {
        StickMan stickMan = new StickMan(25, 25, Direction.Up);
        maze.setStickMan(stickMan);
        assertEquals(maze.getStickMan().getPosition(), stickMan.getPosition());
        assertEquals(maze.getStickMan().getLives(), stickMan.getLives());

        ArrayList<Wall> walls = new ArrayList<>(Arrays.asList(
                new Wall(10, 15),
                new Wall(20, 50),
                new Wall(40, 10),
                new Wall(15, 65),
                new Wall(0, 5),
                new Wall(46, 20),
                new Wall(20, 10)
        ));
        maze.setWalls(walls);
        assertEquals(maze.getWalls().size(), walls.size());

        ArrayList<Robot> robots = new ArrayList<>(Arrays.asList(
                new Robot(15, 10, Direction.Up),
                new Robot(12, 20, Direction.Down),
                new Robot(26, 35, Direction.Left),
                new Robot(15, 65, Direction.Down),
                new Robot(30, 70, Direction.Left),
                new Robot(40, 10, Direction.Right)
        ));
        maze.setRobots(robots);
        assertEquals(maze.getRobots().size(), robots.size());
    }
}
