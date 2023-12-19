package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.model.menu.InstructionsMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.gui.GUI.KEY.ARROW_RIGHT;
import static com.ld04gr02.berzerk.gui.GUI.KEY.ESC;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InstructionsMenuControllerTests extends Assertions {
    private InstructionsMenuController instructionsMenuController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        InstructionsMenu instructionsMenu = new InstructionsMenu();
        instructionsMenuController = new InstructionsMenuController(instructionsMenu);
        game = mock(Game.class);
    }

    @Test
    public void leaveMenuTest() throws IOException, URISyntaxException, FontFormatException {
        instructionsMenuController.update(game, ESC, 0);
        verify(game).setState(any());
    }

    @Test
    public void updateTest() throws IOException, URISyntaxException, FontFormatException {
        instructionsMenuController.update(game, ARROW_RIGHT, 0);
        assertEquals(0, instructionsMenuController.getModel().getCurrentOption());
    }
}
