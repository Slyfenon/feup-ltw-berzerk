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
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.gui.GUI.KEY.*;
import static org.mockito.Mockito.mock;

public class StickManControllerTests extends Assertions {
    private StickManController stickManController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze_test.lvl");
        stickManController = new StickManController(maze);
        game = mock(Game.class);
    }

    @Test
    public void moveStickManUpTest() throws IOException, URISyntaxException, FontFormatException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, ARROW_UP, 0);
        assertEquals(position.getUp(), stickManController.getModel().getStickMan().getPosition());
    }

    @Test
    public void moveStickManDownTest() throws IOException, URISyntaxException, FontFormatException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, ARROW_DOWN, 0);
        assertEquals(position.getDown(), stickManController.getModel().getStickMan().getPosition());
    }

    @Test
    public void moveStickManRightTest() throws IOException, URISyntaxException, FontFormatException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, ARROW_RIGHT, 0);
        assertEquals(position.getRight(), stickManController.getModel().getStickMan().getPosition());
    }

    @Test
    public void moveStickManLeftTest() throws IOException, URISyntaxException, FontFormatException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, ARROW_LEFT, 0);
        assertEquals(position.getLeft(), stickManController.getModel().getStickMan().getPosition());
    }

    @Test
    public void moveStickManSpaceTest() throws IOException, URISyntaxException, FontFormatException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, SPACE, 0);
        assertEquals(position, stickManController.getModel().getStickMan().getPosition());
    }

    @Test
    public void moveStickManCollidedTest() throws IOException, URISyntaxException, FontFormatException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.getModel().getStickMan().setCollided(true);
        stickManController.update(game, SPACE, 0);
        assertEquals(new Position(10, 111), stickManController.getModel().getStickMan().getPosition());
    }
}

