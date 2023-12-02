package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.io.IOException;

public class MazeController extends GameController {
    private final StickManController stickManController;

    public MazeController(Maze maze) {
        super(maze);

        this.stickManController = new StickManController(maze);
    }

    @Override
    public boolean update(Game game, GUI.KEY key, long time) throws IOException {
        return stickManController.update(game, key, time);
    }

}
