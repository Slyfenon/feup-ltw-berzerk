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
import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static com.ld04gr02.berzerk.gui.GUI.KEY.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GameOverControllerTests extends Assertions {
    private GameOverController gameOverController;
    private Game game;
    private String content;

    @BeforeEach
    public void setUp() throws IOException {
        GameOverMenu gameOverMenu = new GameOverMenu();
        gameOverController = new GameOverController(gameOverMenu);
        game = mock(Game.class);

        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String mapLocation = rootPath + "/src/main/resources/Leaderboard.brd";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(mapLocation, StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();

        String line = bufferedReader.readLine();

        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
            line = bufferedReader.readLine();
        }

        content = stringBuilder.toString();
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
        Leaderboard leaderboard = new Leaderboard("/src/main/resources/Leaderboard.brd");
        gameOverController.getModel().getName().append("Hello");
        StickMan.setScore(9950);
        gameOverController.update(game, ARROW_DOWN, 0);
        assertEquals(0, gameOverController.getModel().getCurrentOption());
        gameOverController.update(game, ENTER, 0);
        verify(game).setState(any());
        Leaderboard leaderboard2 = new Leaderboard("/src/main/resources/Leaderboard.brd");
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
    public void reset() throws IOException {
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String mapLocation = rootPath + "/src/main/resources/Leaderboard.brd";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(mapLocation, StandardCharsets.UTF_8));
        bufferedWriter.write(content);
        bufferedWriter.close();
    }
}
