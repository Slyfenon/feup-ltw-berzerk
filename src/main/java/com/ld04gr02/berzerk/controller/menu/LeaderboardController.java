package com.ld04gr02.berzerk.controller.menu;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.Soundboard;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.Leaderboard;
import com.ld04gr02.berzerk.model.menu.MainMenu;
import com.ld04gr02.berzerk.state.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class LeaderboardController extends Controller<Leaderboard> {
    public LeaderboardController(Leaderboard model) {
        super(model);
    }

    @Override
    public void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException {
        switch(key) {
            case ESC:
                Soundboard.getInstance().getClick().playSound(0);
                MainMenuState mainMenuState = new MainMenuState(new MainMenu());
                game.setState(mainMenuState);
                break;
            default:
                break;
        }
    }
}
