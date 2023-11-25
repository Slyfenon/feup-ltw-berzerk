package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.controller.MainMenuController;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.view.Viewer;
import com.ld04gr02.berzerk.view.menu.MenuViewer;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public Viewer getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller getController() {
        return null;
    }

    @Override
    public State nextState() {
        return null;
    }

    @Override
    public void initState() {

    }
}
