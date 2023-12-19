package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.*;
import com.ld04gr02.berzerk.view.menu.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
        verify(guiMock, times(9)).drawText(any(), any(), anyString());
        verify(guiMock, times(1)).drawBlinkText(any(), any(), anyString());
    }

    @Test
    public void InstructionsMenuViewerTest() throws IOException {
        InstructionsMenu instructionsMenu = new InstructionsMenu();
        InstructionsViewer instructionsViewer = new InstructionsViewer(instructionsMenu);
        instructionsViewer.display(guiMock);
        verify(guiMock, times(25)).drawText(any(), any(), anyString());
    }

    @Test
    public void LeaderboardViewerTest() throws IOException {
        Leaderboard leaderboard = new Leaderboard();
        LeaderboardViewer leaderboardViewer = new LeaderboardViewer(leaderboard);
        leaderboardViewer.display(guiMock);
        verify(guiMock, times(28)).drawText(any(), any(), anyString());
    }

    @Test
    public void PauseMenuViewerTest() throws IOException {
        PauseMenu pauseMenu = new PauseMenu();
        MenuViewer<PauseMenu> pauseMenuViewer = new MenuViewer<>(pauseMenu);
        pauseMenuViewer.display(guiMock);
        verify(guiMock, times(8)).drawText(any(), any(), anyString());
        verify(guiMock, times(1)).drawBlinkText(any(), any(), anyString());
    }

    @Test
    public void GameOverMenuViewerTest() throws IOException {
        GameOverMenu gameOverMenu = new GameOverMenu();
        GameOverViewer gameOverViewer = new GameOverViewer(gameOverMenu);
        gameOverViewer.display(guiMock);
        verify(guiMock, times(14)).drawText(any(), any(), anyString());
        verify(guiMock, times(1)).drawBlinkText(any(), any(), anyString());
    }
}
