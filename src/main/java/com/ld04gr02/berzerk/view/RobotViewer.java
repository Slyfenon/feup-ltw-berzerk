package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Robot;

public class RobotViewer implements ElementViewer<Robot> {
    @Override
    public void display(Robot robot, GUI gui) {
        gui.drawRobot(robot.getPosition());
    }
}
