package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class CountCommand implements Command {
    private InputOutput io;

    public CountCommand(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input) {
        if(input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("count");
    }

    @Override
    public void execute(String input) {
        input = input.trim();
        var destination = input.substring(5);
        io.displayText("You count" + destination + ".");
    }
}
