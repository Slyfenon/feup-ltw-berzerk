package com.ld04gr02.berzerk.model.menu;


public class PauseMenu extends Menu {

    public PauseMenu() {
        super();
        options.add(MenuOptions.RESUME);
        options.add(MenuOptions.RESTART);
        options.add(MenuOptions.QUIT);
    }
}