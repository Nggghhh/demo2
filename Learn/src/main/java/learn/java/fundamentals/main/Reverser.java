package learn.java.fundamentals.main;

import java.util.Scanner;

class Reverser {
    public static void main(String[] args) {
        reverseLine();
    }

    public static void reverseLine() {
        System.out.println("Enter a line to flip it");
        String line = new Scanner(System.in).nextLine();

        char[] chars = line.toCharArray();
        int len = chars.length;
        char[] newChars = new char[len];

        for (int i = len - 1; i >= 0; i--) {
            int j = Math.abs(i - len) - 1;
            newChars[j] = chars[i];
        }
        System.out.println(new String(newChars));
    }
}
