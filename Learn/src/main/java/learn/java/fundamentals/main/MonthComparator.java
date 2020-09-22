package learn.java.fundamentals.main;

import java.util.InputMismatchException;
import java.util.Scanner;

class MonthComparator {
    public static void main(String[] args) {
        numberToMonth();
    }

    public static void numberToMonth() {
        System.out.println("Enter a number to get a corresponding month");

        try {
            int month = new Scanner(System.in).nextInt();
            try {
                System.out.println(month + " of " + getMonthName(month));
            } catch (Exception e) {
                e.printStackTrace();
                numberToMonth();
            }
        } catch (InputMismatchException e) {
            System.out.println("You did not enter a number. Try again");
            numberToMonth();
        }
    }

    private static String getMonthName(int month) throws Exception {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                throw new Exception("Enter a number from 1-12 range");
        }
    }
}
