package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.controller.menu.InstructionsMenuController;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.InstructionsMenu;
import com.ld04gr02.berzerk.view.Viewer;
import com.ld04gr02.berzerk.view.menu.InstructionsViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class InstructionsMenuState extends State<InstructionsMenu>{
    public InstructionsMenuState(InstructionsMenu model) {
        super(model);
    }

    @Override
    public Viewer<InstructionsMenu> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    protected Controller<InstructionsMenu> getController() {
        return new InstructionsMenuController(getModel());
    }

    @Override
    public void update(Game game, GUI gui, long time) throws IOException, URISyntaxException, FontFormatException {
        GUI.KEY action = gui.getPressedKey();
        this.controller.update(game, action, time);
        if(action != GUI.KEY.ENTER) {
            this.viewer.display(gui);
        }
    }

    @Override
    public void initScreen(GUI gui, int width, int height) throws IOException, URISyntaxException, FontFormatException {
        gui.createMenuScreen(width, height);
    }
}
