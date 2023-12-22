package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.menu.PauseMenuController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.menu.PauseMenu;
import com.ld04gr02.berzerk.view.menu.MenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class PauseMenuStateTests extends Assertions {
    private PauseMenuState pauseMenuState;
    private PauseMenuController pauseMenuController;
    private MenuViewer<PauseMenu> pauseMenuViewer;
    private LanternaGUI lanternaGUI;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        PauseMenu pauseMenu = new PauseMenu();
        pauseMenuState = new PauseMenuState(pauseMenu);
        lanternaGUI = mock(LanternaGUI.class);

        pauseMenuController = mock(PauseMenuController.class);
        pauseMenuViewer = mock(MenuViewer.class);
        pauseMenuState.setController(pauseMenuController);
        pauseMenuState.setViewer(pauseMenuViewer);

        game = mock(Game.class);
    }

    @Test
    public void initScreenTest() throws IOException, URISyntaxException, FontFormatException {
        pauseMenuState.initScreen(lanternaGUI, Game.MENU_SCREEN_WIDTH, Game.MENU_SCREEN_HEIGHT);
        verify(lanternaGUI).createMenuScreen(Game.MENU_SCREEN_WIDTH, Game.MENU_SCREEN_HEIGHT);
    }

    @Test
    public void updateTest() throws IOException, URISyntaxException, FontFormatException {
        when(lanternaGUI.getPressedKey()).thenReturn(GUI.KEY.ARROW_RIGHT);
        pauseMenuState.update(game, lanternaGUI, 0);
        verify(pauseMenuController).update(game, GUI.KEY.ARROW_RIGHT, 0);
        verify(pauseMenuViewer).display(lanternaGUI);
    }

    @Test
    public void gettersTest() {
        assertEquals(3, pauseMenuState.getController().getModel().getOptions().size());
        assertEquals(3, pauseMenuState.getViewer().getModel().getOptions().size());
    }
}
