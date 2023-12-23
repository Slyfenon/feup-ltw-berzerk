package com.ld04gr02.berzerk.view.game;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;

public class StickManViewer implements ElementViewer<StickMan> {
<<<<<<< HEAD
=======

>>>>>>> 698252fa20d84dc47c28ecc01c901076ce73eb0a
    @Override
    public void display(StickMan stickMan, GUI gui) {
        String color = !stickMan.isCollided() ? "#00ff00" : "#0000ff";
        if(stickMan.isMoving()) {
            switch (stickMan.getCurrentDirection()) {
                case Left:
                    gui.drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManMovingLeft(), '#', color);
                    break;
                case Up: case Down: case Right:
                    gui.drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManMovingRight(), '#', color);
                    break;
                case None:
                    break;
            }
        }
        else if(stickMan.isShooting()) {
            stickMan.setShooting(false);
            switch(stickMan.getCurrentDirection()) {
                case Up:
                    gui.drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManShootingUp(), '#', color);
                    break;
                case Down:
                    gui.drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManShootingDown(), '#', color);
                    break;
                case Left:
                    gui.drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManShootingLeft(), '#', color);
                    break;
                case Right:
                    gui.drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManShootingRight(), '#', color);
                    break;
                case None:
                    break;
            }
        }
        else
        {
            gui.drawSprite(stickMan.getPosition().getX(), stickMan.getPosition().getY(), Sprites.getStickManRight(), '#', color);
        }
    }
}
