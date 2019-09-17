package org.improving.tag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.print("> ");
            String input = scanner.nextLine();
            else if(input.trim().equals("look")) {
                System.out.println("You look around");
            }
            else if (input.trim().equals("inventory")) {
                System.out.println("You are carrying nothing.");
            }
            else if (input.trim().equals("dance")) {
                System.out.println("You dance around.");
            }
            else if (input.trim().equals("jump")) {
                System.out.println("You jump in the air.");
            }
            else if (input.trim().equals("exit")) {
                System.out.println("Goodbye.");
                loop = false;
            } else {
                System.out.println("huh? I don't understand.");
            }

        }
    }
}