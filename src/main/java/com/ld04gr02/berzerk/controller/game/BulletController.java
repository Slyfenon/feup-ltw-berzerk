package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static com.ld04gr02.berzerk.view.Sprites.*;

public class BulletController extends GameController{

    public BulletController(Maze maze) {
        super(maze);
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        ArrayList<Bullet> temp = new ArrayList<>(getModel().getBullets());
        for (Bullet bullet : temp)
            moveBullet(bullet);
    }

    public void moveBullet(Bullet bullet) {
        Position nextPosition = bullet.getPosition();
        switch (bullet.getCurrentDirection()) {
            case Up:
                nextPosition.setY(nextPosition.getY() - 10);
                if (getModel().collideWall(nextPosition, getBulletWidth(), 10)) {
                    getModel().getBullets().remove(bullet);
                }
                break;
            case Down:
                nextPosition.setY(nextPosition.getY() + 10);
                if (getModel().collideWall(new Position(bullet.getPosition().getX(), bullet.getPosition().getY()+getBulletHeight()), getBulletWidth(), 10)) {
                    getModel().getBullets().remove(bullet);
                }
                break;
            case Left:
                nextPosition.setX(nextPosition.getX() - 10);
                if (getModel().collideWall(nextPosition, getBulletWidth(), getBulletHeight())) {
                    getModel().getBullets().remove(bullet);
                }
                break;
            case Right:
                nextPosition.setX(nextPosition.getX() + 10);
                if (getModel().collideWall(nextPosition, getBulletWidth(), getBulletHeight())) {
                    getModel().getBullets().remove(bullet);
                }
                break;
            default:
                break;
        }
        bullet.setPosition(nextPosition);
    }
}
