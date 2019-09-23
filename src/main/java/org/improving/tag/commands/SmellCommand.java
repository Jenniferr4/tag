package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SmellCommand extends BaseEmoteCommand {
    public SmellCommand(InputOutput io) {
        super("Smell", "I'd rather not..", io);
    }
}
