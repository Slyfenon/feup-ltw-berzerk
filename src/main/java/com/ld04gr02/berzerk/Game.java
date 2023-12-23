package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.state.MainMenuState;
import com.ld04gr02.berzerk.state.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private static Game game;
    private final GUI gui;
    private State previousState;
    private State state;
    public static final int MENU_SCREEN_WIDTH = 70;
    public static final int MENU_SCREEN_HEIGHT = 30;
    public static final int INFO_SECTIONS_HEIGHT = 30;
    public static final int GAME_SCREEN_WIDTH = 502;
    static private int level = 1;
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

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
        this.state = new MainMenuState(new MainMenu());
    }

    public Game(LanternaGUI gui) throws IOException {
        this.gui = gui;
        this.state = new MainMenuState(new MainMenu());
    }

    public static Game getGame() {
        return game;
    }

    static public int getLevel() {
        return level;
    }

    static public void setLevel(int level){
        Game.level = level;
    }
    public void levelUp() {level++;}

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        game.run();
    }


    private void run() throws IOException, URISyntaxException, FontFormatException {
        int FPS = 60;
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

