package org.example.controller.game.surface;

import org.example.Game;
import org.example.controller.game.GameController;
import org.example.gui.KeyHandler;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.player.Player;
import org.example.model.game.elements.surface.Elevator;

import java.io.IOException;

public class ElevatorController extends GameController {

    public int actionLockCounter = 0;

    public ElevatorController(Arena arena) { super(arena);}

    public void moveElevatorUp(Elevator elevator) {
        elevator.setPosition( elevator.getPosition().getUp());
    }

    public void moveElevatorDown(Elevator elevator) {
        elevator.setPosition(elevator.getPosition().getDown());
    }

    public void movePlayerUp(Player player) {movePlayer(player, player.getPosition().getUp());}

    public void movePlayer(Player player, Position new_position){
        if (getModel().canMove(new_position))
            player.setPosition(new_position);
    }

    @Override
    public void step(Game game, KeyHandler keyH) throws IOException {
        actionLockCounter++;

        if(actionLockCounter == 3) {

            if (getModel().canAllMoveDown() & (getModel().isButtonPressed(getModel().getLavaBoy().getPosition()) || getModel().isButtonPressed(getModel().getWaterGirl().getPosition()))) {
                for (Elevator elevator : getModel().getElevators()) {
                    moveElevatorDown(elevator);
                }
            }

            else if(getModel().canAllMoveUp() && (!getModel().isButtonPressed(getModel().getLavaBoy().getPosition()) && !getModel().isButtonPressed(getModel().getWaterGirl().getPosition()))) {
                for (Elevator elevator : getModel().getElevators()) {
                    moveElevatorUp(elevator);

                    if (getModel().onElevator(getModel().getWaterGirl().getPosition()))
                        movePlayerUp(getModel().getWaterGirl());

                    if (getModel().onElevator(getModel().getLavaBoy().getPosition()))
                        movePlayerUp(getModel().getLavaBoy());
                }

            }

            actionLockCounter = 0;
        }

    }
}

