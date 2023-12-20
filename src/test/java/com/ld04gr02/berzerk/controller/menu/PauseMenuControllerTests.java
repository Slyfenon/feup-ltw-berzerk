package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.PauseMenu;
import com.ld04gr02.berzerk.state.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.INFO_SECTIONS_HEIGHT;
import static com.ld04gr02.berzerk.gui.GUI.KEY.*;
import static org.mockito.Mockito.*;

public class PauseMenuControllerTests extends Assertions {
    private PauseMenuController pauseMenuController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        PauseMenu pauseMenu = new PauseMenu();
        pauseMenuController = new PauseMenuController(pauseMenu);
        game = mock(Game.class);
    }

    @Test
    public void updatePauseMenuTest() throws IOException, URISyntaxException, FontFormatException {
        assertEquals(0, pauseMenuController.getModel().getCurrentOption());
        pauseMenuController.update(game, ARROW_DOWN, 0);
        assertEquals(1, pauseMenuController.getModel().getCurrentOption());
        pauseMenuController.update(game, ARROW_UP, 0);
        assertEquals(0, pauseMenuController.getModel().getCurrentOption());
        pauseMenuController.update(game, ARROW_RIGHT, 0);
        assertEquals(0, pauseMenuController.getModel().getCurrentOption());
    }

    @Test
    public void resumePauseMenuTest() throws IOException, URISyntaxException, FontFormatException {
        assertEquals(0, pauseMenuController.getModel().getCurrentOption());
        GUI gui = mock(GUI.class);
        Maze maze = mock(Maze.class);
        when(game.getGui()).thenReturn(gui);
        GameState gameState = mock(GameState.class);
        when(gameState.getModel()).thenReturn(maze);
        when(game.getPreviousState()).thenReturn(gameState);
        when(game.getState()).thenReturn(gameState);
        pauseMenuController.update(game, ENTER, 0);
        verify(game, times(2)).getGui();
        verify(game).setState(gameState);
        verify(gui).close();
        verify(gameState).initScreen(gui, 0, 30);
    }

    @Test
    public void restartPauseMenuTest() throws IOException, URISyntaxException, FontFormatException {
        StickMan.setScore(500);
        StickMan.setLives(1);
        Game.setLevel(3);
        assertEquals(0, pauseMenuController.getModel().getCurrentOption());
        GUI gui = mock(GUI.class);
        Maze maze = mock(Maze.class);
        when(game.getGui()).thenReturn(gui);
        GameState gameState = mock(GameState.class);
        when(gameState.getModel()).thenReturn(maze);
        when(game.getPreviousState()).thenReturn(gameState);
        when(game.getState()).thenReturn(gameState);
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze1 = mazeRenderer.createMaze("maze1.lvl");
        pauseMenuController.update(game, ARROW_DOWN, 0);
        pauseMenuController.update(game, ENTER, 0);
        verify(game, times(2)).getGui();
        verify(game).setState(any());
        verify(gameState).initScreen(gui, maze1.getWidth(), maze1.getHeight() + INFO_SECTIONS_HEIGHT);
        assertEquals(0, StickMan.getScore());
        assertEquals(3, StickMan.getLives());
        assertEquals(1, Game.getLevel());
    }

    @Test
    public void quitPauseMenuTest() throws IOException, URISyntaxException, FontFormatException {
        pauseMenuController.update(game, ARROW_UP, 0);
        assertEquals(2, pauseMenuController.getModel().getCurrentOption());
        pauseMenuController.update(game, ENTER, 0);
        verify(game).setState(any());
    }
}
