package com.ld04gr02.berzerk.view.menu;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.view.game.Viewer;

public class GameOverViewer extends Viewer<GameOverMenu> {
    public GameOverViewer(GameOverMenu model) {
        super(model);
    }

    @Override
    protected void renderElements(GUI gui) {
        gui.drawGameOverMenu(getModel());
    }
}
