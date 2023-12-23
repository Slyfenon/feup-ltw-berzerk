package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.controller.game.MazeController;
import com.ld04gr02.berzerk.controller.menu.*;
import com.ld04gr02.berzerk.gui.GUI;

import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.*;
import com.ld04gr02.berzerk.state.GameState;
import com.ld04gr02.berzerk.state.MainMenuState;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.awt.FontFormatException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SoundTests {

    Sound sound = Mockito.mock(Sound.class);
    Soundboard soundboard = Mockito.mock(Soundboard.class);
    Game game = Mockito.mock(Game.class);
    GUI gui = Mockito.mock(GUI.class);
    Clip clip = Mockito.mock(Clip.class);
    GameState gameState = Mockito.mock(GameState.class);

    MainMenuState mainMenuState = Mockito.mock(MainMenuState.class);

    @Test
    void menuSounds() throws IOException, URISyntaxException, FontFormatException {
        when(soundboard.getMenuSong()).thenReturn(sound);
        when(soundboard.getClick()).thenReturn(sound);
        when(soundboard.getPlaySong()).thenReturn(sound);
        when(game.getGui()).thenReturn(gui);
        when(game.getState()).thenReturn(gameState);
        when(game.getPreviousState()).thenReturn(gameState);
        doNothing().when(gui).close();
        doNothing().when(game).setState(any());
        doNothing().when(gameState).initScreen(any(), anyInt(), anyInt());

        try (MockedStatic<Soundboard> configurationMockedStatic = Mockito.mockStatic(Soundboard.class)) {
            configurationMockedStatic.when(Soundboard::getInstance).thenReturn(soundboard);
            MainMenuController mainMenuController = new MainMenuController(new MainMenu());
            mainMenuController.update(game, GUI.KEY.ARROW_UP, 0);
            mainMenuController.update(game, GUI.KEY.ARROW_DOWN, 0);
            mainMenuController.update(game, GUI.KEY.ENTER, 0);
            PauseMenuController pauseMenuController = new PauseMenuController(new PauseMenu());
            pauseMenuController.update(game, GUI.KEY.ARROW_UP, 0);
            pauseMenuController.update(game, GUI.KEY.ARROW_DOWN, 0);
            pauseMenuController.update(game, GUI.KEY.ENTER, 0);
            PauseMenuController pauseMenuController2 = new PauseMenuController(new PauseMenu());
            pauseMenuController2.update(game, GUI.KEY.ARROW_DOWN, 0);
            pauseMenuController2.update(game, GUI.KEY.ENTER, 1);
        }

        verify(sound, Mockito.times(3)).loopSound(-15.0f);
        verify(sound, Mockito.times(6)).stopSound();
        verify(sound, Mockito.times(6)).playSound(0);
        verify(gui, Mockito.times(2)).close();
    }

    @Test
    void leaderboardInstructionsGameOverSounds() throws IOException, URISyntaxException, FontFormatException {
        when(soundboard.getMenuSong()).thenReturn(sound);
        when(soundboard.getClick()).thenReturn(sound);
        when(game.getGui()).thenReturn(gui);
        when(game.getState()).thenReturn(mainMenuState);
        doNothing().when(gui).close();
        doNothing().when(game).setState(any());

        try (MockedStatic<Soundboard> configurationMockedStatic = Mockito.mockStatic(Soundboard.class)) {
            configurationMockedStatic.when(Soundboard::getInstance).thenReturn(soundboard);
            LeaderboardController leaderboardController = new LeaderboardController(new Leaderboard("/src/main/resources/LeaderboardTest.brd"));
            leaderboardController.update(game, GUI.KEY.ESC, 0);
            InstructionsMenuController instructionsMenuController = new InstructionsMenuController(new InstructionsMenu());
            instructionsMenuController.update(game, GUI.KEY.ESC, 0);
            GameOverController gameOverController = new GameOverController(new GameOverMenu());
            gameOverController.update(game, GUI.KEY.ESC, 0);
        }

        verify(sound, Mockito.times(3)).loopSound(-15.0f);
        verify(sound, Mockito.times(3)).playSound(0);
    }

    @Test
    void gameSounds() throws IOException, URISyntaxException, FontFormatException {

        when(soundboard.getBullet()).thenReturn(sound);
        when(soundboard.getPlaySong()).thenReturn(sound);
        when(soundboard.getShock()).thenReturn(sound);

        try (MockedStatic<Soundboard> configurationMockedStatic = Mockito.mockStatic(Soundboard.class)) {
            configurationMockedStatic.when(Soundboard::getInstance).thenReturn(soundboard);
            MazeRenderer mazeRenderer = new MazeRenderer();
            Maze maze = mazeRenderer.createMaze("maze_test3.lvl");
            MazeController mazeController = new MazeController(maze);
            mazeController.update(game, GUI.KEY.SPACE, 351);
            mazeController.update(game, GUI.KEY.ARROW_LEFT, 400);
            mazeController.update(game, GUI.KEY.NONE, 450);
        }

        verify(sound, Mockito.times(1)).loopSound(-15.0f);
        verify(sound, Mockito.times(2)).playSound(0);
    }

    @Test
    void gameOverSounds() throws IOException, URISyntaxException, FontFormatException {

        when(soundboard.getPlaySong()).thenReturn(sound);
        when(soundboard.getGameOverSound()).thenReturn(sound);
        when(game.getGui()).thenReturn(gui);
        doNothing().when(gui).close();

        try (MockedStatic<Soundboard> configurationMockedStatic = Mockito.mockStatic(Soundboard.class)) {
            configurationMockedStatic.when(Soundboard::getInstance).thenReturn(soundboard);
            MazeRenderer mazeRenderer = new MazeRenderer();
            Maze maze = mazeRenderer.createMaze("maze_test3.lvl");
            MazeController mazeController = new MazeController(maze);
            StickMan.setLives(0);
            mazeController.update(game, GUI.KEY.NONE, 0);
        }

        verify(sound, Mockito.times(1)).loopSound(-15.0f);
        verify(sound, Mockito.times(1)).playSound(-10.0f);
        verify(sound, Mockito.times(1)).stopSound();
    }

    @Test
    void clipTest() throws IOException {
        Sound sound = new Sound("/src/main/resources/sounds/zipclick.wav");
        FloatControl floatControlMock = Mockito.mock(FloatControl.class);
        when(clip.getControl(FloatControl.Type.MASTER_GAIN)).thenReturn(floatControlMock);
        when(floatControlMock.getValue()).thenReturn(-15.0f);

        sound.setClip(clip);

        sound.playSound(-15.0f);
        FloatControl floatControl = (FloatControl) sound.getClip().getControl(FloatControl.Type.MASTER_GAIN);
        sound.stopSound();

        assertNotNull(sound);
        assertEquals(-15.0f, floatControl.getValue());
        Mockito.verify(clip, Mockito.times(1)).setMicrosecondPosition(0L);
        Mockito.verify(clip, Mockito.times(1)).start();
        Mockito.verify(clip, Mockito.times(1)).stop();
    }

    @Test
    void loopSoundTest() throws IOException {
        Sound sound = new Sound("/src/main/resources/sounds/zipclick.wav");
        FloatControl floatControlMock = Mockito.mock(FloatControl.class);
        when(clip.getControl(FloatControl.Type.MASTER_GAIN)).thenReturn(floatControlMock);
        when(floatControlMock.getValue()).thenReturn(-15.0f);

        sound.setClip(clip);

        sound.loopSound(-15.0f);
        FloatControl floatControl = (FloatControl) sound.getClip().getControl(FloatControl.Type.MASTER_GAIN);
        sound.stopSound();

        assertNotNull(sound);
        assertEquals(-15.0f, floatControl.getValue());
        Mockito.verify(clip, Mockito.times(1)).setMicrosecondPosition(0L);
        Mockito.verify(clip, Mockito.times(1)).start();
        Mockito.verify(clip, Mockito.times(1)).loop(Clip.LOOP_CONTINUOUSLY);
        Mockito.verify(clip, Mockito.times(1)).stop();
    }

    @Test
    void invalidPath() throws IOException {
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(errContent, true, StandardCharsets.UTF_8));
        sound = new Sound("");
        String errorMessage = errContent.toString(StandardCharsets.UTF_8).trim();
        System.setErr(originalErr);
        assertTrue(errorMessage.startsWith("Error: opening"));
    }
}
