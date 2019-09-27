package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand implements Command {
    InputOutput io;

    AttackCommand(InputOutput io) {
    }

    {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input.trim();
        return input.equalsIgnoreCase("attack");
    }


    @Override
    public void execute(String input, Game game) {
        Random random = new Random();
        if (game.getPlayer().getLocation().getAdversary() == game.getStartingLocation().getAdversary()) {
            io.displayText("Attack what? ");
        } else if (random.nextInt(100) <= 20) {

            game.getPlayer().getLocation().getAdversary().setDamageTaken(10);
            io.displayText("" + game.getPlayer().getLocation()
                    .getAdversary().getHitPoints() + "remaining hp for" +
                    game.getPlayer().getLocation().getAdversary().getName());

        }else  {
            io.displayText("You missed attack.");
        }
    }

}
