package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.Wall;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.util.List;

public class GameViewer extends Viewer<Maze> {
    private boolean isPaused = false;

    public GameViewer(Maze maze) {
        super(maze);
    }
    @Override
    protected void renderElements(GUI gui) {

        StickManViewer stickManViewer = new StickManViewer();
        stickManViewer.display(getModel().getStickMan(), gui);
        gui.drawLives(getModel().getStickMan().getLives());
        gui.drawScore();
        gui.drawNumbers(getModel().getStickMan().getScore());

        WallViewer wallViewer = new WallViewer();
        for (Wall wall : getModel().getWalls()) wallViewer.display(wall, gui);

        RobotViewer robotViewer = new RobotViewer();
        for (Robot robot : getModel().getRobots()) robotViewer.display(robot, gui);

        BulletViewer bulletViewer = new BulletViewer();
        for(Bullet bullet: getModel().getBullets()) bulletViewer.display(bullet, gui);
    }
}
