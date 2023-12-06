package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.EvilSmile;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.view.game.Sprites.*;
import static java.lang.Math.abs;

public class EvilSmileController extends GameController{
    private long lastAction;
    private long timePause = 1200;

    Sound shock = new Sound();

    public EvilSmileController(Maze maze) {
        super(maze);
        this.lastAction = 0;
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        if (getModel().getEvilSmile().isCollided()) {
            getModel().getEvilSmile().setCollided(false);
            getModel().getEvilSmile().setPosition(new Position(-20, getModel().getHeight() / 2));
            timePause = 1200;
        }
        if (time - lastAction > timePause) {
            Position stickManPosition = getModel().getStickMan().getPosition();
            while (true) {
                Position newPosition = getModel().getEvilSmile().getPosition().getRandomNeighbour();
                if (closer(stickManPosition, getModel().getEvilSmile().getPosition(), newPosition)) {
                    moveEvilSmile(getModel().getEvilSmile(), newPosition);
                    break;
                }
            }

            if (getModel().collideStickMan(getModel().getEvilSmile().getPosition(), getEvilSmileWidth(), getEvilSmileHeight())) getModel().getEvilSmile().setCollided(true);
            getModel().collideRobot(getModel().getEvilSmile().getPosition(), getEvilSmileWidth(), getEvilSmileHeight());

            this.lastAction = time;
            if (timePause > 100) timePause -= 50;
        }
    }

    private void moveEvilSmile(EvilSmile evilSmile, Position position) {
        evilSmile.setPosition(position);
        if (getModel().collideStickMan(position, getEvilSmileWidth(), getEvilSmileHeight())) {
            shock.playShockSound();
            getModel().getStickMan().setCollided(true);
        }
    }

    private boolean closer(Position stickManPosition, Position currentPosition, Position newPosition) {
        return (abs(stickManPosition.getX()-newPosition.getX()) < abs(stickManPosition.getX()-currentPosition.getX()) || abs(stickManPosition.getY()-newPosition.getY()) < abs(stickManPosition.getY()-currentPosition.getY()));
    }
}
