package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.view.game.GameViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.ld04gr02.berzerk.Game.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
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
        setLevel(1);
        gameViewer.getModel().getBullets().add(new Bullet(5,5, Direction.Right));
        gameViewer.display(guiMock);
        verify(guiMock, times(1)).drawFrame(anyInt(), anyInt());
        verify(guiMock, times(1 + gameViewer.getModel().getRobots().size() + 1 + gameViewer.getModel().getBullets().size() + 5 + 5 + 2)).drawSprite(anyInt(), anyInt(), any(), anyChar(), anyString());
        verify(guiMock, times(gameViewer.getModel().getWalls().size() + gameViewer.getModel().getGates().size())).drawWall(any(), anyString());
        gameViewer.getModel().getBullets().clear();
        verify(guiMock).clear();
        verify(guiMock).refresh();
    }
}
