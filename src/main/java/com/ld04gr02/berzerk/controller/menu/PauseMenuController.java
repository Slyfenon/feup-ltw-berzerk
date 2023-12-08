package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.Soundboard;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.menu.MenuOptions;
import com.ld04gr02.berzerk.model.menu.PauseMenu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.INFO_SECTIONS_HEIGHT;

public class PauseMenuController extends Controller<PauseMenu> {


    public PauseMenuController(PauseMenu model) {
        super(model);

    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException, NullPointerException {
        switch(key) {
            case ARROW_UP :
                Soundboard.getInstance().getClick().stopSound();
                getModel().selectPrev();
                Soundboard.getInstance().getClick().playSound(0);
                break;
            case ARROW_DOWN :
                Soundboard.getInstance().getClick().stopSound();
                getModel().selectNext();
                Soundboard.getInstance().getClick().playSound(0);
                break;
            case ENTER : {
                if (getModel().getSelected() == MenuOptions.QUIT) game.setState(null);
                if (getModel().getSelected() == MenuOptions.RESUME) {
                    if(game.getPreviousState().getModel() instanceof Maze) {
                        game.getGui().close();
                        game.setState(game.getPreviousState());
                        Maze maze = (Maze) game.getPreviousState().getModel();
                        game.getState().initScreen(game.getGui(), maze.getWidth() , maze.getHeight() + INFO_SECTIONS_HEIGHT);
                    }
                }
                Soundboard.getInstance().getClick().playSound(0);
                break;
            }
            default:
                break;
        }
    }
}
