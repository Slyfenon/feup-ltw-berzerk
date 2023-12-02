package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.MovingElement;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.Wall;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.io.IOException;
import java.util.List;

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
        if (this.getModel().getStickMan().isCollided()) {
            this.getModel().getStickMan().decreaseLives();
            this.getModel().getStickMan().setPosition(new Position(30, 150));
            this.getModel().getStickMan().setCollided(false);
            return true;
        }

        switch (key) {
            case ARROW_UP :
                moveStickManUp();
                if (collideStickMan(this.getModel().getStickMan().getPosition())) {
                    this.getModel().getStickMan().setCollided(true);
                    return false;
                }
                break;
            case ARROW_DOWN :
                moveStickManDown();
                if (collideStickMan(this.getModel().getStickMan().getPosition())) {
                    this.getModel().getStickMan().setCollided(true);
                    return false;
                }
                break;
            case ARROW_LEFT :
                moveStickManLeft();
                if (collideStickMan(this.getModel().getStickMan().getPosition())) {
                    this.getModel().getStickMan().setCollided(true);
                    return false;
                }
                break;
            case ARROW_RIGHT :
                moveStickManRight();
                if (collideStickMan(this.getModel().getStickMan().getPosition())) {
                    this.getModel().getStickMan().setCollided(true);
                    return false;
                }
                break;
            case SPACE:
                break;
            default:
                break;
        }
        return true;
    }

    public boolean collideStickMan(Position positionStickMan) {
        List<Robot> robots = this.getModel().getRobots();
        for (Robot robot : robots) {
            Position positionRobot = robot.getPosition();
            if ((positionStickMan.getX() < (positionRobot.getX() + 13)) && ((positionStickMan.getX()) + 4 > positionRobot.getX()) && (positionStickMan.getY() < (positionRobot.getY() + 13)) && ((positionStickMan.getY() + 18) > positionRobot.getY())) return true;
        }

        List<Wall> walls = this.getModel().getWalls();
        for (Wall wall : walls) {
            Position positionWall = wall.getPosition();
            if ((positionWall.getX() >= positionStickMan.getX()) && (positionWall.getX() < positionStickMan.getX() + 4) && (positionWall.getY() >= positionStickMan.getY()) && (positionWall.getY() < positionStickMan.getY() + 18)) return true;
        }

        return false;
    }

}
