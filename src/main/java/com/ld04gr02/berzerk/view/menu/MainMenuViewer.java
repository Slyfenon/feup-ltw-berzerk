package com.ld04gr02.berzerk.view.menu;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.view.Viewer;

public class MainMenuViewer extends Viewer<MainMenu> {

    public MainMenuViewer(MainMenu model) {
        super(model);
    }

    @Override
    protected void renderElements(GUI gui) {
        gui.drawMainMenu(getModel());
    }
}
