package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.state.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu model) {
        super(model);
    }


    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        switch(key) {
            case ARROW_UP -> getModel().selectPrev();
            case ARROW_DOWN -> getModel().selectNext();
            case ENTER -> {
                if (getModel().getSelected() == MainMenu.Options.QUIT) game.setState(null);
                MazeRenderer MazeRenderer = new MazeRenderer();
                if (getModel().getSelected() == MainMenu.Options.PLAY) {
                    game.getGui().close();
                    game.setState(new GameState(MazeRenderer.createMaze("maze1.lvl")));
                    game.getState().initScreen(game.getGui());
                }
            }

        }
    }
}
