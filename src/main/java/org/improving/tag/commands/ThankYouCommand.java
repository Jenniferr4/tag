package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class ThankYouCommand extends BaseEmoteCommand {
    public ThankYouCommand (InputOutput io) {
        super ("You're welcome. :) " , io , "ty", "gracias", "thank you", "thanks");
    }
}
