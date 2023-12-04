package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.EvilSmile;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.view.Sprites.*;

public class EvilSmileController extends GameController{
    private long lastAction;
    private long timePause = 5000;
    public EvilSmileController(Maze maze) {
        super(maze);
        this.lastAction = 0;
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        if (time - lastAction > timePause) {
            moveEvilSmile(getModel().getEvilSmile(), getModel().getEvilSmile().getPosition().getRandomNeighbour());
            this.lastAction = time;
            if (timePause > 0) timePause -= 250;
        }
    }

    private void moveEvilSmile(EvilSmile evilSmile, Position position) {
        if (!getModel().collideWall(position, getEvilSmileWidth(), getEvilSmileHeight())) {
            evilSmile.setPosition(position);
            if (getModel().collideStickMan(position, getEvilSmileWidth(), getEvilSmileHeight()))
                getModel().getStickMan().decreaseLives();
        }
    }
}
