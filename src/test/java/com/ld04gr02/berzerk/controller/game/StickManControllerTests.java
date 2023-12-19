package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.PauseMenu;
import com.ld04gr02.berzerk.state.PauseMenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.gui.GUI.KEY.*;
import static org.mockito.Mockito.*;

public class StickManControllerTests extends Assertions {
    private StickManController stickManController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze1.lvl");
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
        stickManController.update(game, SPACE, 4000);
        assertEquals(position, stickManController.getModel().getStickMan().getPosition());
        assertEquals(1, stickManController.getModel().getBullets().size());
    }

    @Test
    public void shootingTest() throws IOException, URISyntaxException, FontFormatException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, SPACE, 500);
        assertEquals(1, stickManController.getModel().getBullets().size());
        stickManController.getModel().getStickMan().setDirection(Direction.Down);
        stickManController.update(game, SPACE, 1000);
        assertEquals(2, stickManController.getModel().getBullets().size());
        stickManController.getModel().getStickMan().setDirection(Direction.Left);
        stickManController.update(game, SPACE, 1500);
        assertEquals(3, stickManController.getModel().getBullets().size());
        stickManController.getModel().getStickMan().setDirection(Direction.Up);
        stickManController.update(game, SPACE, 2000);
        assertEquals(4, stickManController.getModel().getBullets().size());
        assertEquals(position, stickManController.getModel().getStickMan().getPosition());
    }

    @Test
    public void moveStickManCollidedTest() throws IOException, URISyntaxException, FontFormatException {
        stickManController.getModel().getStickMan().setCollided(true);
        stickManController.update(game, SPACE, 0);
        assertEquals(new Position(10, 143), stickManController.getModel().getStickMan().getPosition());
    }

    @Test
    public void pauseTest() throws IOException, URISyntaxException, FontFormatException {
        GUI gui = mock(GUI.class);
        PauseMenu pauseMenu = mock(PauseMenu.class);
        when(game.getGui()).thenReturn(gui);
        PauseMenuState pauseMenuState = mock(PauseMenuState.class);
        when(pauseMenuState.getModel()).thenReturn(pauseMenu);
        when(game.getState()).thenReturn(pauseMenuState);

        stickManController.update(game, ESC, 0);
        verify(gui).close();
        verify(pauseMenuState).initScreen(any(), anyInt(), anyInt());
    }

    @Test
    public void stopTest() throws IOException, URISyntaxException, FontFormatException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, CHAR, 0);
        assertEquals(position, stickManController.getModel().getStickMan().getPosition());
        assertFalse(stickManController.getModel().getStickMan().isMoving());
    }
}

