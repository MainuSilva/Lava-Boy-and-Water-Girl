package org.example.controller.game.player;

import org.example.controller.game.GameController;
import org.example.model.Position;
import org.example.model.game.Arena;
import org.example.model.game.elements.player.Player;


public abstract class PlayerController extends GameController {

    public int cooldown = 0;

    public PlayerController(Arena arena) { super(arena);}

    public void movePlayerLeft(Player player) { movePlayer(player, player.getPosition().getLeft());}

    public void movePlayerRight(Player player) { movePlayer(player, player.getPosition().getRight());}

    public void movePlayerUp(Player player) { movePlayer(player, player.getPosition().getUp());}

    public void movePlayerDown(Player player) { movePlayer(player, player.getPosition().getDown());}

    private void movePlayer(Player player, Position newPosition) {
        if (getModel().canMove(newPosition) &&
                !newPosition.equals(getModel().getWaterGirl().getPosition()) &&
                !newPosition.equals(getModel().getLavaBoy().getPosition())) {

            player.setPosition(newPosition);

        }
    }

    public abstract void powerPlayer();

}
