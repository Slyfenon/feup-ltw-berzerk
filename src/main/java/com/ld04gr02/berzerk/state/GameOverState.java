package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.controller.menu.GameOverController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.GameOverMenu;
import com.ld04gr02.berzerk.view.game.Viewer;
import com.ld04gr02.berzerk.view.menu.GameOverViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverState extends State<GameOverMenu> {
    public GameOverState(GameOverMenu model) {
        super(model);
    }

    @Override
    public Viewer<GameOverMenu> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverController(getModel());
    }

    @Override
    public void update(Game game, GUI gui, long time) throws IOException, URISyntaxException, FontFormatException {

        String str = game.getGui().getCharPressedKey();

        if("Escape".equals(str)) {
            this.controller.update(game, GUI.KEY.ESC, time);
        }
        else if("Enter".equals(str)) {
            this.controller.update(game, GUI.KEY.ENTER, time);
        }
        else if("Backspace".equals(str)){
            if(getModel().getName().length() > 0) getModel().getName().deleteCharAt(getModel().getName().length()-1);
            this.viewer.display(gui);
        }
        else {
            if(getModel().getName().length() <= 10) getModel().getName().append(str);
            this.viewer.display(gui);
        }

    }

    @Override
    public void initScreen(GUI gui, int width, int height) throws IOException, URISyntaxException, FontFormatException {
        gui.createMenuScreen(width, height);
    }
}
