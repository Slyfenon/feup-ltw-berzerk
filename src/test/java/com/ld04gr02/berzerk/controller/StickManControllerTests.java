package com.ld04gr02.berzerk.controller;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.game.StickManController;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    public void moveStickManUpTest() throws IOException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, ARROW_UP, 0);
        assertEquals(stickManController.getModel().getStickMan().getPosition(), position.getUp());
    }

    @Test
    public void moveStickManDownTest() throws IOException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, ARROW_DOWN, 0);
        assertEquals(stickManController.getModel().getStickMan().getPosition(), position.getDown());
    }

    @Test
    public void moveStickManRightTest() throws IOException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, ARROW_RIGHT, 0);
        assertEquals(stickManController.getModel().getStickMan().getPosition(), position.getRight());
    }

    @Test
    public void moveStickManLeftTest() throws IOException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, ARROW_LEFT, 0);
        assertEquals(stickManController.getModel().getStickMan().getPosition(), position.getLeft());
    }
}
