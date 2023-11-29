package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.model.menu.MenuOptions;
import com.ld04gr02.berzerk.state.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainMenuController extends Controller<MainMenu> {

    Sound sound1 = new Sound();
    Sound sound2 = new Sound();
    public MainMenuController(MainMenu model) {
        super(model);
    }


    @Override
    public boolean update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        switch(key) {
            case ARROW_UP :
                getModel().selectPrev();
                play(0);
                break;
            case ARROW_DOWN :
                getModel().selectNext();
                play(0);
                break;
            case ENTER : {
                if (getModel().getSelected() == MenuOptions.QUIT) game.setState(null);
                MazeRenderer mazeRenderer = new MazeRenderer();
                if (getModel().getSelected() == MenuOptions.PLAY) {
                    play(0);
                    game.getGui().close();
                    Maze maze = mazeRenderer.createMaze("maze3.lvl");
                    game.setState(new GameState(maze));
                    game.getState().initScreen(game.getGui(), maze.getWidth(), maze.getHeight());
                    return false;
                }
                play(0);
                break;
            }
            default:
                break;
        }
        return true;
    }

    void play(int i){
        sound1.setFile(i);
        sound1.playSound();
    }


}
