package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;

public class StickManViewer implements ElementViewer<StickMan> {
    @Override
    public void display(StickMan stickMan, GUI gui) {
        gui.drawStickMan(stickMan.getPosition(), stickMan.isCollided());
    }
}
