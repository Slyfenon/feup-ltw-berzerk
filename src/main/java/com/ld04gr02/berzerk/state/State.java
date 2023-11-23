package com.ld04gr02.berzerk.state;

import com.ld04gr02.berzerk.Game;
import com.ld04gr02.berzerk.controller.Controller;
import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.view.Viewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    public State(T model) {
        this.model = model;
        this.controller = getController();
    }

    public T getModel() {
        return model;
    }

    protected abstract Controller<T> getController();

    public void update(Game game, GUI gui) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        //GUI.INPUT action = gui.getInput();
        //controller.update(game, action);
    }
}
