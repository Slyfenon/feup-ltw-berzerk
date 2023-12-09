package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.Soundboard;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.Leaderboard;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.model.menu.MenuOptions;
import com.ld04gr02.berzerk.state.GameState;
import com.ld04gr02.berzerk.state.LeaderboardState;
import com.ld04gr02.berzerk.state.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.INFO_SECTIONS_HEIGHT;

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
                else if (getModel().getSelected() == MenuOptions.PLAY) {
                    Soundboard.getInstance().getMenuSong().stopSound();
                    game.getGui().close();
                    game.setLevel(1);
                    StickMan.setScore(0);
                    MazeRenderer mazeRenderer = new MazeRenderer();
                    Maze maze = mazeRenderer.createMaze("maze1.lvl");
                    game.setState(new GameState(maze));
                    game.getState().initScreen(game.getGui(), maze.getWidth(), maze.getHeight() + INFO_SECTIONS_HEIGHT);
                    Soundboard.getInstance().getClick().playSound(0);
                }
                else if(getModel().getSelected() == MenuOptions.LEADERBOARD) {
                    LeaderboardState leaderboardstate = new LeaderboardState(new Leaderboard());
                    game.setState(leaderboardstate);
                }
                Soundboard.getInstance().getClick().playSound(0);
                break;
            }
            default:
                break;
        }
    }
}

