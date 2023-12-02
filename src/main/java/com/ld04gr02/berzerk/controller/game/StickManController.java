package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.MovingElement;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.io.IOException;

public class StickManController extends GameController {

    public StickManController(Maze maze) {
        super(maze);
    }

    private void moveStickManUp() {
        move(getModel().getStickMan().getPosition().getUP(), Direction.Up);
    }

    private void moveStickManDown() {
        move(getModel().getStickMan().getPosition().getDown(), Direction.Down);
    }

    private void moveStickManLeft() {
        move(getModel().getStickMan().getPosition().getLeft(), Direction.Left);
    }

    private void moveStickManRight() {
        move(getModel().getStickMan().getPosition().getRight(), Direction.Right);
    }

    private void move(Position position, Direction direction) {
        getModel().getStickMan().setPosition(position);
        getModel().getStickMan().setDirection(direction);
        getModel().getStickMan().changeMoving();
    }

    @Override
    public boolean update(Game game, GUI.KEY key, long time) throws IOException {
        switch (key) {
            case ARROW_UP : moveStickManUp();
                break;
            case ARROW_DOWN : moveStickManDown();
                break;
            case ARROW_LEFT : moveStickManLeft();
                break;
            case ARROW_RIGHT : moveStickManRight();
                break;
            case SPACE:
                break;
            default:
                break;
        }
        return true;
    }

}
