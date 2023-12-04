package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static com.ld04gr02.berzerk.view.Sprites.getRobotHeight;
import static com.ld04gr02.berzerk.view.Sprites.getRobotWidth;
import static java.lang.Math.abs;

public class RobotController extends GameController {
    private long lastAction;

    public RobotController(Maze maze) {
        super(maze);
        this.lastAction = 0;
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        if (time - lastAction > 1000) {
            Position stickManPosition = getModel().getStickMan().getPosition();
            ArrayList<Robot> newRobots = new ArrayList<Robot>(getModel().getRobots());
            for (Robot robot : getModel().getRobots()) {
                if (robot.isCollided()) {
                    newRobots.remove(robot);
                    continue;
                }

                while (true) {
                    Position newPosition = robot.getPosition().getRandomNeighbour();
                    if (closer(stickManPosition, robot.getPosition(), newPosition)) {
                        moveRobot(robot, newPosition);
                        break;
                    }
                }
                collisionTest(robot, newRobots);
            }
            getModel().setRobots(newRobots);
            this.lastAction = time;
        }
    }

    private void moveRobot(Robot robot, Position position) {
        if (!getModel().collideWall(position, getRobotWidth(), getRobotHeight())) {
            robot.setPosition(position);
            if (getModel().collideStickMan(position, getRobotWidth(), getRobotHeight()))
                getModel().getStickMan().decreaseLives();
        }
    }

    private boolean closer(Position stickManPosition, Position currentPosition, Position newPosition) {
        return (abs(stickManPosition.getX()-newPosition.getX()) < abs(stickManPosition.getX()-currentPosition.getX()) || abs(stickManPosition.getY()-newPosition.getY()) < abs(stickManPosition.getY()-currentPosition.getY()));
    }

    private void collisionTest(Robot robot, ArrayList<Robot> robots) {
        robots.remove(robot);

        if (getModel().collideWall(robot.getPosition(), getRobotWidth(), getRobotHeight()) || getModel().collideRobot(robot.getPosition(), getRobotWidth(), getRobotHeight()))
            robot.setCollided(true);

        robots.add(robot);
    }
}
