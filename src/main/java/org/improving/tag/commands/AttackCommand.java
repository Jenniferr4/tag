package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand extends BaseAliasedCommand {
    private final Random random;
    private InputOutput io;

    private AttackCommand(InputOutput io, Random random) {
        super(io, "attack", "a", "atack", "at", "att");
        this.io = io;
        this.random = random;

    }

    @Override
    public void execute(String input, Game game) {

        var adversary = game.getPlayer().getLocation().getAdversary();
        if (adversary == null) {
            io.displayText("Attack what? ");
        } else {
            Random random = new Random();
            int Random = random.nextInt(100);
            Random += 1;

            if (Random <= 99) {
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                io.displayText(adversary.getName() + "'s" +
                        " remaining points are " + adversary.getHitPoints() + ".");

            } else {
                io.displayText("You missed attack!");
            }
            if (adversary.getHitPoints() == 0) {
                var advItem = adversary.getInventory().getItem();
                game.getPlayer().getInventory().addItem(advItem);
                io.displayText("You have defeated " + adversary.getName() + " and obtained his loot..." + advItem);

                game.getPlayer().getLocation().setAdversary(null);
            }
        }
    }
}
