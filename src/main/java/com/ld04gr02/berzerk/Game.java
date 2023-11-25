package com.ld04gr02.berzerk;

import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.state.GameState;
import com.ld04gr02.berzerk.state.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    public Game() throws IOException, URISyntaxException, FontFormatException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        this.state = new GameState(mazeRenderer.createMaze("maze1.lvl"));
        GameState g = (GameState) state;
        this.gui = new LanternaGUI(g.getModel().getWidth(),g.getModel().getHeight());

        /*StickMan s = new StickMan(4,4);
        g.getModel().setStickMan(s);
        ArrayList<Wall> walls = new ArrayList<>(Arrays.asList(
                new Wall(10, 15),
                new Wall(20, 50),
                new Wall(40, 10),
                new Wall(15, 65),
                new Wall(0, 5),
                new Wall(46, 20),
                new Wall(20, 10)
        ));
        g.getModel().setWalls(walls);
        ArrayList<Robot> robots = new ArrayList<>(Arrays.asList(
                new Robot(100, 50),
                new Robot(200, 100),
                new Robot(300, 150),
                new Robot(420, 420),
                new Robot(100, 300),
                new Robot(250, 300)
        ));
        g.getModel().setRobots(robots);*/
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
