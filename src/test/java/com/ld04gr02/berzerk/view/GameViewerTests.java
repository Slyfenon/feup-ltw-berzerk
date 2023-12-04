/*
package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.view.game.GameViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class GameViewerTests extends Assertions {
    GameViewer gameViewer;
    private GUI guiMock;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze_test.lvl");
        gameViewer = new GameViewer(maze);
        guiMock = mock(GUI.class);
    }

    @Test
    public void displayTest() throws IOException {
        gameViewer.display(guiMock);

        verify(guiMock, times(14)).drawSprite(any(), any(), anyChar(), anyString());
        verify(guiMock).clear();
        verify(guiMock).refresh();
    }
}
*/
