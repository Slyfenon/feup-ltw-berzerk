package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.gui.GUI.KEY.ARROW_UP;
import static org.mockito.Mockito.*;

public class MazeControllerTests extends Assertions {

    private MazeController mazeController;
    private StickManController stickManController;
    private RobotController robotController;
    private BulletController bulletController;
    private EvilSmileController evilSmileController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze_test2.lvl");
        stickManController = mock(StickManController.class);
        robotController = mock(RobotController.class);
        bulletController = mock(BulletController.class);
        evilSmileController = mock(EvilSmileController.class);
        mazeController = new MazeController(maze, stickManController, robotController, evilSmileController, bulletController);
        game = mock(Game.class);
    }

    @Test
    public void updateTest() throws IOException, URISyntaxException, FontFormatException {
        mazeController.update(game, ARROW_UP, 0);
        verify(stickManController).update(game, ARROW_UP, 0);
        verify(robotController).update(game, ARROW_UP, 0);
        verify(evilSmileController).update(game, ARROW_UP, 0);
        verify(bulletController).update(game, ARROW_UP, 0);
    }

    @Test
    public void nextLevelTest() throws IOException, URISyntaxException, FontFormatException {
        mazeController.getModel().getStickMan().setPosition(new Position(600, 150));
        mazeController.update(game, ARROW_UP, 0);
        verify(game).levelUp();
        verify(game).setState(any());
    }

    @Test
    public void gameOverTest() throws IOException, URISyntaxException, FontFormatException {
        mazeController.getModel().getStickMan().decreaseLives();
        mazeController.getModel().getStickMan().decreaseLives();
        mazeController.getModel().getStickMan().decreaseLives();
        assertEquals(0, StickMan.getLives());

        GUI guiMock = mock(GUI.class);
        when(game.getGui()).thenReturn(guiMock);
        mazeController.update(game, ARROW_UP, 0);
        verify(guiMock).close();
        verify(game).setState(any());
        verify(game, times(2)).getGui();
        assertEquals(3, StickMan.getLives());
    }

    @Test
    public void gatesTest() throws IOException, URISyntaxException, FontFormatException {
        assertEquals(15, mazeController.getModel().getGates().size());
        mazeController.getModel().getRobots().clear();
        mazeController.update(game, ARROW_UP, 0);
        assertEquals(0, mazeController.getModel().getGates().size());
    }
}
