package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.GameExitException;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand extends BaseAliasedCommand {
    private final SaveGameFactory saveFactory;

    public ExitCommand(InputOutput io, SaveGameFactory saveFactory) {
        super(io, "Exit", "x", "ex");
        this.saveFactory = saveFactory;
    }


    @Override
    public void childExecute(String input, Game game) {
        io.displayText("Goodbye.");
        saveFactory.save(game);
        throw new GameExitException();
    }

}
