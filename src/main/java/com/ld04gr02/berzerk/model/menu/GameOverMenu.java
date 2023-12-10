package com.ld04gr02.berzerk.model.menu;

public class GameOverMenu extends Menu {
    private final StringBuilder name;

    public GameOverMenu(){
        name = new StringBuilder();
    }

    public StringBuilder getName() {
        return name;
    }
}