package org.example.model.state;

import org.example.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest {
    private Menu menu;

    @BeforeEach
    void setUp(){
        menu = new Menu();
    }

    @Test
    public void flowMenuTest(){
        int first = 0;

        for(int i = 0; i < menu.getNumberEntries(); i++){
            menu.nextEntry();
        }

        Assertions.assertEquals(first, 0);

        for(int i = 0; i < menu.getNumberEntries(); i++){
            menu.previousEntry();
        }

        Assertions.assertEquals(first, 0);
    }
}

