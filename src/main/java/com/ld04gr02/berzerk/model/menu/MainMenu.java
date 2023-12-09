package com.ld04gr02.berzerk.model.menu;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {
    public MainMenu() {
        super();
        options.add(MenuOptions.PLAY);
        options.add(MenuOptions.LEADERBOARD);
        options.add(MenuOptions.INSTRUCTIONS);
        options.add(MenuOptions.QUIT);
    }
}
