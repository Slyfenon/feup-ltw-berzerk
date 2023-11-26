package com.ld04gr02.berzerk.model.menu;

public interface Menu<T> {

    public void selectNext();

    public void selectPrev();

    public MenuOptions getSelected();

    public boolean isSelected();

}
