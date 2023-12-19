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
        evilSmileController.update(game, ARROW_RIGHT, 4000);
        assertFalse(evilSmileController.getModel().getEvilSmile().isCollided());
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
        evilSmileController.update(game, ARROW_RIGHT, 4000);
        assertTrue(evilSmileController.getModel().getEvilSmile().isCollided());
        assertTrue(evilSmileController.getModel().getStickMan().isCollided());
    }
}
