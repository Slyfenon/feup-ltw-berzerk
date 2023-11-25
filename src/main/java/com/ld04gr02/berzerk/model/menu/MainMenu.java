package com.ld04gr02.berzerk.model.menu;

import java.util.List;

public class MainMenu implements Menu{

    public enum Options{
        PLAY,
        QUIT,
        LEADERBOARD,
        INSTRUCTIONS;
    }

    private List<Options> options;
    private int currentOption = 0;

    public MainMenu(){
        options.add(Options.PLAY);
        options.add(Options.QUIT);
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

    @Override
    public Options getSelected() {
        return options.get(currentOption);
    }

    public int getCurrentOption() {
        return currentOption;
    }

    public List<Options> getOptions() {
        return options;
    }
}
