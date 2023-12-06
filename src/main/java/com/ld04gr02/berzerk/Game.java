package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.gui.GUI;
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
            System.err.println("Error starting the game:  " + e.getMessage());
            throw new RuntimeException("Error starting the game", e);
        }
    }

    private final GUI gui;
    private State previousState;
    private State state;
    public static final int MENU_SCREEN_WIDTH = 70;
    public static final int MENU_SCREEN_HEIGHT = 30;
    public static final int INFO_SECTIONS_HEIGHT = 30;
    public static final int GAME_SCREEN_WIDTH = 502;
    public int level = 1;
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public State getPreviousState() {
        return previousState;
    }
    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    public GUI getGui() {
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

    public int getLevel() {
        return level;
    }
    public void levelUp() {level++;}

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, FontFormatException {
        Game game = Game.getGame();
        game.run();
    }


    private void run() throws IOException, URISyntaxException, FontFormatException {
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
                throw new RuntimeException("InterruptedException", e);
            }
        }

        gui.close();
    }
}

