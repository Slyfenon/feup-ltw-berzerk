package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.state.GameState;
import com.ld04gr02.berzerk.state.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(500,500);
        this.state = new GameState(new Maze(20,20));
        StickMan s = new StickMan(4,4);
        GameState g = (GameState) state;
        g.getModel().setStickMan(s);
        g.getViewer().display(gui);
    }

    public static void main(String[] args) throws IOException {
        try {
            Game game = new Game();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }

    // private void run() throws IOException {}
}
