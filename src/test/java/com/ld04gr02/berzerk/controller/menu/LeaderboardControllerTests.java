package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.menu.Leaderboard;
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

public class LeaderboardControllerTests extends Assertions {
    private LeaderboardController leaderboardController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        Leaderboard leaderboard = new Leaderboard("/src/main/resources/LeaderboardTest.brd");
        leaderboardController = new LeaderboardController(leaderboard);
        game = mock(Game.class);
    }

    @Test
    public void leaveMenuTest() throws IOException, URISyntaxException, FontFormatException {
        leaderboardController.update(game, ESC, 0);
        verify(game).setState(any());
    }

    @Test
    public void updateTest() throws IOException, URISyntaxException, FontFormatException {
        leaderboardController.update(game, ARROW_RIGHT, 0);
        assertEquals(0, leaderboardController.getModel().getCurrentOption());
    }
}
