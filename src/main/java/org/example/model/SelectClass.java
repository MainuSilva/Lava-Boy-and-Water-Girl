package org.example.model;

import java.util.List;

public abstract class SelectClass {
    private List<String> buttons;
    private int currentEntry = 0;

    public void setButtons(List<String> buttons) {
        this.buttons = buttons;
    }

    public void setCurrentEntry(int i){
        currentEntry = i;
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.buttons.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.buttons.size() - 1;
    }

    public int getCurrentEntry() { return currentEntry;}

    public String getEntry(int i) {
        return buttons.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() { return this.buttons.size();}

}
