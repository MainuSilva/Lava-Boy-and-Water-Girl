package org.example.state;

import org.example.controller.Controller;
import org.example.controller.menu.InstructionsController;
import org.example.model.menu.Instructions;
import org.example.viewer.View;
import org.example.viewer.menu.InstructionsView;

import java.io.IOException;

public class InstructionState extends State<Instructions>{

    public InstructionState(Instructions instructions) throws IOException, ClassNotFoundException { super(instructions);}

    @Override
    protected View<Instructions> getViewer() { return new InstructionsView(getModel());}

    @Override
    protected Controller<Instructions> getController() { return new InstructionsController(getModel());}
}
