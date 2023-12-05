package com.ld04gr02.berzerk.model.menu;

import java.util.ArrayList;
import java.util.List;

public class PauseMenu implements Menu {
    private final List<MenuOptions> options = new ArrayList<>();
    private int currentOption = 0;

    public PauseMenu(){
        options.add(MenuOptions.RESUME);
        options.add(MenuOptions.QUIT);
    }
    @Override
    public void selectNext() {
        currentOption++;
        if(currentOption > options.size()-1){
            currentOption=0;
        }
    }

    @Override
    public void selectPrev() {
        currentOption--;
        if(currentOption < 0){
            currentOption = options.size()-1;
        }
    }
    public String getString(int i){
        return options.get(i).convertString();
    }
    @Override
    public MenuOptions getSelected() {
        return options.get(currentOption);
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    // public int getCurrentOption() {return currentOption;}

    public List<MenuOptions> getOptions() {
        return options;
    }
}
