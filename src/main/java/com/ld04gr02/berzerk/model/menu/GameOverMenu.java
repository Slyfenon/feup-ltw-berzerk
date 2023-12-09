package com.ld04gr02.berzerk.model.menu;

import com.ld04gr02.berzerk.model.game.elements.StickMan;

import java.util.ArrayList;
import java.util.List;

public class GameOverMenu {
    private final StringBuilder name;

    public GameOverMenu(){
        name = new StringBuilder();
    }

    public StringBuilder getName() {
        return name;
    }
}