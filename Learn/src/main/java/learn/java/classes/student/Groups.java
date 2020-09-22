package learn.java.classes.student;

import java.util.Scanner;

enum Groups {
    FIRST_GROUP("First group"), SECOND_GROUP("Second group"), THIRD_GROUP("Third group"), FOURTH_GROUP("Fourth group");

    private String name;

    Groups(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Groups chooseGroup() {
        System.out.println("Select a group:");
        printGroups();

        int input = checkIfInputIsANumber();
        if (input <= Groups.values().length && input >= 0) {
            for (Groups group : Groups.values()) {
                if (input == group.ordinal()) {
                    return group;
                }
            }
        }
        return null;
    }

    public static void printGroups() {
        for (Groups group : Groups.values()) {
            System.out.println(group.ordinal() + " " + group.name);
        }
    }

    public static int checkIfInputIsANumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.hasNextInt() ? scanner.nextInt() : checkIfInputIsANumber();
    }
}
