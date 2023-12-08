package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Soundboard;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.InstructionsMenu;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.model.menu.MenuOptions;
import com.ld04gr02.berzerk.state.GameState;
import com.ld04gr02.berzerk.state.InstructionsMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.*;

public class MainMenuController extends Controller<MainMenu> {


    public MainMenuController(MainMenu model) {
        super(model);
        Soundboard.getInstance().getMenuSong().loopSound(-15.0f);
    }


    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException, NullPointerException {
        switch (key) {
            case ARROW_UP:
                getModel().selectPrev();
                Soundboard.getInstance().getClick().playSound(0);
                break;
            case ARROW_DOWN:
                getModel().selectNext();
                Soundboard.getInstance().getClick().playSound(0);
                break;
            case ENTER: {
                if (getModel().getSelected() == MenuOptions.QUIT) game.setState(null);
                if (getModel().getSelected() == MenuOptions.PLAY) {
                    Soundboard.getInstance().getMenuSong().stopSound();
                    game.getGui().close();
                    game.setLevel(0);
                    StickMan.setScore(0);
                    MazeRenderer mazeRenderer = new MazeRenderer();
                    Maze maze = mazeRenderer.createMaze("maze1.lvl");
                    game.setState(new GameState(maze));
                    game.getState().initScreen(game.getGui(), maze.getWidth(), maze.getHeight() + INFO_SECTIONS_HEIGHT);
                    Soundboard.getInstance().getClick().playSound(0);
                }
                if(getModel().getSelected() == MenuOptions.INSTRUCTIONS){
                    game.getGui().close();
                    InstructionsMenu instructionsMenu = new InstructionsMenu();
                    game.setState(new InstructionsMenuState(instructionsMenu));
                    game.getState().initScreen(game.getGui(), MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
                }
                Soundboard.getInstance().getClick().playSound(0);
                break;
            }
            default:
                break;
        }
    }
}

