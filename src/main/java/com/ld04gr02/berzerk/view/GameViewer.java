package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.EvilSmile;
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

        List<Wall> walls = getModel().getWalls();
        WallViewer wallViewer = new WallViewer();
        for (Wall wall : walls) wallViewer.display(wall, gui);

        List<Robot> robots = getModel().getRobots();
        RobotViewer robotViewer = new RobotViewer();
        for (Robot robot : robots) robotViewer.display(robot, gui);

        EvilSmileViewer evilSmileViewer = new EvilSmileViewer();
        evilSmileViewer.display(getModel().getEvilSmile(), gui);
    }
}
