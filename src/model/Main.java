package model;

import java.util.Scanner;

public class Main {

    private static User user;
    private static Scanner input;

    public static void main(String[] args) {
        messagingAppRun();
    }

    private static void messagingAppRun() {
        System.out.println("This is the messaging app.");

        setUsername();
        runMessageTaker();
    }

    private static void setUsername() {
        Scanner nameScanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String name = nameScanner.nextLine();
        user = new User(name);
        System.out.println("Your username has been set to : " + user.getUsername());
    }

    private static void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tm -> write a new message");
        System.out.println("\tq -> quit");
    }

    private static void runMessageTaker() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    private static void processCommand(String command) {
        if (command.equals("m")) {
            // TODO
        } else {
            System.out.println("Selection not valid...");
        }
    }
}


