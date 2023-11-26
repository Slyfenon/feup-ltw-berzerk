package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.controller.Controller;
//import com.ld04gr02.berzerk.controller.MainMenuController;
import com.ld04gr02.berzerk.controller.menu.MainMenuController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.view.Viewer;
import com.ld04gr02.berzerk.view.menu.MenuViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public Viewer<MainMenu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }

    @Override
    public void initScreen(GUI gui, int width, int height) throws IOException, URISyntaxException, FontFormatException {
        gui.createMenuScreen(width,height);
    }

}
