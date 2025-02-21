package com.ld04gr02.berzerk.controller;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model) {
        this.model = model;
    }
    public T getModel() {
        return model;
    }
    public abstract void update(Game game, GUI.KEY key, long time) throws IOException, URISyntaxException, FontFormatException;
}
