package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.ld04gr02.berzerk.gui.GUI.KEY.ARROW_RIGHT;
import static org.mockito.Mockito.mock;

public class BulletControllerTests extends Assertions {
    private BulletController bulletController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze_test2.lvl");

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
        bulletController = new BulletController(maze);
        game = mock(Game.class);
    }

    @Test
    public void moveBulletTest() throws IOException, URISyntaxException, FontFormatException {
        assertEquals(12, bulletController.getModel().getBullets().size());
        bulletController.update(game, ARROW_RIGHT, 0);
        assertEquals(8, bulletController.getModel().getBullets().size());
    }

    @Test
    public void collideStickManTest() throws IOException, URISyntaxException, FontFormatException {
        bulletController.getModel().getBullets().clear();
        ArrayList<Bullet> bullets = new ArrayList<>(Arrays.asList(
                new Bullet(15, 150, Direction.Left)
        ));
        bulletController.getModel().setBullets(bullets);
        assertEquals(1, bulletController.getModel().getBullets().size());
        bulletController.update(game, ARROW_RIGHT, 0);
        assertEquals(0, bulletController.getModel().getBullets().size());
    }

    @Test
    public void moveBulletsTest() throws IOException, URISyntaxException, FontFormatException {
        assertEquals(12, bulletController.getModel().getBullets().size());
        Bullet bulletUp = bulletController.getModel().getBullets().get(4);
        int Y_Up = bulletUp.getPosition().getY();
        Bullet bulletLeft = bulletController.getModel().getBullets().get(6);
        int X_Left = bulletLeft.getPosition().getX();
        Bullet bulletRight = bulletController.getModel().getBullets().get(8);
        int X_Right = bulletRight.getPosition().getX();
        Bullet bulletDown = bulletController.getModel().getBullets().get(10);
        int Y_Down = bulletDown.getPosition().getY();
        bulletController.update(game, ARROW_RIGHT, 0);
        assertEquals(8, bulletController.getModel().getBullets().size());
        assertEquals(Y_Up-10, bulletUp.getPosition().getY());
        assertEquals(X_Left-10, bulletLeft.getPosition().getX());
        assertEquals(Y_Down+10, bulletDown.getPosition().getY());
        assertEquals(X_Right+10, bulletRight.getPosition().getX());
    }

    @Test
    public void outOfScreenTest() throws IOException, URISyntaxException, FontFormatException {
        bulletController.getModel().getGates().clear();
        bulletController.getModel().getBullets().clear();
        ArrayList<Bullet> bullets = new ArrayList<>(Arrays.asList(
                new Bullet(492, 150, Direction.Right),
                new Bullet(550, 155, Direction.Right),
                new Bullet(600, 150, Direction.Right)
        ));
        bulletController.getModel().setBullets(bullets);
        assertEquals(3, bulletController.getModel().getBullets().size());
        bulletController.update(game, ARROW_RIGHT, 0);
        assertEquals(1, bulletController.getModel().getBullets().size());
    }
}
