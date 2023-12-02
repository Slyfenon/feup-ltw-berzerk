package com.ld04gr02.berzerk.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;

public class StickManViewer implements ElementViewer<StickMan> {

    TextGraphics textGraphics;
    @Override
    public void display(StickMan stickMan, GUI gui) {
        if(stickMan.isMoving()) {
            switch (stickMan.getCurrentDirection()) {
                case Left:
                    gui.drawStickMan(stickMan.getPosition(), Sprites.STICKMAN_MOVING_LEFT, stickMan.isCollided());
                    break;
                case Up: case Down: case Right:
                    gui.drawStickMan(stickMan.getPosition(), Sprites.STICKMAN_MOVING_RIGHT, stickMan.isCollided());
                    break;
            }
        }
        else
        {
            gui.drawStickMan(stickMan.getPosition(), Sprites.STICKMAN_RIGHT, stickMan.isCollided());
        }
    }
}
