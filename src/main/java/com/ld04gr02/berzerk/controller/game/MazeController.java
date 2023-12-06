package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
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
    private final EvilSmileController evilSmileController;
    private final BulletController bulletController;

    public MazeController(Maze maze) {
        super(maze);
        this.stickManController = new StickManController(maze);
        this.robotController = new RobotController(maze);
        this.evilSmileController = new EvilSmileController(maze);
        this.bulletController = new BulletController(maze);
        playSong(-20.0f);
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        bulletController.update(game, key, time);
        stickManController.update(game, key, time);
        robotController.update(game, key, time);
        evilSmileController.update(game, key, time);
        if (getModel().getRobots().isEmpty()) getModel().getGates().clear();
        if(StickMan.getLives() == 0){
            game.getGui().close();
            stopSong(0);
            GameOverMenu gameOverMenu = new GameOverMenu();
            GameOverState gameOverState= new GameOverState(gameOverMenu);
            game.setState(gameOverState);
            gameOverState.initScreen(game.getGui(), MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
            getModel().getStickMan().setLives(3);
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
