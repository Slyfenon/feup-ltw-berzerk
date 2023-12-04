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
    Sound menuSong = new Sound();

    public MainMenuController(MainMenu model) {
        super(model);
        if(menuSong.getClip() != null){
            stopMenuSong();
        }
        else {
            playMenuSong(-20.0f);
        }
    }


    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException, NullPointerException {
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
                if (getModel().getSelected() == MenuOptions.PLAY) {
                    game.getGui().close();
                    play(0,0);
                    MazeRenderer mazeRenderer = new MazeRenderer();
                    Maze maze = mazeRenderer.createMaze("maze3.lvl");
                    stopMenuSong();
                    game.setState(new GameState(maze));
                    game.getState().initScreen(game.getGui(), maze.getWidth(), maze.getHeight());
                }
                play(0,0);
                break;
            }
            default:
                break;
        }
    }

    void play(int i, float volume){
        sound.setFile(i);
        sound.playSound(volume);
    }

    public void playMenuSong(float volume){
        menuSong.setFile(2);
        menuSong.loopSound(volume);
    }

    public void stopMenuSong(){
        menuSong.stopSound();
    }
}
