package com.ld04gr02.berzerk.view;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.game.elements.Element;
import com.ld04gr02.berzerk.model.game.elements.Wall;
import com.ld04gr02.berzerk.model.game.maze.Maze;

import java.util.List;

public class GameViewer extends Viewer<Maze> {

    public GameViewer(Maze maze) {
        super(maze);
    }
    @Override
    protected void renderElements(GUI gui) {
        gui.drawStickMan(getModel().getStickMan().getPosition());
    }
}
