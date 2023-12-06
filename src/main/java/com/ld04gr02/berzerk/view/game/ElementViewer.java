package com.ld04gr02.berzerk.view.game;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    public void display(T element, GUI gui);
}
