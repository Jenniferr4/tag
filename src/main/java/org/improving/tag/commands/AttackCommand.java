package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand implements Command {
    private InputOutput io;

    private AttackCommand(InputOutput io) {
        this.io = io;

    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;

        return input.trim().equalsIgnoreCase("attack");
    }


    @Override
    public void execute(String input, Game game) {
        var adversary = game .getPlayer().getLocation().getAdversary();

        if (adversary == null) {
            io.displayText("Attack what? ");
        } else {
            Random random = new Random();
            int Random = random.nextInt(100);
            Random += 1;

            if (Random <= 99) {
                adversary.setDamageTaken(adversary.getDamageTaken() +10);
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                io.displayText(adversary.getName()+"'s" +" remaining points are " + adversary.getHitPoints() + ".");


            } else {
                io.displayText("You missed attack!");
            }
        }
    }

}
