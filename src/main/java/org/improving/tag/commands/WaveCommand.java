package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class WaveCommand extends BaseEmoteCommand {
    public WaveCommand(InputOutput io) {
        super("Who are you waving at?", io , "wave", "w");
    }
}
