package com.ld04gr02.berzerk.model.menu;

public enum MenuOptions{
    PLAY("Play"),
    LEADERBOARD("Leaderboard"),
    INSTRUCTIONS("Instructions"),
    RESUME("Resume"),
    QUIT("Quit");
    private final String option;
    MenuOptions(String option) {
        this.option = option;
    }
    String convertString(){
        return option;
    }
}