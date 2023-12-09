package com.ld04gr02.berzerk.model.menu;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<MenuOptions> options;
    private int currentOption = 0;

    public Menu() {
        options = new ArrayList<>();
    }

    public void selectNext() {
        currentOption++;
        if(currentOption > options.size()-1){
            currentOption=0;
        }
    }

    public void selectPrev() {
        currentOption--;
        if(currentOption < 0){
            currentOption = options.size()-1;
        }
    }

    public MenuOptions getSelected() {
        return options.get(currentOption);
    }

    public boolean isSelected(int i) {
        return options.get(i) == getSelected();
    }

    public List<MenuOptions> getOptions() {
        return options;
    }

    public String getString(int i){
        return options.get(i).convertString();
    }
}
