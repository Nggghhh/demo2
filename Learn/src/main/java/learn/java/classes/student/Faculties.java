package learn.java.classes.student;

import java.util.Scanner;

enum Faculties {
    LAW("Law"), ECONOMY("Economy"), WEBDESIGN("Web-design"), MATH("Math");

    private String name;

    Faculties(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Faculties chooseFaculty() {
        System.out.println("Select a faculty:");
        printFaculties();

        int input = checkIfInputIsANumber();
        if (input <= Faculties.values().length && input >= 0) {
            for (Faculties faculty : Faculties.values()) {
                if (input == faculty.ordinal()) {
                    return faculty;
                }
            }
        }
        return null;
    }

    public static void printFaculties() {
        for (Faculties faculty : Faculties.values()) {
            System.out.println(faculty.ordinal() + " " + faculty.name);
        }
    }

    public static int checkIfInputIsANumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.hasNextInt() ? scanner.nextInt() : checkIfInputIsANumber();
    }
}
