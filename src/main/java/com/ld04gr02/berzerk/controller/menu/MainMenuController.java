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

    Sound sound = new Sound();
    public MainMenuController(MainMenu model) {
        super(model);
        loop(2, -20.0f);
    }


    @Override
    public boolean update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException, NullPointerException {
        switch(key) {
            case ARROW_UP :
                getModel().selectPrev();
                play(0, 0);
                break;
            case ARROW_DOWN :
                getModel().selectNext();
                play(0,0);
                break;
            case ENTER : {
                if (getModel().getSelected() == MenuOptions.QUIT) game.setState(null);
                MazeRenderer mazeRenderer = new MazeRenderer();
                if (getModel().getSelected() == MenuOptions.PLAY) {
                    sound.stopSound();
                    game.getGui().close();
                    play(0,0);
                    Maze maze = mazeRenderer.createMaze("maze3.lvl");
                    game.setState(new GameState(maze));
                    game.getState().initScreen(game.getGui(), maze.getWidth(), maze.getHeight());

                    return false;
                }
                play(0,0);
                break;
            }
            default:
                break;
        }
        return true;
    }

    void play(int i, float volume){
        sound.setFile(i);
        sound.playSound(volume);
    }

    void loop(int i, float volume){
        sound.setFile(i);
        sound.loopSound(volume);
    }


}
