package com.ld04gr02.berzerk.view.game;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.Wall;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.view.game.info.InfoViewer;
import com.ld04gr02.berzerk.view.game.info.LevelInfoViewer;
import com.ld04gr02.berzerk.view.game.info.LivesInfoViewer;
import com.ld04gr02.berzerk.view.game.info.ScoreInfoViewer;

public class GameViewer extends Viewer<Maze> {
    private boolean isPaused = false;
    private final BulletViewer bulletViewer;
    private final StickManViewer stickManViewer;
    private final WallViewer wallViewer;
    private final RobotViewer robotViewer;
    private final EvilSmileViewer evilSmileViewer;
    private final ScoreInfoViewer scoreInfoViewer;
    private final LivesInfoViewer livesInfoViewer;

    private final LevelInfoViewer levelInfoViewer;


    public GameViewer(Maze maze) {
        super(maze);
        bulletViewer = new BulletViewer();
        stickManViewer = new StickManViewer();
        wallViewer = new WallViewer();
        robotViewer = new RobotViewer();
        evilSmileViewer = new EvilSmileViewer();
        scoreInfoViewer = new ScoreInfoViewer();
        livesInfoViewer = new LivesInfoViewer();
        levelInfoViewer = new LevelInfoViewer();
    }
    @Override
    protected void renderElements(GUI gui) {
        gui.drawFrame(getModel().getWidth(), getModel().getHeight());


        for(Bullet bullet: getModel().getBullets()) bulletViewer.display(bullet, gui);


        stickManViewer.display(getModel().getStickMan(), gui);



        for (Wall wall : getModel().getWalls()) wallViewer.display(wall, gui);
        for (Wall gate : getModel().getGates()) wallViewer.display(gate, gui);


        for (Robot robot : getModel().getRobots()) robotViewer.display(robot, gui);


        evilSmileViewer.display(getModel().getEvilSmile(), gui);
        scoreInfoViewer.display(gui);
        livesInfoViewer.display(gui);
        levelInfoViewer.display(gui);
    }
}
