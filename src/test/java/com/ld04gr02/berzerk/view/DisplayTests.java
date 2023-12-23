package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.elements.Wall;
import com.ld04gr02.berzerk.view.game.*;
import com.ld04gr02.berzerk.view.game.info.LevelInfoViewer;
import com.ld04gr02.berzerk.view.game.info.LivesInfoViewer;
import com.ld04gr02.berzerk.view.game.info.ScoreInfoViewer;
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
        verify(guiMock).drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManRight(), '#', "#00ff00");
    }

    @Test
    public void stickManMovingDisplayTest() {
        StickMan stickMan = new StickMan(20, 50, Direction.Right);

        stickMan.setMoving(true);
        stickMan.setCollided(true);
        StickManViewer stickManViewer = new StickManViewer();
        stickManViewer.display(stickMan, guiMock);
        verify(guiMock).drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManMovingRight(), '#', "#0000ff");
        stickMan.setDirection(Direction.Left);
        stickManViewer.display(stickMan, guiMock);
        verify(guiMock).drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManMovingLeft(), '#', "#0000ff");

        stickMan.setMoving(false);
        stickMan.setCollided(false);

        stickMan.setShooting(true);
        stickMan.setDirection(Direction.Up);
        stickManViewer.display(stickMan, guiMock);
        verify(guiMock).drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManShootingUp(), '#', "#00ff00");
        assertFalse(stickMan.isShooting());

        stickMan.setShooting(true);
        stickMan.setDirection(Direction.Down);
        stickManViewer.display(stickMan, guiMock);
        verify(guiMock).drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManShootingDown(), '#', "#00ff00");
        assertFalse(stickMan.isShooting());

        stickMan.setShooting(true);
        stickMan.setDirection(Direction.Left);
        stickManViewer.display(stickMan, guiMock);
        verify(guiMock).drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManShootingLeft(), '#', "#00ff00");
        assertFalse(stickMan.isShooting());

        stickMan.setShooting(true);
        stickMan.setDirection(Direction.Right);
        stickManViewer.display(stickMan, guiMock);
        verify(guiMock).drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManShootingRight(), '#', "#00ff00");
        assertFalse(stickMan.isShooting());
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
        verify(guiMock).drawSprite(robot.getPosition().getX(), robot.getPosition().getY(), Sprites.getRobot(), '#', "#ff0000");
    }

    @Test
    public void bulletDisplay() {
        Bullet bullet1 = new Bullet(50, 50, Direction.Right);
        Bullet bullet2 = new Bullet(100, 100, Direction.Down);
        BulletViewer bulletViewer = new BulletViewer();
        bulletViewer.display(bullet1, guiMock);
        verify(guiMock).drawSprite(bullet1.getPosition().getX(), bullet1.getPosition().getY(), Sprites.getHorizontalBullet(), '#', "#ffffff");
        bulletViewer.display(bullet2, guiMock);
        verify(guiMock).drawSprite(bullet2.getPosition().getX(), bullet2.getPosition().getY(), Sprites.getVerticalBullet(), '#', "#ffffff");
    }

    @Test
    public void levelInfoViewer() {
        LevelInfoViewer levelInfoViewer = new LevelInfoViewer();
        levelInfoViewer.display(guiMock);
        verify(guiMock).drawSprite(30,315, Sprites.getLEVEL(), '#', "#ffffff");
        verify(guiMock).drawSprite(80, 315, Sprites.getNumber(Game.getLevel()), '#', "#ffffff");
    }

    @Test
    public void livesInfoViewer() {
        LivesInfoViewer livesInfoViewer = new LivesInfoViewer();
        livesInfoViewer.display(guiMock);
        verify(guiMock).drawSprite(310,315, Sprites.getHeart(), '#', "#ff0000");
        verify(guiMock).drawSprite(406,315, Sprites.getHeart(), '#', "#221111");
    }

    @Test
    public void scoreInfoViewer() {
        ScoreInfoViewer scoreInfoViewer = new ScoreInfoViewer();
        StickMan.setScore(1234);
        scoreInfoViewer.display(guiMock);
        verify(guiMock).drawSprite(135,315, Sprites.getScore(), '#', "#ffffff");
        verify(guiMock).drawSprite(215,315, Sprites.getNumber(1), '#', "#ffffff");
        verify(guiMock).drawSprite(229,315, Sprites.getNumber(2), '#', "#ffffff");
        verify(guiMock).drawSprite(243,315, Sprites.getNumber(3), '#', "#ffffff");
        verify(guiMock).drawSprite(257,315, Sprites.getNumber(4), '#', "#ffffff");
        StickMan.setScore(0);
    }
}

