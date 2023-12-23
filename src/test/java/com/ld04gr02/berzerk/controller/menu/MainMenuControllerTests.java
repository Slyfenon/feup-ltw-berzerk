package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.state.GameState;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.INFO_SECTIONS_HEIGHT;
import static com.ld04gr02.berzerk.gui.GUI.KEY.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MainMenuControllerTests extends Assertions {
    private MainMenuController mainMenuController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MainMenu mainMenu = new MainMenu();
        mainMenuController = new MainMenuController(mainMenu);
        game = mock(Game.class);
    }

    @Test
    public void updateMainMenuTest() throws IOException, URISyntaxException, FontFormatException {
        assertEquals(0, mainMenuController.getModel().getCurrentOption());
        mainMenuController.update(game, ARROW_DOWN, 0);
        assertEquals(1, mainMenuController.getModel().getCurrentOption());
        mainMenuController.update(game, ARROW_UP, 0);
        assertEquals(0, mainMenuController.getModel().getCurrentOption());
        mainMenuController.update(game, ARROW_RIGHT, 0);
        assertEquals(0, mainMenuController.getModel().getCurrentOption());
    }

    @Test
    public void playMainMenuTest() throws IOException, URISyntaxException, FontFormatException {
        StickMan.setScore(500);
        Game.setLevel(3);
        assertEquals(0, mainMenuController.getModel().getCurrentOption());
        GUI gui = mock(GUI.class);
        when(game.getGui()).thenReturn(gui);
        GameState gameState = mock(GameState.class);
        when(game.getState()).thenReturn(gameState);
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze1.lvl");
        mainMenuController.update(game, ENTER, 0);
        verify(game, times(2)).getGui();
        verify(game).setState(new GameState(any()));
        verify(game).getState();
        verify(gui).close();
        verify(gameState).initScreen(gui, maze.getWidth(), maze.getHeight() + INFO_SECTIONS_HEIGHT);
        assertEquals(0, StickMan.getScore());
        assertEquals(1, Game.getLevel());
    }

    @Test
    public void leaderboardMainMenuTest() throws IOException, URISyntaxException, FontFormatException {
        mainMenuController.update(game, ARROW_DOWN, 0);
        assertEquals(1, mainMenuController.getModel().getCurrentOption());
        mainMenuController.update(game, ENTER, 0);
        verify(game).setState(any());
    }

    @Test
    public void instructionsMainMenuTest() throws IOException, URISyntaxException, FontFormatException {
        mainMenuController.update(game, ARROW_DOWN, 0);
        mainMenuController.update(game, ARROW_DOWN, 0);
        assertEquals(2, mainMenuController.getModel().getCurrentOption());
        mainMenuController.update(game, ENTER, 0);
        verify(game).setState(any());
    }

    @Test
    public void quitMainMenuTest() throws IOException, URISyntaxException, FontFormatException {
        mainMenuController.update(game, ARROW_UP, 0);
        assertEquals(3, mainMenuController.getModel().getCurrentOption());
        mainMenuController.update(game, ENTER, 0);
        verify(game).setState(null);
    }
}
