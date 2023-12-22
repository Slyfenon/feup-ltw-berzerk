package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.game.MazeController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.view.game.GameViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class GameStateTests extends Assertions {
    private GameState gameState;
    private MazeController mazeController;
    private GameViewer gameViewer;
    private LanternaGUI lanternaGUI;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze_test.lvl");
        gameState = new GameState(maze);
        lanternaGUI = mock(LanternaGUI.class);

        mazeController = mock(MazeController.class);
        gameViewer = mock(GameViewer.class);
        gameState.setController(mazeController);
        gameState.setViewer(gameViewer);

        game = mock(Game.class);
    }

    @Test
    public void initScreenTest() throws IOException, URISyntaxException, FontFormatException {
        gameState.initScreen(lanternaGUI, gameState.getModel().getWidth(), gameState.getModel().getHeight());
        verify(lanternaGUI).createGameScreen(gameState.getModel().getWidth(), gameState.getModel().getHeight());
    }

    @Test
    public void updateTest() throws IOException, URISyntaxException, FontFormatException {
        when(lanternaGUI.getPressedKey()).thenReturn(GUI.KEY.ARROW_RIGHT);
        gameState.update(game, lanternaGUI, 0);
        verify(mazeController).update(game, GUI.KEY.ARROW_RIGHT, 0);
        verify(gameViewer).display(lanternaGUI);
    }

    @Test
    public void gettersTest() {
        assertEquals(new Position(10, 111), gameState.getController().getModel().getStickMan().getPosition());
        assertEquals(new Position(10, 111), gameState.getViewer().getModel().getStickMan().getPosition());
    }
}
