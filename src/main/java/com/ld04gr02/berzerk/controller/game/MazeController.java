package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MazeController extends GameController {
    private final StickManController stickManController;
    private final RobotController robotController;
    private final BulletController bulletController;

    public MazeController(Maze maze) {
        super(maze);

        this.stickManController = new StickManController(maze);
        this.robotController = new RobotController(maze);
        this.bulletController = new BulletController(maze);
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        bulletController.update(game, key, time);
        stickManController.update(game, key, time);
        robotController.update(game, key, time);
    }

}
