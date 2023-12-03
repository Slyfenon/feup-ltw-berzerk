package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameStateTests extends Assertions {
    private GameState gameState;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze_test.lvl");
        gameState = new GameState(maze);
    }

    @Test
    public void initScreenTest() throws IOException, URISyntaxException, FontFormatException {
        LanternaGUI lanternaGUI = mock(LanternaGUI.class);
        gameState.initScreen(lanternaGUI, gameState.getModel().getWidth(), gameState.getModel().getHeight());
        verify(lanternaGUI).createGameScreen(gameState.getModel().getWidth(), gameState.getModel().getHeight());
    }

    @Test
    public void updateTest() {

    }
}
