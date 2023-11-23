package com.ld04gr02.berzerk.model.game.maze;

import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.elements.Wall;

import java.util.List;

public class Maze {
    private final int width;
    private final int height;
    private StickMan stickMan;
    private List<Robot> robots;
    private List<Wall> walls;

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
}

