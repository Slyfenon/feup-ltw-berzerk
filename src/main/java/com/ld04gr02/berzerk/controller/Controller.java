package com.ld04gr02.berzerk.controller;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.view.*;
import java.io.IOException;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model) {
        this.model = model;
    }
    public T getModel() {
        return model;
    }
    public abstract void update(Game game, long time) throws IOException; //TODO
}
