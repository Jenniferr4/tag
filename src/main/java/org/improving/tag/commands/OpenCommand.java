package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.items.Item;
import org.springframework.stereotype.Component;

@Component
public class OpenCommand extends BaseAliasedCommand {
    private InputOutput io;

    public OpenCommand(InputOutput io) {
        super(io, "o", "open", "loot", "abrir");
        this.io = io;
    }

    @Override
    public void childExecute(String input, Game game) {
        Item item = game.getPlayer().getLocation().openTreasureChest();
        io.displayText("Opening...."+ "\n");
        io.displayText("You have found " + item + "!");
        game.getPlayer().getInventory().addItem(item);
    }

    @Override
    public String getErrorMessage() {
        return "Are you seeing things? There's nothing here.";
    }
}
