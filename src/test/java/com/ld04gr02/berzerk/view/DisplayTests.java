package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.elements.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayTests extends Assertions {
    private GUI guiMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
    }

    @Test
    public void stickManDisplayTest() {
        StickMan stickMan = new StickMan(20, 50);
        StickManViewer stickManViewer = new StickManViewer();
        stickManViewer.display(stickMan, guiMock);
        verify(guiMock).drawStickMan(stickMan.getPosition(), false);
    }

    @Test
    public void wallDisplayTest() {
        Wall wall = new Wall(60, 100);
        WallViewer wallViewer = new WallViewer();
        wallViewer.display(wall, guiMock);
        verify(guiMock).drawWall(wall.getPosition());
    }

    @Test
    public void robotDisplayTest() {
        Robot robot = new Robot(100, 150);
        RobotViewer robotViewer = new RobotViewer();
        robotViewer.display(robot, guiMock);
        verify(guiMock).drawRobot(robot.getPosition());
    }
}
