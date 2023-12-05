package com.ld04gr02.berzerk.controller.game;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Sound;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.Direction;
import com.ld04gr02.berzerk.model.Position;
import com.ld04gr02.berzerk.model.game.maze.Maze;
import com.ld04gr02.berzerk.model.menu.PauseMenu;
import com.ld04gr02.berzerk.state.PauseMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.ld04gr02.berzerk.Game.MENU_SCREEN_HEIGHT;
import static com.ld04gr02.berzerk.Game.MENU_SCREEN_WIDTH;
import static com.ld04gr02.berzerk.view.Sprites.*;

public class StickManController extends GameController {

    public StickManController(Maze maze) {
        super(maze);
    }

    Sound shock = new Sound();

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
            playShockSound();
            this.getModel().getStickMan().setCollided(true);
        }
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        if (this.getModel().getStickMan().isCollided()) {
            this.getModel().getStickMan().decreaseLives();
            this.getModel().getStickMan().setPosition(new Position(30, 150));
            this.getModel().getStickMan().setCollided(false);
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
                break;
            case ESC:
                game.getGui().close();
                game.setPreviousState(game.getState());
                game.setState(new PauseMenuState(new PauseMenu()));
                game.getState().initScreen(game.getGui(), MENU_SCREEN_WIDTH, MENU_SCREEN_HEIGHT);
                break;
            default:
                break;
        }
    }

    public boolean collideStickMan(Position positionStickMan) {
        return getModel().collideWall(positionStickMan, getStickManWidth(), getStickManHeight())
                || getModel().collideRobot(positionStickMan, getStickManWidth(), getStickManHeight());
    }

    private void playShockSound(){
        shock.setFile(3);
        shock.playSound(0);
    }

}
