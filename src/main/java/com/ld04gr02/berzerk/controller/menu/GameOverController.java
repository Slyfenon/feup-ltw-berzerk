package com.ld04gr02.berzerk.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.Soundboard;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.model.menu.Leaderboard;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.model.menu.MenuOptions;
import com.ld04gr02.berzerk.state.GameOverState;
import com.ld04gr02.berzerk.state.GameState;
import com.ld04gr02.berzerk.state.LeaderboardState;
import com.ld04gr02.berzerk.state.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.*;

public class GameOverController extends Controller<GameOverMenu> {
    public GameOverController(GameOverMenu model) {
        super(model);
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
            switch (key) {
                case CHAR:
                    if(getModel().getName().length() == 10){
                        MainMenuState mainMenuState= new MainMenuState(new MainMenu());
                        game.getGui().close();
                        game.setState(mainMenuState);
                        mainMenuState.initScreen(game.getGui(), MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
                    }
                    break;
                case ESC:
                    Soundboard.getInstance().getClick().playSound(0);
                    MainMenuState mainMenuState= new MainMenuState(new MainMenu());
                    game.getGui().close();
                    game.setState(mainMenuState);
                    mainMenuState.initScreen(game.getGui(), MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
                    break;
                case ENTER:
                    LeaderboardState leaderboardstate = new LeaderboardState(new Leaderboard());
                    if(leaderboardstate.getModel().addToLeaderboard(getModel().getName().toString(), StickMan.getScore())) {
                        leaderboardstate.getModel().writeToFile("/src/main/resources/Leaderboard.brd");
                    }
                    game.setState(leaderboardstate);
                    break;
                default:
                    break;
            }
        }

}
