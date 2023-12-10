package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.elements.Wall;
import com.ld04gr02.berzerk.view.game.*;
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
        StickMan stickMan = new StickMan(20, 50, Direction.Right);
        StickManViewer stickManViewer = new StickManViewer();
        stickManViewer.display(stickMan, guiMock);
        verify(guiMock).drawSprite(stickMan.getPosition(), Sprites.getStickManRight(), '#', "#00ff00");
    }

    @Test
    public void stickManMovingDisplayTest() {
        StickMan stickMan = new StickMan(20, 50, Direction.Right);
        stickMan.setCollided(true);
        stickMan.changeMoving();
        StickManViewer stickManViewer = new StickManViewer();
        stickManViewer.display(stickMan, guiMock);
        verify(guiMock).drawSprite(stickMan.getPosition(), Sprites.getStickManMovingRight(), '#', "#0000ff");
        stickMan.setDirection(Direction.Left);
        stickMan.setCollided(false);
        stickManViewer.display(stickMan, guiMock);
        verify(guiMock).drawSprite(stickMan.getPosition(), Sprites.getStickManMovingLeft(), '#', "#00ff00");
    }

    @Test
    public void wallDisplayTest() {
        Wall wall = new Wall(60, 100, true);
        WallViewer wallViewer = new WallViewer();
        wallViewer.display(wall, guiMock);
        verify(guiMock).drawWall(wall.getPosition(), "#0000ff");
    }

    @Test
    public void robotDisplayTest() {
        Robot robot = new Robot(100, 150, Direction.Right);
        RobotViewer robotViewer = new RobotViewer();
        robotViewer.display(robot, guiMock);
        verify(guiMock).drawSprite(robot.getPosition(), Sprites.getRobot(), '#', "#ff0000");
    }

    @Test
    public void bulletDisplay() {
        Bullet bullet1 = new Bullet(50, 50, Direction.Right);
        Bullet bullet2 = new Bullet(100, 100, Direction.Down);
        BulletViewer bulletViewer = new BulletViewer();
        bulletViewer.display(bullet1, guiMock);
        verify(guiMock).drawSprite(bullet1.getPosition(), Sprites.getHorizontalBullet(), '#', "#ffffff");
        bulletViewer.display(bullet2, guiMock);
        verify(guiMock).drawSprite(bullet2.getPosition(), Sprites.getVerticalBullet(), '#', "#ffffff");
    }
}

