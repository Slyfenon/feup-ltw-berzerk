package com.ld04gr02.berzerk.view.game;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.EvilSmile;

public class EvilSmileViewer implements ElementViewer<EvilSmile> {
    @Override
    public void display(EvilSmile evilSmile, GUI gui) {
        gui.drawSprite2(evilSmile.getPosition().getX(), evilSmile.getPosition().getY(), Sprites.getEvilSmile(), '#', "#ffff00");
    }
}
