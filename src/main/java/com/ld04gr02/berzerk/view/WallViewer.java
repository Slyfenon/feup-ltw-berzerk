package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Wall;

public class WallViewer {
    public void display(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
