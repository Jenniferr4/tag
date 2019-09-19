package org.improving.tag;
import org.improving.tag.commands.LookCommand;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Scanner;

public class Game {

    private Date startTime;
    private Date endTime;

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
            String input = scanner.nextLine();
                     LookCommand lCmd = new LookCommand();
            if (lCmd.isValid(input)) {
                     lCmd.execute(input);
            } else if (input.trim().equals("inventory")) {
                System.out.println("You are carrying nothing.");
            } else if (input.trim().equals("dance")) {
                System.out.println("You dance around.");
            } else if (input.trim().equals("jump")) {
                System.out.println("You jump in the air.");
            } else if (input.trim().equals("exit")) {
                System.out.println("Goodbye.");
                loop = false;
            } else {
                System.out.println("Huh? I don't understand.");

            }
            this.setEndTime(new Date());

        }
    }
}