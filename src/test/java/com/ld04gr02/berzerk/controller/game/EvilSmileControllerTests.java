package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.gui.GUI.KEY.ARROW_DOWN;
import static com.ld04gr02.berzerk.gui.GUI.KEY.ARROW_RIGHT;
import static org.mockito.Mockito.mock;

public class EvilSmileControllerTests extends Assertions {
    private EvilSmileController evilSmileController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze_test2.lvl");
        evilSmileController = new EvilSmileController(maze);
        game = mock(Game.class);
    }

    @Test
    public void moveEvilSmileTest() throws IOException, URISyntaxException, FontFormatException {
        assertEquals(1200, evilSmileController.getTimePause());
        evilSmileController.update(game, ARROW_RIGHT, 1201);
        assertFalse(evilSmileController.getModel().getEvilSmile().isCollided());
        assertEquals(1150, evilSmileController.getTimePause());
    }

    @Test
    public void notMoveEvilSmileTest() throws IOException, URISyntaxException, FontFormatException {
        evilSmileController.update(game, ARROW_RIGHT, 1200);
        assertFalse(evilSmileController.getModel().getEvilSmile().isCollided());
        assertEquals(1200, evilSmileController.getTimePause());
    }

    @Test
    public void moveEvilSmileCollidedTest() throws IOException, URISyntaxException, FontFormatException {
        evilSmileController.getModel().getEvilSmile().setCollided(true);
        assertTrue(evilSmileController.getModel().getEvilSmile().isCollided());
        evilSmileController.update(game, ARROW_RIGHT, 4000);
        assertEquals(new Position(-20, 151), evilSmileController.getModel().getEvilSmile().getPosition());
    }

    @Test
    public void collideStickManTest() throws IOException, URISyntaxException, FontFormatException {
        evilSmileController.getModel().getEvilSmile().setPosition(new Position(10, 150));
        evilSmileController.update(game, ARROW_RIGHT, 1201);
        assertTrue(evilSmileController.getModel().getEvilSmile().isCollided());
        assertTrue(evilSmileController.getModel().getStickMan().isCollided());
        evilSmileController.update(game, ARROW_DOWN, 1201);
        assertFalse(evilSmileController.getModel().getEvilSmile().isCollided());
        assertEquals(new Position(-20, 151), evilSmileController.getModel().getEvilSmile().getPosition());
        assertEquals(1200, evilSmileController.getTimePause());
    }

    @Test
    public void timePauseTest() throws IOException, URISyntaxException, FontFormatException {
        assertEquals(1200, evilSmileController.getTimePause());
        evilSmileController.update(game, ARROW_RIGHT, 1201);
        assertEquals(1150, evilSmileController.getTimePause());
        evilSmileController.setTimePause(100);
        evilSmileController.update(game, ARROW_RIGHT, 2402);
        assertEquals(100, evilSmileController.getTimePause());
        evilSmileController.setTimePause(50);
        evilSmileController.update(game, ARROW_RIGHT, 3603);
        assertEquals(50, evilSmileController.getTimePause());
        evilSmileController.setTimePause(130);
        evilSmileController.update(game, ARROW_RIGHT, 4904);
        assertEquals(80, evilSmileController.getTimePause());
    }

    @Test
    public void moveMethodTest() {
        Position newPosition = new Position(10, 150);
        evilSmileController.moveEvilSmile(evilSmileController.getModel().getEvilSmile(), newPosition);
        assertEquals(newPosition, evilSmileController.getModel().getEvilSmile().getPosition());
        assertTrue(evilSmileController.getModel().getStickMan().isCollided());
    }

    @Test
    public void closerTest() {
        Position positionStickMan = evilSmileController.getModel().getStickMan().getPosition();
        Position currentPosition = new Position(50, 50);
        Position newPosition = new Position(50, 50);

        assertFalse(evilSmileController.closer(positionStickMan, currentPosition, newPosition));

        newPosition = new Position(49, 50);
        assertTrue(evilSmileController.closer(positionStickMan, currentPosition, newPosition));

        newPosition = new Position(50, 51);
        assertTrue(evilSmileController.closer(positionStickMan, currentPosition, newPosition));

        newPosition = new Position(51, 49);
        assertFalse(evilSmileController.closer(positionStickMan, currentPosition, newPosition));
    }
}
