package com.ld04gr02.berzerk.view.game.info;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.StickMan;

public class ScoreInfoViewer implements InfoViewer {

    @Override
    public void display(GUI gui) {
        gui.drawScore();
        gui.drawNumbers(StickMan.getScore());
    }
}
