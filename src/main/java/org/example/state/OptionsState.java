package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.OptionsController;
import org.example.model.menu.Options;
import org.example.viewer.View;
import org.example.viewer.menu.OptionsView;

import java.io.IOException;

public class OptionsState extends  State<Options>{

    public OptionsState(Options options) throws IOException, ClassNotFoundException { super(options);}

    @Override
    protected View<Options> getViewer() { return new OptionsView(getModel());}

    @Override
    protected Controller<Options> getController() { return new OptionsController(getModel());}
}
