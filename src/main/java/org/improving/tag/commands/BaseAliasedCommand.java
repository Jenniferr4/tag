package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseAliasedCommand implements Command {
    protected final InputOutput io;
    private List<String> aliases = new ArrayList<>();

    public BaseAliasedCommand(InputOutput io, String... aliases) {
        this.io = io;

        this.aliases.addAll(Arrays.asList(aliases));
    }

    @Override
    public boolean isValid(String input, Game game) {
        try {
            var trimmedInput = getCommandPart(input).trim();
            return aliases.stream()
                    .anyMatch(trimmedInput::equalsIgnoreCase);
        } catch (UnsupportedOperationException ex) {
            return false;
            //could have done a for loop but this is Austin's way "stream"
        }
    }
    public void childExecute(String input, Game game) {
    }

    public String getErrorMessage() {
        return "Huh, I don't understand?";
    }

    @Override
    public void execute(String input, Game game) {
        try {
            childExecute(input, game);
        } catch (UnsupportedOperationException ex) {
            io.displayText(getErrorMessage());
        }


    }

    public String getCommandPart(String input) {
        return input;
    }
}