package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.view.Sprites.getRobotHeight;
import static com.ld04gr02.berzerk.view.Sprites.getRobotWidth;

public class RobotController extends GameController {
    private long lastAction;
    
    public RobotController(Maze maze) {
        super(maze);
        this.lastAction = 0;
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        if (time - lastAction > 1000) {
            for (Robot robot : getModel().getRobots())
                moveRobot(robot, robot.getPosition().getRandomNeighbour());
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
}
