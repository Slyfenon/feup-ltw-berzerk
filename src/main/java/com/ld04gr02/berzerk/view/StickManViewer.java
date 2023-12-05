package com.ld04gr02.berzerk.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;

public class StickManViewer implements ElementViewer<StickMan> {

    TextGraphics textGraphics;
    @Override
    public void display(StickMan stickMan, GUI gui) {
        String color = !stickMan.isCollided() ? "#00ff00" : "#0000ff";
        if(stickMan.isMoving()) {
            switch (stickMan.getCurrentDirection()) {
                case Left:
                    gui.drawSprite(stickMan.getPosition(), Sprites.getStickManMovingLeft(), '#', color);
                    break;
                case Up: case Down: case Right:
                    gui.drawSprite(stickMan.getPosition(), Sprites.getStickManMovingRight(), '#', color);
                    break;
                case None:
                    break;
            }
        }
        else if(stickMan.isShooting()) {
            switch(stickMan.getCurrentDirection()) {
                case Up:
                    gui.drawSprite(stickMan.getPosition(), Sprites.getStickManShootingUp(), '#', color);
                    break;
                case Down:
                    gui.drawSprite(stickMan.getPosition(), Sprites.getStickManShootingDown(), '#', color);
                    break;
                case Left:
                    gui.drawSprite(stickMan.getPosition(), Sprites.getStickManShootingLeft(), '#', color);
                    break;
                case Right:
                    gui.drawSprite(stickMan.getPosition(), Sprites.getStickManShootingRight(), '#', color);
                    break;
                case None:
                    break;
            }
        }
        else
        {
            gui.drawSprite(stickMan.getPosition(), Sprites.getStickManRight(), '#', color);
        }
    }
}
