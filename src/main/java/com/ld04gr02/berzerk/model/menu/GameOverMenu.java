package com.ld04gr02.berzerk.model.menu;

import com.ld04gr02.berzerk.model.game.elements.StickMan;

import java.util.ArrayList;
import java.util.List;

public class GameOverMenu implements Menu {
    private final List<MenuOptions> options = new ArrayList<>();


    private StringBuilder name = new StringBuilder();

    public GameOverMenu(){
        options.add(MenuOptions.QUIT);
        options.add(MenuOptions.PLAY);
    }
    @Override
    public void selectNext() {

    }

    @Override
    public void selectPrev() {
    }

    @Override
    public MenuOptions getSelected() {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    public String getStickManScore() {
        return Integer.toString(StickMan.getScore());
    }


    public StringBuilder getName() {
        return name;
    }

    public void setName(String name) {
        this.name = new StringBuilder(name);
    }
}
