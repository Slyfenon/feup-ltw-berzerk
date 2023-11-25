package com.ld04gr02.berzerk.controller;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.model.menu.MainMenu;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu>{
    public MainMenuController(MainMenuController model) {
        super(model.getModel());
    }

    @Override
    public void update(Game game, long time) throws IOException {

    }
}
