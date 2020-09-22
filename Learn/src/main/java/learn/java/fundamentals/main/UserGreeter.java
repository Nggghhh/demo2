package learn.java.fundamentals.main;

import java.util.Scanner;

class UserGreeter {
    public static void main(String[] args) {
        greetUser();
    }

    public static void greetUser() {
        String name = new Scanner(System.in).nextLine();
        if (!name.isEmpty()) {
            System.out.println("Hello, " + name + "!");
        } else {
            System.out.println("Please, enter your name");
        }
    }
}
