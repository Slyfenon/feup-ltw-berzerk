package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.state.MainMenuState;
import com.ld04gr02.berzerk.state.State;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private static Game game;

    static {
        try {
            game = new Game();
        } catch (IOException | URISyntaxException | FontFormatException e) {
            System.err.println("Erro ao iniciar o jogo: " + e.getMessage());
            throw new RuntimeException("Erro ao inicializar o jogo", e);
        }
    }

    private final LanternaGUI gui;
    private State state;

    // public static final int GAME_SCREEN_WIDTH = 50;
    // public static final int GAME_SCREEN_HEIGHT = 50;

    public static final int MENU_SCREEN_WIDTH = 70;
    public static final int MENU_SCREEN_HEIGHT = 30;
    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public LanternaGUI getGui() {
        return gui;
    }

    private Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI();
        this.state = new MainMenuState(new MainMenu());
        state.initScreen(gui, MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
    }

    public static Game getGame() {
        return game;
    }

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, FontFormatException {
        Game game = Game.getGame();
        game.run();
    }


    private void run() throws IOException, UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, FontFormatException {
        //int FPS = 1;
        int frameTime = 10;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.update(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        gui.close();
    }
}

