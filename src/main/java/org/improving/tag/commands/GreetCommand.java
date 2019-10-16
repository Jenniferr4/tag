package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class GreetCommand extends BaseEmoteCommand {
    public GreetCommand(InputOutput io) {
        super("Hello there!", io, " Gt", "g", "Greet","hi", "hello", "hola", "bonjour");
    }
}
