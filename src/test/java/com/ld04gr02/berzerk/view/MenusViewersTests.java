package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.menu.*;
import com.ld04gr02.berzerk.view.menu.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static org.mockito.Mockito.*;

public class MenusViewersTests extends Assertions {
    private GUI guiMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
    }

    @Test
    public void MainMenuViewerTest() throws IOException {
        MainMenu mainMenu = new MainMenu();
        MenuViewer<MainMenu> mainMenuViewer = new MenuViewer<>(mainMenu);
        mainMenuViewer.display(guiMock);
        verify(guiMock).drawText(7, 5, "██████╗ ███████╗██████╗ ███████╗███████╗██████╗ ██╗  ██╗", "#00ff00");
        verify(guiMock).drawText(7, 10, "╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝", "#00ff00");
        verify(guiMock).drawBlinkText(31, 15, "> Play <", "#00ff00");
        verify(guiMock).drawText(33, 21, "Quit", "#00ff00");
    }

    @Test
    public void InstructionsMenuViewerTest() throws IOException {
        InstructionsMenu instructionsMenu = new InstructionsMenu();
        InstructionsViewer instructionsViewer = new InstructionsViewer(instructionsMenu);
        instructionsViewer.display(guiMock);
        verify(guiMock).drawText(7, 5, "██████╗ ███████╗██████╗ ███████╗███████╗██████╗ ██╗  ██╗", "#00ff00");
        verify(guiMock).drawText(7, 10, "╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝", "#00ff00");
        verify(guiMock).drawText(MENU_SCREEN_WIDTH / 2 - 7, 12, "GAME OBJECTIVE:", "#ffffff");
        verify(guiMock).drawText(3, 14, "SHOOT THE ROBOTS, SCORE POINTS AND RUN FROM EVIL SMILE", "#ffffff");
        verify(guiMock).drawText(3, 15, "DESTROY ALL ROBOTS TO OPEN THE GATE AND ADVANCE TO THE NEXT LEVEL", "#ffffff");
        verify(guiMock).drawText(3, 16, "PLAYER STARTS WITH 3 LIVES, EACH ROBOT DESTROYED = 50 POINTS", "#ffffff");
        verify(guiMock).drawText(10, 23, "||___|||___|||___||", "#ffffff");
        verify(guiMock).drawText(10, 26, "Use ARROWS to move", "#ffffff");
        verify(guiMock).drawText(40, 17, " _______________", "#ffffff");
        verify(guiMock).drawText(40, 22, "Use SPACE to shoot", "#ffffff");
        verify(guiMock).drawText(MENU_SCREEN_WIDTH/2 - 20/2, MENU_SCREEN_HEIGHT - 2, "Press ESC to go back", "#ffffff");
    }

    @Test
    public void LeaderboardViewerTest() throws IOException {
        Leaderboard leaderboard = new Leaderboard("/src/main/resources/LeaderboardTest.brd");
        LeaderboardViewer leaderboardViewer = new LeaderboardViewer(leaderboard);
        leaderboardViewer.display(guiMock);
        verify(guiMock).drawText(7, 5, "██████╗ ███████╗██████╗ ███████╗███████╗██████╗ ██╗  ██╗", "#00ff00");
        verify(guiMock).drawText(7, 10, "╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝", "#00ff00");
        verify(guiMock).drawText(MENU_SCREEN_WIDTH / 2 - 11/2, 15, "Leaderboard", "#ffffff");
        verify(guiMock).drawText(20, 19, "JackSparrow", "#ffffff");
        verify(guiMock).drawText(46, 24, "1800", "#ffffff");
        verify(guiMock).drawText(MENU_SCREEN_WIDTH/2 - 20/2, MENU_SCREEN_HEIGHT - 2, "Press ESC to go back", "#ffffff");
    }

    @Test
    public void PauseMenuViewerTest() throws IOException {
        PauseMenu pauseMenu = new PauseMenu();
        MenuViewer<PauseMenu> pauseMenuViewer = new MenuViewer<>(pauseMenu);
        pauseMenuViewer.display(guiMock);
        verify(guiMock).drawText(7, 5, "██████╗ ███████╗██████╗ ███████╗███████╗██████╗ ██╗  ██╗", "#00ff00");
        verify(guiMock).drawText(7, 10, "╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝", "#00ff00");
        verify(guiMock).drawBlinkText(30, 15, "> Resume <", "#00ff00");
        verify(guiMock).drawText(33, 19, "Quit", "#00ff00");
    }

    @Test
    public void GameOverMenuViewerTest() throws IOException {
        GameOverMenu gameOverMenu = new GameOverMenu();
        GameOverViewer gameOverViewer = new GameOverViewer(gameOverMenu);
        gameOverViewer.display(guiMock);
        verify(guiMock).drawText(17, 5, " ██████╗  █████╗ ███╗   ███╗███████╗", "#ff0000");
        verify(guiMock).drawText(17, 16, " ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝", "#ff0000");
        verify(guiMock).drawBlinkText(MENU_SCREEN_WIDTH / 2 - 5, 19, "Score:" + String.format("%04d", StickMan.getScore()), "#ffffff");
        verify(guiMock).drawText(MENU_SCREEN_WIDTH / 2 - 8, 23, "Name: " + gameOverMenu.getName(), "#ffffff");
        verify(guiMock).drawText(MENU_SCREEN_WIDTH/2 - 20/2, MENU_SCREEN_HEIGHT - 2, "Press ESC for Main Menu", "#ffffff");
        StickMan.setScore(0);
    }
}
