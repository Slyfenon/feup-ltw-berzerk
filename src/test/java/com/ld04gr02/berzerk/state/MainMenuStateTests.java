package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.menu.MainMenuController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.view.menu.MenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class MainMenuStateTests extends Assertions {
    private MainMenuState mainMenuState;
    private MainMenuController mainMenuController;
    private MenuViewer<MainMenu> mainMenuViewer;
    private LanternaGUI lanternaGUI;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MainMenu mainMenu = new MainMenu();
        mainMenuState = new MainMenuState(mainMenu);
        lanternaGUI = mock(LanternaGUI.class);

        mainMenuController = mock(MainMenuController.class);
        mainMenuViewer = mock(MenuViewer.class);
        mainMenuState.setController(mainMenuController);
        mainMenuState.setViewer(mainMenuViewer);

        game = mock(Game.class);
    }

    @Test
    public void updateTest() throws IOException, URISyntaxException, FontFormatException {
        when(lanternaGUI.getPressedKey()).thenReturn(GUI.KEY.ARROW_RIGHT);
        mainMenuState.update(game, lanternaGUI, 0);
        verify(mainMenuController).update(game, GUI.KEY.ARROW_RIGHT, 0);
        verify(mainMenuViewer).display(lanternaGUI);
    }

    @Test
    public void initScreenTest() throws IOException, URISyntaxException, FontFormatException {
        mainMenuState.initScreen(lanternaGUI, 10, 20);
        verify(lanternaGUI).createMenuScreen(10, 20);
    }

    @Test
    public void gettersTest() {
        assertEquals(4, mainMenuState.getController().getModel().getOptions().size());
        assertEquals(4 , mainMenuState.getViewer().getModel().getOptions().size());
    }
}
