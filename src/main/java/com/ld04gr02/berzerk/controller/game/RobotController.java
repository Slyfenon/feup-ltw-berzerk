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
        ArrayList<Robot> auxRobots = new ArrayList<Robot>(getModel().getRobots());
        for (Robot robot : auxRobots) {
            if (robot.isCollided()) {
                getModel().getRobots().remove(robot);
            }
        }


        if (time - lastAction > 1000) {
            Position stickManPosition = getModel().getStickMan().getPosition();

            for(Robot robot: getModel().getRobots()) {
                while (true) {
                    Position newPosition = robot.getPosition().getRandomNeighbour();
                    if (closer(stickManPosition, robot.getPosition(), newPosition)) {
                        moveRobot(robot, newPosition);
                        break;
                    }
                }

                collisionTest(robot, auxRobots);
            }
            this.lastAction = time;
        }
    }

    private void moveRobot(Robot robot, Position position) {
        if (!getModel().collideWall(position, getRobotWidth(), getRobotHeight())) {
            robot.setPosition(position);
            if (getModel().collideStickMan(position, getRobotWidth(), getRobotHeight())) {
                getModel().getStickMan().setCollided(true);
            }
        }
    }

    private boolean closer(Position stickManPosition, Position currentPosition, Position newPosition) {
        return (abs(stickManPosition.getX()-newPosition.getX()) < abs(stickManPosition.getX()-currentPosition.getX()) || abs(stickManPosition.getY()-newPosition.getY()) < abs(stickManPosition.getY()-currentPosition.getY()));
    }

    private void collisionTest(Robot robot, ArrayList<Robot> robots) {
        if (robot.isCollided()) return;
        robots.remove(robot);

        if (getModel().collideStickMan(robot.getPosition(), getRobotWidth(), getRobotHeight())) {
            robot.setCollided(true);
        }

        else if (getModel().collideRobot(robot.getPosition(), getRobotWidth(), getRobotHeight())) {
            robot.setCollided(true);
        }

        else if (getModel().collideEvilSmile(robot.getPosition(), getRobotWidth(), getRobotHeight())) {
            robot.setCollided(true);
            getModel().getEvilSmile().setCollided(false);
        }

        robots.add(robot);
    }
}
