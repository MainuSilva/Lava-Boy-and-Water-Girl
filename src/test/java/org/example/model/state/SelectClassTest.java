package org.example.model.state;

import org.example.model.SelectClass;
import org.example.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SelectClassTest {
    SelectClass selectClass;

    @BeforeEach
    void setUp() {
        selectClass = new Menu(); // test with menu

        selectClass.setButtons(List.of("Button 1", "Button 2", "Button 3"));
    }

    @Test
    public void nextEntryTest() {
        selectClass.setCurrentEntry(0);
        selectClass.nextEntry();
        assertEquals(1, selectClass.getCurrentEntry());

        selectClass.setCurrentEntry(2);
        selectClass.nextEntry();
        assertEquals(0, selectClass.getCurrentEntry());
    }

    @Test
    public void previousEntryTest() {
        selectClass.setCurrentEntry(1);
        selectClass.previousEntry();
        assertEquals(0, selectClass.getCurrentEntry());

        selectClass.setCurrentEntry(0);
        selectClass.previousEntry();
        assertEquals(2, selectClass.getCurrentEntry());
    }

    @Test
    public void getEntryTest() {
        assertEquals("Button 2", selectClass.getEntry(1));
    }

    @Test
    public void isSelectedTest() {
        selectClass.setCurrentEntry(1);
        assertTrue(selectClass.isSelected(1));
        assertFalse(selectClass.isSelected(0));
    }

    @Test
    public void getNumberEntriesTest() {
        assertEquals(3, selectClass.getNumberEntries());
    }

    @Test
    public void flowTest(){
        int first = 0;

        for(int i = 0; i < selectClass.getCurrentEntry(); i++){
            selectClass.nextEntry();
        }

        Assertions.assertEquals(first, 0);

        for(int i = 0; i < selectClass.getNumberEntries(); i++){
            selectClass.previousEntry();
        }

        Assertions.assertEquals(first, 0);
    }
}
