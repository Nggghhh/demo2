package learn.java.fundamentals.main;

import java.util.Random;
import java.util.Scanner;

class RandomNumGen {
    public static void main(String[] args) {
        generateNums();
    }

    public static void generateNums() {
        Random r = new Random();
        System.out.println("Enter a number to define a quantity of numbers:");
        int quantity = new Scanner(System.in).nextInt();
        System.out.println("Should they be printed in separate lines? Y/N");
        String println = new Scanner(System.in).nextLine();

        int[] arr = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            arr[i] = r.nextInt();
        }

        if (println.equals("Y") || println.equals("y")) {
            printlnRandomNums(arr);
        } else {
            printRandomNums(arr);
        }
    }

    private static void printRandomNums(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    private static void printlnRandomNums(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
