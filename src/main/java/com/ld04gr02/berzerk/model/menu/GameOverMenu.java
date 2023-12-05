package com.ld04gr02.berzerk.model.menu;

import java.util.ArrayList;
import java.util.List;

public class GameOverMenu implements Menu {
    private final List<MenuOptions> options = new ArrayList<>();
    private int currentOption = 0;

    private int stickManScore;

    private String name = "";

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
        return Integer.toString(stickManScore);
    }

    public void setStickManScore(int stickManScore) {
        this.stickManScore = stickManScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
