package learn.java.fundamentals.main;

import java.util.Scanner;

class Summator {
    public static void main(String[] args) {
        getSum();
    }

    public static void getSum() {
        System.out.println("Enter first number");
        int num1 = new Scanner(System.in).nextInt();
        System.out.println("Enter second number");
        int num2 = new Scanner(System.in).nextInt();
        System.out.println("Summation: " + (num1 + num2) + "\nMultiplication: " + num1 * num2);
    }
}
