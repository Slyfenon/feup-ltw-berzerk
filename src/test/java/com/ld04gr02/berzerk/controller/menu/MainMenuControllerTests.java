package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.state.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

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
        assertEquals(0, mainMenuController.getModel().getCurrentOption());
        GUI gui = mock(GUI.class);
        when(game.getGui()).thenReturn(gui);
        GameState gameState = mock(GameState.class);
        when(game.getState()).thenReturn(gameState);
        mainMenuController.update(game, ENTER, 0);
        verify(game, times(2)).getGui();
        verify(game).setLevel(1);
        verify(game).setState(new GameState(any()));
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
