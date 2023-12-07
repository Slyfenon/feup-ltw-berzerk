package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.Soundboard;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.elements.Bullet;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.menu.PauseMenu;
import com.ld04gr02.berzerk.state.PauseMenuState;
import com.ld04gr02.berzerk.view.game.Sprites;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static com.ld04gr02.berzerk.view.game.Sprites.*;

public class StickManController extends GameController {

    private long lastAction;
    public StickManController(Maze maze) {
        super(maze);
        this.lastAction = 0;
    }

    private void moveStickManUp() {
        move(getModel().getStickMan().getPosition().getUp(), Direction.Up);
    }

    private void moveStickManDown() {
        move(getModel().getStickMan().getPosition().getDown(), Direction.Down);
    }

    private void moveStickManLeft() {
        move(getModel().getStickMan().getPosition().getLeft(), Direction.Left);
    }

    private void moveStickManRight() {
        move(getModel().getStickMan().getPosition().getRight(), Direction.Right);
    }

    private void move(Position position, Direction direction) {
        getModel().getStickMan().setPosition(position);
        getModel().getStickMan().setDirection(direction);
        getModel().getStickMan().changeMoving();
        if (collideStickMan(this.getModel().getStickMan().getPosition())) {
            this.getModel().getStickMan().setCollided(true);
        }
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {

        if (this.getModel().getStickMan().isCollided()) {
            this.getModel().getStickMan().decreaseLives();
            this.getModel().getStickMan().setPosition(new Position(10, getModel().getHeight() / 2 - Sprites.getStickManHeight() / 2));
            this.getModel().getStickMan().setCollided(false);
            Soundboard.getInstance().getShock().playSound(0);
        }

        switch (key) {
            case ARROW_UP :
                moveStickManUp();
                break;
            case ARROW_DOWN :
                moveStickManDown();
                break;
            case ARROW_LEFT :
                moveStickManLeft();
                break;
            case ARROW_RIGHT :
                moveStickManRight();
                break;
            case SPACE:
                if (time - lastAction > 350) {
                    getModel().getStickMan().setShooting(true);
                    Position tempPosition = getNewBulletPosition();
                    getModel().getBullets().add(new Bullet(tempPosition.getX(), tempPosition.getY(), getModel().getStickMan().getCurrentDirection()));
                    lastAction = time;
                    Soundboard.getInstance().getBullet().playSound(0);
                }
                break;
            case ESC:
                game.getGui().close();
                game.setPreviousState(game.getState());
                game.setState(new PauseMenuState(new PauseMenu()));
                game.getState().initScreen(game.getGui(), MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
                break;
            default:
                this.getModel().getStickMan().setMoving(false);
                break;
        }
    }

    public Position getNewBulletPosition() {
        switch(getModel().getStickMan().getCurrentDirection()) {
            case Up :
                return new Position(getModel().getStickMan().getPosition().getX() + getStickManWidth() / 2, getModel().getStickMan().getPosition().getY() - getBulletLong() - 1);
            case Down :
                return new Position(getModel().getStickMan().getPosition().getX() + getStickManWidth() / 2, getModel().getStickMan().getPosition().getY() + getStickManHeight() + 1);
            case Left :
                return new Position(getModel().getStickMan().getPosition().getX() - getBulletLong() - 1, getModel().getStickMan().getPosition().getY() + getStickManHeight() / 2);
            case Right :
                return new Position(getModel().getStickMan().getPosition().getX() + getStickManWidth() + 1, getModel().getStickMan().getPosition().getY() + getStickManHeight() / 2);
            default:
                return null;
        }
    }

    public boolean collideStickMan(Position positionStickMan) {
        return getModel().collideWall(positionStickMan, getStickManWidth(), getStickManHeight())
                || getModel().collideRobot(positionStickMan, getStickManWidth(), getStickManHeight())
                || getModel().collideEvilSmile(positionStickMan, getStickManWidth(), getStickManHeight(), true)
                || getModel().collideBullet(positionStickMan, getStickManWidth(), getStickManHeight());
    }


}
