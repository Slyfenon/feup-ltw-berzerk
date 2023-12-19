package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.view.game.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class State<T> {
    protected final T model;
    protected Viewer<T> viewer;
    protected Controller<T> controller;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    public T getModel() {
        return model;
    }
    public abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public void setViewer(Viewer<T> viewer) {this.viewer = viewer;}

    public void setController(Controller<T> controller) { this.controller = controller;}

    public abstract void update(Game game, GUI gui, long time) throws IOException, URISyntaxException, FontFormatException;

    public abstract void initScreen(GUI gui, int width, int height) throws IOException, URISyntaxException, FontFormatException;
}
