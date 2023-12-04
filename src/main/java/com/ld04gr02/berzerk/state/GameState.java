package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.controller.game.MazeController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.view.GameViewer;
import com.ld04gr02.berzerk.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;

public class GameState extends State<Maze> {
    public GameState(Maze maze) {

        super(maze);
    }

    @Override
    public Viewer<Maze> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Maze> getController() {
        return new MazeController(getModel());
    }
    @Override
    public void update(Game game, GUI gui, long time) throws IOException, URISyntaxException, FontFormatException {
        GUI.KEY action = gui.getPressedKey();
        this.controller.update(game, action, time);
        if(action != GUI.KEY.ESC) {
            this.viewer.display(gui);
            if(action == GUI.KEY.ARROW_UP
                    || action == GUI.KEY.ARROW_DOWN
                    || action == GUI.KEY.ARROW_LEFT
                    || action == GUI.KEY.ARROW_RIGHT) {
                this.model.getStickMan().changeMoving();
                this.viewer.display(gui);
            }
        }
    }

    @Override
    public void initScreen(GUI gui, int width, int height) throws IOException, URISyntaxException, FontFormatException {
        gui.createGameScreen(width,height);
    }

}
