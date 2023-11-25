package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.state.GameState;
import com.ld04gr02.berzerk.state.MainMenuState;
import com.ld04gr02.berzerk.state.State;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    // public static final int GAME_SCREEN_WIDTH = 50;
    // public static final int GAME_SCREEN_HEIGHT = 50;

    public void setState(State state) {
        this.state = state;
    }

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(500,500);
        this.state = new MainMenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException {
        try {
            new Game().run();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }


    private void run() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.update(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}

