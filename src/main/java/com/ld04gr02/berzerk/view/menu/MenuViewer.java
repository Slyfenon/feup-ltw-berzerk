package com.ld04gr02.berzerk.view.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.gui.LanternaGUI;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.model.menu.Menu;
import com.ld04gr02.berzerk.view.Viewer;
import com.sun.tools.javac.Main;

public class MenuViewer extends Viewer<MainMenu> {

    public MenuViewer(MainMenu model) {
        super(model);
    }

    @Override
    protected void renderElements(GUI gui) {
        gui.drawMainMenu(getModel());
    }
}
