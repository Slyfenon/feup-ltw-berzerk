package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.menu.InstructionsMenuController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.menu.InstructionsMenu;
import com.ld04gr02.berzerk.view.menu.InstructionsViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class InstructionsMenuStateTests extends Assertions {
    private InstructionsMenuState instructionsMenuState;
    private InstructionsMenuController instructionsMenuController;
    private InstructionsViewer instructionsViewer;
    private LanternaGUI lanternaGUI;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        InstructionsMenu instructionsMenu = new InstructionsMenu();
        instructionsMenuState = new InstructionsMenuState(instructionsMenu);
        lanternaGUI = mock(LanternaGUI.class);

        instructionsMenuController = mock(InstructionsMenuController.class);
        instructionsViewer = mock(InstructionsViewer.class);
        instructionsMenuState.setController(instructionsMenuController);
        instructionsMenuState.setViewer(instructionsViewer);

        game = mock(Game.class);
    }

    @Test
    public void initScreenTest() throws IOException, URISyntaxException, FontFormatException {
        instructionsMenuState.initScreen(lanternaGUI, Game.MENU_SCREEN_WIDTH, Game.MENU_SCREEN_HEIGHT);
        verify(lanternaGUI).createMenuScreen(Game.MENU_SCREEN_WIDTH, Game.MENU_SCREEN_HEIGHT);
    }

    @Test
    public void updateTest() throws IOException, URISyntaxException, FontFormatException {
        when(lanternaGUI.getPressedKey()).thenReturn(GUI.KEY.ARROW_RIGHT);
        instructionsMenuState.update(game, lanternaGUI, 0);
        verify(instructionsMenuController).update(game, GUI.KEY.ARROW_RIGHT, 0);
        verify(instructionsViewer).display(lanternaGUI);
    }

    @Test
    public void gettersTest() {
        assertEquals(0, instructionsMenuState.getController().getModel().getOptions().size());
        assertEquals(0, instructionsMenuState.getViewer().getModel().getOptions().size());
    }
}
