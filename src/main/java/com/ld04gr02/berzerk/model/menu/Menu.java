package com.ld04gr02.berzerk.model.menu;

public interface Menu<T> {

    public void selectNext();

    public void selectPrev();

    public MainMenu.Options getSelected();

    public boolean isSelected();

}
