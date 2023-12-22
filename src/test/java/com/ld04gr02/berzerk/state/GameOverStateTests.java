package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.menu.GameOverController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.view.menu.GameOverViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class GameOverStateTests extends Assertions {
    private GameOverState gameOverState;
    private GameOverController gameOverController;
    private GameOverViewer gameOverViewer;
    private LanternaGUI lanternaGUI;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        GameOverMenu gameOverMenu = new GameOverMenu();
        gameOverState = new GameOverState(gameOverMenu);
        lanternaGUI = mock(LanternaGUI.class);

        gameOverController = mock(GameOverController.class);
        gameOverViewer = mock(GameOverViewer.class);
        gameOverState.setController(gameOverController);
        gameOverState.setViewer(gameOverViewer);

        game = mock(Game.class);
    }

    @Test
    public void initScreenTest() throws IOException, URISyntaxException, FontFormatException {
        gameOverState.initScreen(lanternaGUI, Game.MENU_SCREEN_WIDTH, Game.MENU_SCREEN_HEIGHT);
        verify(lanternaGUI).createMenuScreen(Game.MENU_SCREEN_WIDTH, Game.MENU_SCREEN_HEIGHT);
    }

    @Test
    public void updateEscapeTest() throws IOException, URISyntaxException, FontFormatException {
        when(game.getGui()).thenReturn(lanternaGUI);
        when(lanternaGUI.getCharPressedKey()).thenReturn("Escape");
        gameOverState.update(game, lanternaGUI, 0);
        verify(gameOverController).update(game, GUI.KEY.ESC, 0);
    }

    @Test
    public void updateEnterTest() throws IOException, URISyntaxException, FontFormatException {
        when(game.getGui()).thenReturn(lanternaGUI);
        when(lanternaGUI.getCharPressedKey()).thenReturn("Enter");
        gameOverState.update(game, lanternaGUI, 0);
        verify(gameOverController).update(game, GUI.KEY.ENTER, 0);
    }

    @Test
    public void updateBackspaceTest() throws IOException, URISyntaxException, FontFormatException {
        when(game.getGui()).thenReturn(lanternaGUI);
        when(lanternaGUI.getCharPressedKey()).thenReturn("Backspace");
        gameOverState.getModel().getName().append("Hello");
        gameOverState.update(game, lanternaGUI, 0);
        assertEquals("Hell", gameOverState.getModel().getName().toString());

        gameOverState.getModel().getName().setLength(0);
        gameOverState.update(game, lanternaGUI, 0);
        assertEquals("", gameOverState.getModel().getName().toString());

        verify(gameOverViewer, times(2)).display(lanternaGUI);
    }

    @Test
    public void updateCharTest() throws IOException, URISyntaxException, FontFormatException {
        when(game.getGui()).thenReturn(lanternaGUI);
        when(lanternaGUI.getCharPressedKey()).thenReturn("H");
        gameOverState.update(game, lanternaGUI, 0);
        assertEquals("H", gameOverState.getModel().getName().toString());

        gameOverState.getModel().getName().setLength(0);
        gameOverState.getModel().getName().append("JackSparrow");
        gameOverState.update(game, lanternaGUI, 0);
        assertEquals("JackSparrow", gameOverState.getModel().getName().toString());

        verify(gameOverViewer, times(2)).display(lanternaGUI);
    }

    @Test
    public void maxNameLengthTest() throws IOException, URISyntaxException, FontFormatException {
        when(game.getGui()).thenReturn(lanternaGUI);
        when(lanternaGUI.getCharPressedKey()).thenReturn("k");
        gameOverState.getModel().getName().setLength(0);
        gameOverState.getModel().getName().append("abcdefghij");
        assertEquals("abcdefghij", gameOverState.getModel().getName().toString());
        gameOverState.update(game, lanternaGUI, 0);
        assertEquals("abcdefghij", gameOverState.getModel().getName().toString());
    }

    @Test
    public void gettersTest() {
        assertEquals(0, gameOverState.getController().getModel().getOptions().size());
        assertEquals(0, gameOverState.getViewer().getModel().getOptions().size());
    }
}
