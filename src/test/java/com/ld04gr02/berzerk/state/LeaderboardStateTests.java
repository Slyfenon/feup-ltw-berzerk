package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.menu.LeaderboardController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.menu.Leaderboard;
import com.ld04gr02.berzerk.view.menu.LeaderboardViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class LeaderboardStateTests extends Assertions {
    private LeaderboardState leaderboardState;
    private LeaderboardController leaderboardController;
    private LeaderboardViewer leaderboardViewer;
    private LanternaGUI lanternaGUI;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        Leaderboard leaderboard = new Leaderboard();
        leaderboardState = new LeaderboardState(leaderboard);
        lanternaGUI = mock(LanternaGUI.class);

        leaderboardController = mock(LeaderboardController.class);
        leaderboardViewer = mock(LeaderboardViewer.class);
        leaderboardState.setController(leaderboardController);
        leaderboardState.setViewer(leaderboardViewer);

        game = mock(Game.class);
    }

    @Test
    public void initScreenTest() throws IOException, URISyntaxException, FontFormatException {
        leaderboardState.initScreen(lanternaGUI, Game.MENU_SCREEN_WIDTH, Game.MENU_SCREEN_HEIGHT);
    }

    @Test
    public void updateTest() throws IOException, URISyntaxException, FontFormatException {
        when(lanternaGUI.getPressedKey()).thenReturn(GUI.KEY.ARROW_RIGHT);
        leaderboardState.update(game, lanternaGUI, 0);
        verify(leaderboardController).update(game, GUI.KEY.ARROW_RIGHT, 0);
        verify(leaderboardViewer).display(lanternaGUI);
    }
}
