package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Soundboard;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.maze.MazeRenderer;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.state.GameOverState;
import com.ld04gr02.berzerk.state.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.*;

public class MazeController extends GameController {
    private final StickManController stickManController;
    private final RobotController robotController;
    private final EvilSmileController evilSmileController;
    private final BulletController bulletController;
    public MazeController(Maze maze) throws IOException {
        super(maze);
        this.stickManController = new StickManController(maze);
        this.robotController = new RobotController(maze);
        this.evilSmileController = new EvilSmileController(maze);
        this.bulletController = new BulletController(maze);
        Soundboard.getInstance().getPlaySong().loopSound(-15.0f);
    }

    public MazeController(Maze maze, StickManController stickManController, RobotController robotController, EvilSmileController evilSmileController, BulletController bulletController) {
        super(maze);
        this.stickManController = stickManController;
        this.robotController = robotController;
        this.evilSmileController = evilSmileController;
        this.bulletController = bulletController;
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        if (getModel().getStickMan().getPosition().getX() > GAME_SCREEN_WIDTH) {
            nextLevel(game);
            return;
        }
        bulletController.update(game, key, time);
        stickManController.update(game, key, time);
        robotController.update(game, key, time);
        if(getModel().getEvilSmile() != null) {
            evilSmileController.update(game, key, time);
        }
        if (getModel().getRobots().isEmpty()) getModel().getGates().clear();
        if(StickMan.getLives() == 0){
            Soundboard.getInstance().getPlaySong().stopSound();
            game.getGui().close();
            GameOverState gameOverState= new GameOverState(new GameOverMenu());
            game.setState(gameOverState);
            getModel().getStickMan().setLives(3);
            gameOverState.initScreen(game.getGui(), MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
            Soundboard.getInstance().getGameOverSound().playSound(-10.0f);
        }
    }


    public void nextLevel(Game game) throws IOException {
        MazeRenderer mazeRenderer = new MazeRenderer();
        game.levelUp();
        String level = "maze" + (((game.getLevel() - 1) % 8) + 1) + ".lvl";
        Maze maze = mazeRenderer.createMaze(level);
        game.setState(new GameState(maze));
    }
}
