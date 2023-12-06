package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void display(Wall wall, GUI gui) {
        String color = wall.isWall() ? "#0000ff" : "#ffff00";
        gui.drawWall(wall.getPosition(), color);
    }
}
