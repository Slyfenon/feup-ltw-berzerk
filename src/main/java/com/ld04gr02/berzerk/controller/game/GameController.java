package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.model.game.maze.Maze;

public abstract class GameController extends Controller<Maze> {
    Sound gameMusic = new Sound();
    public GameController(Maze maze) {
        super(maze);
    }
}
