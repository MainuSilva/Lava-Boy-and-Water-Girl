package org.example.viewer.game.elements.surface;

import org.example.gui.GUI;
import org.example.model.game.elements.surface.Elevator;
import org.example.viewer.game.elements.ElementView;

public class ElevatorView implements ElementView<Elevator> {
    @Override
    public void draw(Elevator elevator, GUI gui) {
        gui.drawElevator(elevator.getPosition());
    }
}

