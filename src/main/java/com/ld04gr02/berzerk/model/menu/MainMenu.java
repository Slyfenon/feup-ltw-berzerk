package com.ld04gr02.berzerk.model.menu;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu{

    public enum Options{
        PLAY("Play"),
        QUIT("Quit"),
        LEADERBOARD("Leaderboard"),
        INSTRUCTIONS("Instructions");

        private final String option;
        Options(String option) {
            this.option = option;
        }
        String convertString(){
            return option;
        }
    };


    private List<Options> options = new ArrayList<>();
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
    public String getString(int i){
        return options.get(i).convertString();
    }
    @Override
    public Options getSelected() {
        return options.get(currentOption);
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    public int getCurrentOption() {
        return currentOption;
    }

    public List<Options> getOptions() {
        return options;
    }
}
