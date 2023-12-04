package com.ld04gr02.berzerk.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.model.menu.MenuOptions;
import com.ld04gr02.berzerk.state.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverController extends Controller<GameOverMenu> {
    public GameOverController(GameOverMenu model) {
        super(model);
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {

        if(getModel().getName().length() <= 5) {
            switch (key) {
                case CHAR:
                    getModel().setName(getModel().getName());
                    break;
                default:
                    break;
            }
        }
    }
}
