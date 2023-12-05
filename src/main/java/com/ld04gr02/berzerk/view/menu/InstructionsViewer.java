package com.ld04gr02.berzerk.view.menu;

import com.ld04gr02.berzerk.gui.GUI;
import com.ld04gr02.berzerk.model.menu.InstructionsMenu;
import com.ld04gr02.berzerk.view.Viewer;

public class InstructionsViewer extends Viewer<InstructionsMenu> {
    public InstructionsViewer(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected void renderElements(GUI gui) {
        gui.drawInstructionsMenu(getModel());
    }
}
