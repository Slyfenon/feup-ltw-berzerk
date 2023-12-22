package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.controller.game.MazeController;
import com.ld04gr02.berzerk.controller.game.StickManController;
import com.ld04gr02.berzerk.controller.menu.MainMenuController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;
import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class SoundTests {


    MainMenuController mainMenuController;

    Sound sound = Mockito.mock(Sound.class);

    Soundboard soundboard = Mockito.mock(Soundboard.class);
    Game game = Mockito.mock(Game.class);

    GUI gui = Mockito.mock(GUI.class);




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
            mazeController.update(game, GUI.KEY.ARROW_LEFT, 352);
            mazeController.update(game, GUI.KEY.NONE, 353);
            StickMan.setLives(0);
            mazeController.update(game, GUI.KEY.NONE, 354);
        }

        verify(sound, Mockito.times(1)).loopSound(-15.0f);
        verify(sound, Mockito.times(2)).playSound(0);
        verify(sound, Mockito.times(1)).playSound(-10.0f);

    }



}
