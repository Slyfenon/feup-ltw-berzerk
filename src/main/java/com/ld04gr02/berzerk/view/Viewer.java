package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer (T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void display(GUI gui) throws IOException {
        gui.clear();
        renderElements(gui);
        gui.refresh();
    }

    protected abstract void renderElements(GUI gui);
}
