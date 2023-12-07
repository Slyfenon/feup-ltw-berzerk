package com.ld04gr02.berzerk.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.model.menu.MenuOptions;
import com.ld04gr02.berzerk.state.GameOverState;
import com.ld04gr02.berzerk.state.GameState;
import com.ld04gr02.berzerk.state.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.*;

public class GameOverController extends Controller<GameOverMenu> {
    private final Sound gameOverSound = new Sound();
    public GameOverController(GameOverMenu model) {
        super(model);
        gameOverSound.playGameOverMusic(-10.0f);
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {

            switch (key) {
                case CHAR:
                    if(getModel().getName().length() == 10){
                        MainMenu mainMenu = new MainMenu();
                        MainMenuState mainMenuState= new MainMenuState(mainMenu);
                        game.getGui().close();
                        game.setState(mainMenuState);
                        mainMenuState.initScreen(game.getGui(), MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
                    }
                    break;
                case ESC:
                    gameOverSound.stopSound();
                    MainMenu mainMenu = new MainMenu();
                    MainMenuState mainMenuState= new MainMenuState(mainMenu);
                    game.getGui().close();
                    game.setState(mainMenuState);
                    mainMenuState.initScreen(game.getGui(), MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
                    break;
                case ENTER:
                    break;
                default:
                    break;
            }
        }

}
