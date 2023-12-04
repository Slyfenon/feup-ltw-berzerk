package com.ld04gr02.berzerk.model.game.maze;

import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.EvilSmile;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.elements.Wall;

import java.util.List;

import static com.ld04gr02.berzerk.view.Sprites.*;

public class Maze {
    private final int width;
    private final int height;
    private StickMan stickMan;
    private List<Robot> robots;
    private List<Wall> walls;
    private EvilSmile evilSmile;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public StickMan getStickMan() {
        return stickMan;
    }
    public void setStickMan(StickMan stickMan) {
        this.stickMan = stickMan;
    }
    public List<Robot> getRobots() {
        return robots;
    }
    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }
    public List<Wall> getWalls() {
        return walls;
    }
    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }
    public EvilSmile getEvilSmile() {return evilSmile;}
    public void setEvilSmile(EvilSmile evilSmile) {this.evilSmile = evilSmile;}

    public boolean collideWall(Position position, int elementWidth, int elementHeight) {
        for (Wall wall : getWalls()) {
            Position positionWall = wall.getPosition();
            if ((positionWall.getX() >= position.getX())
                    && (positionWall.getX() < position.getX() + elementWidth)
                    && (positionWall.getY() >= position.getY())
                    && (positionWall.getY() < position.getY() + elementHeight))
                return true;
        }
        return false;
    }

    public boolean collideRobot(Position position, int elementWidth, int elementHeight) {
        for (Robot robot : getRobots()) {
            Position positionRobot = robot.getPosition();
            if ((position.getX() < (positionRobot.getX() + getRobotWidth()))
                    && (position.getX() + elementWidth > positionRobot.getX())
                    && (position.getY() < (positionRobot.getY() + getRobotHeight()))
                    && ((position.getY() + elementHeight) > positionRobot.getY()))
                return true;
        }
        return false;
    }

    public boolean collideStickMan(Position position, int elementWidth, int elementHeight) {
        if ((position.getX() < (stickMan.getPosition().getX() + getStickManWidth()))
                && (position.getX() + elementWidth > stickMan.getPosition().getX())
                && (position.getY() < (stickMan.getPosition().getY() + getStickManHeight()))
                && ((position.getY() + elementHeight) > stickMan.getPosition().getY()))
            return true;
        return false;
    }

    public boolean collideEvilSmile(Position position, int elementWidth, int elementHeight) {
        if ((position.getX() < (evilSmile.getPosition().getX() + getEvilSmileWidth()))
                && (position.getX() + elementWidth > evilSmile.getPosition().getX())
                && (position.getY() < (evilSmile.getPosition().getY() + getEvilSmileHeight()))
                && ((position.getY() + elementHeight) > evilSmile.getPosition().getY()))
            return true;
        return false;
    }
}

