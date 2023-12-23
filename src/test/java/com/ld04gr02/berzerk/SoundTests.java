package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.controller.game.MazeController;
import com.ld04gr02.berzerk.controller.menu.MainMenuController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class SoundTests {

    MainMenuController mainMenuController;
    Sound sound = Mockito.mock(Sound.class);
    Soundboard soundboard = Mockito.mock(Soundboard.class);
    Game game = Mockito.mock(Game.class);
    GUI gui = Mockito.mock(GUI.class);
    Clip clip = Mockito.mock(Clip.class);

    @Test
    void mainMenuSounds() throws IOException, URISyntaxException, FontFormatException {

        when(soundboard.getMenuSong()).thenReturn(sound);
        when(soundboard.getClick()).thenReturn(sound);

        try (MockedStatic<Soundboard> configurationMockedStatic = Mockito.mockStatic(Soundboard.class)) {
            configurationMockedStatic.when(Soundboard::getInstance).thenReturn(soundboard);
            mainMenuController = new MainMenuController(new MainMenu());
            mainMenuController.update(game, GUI.KEY.ARROW_UP, 0);
            mainMenuController.update(game, GUI.KEY.ARROW_DOWN, 0);
        }

        verify(sound, Mockito.times(1)).loopSound(-15.0f);
        verify(sound, Mockito.times(2)).playSound(0);
    }

    @Test
    void gameSounds() throws IOException, URISyntaxException, FontFormatException {

        when(soundboard.getBullet()).thenReturn(sound);
        when(soundboard.getPlaySong()).thenReturn(sound);
        when(soundboard.getShock()).thenReturn(sound);
        when(soundboard.getGameOverSound()).thenReturn(sound);
        when(game.getGui()).thenReturn(gui);
        doNothing().when(gui).close();

        try (MockedStatic<Soundboard> configurationMockedStatic = Mockito.mockStatic(Soundboard.class)) {
            configurationMockedStatic.when(Soundboard::getInstance).thenReturn(soundboard);
            MazeRenderer mazeRenderer = new MazeRenderer();
            Maze maze = mazeRenderer.createMaze("maze_test3.lvl");
            MazeController mazeController = new MazeController(maze);
            mazeController.update(game, GUI.KEY.SPACE, 351);
            mazeController.update(game, GUI.KEY.ARROW_LEFT, 400);
            mazeController.update(game, GUI.KEY.NONE, 450);
            StickMan.setLives(0);
            mazeController.update(game, GUI.KEY.NONE, 500);
        }

        verify(sound, Mockito.times(1)).loopSound(-15.0f);
        verify(sound, Mockito.times(2)).playSound(0);
        verify(sound, Mockito.times(1)).playSound(-10.0f);
    }

    @Test
    void clipTest() {
        Sound sound = new Sound("/src/main/resources/sounds/zipclick.wav");
        FloatControl floatControlMock = Mockito.mock(FloatControl.class);
        when(clip.getControl(FloatControl.Type.MASTER_GAIN)).thenReturn(floatControlMock);
        doNothing().when(floatControlMock).setValue(0);

        FloatControl floatControl = (FloatControl) sound.getClip().getControl(FloatControl.Type.MASTER_GAIN);
        sound.setClip(clip);
        sound.playSound(0);
        sound.stopSound();
        sound.loopSound(0);
        sound.stopSound();

        assertNotNull(sound);
        assertEquals(-25.0f, floatControl.getValue());
        Mockito.verify(clip, Mockito.times(2)).setMicrosecondPosition(0);
        Mockito.verify(clip, Mockito.times(2)).start();
        Mockito.verify(clip, Mockito.times(1)).loop(Clip.LOOP_CONTINUOUSLY);
        Mockito.verify(clip, Mockito.times(2)).stop();
    }
}
