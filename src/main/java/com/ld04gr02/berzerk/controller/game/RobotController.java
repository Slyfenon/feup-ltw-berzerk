package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static com.ld04gr02.berzerk.view.game.Sprites.*;
import static java.lang.Math.abs;

public class RobotController extends GameController {
    private long lastAction;
    private long lastShot;
    Sound shock = new Sound();
    public RobotController(Maze maze) {
        super(maze);
        this.lastAction = 0;
        this.lastShot = System.currentTimeMillis();;
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        ArrayList<Robot> auxRobots = new ArrayList<Robot>(getModel().getRobots());
        for (Robot robot : auxRobots) {
            if (robot.isCollided()) {
                getModel().getRobots().remove(robot);
                getModel().getStickMan().increaseScore();
            }
        }

        if (time - lastAction > 250) {
            Position stickManPosition = getModel().getStickMan().getPosition();
            boolean canShoot = time - lastShot > 2000;

            for(Robot robot: getModel().getRobots()) {
                int side =  (int) (Math.random() * 2);
                Position nextPosition = getNextPosition(robot, side, stickManPosition);
                if (closer(stickManPosition, robot.getPosition(), nextPosition)) {
                    moveRobot(robot, nextPosition);
                    if (canShoot) {
                        Position tempPosition = getNewBulletPosition(robot);
                        getModel().getBullets().add(new Bullet(tempPosition.getX(), tempPosition.getY(), robot.getCurrentDirection()));
                    }
                }

                if (collideRobot(robot.getPosition())) {
                    robot.setCollided(true);
                }
            }
            this.lastAction = time;
            if (canShoot) this.lastShot = time;
        }
    }

    private Position getNextPosition(Robot robot, int side, Position stickManPosition) {
        Position newPosition;
        int difference;
        if (side == 0) {
            difference = stickManPosition.getX() - robot.getPosition().getX() > 0 ? 1 : -1;
            newPosition = new Position(robot.getPosition().getX() + difference * 5, robot.getPosition().getY());
            if (difference == 1) robot.setDirection(Direction.Right);
            else robot.setDirection(Direction.Left);
        }
        else {
            difference = stickManPosition.getY() - robot.getPosition().getY() > 0 ? 1 : -1;
            newPosition = new Position(robot.getPosition().getX(), robot.getPosition().getY() + difference * 5);
            if (difference == 1) robot.setDirection(Direction.Down);
            else robot.setDirection(Direction.Up);
        }
        return newPosition;
    }

    private void moveRobot(Robot robot, Position position) {
        if (!getModel().collideWall(position, getRobotWidth(), getRobotHeight())) {
            robot.setPosition(position);
            if (getModel().collideStickMan(position, getRobotWidth(), getRobotHeight())) {
                shock.playShockSound();
                getModel().getStickMan().setCollided(true);
            }
        }
    }

    private boolean closer(Position stickManPosition, Position currentPosition, Position newPosition) {
        return (abs(stickManPosition.getX()-newPosition.getX()) < abs(stickManPosition.getX()-currentPosition.getX()) || abs(stickManPosition.getY()-newPosition.getY()) < abs(stickManPosition.getY()-currentPosition.getY()));
    }

    private boolean collideRobot(Position positionRobot) {
        return getModel().collideStickMan(positionRobot, getRobotWidth(), getRobotHeight())
                || getModel().collideRobot(positionRobot, getRobotWidth(), getRobotHeight())
                || getModel().collideEvilSmile(positionRobot, getRobotWidth(), getRobotHeight(), false)
                || getModel().collideBullet(positionRobot, getRobotWidth(), getRobotHeight());
    }

    public Position getNewBulletPosition(Robot robot) {
        switch(robot.getCurrentDirection()) {
            case Up :
                return new Position(robot.getPosition().getX() + getRobotWidth() / 2, robot.getPosition().getY() - getBulletLong() - 1);
            case Down :
                return new Position(robot.getPosition().getX() + getRobotWidth() / 2, robot.getPosition().getY() + getRobotHeight() + 1);
            case Left :
                return new Position(robot.getPosition().getX() - getBulletLong() - 1, robot.getPosition().getY() + getRobotHeight() / 2);
            case Right :
                return new Position(robot.getPosition().getX() + getRobotWidth() + 1, robot.getPosition().getY() + getRobotHeight() / 2);
            default:
                return null;
        }
    }
}
