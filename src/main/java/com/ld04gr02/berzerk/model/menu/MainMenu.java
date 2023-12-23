package com.ld04gr02.berzerk.model.menu;


public class MainMenu extends Menu {
    public MainMenu() {
        super();
        options.add(MenuOptions.PLAY);
        options.add(MenuOptions.LEADERBOARD);
        options.add(MenuOptions.INSTRUCTIONS);
        options.add(MenuOptions.QUIT);
    }
}