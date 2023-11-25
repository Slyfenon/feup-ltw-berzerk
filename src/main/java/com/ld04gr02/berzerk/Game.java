package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.state.GameState;
import com.ld04gr02.berzerk.state.State;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    public static final int GAME_SCREEN_WIDTH = 50;
    public static final int GAME_SCREEN_HEIGHT = 50;
    public Game() throws IOException, URISyntaxException, FontFormatException, UnsupportedAudioFileException, LineUnavailableException {
        this.gui = new LanternaGUI(GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT);

    }

    public static void main(String[] args) throws IOException {
        try {
            new Game().run();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    private void run() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        long startTime = System.currentTimeMillis();
        state.update(this, gui, startTime);
        StickMan s = new StickMan(10,10);
        GameState g = (GameState) state;
        g.getModel().setStickMan(s);
        g.getViewer().display(gui);
    }
}
