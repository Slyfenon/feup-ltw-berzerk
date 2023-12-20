package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.model.menu.Leaderboard;
import com.ld04gr02.berzerk.state.MainMenuState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static com.ld04gr02.berzerk.gui.GUI.KEY.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GameOverControllerTests extends Assertions {
    private GameOverController gameOverController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        GameOverMenu gameOverMenu = new GameOverMenu();
        gameOverController = new GameOverController(gameOverMenu);
        game = mock(Game.class);
    }

    @Test
    public void leaveTest() throws IOException, URISyntaxException, FontFormatException {
        gameOverController.update(game, ARROW_DOWN, 0);
        assertEquals(0, gameOverController.getModel().getCurrentOption());
        GUI gui = mock(GUI.class);
        when(game.getGui()).thenReturn(gui);
        gameOverController.update(game, ESC, 0);
        verify(game).setState(any());
    }

    @Test
    public void enterTest() throws IOException, URISyntaxException, FontFormatException {
        Leaderboard leaderboard = new Leaderboard();
        gameOverController.getModel().getName().append("Hello");
        StickMan.setScore(250);
        gameOverController.update(game, ARROW_DOWN, 0);
        assertEquals(0, gameOverController.getModel().getCurrentOption());
        gameOverController.update(game, ENTER, 0);
        verify(game).setState(any());
        Leaderboard leaderboard2 = new Leaderboard();
        assertNotEquals(leaderboard.getNames(), leaderboard2.getNames());
    }

    @Test
    public void charTest() throws IOException, URISyntaxException, FontFormatException {
        gameOverController.getModel().getName().append("aaaaaaaaaa");

        GUI guiMock = mock(GUI.class);
        when(game.getGui()).thenReturn(guiMock);
        MainMenuState mainMenuState = mock(MainMenuState.class);
        when(game.getState()).thenReturn(mainMenuState);
        gameOverController.update(game, CHAR, 0);
        verify(guiMock).close();
        verify(game).setState(any());
        verify(mainMenuState).initScreen(guiMock, MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
    }

    @AfterEach
    public void reset() throws IOException, URISyntaxException, FontFormatException {
        gameOverController.getModel().getName().setLength(0);
        gameOverController.getModel().getName().append("Kirby");
        StickMan.setScore(250);
        gameOverController.update(game, ENTER, 0);
    }
}
