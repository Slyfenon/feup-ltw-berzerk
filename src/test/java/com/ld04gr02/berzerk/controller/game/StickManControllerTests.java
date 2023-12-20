package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.PauseMenu;
import com.ld04gr02.berzerk.state.PauseMenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.ld04gr02.berzerk.gui.GUI.KEY.*;
import static org.mockito.Mockito.*;

public class StickManControllerTests extends Assertions {
    private StickManController stickManController;
    private Game game;

    @BeforeEach
    public void setUp() throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        Maze maze = mazeRenderer.createMaze("maze_test2.lvl");
        stickManController = new StickManController(maze);
        game = mock(Game.class);
    }

    @Test
    public void moveStickManUpTest() throws IOException, URISyntaxException, FontFormatException {
        int initialY = stickManController.getModel().getStickMan().getPosition().getY();
        stickManController.update(game, ARROW_UP, 0);
        assertEquals(initialY-5, stickManController.getModel().getStickMan().getPosition().getY());
        assertEquals(Direction.Up, stickManController.getModel().getStickMan().getCurrentDirection());
        assertTrue(stickManController.getModel().getStickMan().isMoving());
    }

    @Test
    public void moveStickManDownTest() throws IOException, URISyntaxException, FontFormatException {
        int initialY = stickManController.getModel().getStickMan().getPosition().getY();
        stickManController.update(game, ARROW_DOWN, 0);
        assertEquals(initialY+5, stickManController.getModel().getStickMan().getPosition().getY());
        assertEquals(Direction.Down, stickManController.getModel().getStickMan().getCurrentDirection());
        assertTrue(stickManController.getModel().getStickMan().isMoving());
    }

    @Test
    public void moveStickManRightTest() throws IOException, URISyntaxException, FontFormatException {
        int initialX = stickManController.getModel().getStickMan().getPosition().getX();
        stickManController.update(game, ARROW_RIGHT, 0);
        assertEquals(initialX+5, stickManController.getModel().getStickMan().getPosition().getX());
        assertEquals(Direction.Right, stickManController.getModel().getStickMan().getCurrentDirection());
        assertTrue(stickManController.getModel().getStickMan().isMoving());
        assertFalse(stickManController.getModel().getStickMan().isCollided());
    }

    @Test
    public void moveStickManLeftTest() throws IOException, URISyntaxException, FontFormatException {
        int initialX = stickManController.getModel().getStickMan().getPosition().getX();
        stickManController.update(game, ARROW_LEFT, 0);
        assertEquals(initialX-5, stickManController.getModel().getStickMan().getPosition().getX());
        assertEquals(Direction.Left, stickManController.getModel().getStickMan().getCurrentDirection());
        assertTrue(stickManController.getModel().getStickMan().isMoving());
    }

    @Test
    public void moveStickManSpaceTest() throws IOException, URISyntaxException, FontFormatException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, SPACE, 4000);
        assertEquals(position, stickManController.getModel().getStickMan().getPosition());
        assertEquals(1, stickManController.getModel().getBullets().size());
    }

    @Test
    public void shootingTest() throws IOException, URISyntaxException, FontFormatException {
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, SPACE, 351);
        assertEquals(1, stickManController.getModel().getBullets().size());
        assertEquals(new Position(19, 151), stickManController.getModel().getBullets().get(0).getPosition());

        stickManController.getModel().getStickMan().setDirection(Direction.Down);
        stickManController.update(game, SPACE, 702);
        assertEquals(2, stickManController.getModel().getBullets().size());
        assertEquals(new Position(14, 160), stickManController.getModel().getBullets().get(1).getPosition());

        stickManController.getModel().getStickMan().setDirection(Direction.Left);
        stickManController.update(game, SPACE, 1053);
        assertEquals(3, stickManController.getModel().getBullets().size());
        assertEquals(new Position(6, 151), stickManController.getModel().getBullets().get(2).getPosition());

        stickManController.getModel().getStickMan().setDirection(Direction.Up);
        stickManController.update(game, SPACE, 1404);
        assertEquals(4, stickManController.getModel().getBullets().size());
        assertEquals(new Position(14, 139), stickManController.getModel().getBullets().get(3).getPosition());

        stickManController.getModel().getStickMan().setDirection(Direction.Up);
        stickManController.update(game, SPACE, 1754);
        assertEquals(4, stickManController.getModel().getBullets().size());

        assertEquals(position, stickManController.getModel().getStickMan().getPosition());
        assertTrue(stickManController.getModel().getStickMan().isShooting());

        stickManController.getModel().getStickMan().setDirection(Direction.None);
        assertNull(stickManController.getNewBulletPosition());
    }

    @Test
    public void moveStickManCollidedTest() throws IOException, URISyntaxException, FontFormatException {
        stickManController.update(game, ARROW_RIGHT, 1000);
        stickManController.getModel().getStickMan().setCollided(true);
        stickManController.update(game, SPACE, 1000);
        assertEquals(new Position(10, 143), stickManController.getModel().getStickMan().getPosition());
        assertEquals(2, StickMan.getLives());
        assertFalse(stickManController.getModel().getStickMan().isCollided());
    }

    @Test
    public void pauseTest() throws IOException, URISyntaxException, FontFormatException {
        GUI gui = mock(GUI.class);
        PauseMenu pauseMenu = mock(PauseMenu.class);
        when(game.getGui()).thenReturn(gui);
        PauseMenuState pauseMenuState = mock(PauseMenuState.class);
        when(pauseMenuState.getModel()).thenReturn(pauseMenu);
        when(game.getState()).thenReturn(pauseMenuState);

        stickManController.update(game, ESC, 0);
        verify(gui).close();
        verify(pauseMenuState).initScreen(any(), anyInt(), anyInt());
        verify(game).setPreviousState(any());
        verify(game).setState(any());
    }

    @Test
    public void stopTest() throws IOException, URISyntaxException, FontFormatException {
        stickManController.getModel().getStickMan().setMoving(true);
        Position position = stickManController.getModel().getStickMan().getPosition();
        stickManController.update(game, CHAR, 0);
        assertEquals(position, stickManController.getModel().getStickMan().getPosition());
        assertFalse(stickManController.getModel().getStickMan().isMoving());
    }

    @Test
    public void collideEvilSmileTest() throws IOException, URISyntaxException, FontFormatException {
        stickManController.getModel().getEvilSmile().setPosition(new Position(10, 143));
        stickManController.update(game, ARROW_RIGHT, 0);
        assertTrue(stickManController.getModel().getStickMan().isCollided());
        assertTrue(stickManController.getModel().getEvilSmile().isCollided());
    }

    @Test
    public void collideBulletTest() throws IOException, URISyntaxException, FontFormatException {
        stickManController.getModel().getBullets().clear();
        ArrayList<Bullet> bullets = new ArrayList<>(Arrays.asList(
                new Bullet(15, 150, Direction.Left)
        ));
        stickManController.getModel().setBullets(bullets);
        stickManController.update(game, ARROW_RIGHT, 0);
        assertTrue(stickManController.getModel().getStickMan().isCollided());
    }

    @Test
    public void collideGateTest() throws IOException, URISyntaxException, FontFormatException {
        stickManController.getModel().getStickMan().setPosition(new Position(498, 148));
        stickManController.update(game, ARROW_DOWN, 0);
        assertTrue(stickManController.getModel().getStickMan().isCollided());
    }
}

