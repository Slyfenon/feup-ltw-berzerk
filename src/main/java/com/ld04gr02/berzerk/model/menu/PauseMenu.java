package com.ld04gr02.berzerk.model.menu;

import java.util.ArrayList;
import java.util.List;

public class PauseMenu extends Menu {

    public PauseMenu() {
        super();
        options.add(MenuOptions.RESUME);
        options.add(MenuOptions.QUIT);
    }
}
