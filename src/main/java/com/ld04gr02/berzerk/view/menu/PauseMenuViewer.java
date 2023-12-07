package com.ld04gr02.berzerk.view.menu;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.PauseMenu;
import com.ld04gr02.berzerk.view.game.Viewer;

public class PauseMenuViewer extends Viewer<PauseMenu> {

    public PauseMenuViewer(PauseMenu model) {
        super(model);
    }

    @Override
    protected void renderElements(GUI gui) {
        gui.drawPauseMenu(getModel());
    }
}


