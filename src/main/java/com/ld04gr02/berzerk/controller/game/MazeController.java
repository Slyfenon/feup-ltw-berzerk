package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.state.GameOverState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;

public class MazeController extends GameController {
    private final StickManController stickManController;
    private final RobotController robotController;

    public MazeController(Maze maze) {
        super(maze);
        System.out.println("oi");
        this.stickManController = new StickManController(maze);
        this.robotController = new RobotController(maze);
        playSong(-20.0f);
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        stickManController.update(game, key, time);
        robotController.update(game, key, time);
        if(getModel().getStickMan().getLives() == 0){
            game.getGui().close();
            stopSong(0);
            GameOverMenu gameOverMenu = new GameOverMenu();
            gameOverMenu.setStickManScore(getModel().getStickMan().getScore());
            GameOverState gameOverState= new GameOverState(gameOverMenu);
            game.setState(gameOverState);
            gameOverState.initScreen(game.getGui(), MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
        }
    }

    public void playSong(float volume){
        gameMusic.setFile(5);
        gameMusic.loopSound(volume);
    }
    public void stopSong(float volume){
        gameMusic.stopSound();
    }

}
