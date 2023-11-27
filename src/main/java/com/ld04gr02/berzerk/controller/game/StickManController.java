package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.io.IOException;

public class StickManController extends GameController {

    public StickManController(Maze maze) {
        super(maze);
    }

    private void moveStickManUp() {
        move(getModel().getStickMan().getPosition().getUP());
    }

    private void moveStickManDown() {
        move(getModel().getStickMan().getPosition().getDown());
    }

    private void moveStickManLeft() {
        move(getModel().getStickMan().getPosition().getLeft());
    }

    private void moveStickManRight() {
        move(getModel().getStickMan().getPosition().getRight());
    }

    private void move(Position position) {
        getModel().getStickMan().setPosition(position);
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException {
        switch (key) {
            case ARROW_UP : moveStickManUp();
                break;
            case ARROW_DOWN : moveStickManDown();
                break;
            case ARROW_LEFT : moveStickManLeft();
                break;
            case ARROW_RIGHT : moveStickManRight();
                break;
            default:
                break;
        }
    }

}
