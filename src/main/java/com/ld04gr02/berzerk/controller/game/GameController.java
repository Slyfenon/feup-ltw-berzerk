package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.io.IOException;

public abstract class GameController extends Controller<Maze> {
    public GameController(Maze maze) {
        super(maze);
    }
}
