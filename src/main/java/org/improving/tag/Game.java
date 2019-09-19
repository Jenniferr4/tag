package org.improving.tag;

import org.improving.tag.commands.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Scanner;

public class Game {

    private final LookCommand lCmd;
    private final DanceCommand dCmd;
    private final InventoryCommand iCmd;
    private final JumpCommand jCmd;
    private Date startTime;
    private Date endTime;
    private BaseEmoteCommand[] commands;

    public Game() {
        commands = new BaseEmoteCommand[]{
                new LookCommand(),
                new DanceCommand(),
                new JumpCommand(),
                new InventoryCommand()};
    }

    public Date getStartTime() {
        return startTime;
    }

    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        this.setStartTime(new Date());
        boolean loop = true;

        while (loop) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            BaseEmoteCommand validCommand = getValidCommand(input);
            if (null != validCommand) {
                validCommand.execute(input);
            } else if (input.equals("exit")) {
                System.out.println("Goodbye.");
                loop = false;
            } else {
                System.out.println("Huh? I don't understand.");

            }
            this.setEndTime(new Date());

        }
    }

    private BaseEmoteCommand getValidCommand(String input) {
        for (BaseEmoteCommand command : commands) {
            if (command.isValid(input)) {
                return command;
            }

        }
        return null;
    }
}