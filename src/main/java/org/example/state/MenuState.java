package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.MenuController;
import org.example.model.menu.Menu;
import org.example.viewer.View;
import org.example.viewer.menu.MenuView;

import java.io.IOException;

public class MenuState extends State<Menu>{

    public MenuState(Menu menu) throws IOException, ClassNotFoundException { super(menu);}

    @Override
    protected View<Menu> getViewer() { return new MenuView(getModel());}

    @Override
    protected Controller<Menu> getController() { return new MenuController(getModel());}
}
