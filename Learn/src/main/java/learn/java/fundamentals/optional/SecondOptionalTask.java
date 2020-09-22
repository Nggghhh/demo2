package learn.java.fundamentals.optional;

import java.util.Random;
import java.util.Scanner;

class SecondOptionalTask {
    private static int[][] matrix;

    public static void main(String[] args) {
        createMatrix();
    }

    public static void createMatrix() {
        System.out.println("Type a number to define amount of rows: ");
        int rows = checkIfInputIsANumber();
        System.out.println("Type a number to define amount of columns: ");
        int columns = checkIfInputIsANumber();


        int[][] tempMatrix = fillMatrixWithNumbers(new int[rows][columns]);
        matrix = tempMatrix;
        printMatrix(tempMatrix);
        collectInput();
    }

    private static void sortRowOrColumnInMatrix(int[][] matrixToSort) {
        System.out.println("What do you want to sort? Type 0 for row and 1 for column");
        int input = checkIfInputIsANumber();
        switch (input) {
            case 0:
                sortRow(matrixToSort);
                break;
            case 1:
                sortColumn(matrixToSort);
                break;
            default:
                System.out.println("Wrong input. Try again");
                sortRowOrColumnInMatrix(matrixToSort);
                break;
        }
        matrix = matrixToSort;
        printMatrix(matrix, "This is matrix after sorting");
        collectInput();
    }

    private static int[][] sortRow(int[][] matrix) {
        int amountOfRows = matrix.length;
        try {
            System.out.println("Enter a number from 1 to " + amountOfRows + " to define a row you want to sort");
            int rowToCheck = checkIfInputIsANumber() - 1;
            int[][] matrixWithRowSorted = matrix;
            int len = matrixWithRowSorted[0].length;

            for (int i = 0; i < len - 1; i++) {
                for (int j = 0; j < len - i - 1; j++) {
                    int firstNum = matrixWithRowSorted[rowToCheck][j];
                    int secondNum = matrixWithRowSorted[rowToCheck][j + 1];
                    if (firstNum > secondNum) {
                        int temporaryInteger = firstNum;
                        matrixWithRowSorted[rowToCheck][j] = secondNum;
                        matrixWithRowSorted[rowToCheck][j + 1] = temporaryInteger;
                    }
                }
            }
            return matrixWithRowSorted;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Input is out of matrix's bounds. Returning original matrix");
        }
        return matrix;
    }

    private static int[][] sortColumn(int[][] matrix) {
        int amountOfColumns = matrix[0].length;
        try {
            System.out.println("Enter a number from 1 to " + amountOfColumns + " to define a col you want to sort");
            int columnWithColumnSorted = checkIfInputIsANumber() - 1;
            int[][] matrixWithColumnSorted = matrix;
            int len = matrixWithColumnSorted.length;

            for (int i = 0; i < len - 1; i++) {
                for (int j = 0; j < len - i - 1; j++) {
                    int firstNum = matrixWithColumnSorted[j][columnWithColumnSorted];
                    int secondNum = matrixWithColumnSorted[j + 1][columnWithColumnSorted];
                    if (firstNum > secondNum) {
                        int temporaryInteger = firstNum;
                        matrixWithColumnSorted[j][columnWithColumnSorted] = secondNum;
                        matrixWithColumnSorted[j + 1][columnWithColumnSorted] = temporaryInteger;
                    }
                }
            }
            return matrixWithColumnSorted;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Input is out of matrix's bounds. Returning original matrix");
        }
        return matrix;
    }

    private static void collectInput() {
        System.out.println(
                "What's next?\n" +
                        "0. Create new matrix\n" +
                        "1. Sort row or col of the matrix\n" +
                        "Enter something but number to stop."
        );

        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            switch (input.nextInt()) {
                case 0 -> createMatrix();
                case 1 -> sortRowOrColumnInMatrix(matrix);
                case 2 -> findBiggestRowOfAscendingElements(matrix);
                default -> collectInput();
            }
        } else {
            System.out.println("End");
        }
    }

    public static int checkIfInputIsANumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.hasNextInt() ? scanner.nextInt() : checkIfInputIsANumber();
    }

    public static String checkInputString() {
        return new Scanner(System.in).nextLine();
    }

    public static int[][] fillMatrixWithNumbers(int[][] matrix) {
        Random random = new Random();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                matrix[row][column] = random.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println("");
        }
    }

    public static void printMatrix(int[][] matrix, String additionalMessage) {
        System.out.println(additionalMessage + "\n");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println("");
        }
    }

    public static void findBiggestRowOfAscendingElements(int[][] matrix) {
        int maxElement;
        int longestSerie = 0;
        int serieToCompareWithTheLongest = 0;
        for (int row = 0; row < matrix.length; row++) {
            maxElement = matrix[row][0];
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] > maxElement) {
                    maxElement = matrix[row][column];
                    System.out.print(maxElement + " ");
                    serieToCompareWithTheLongest++;
                }
            }
            System.out.print(serieToCompareWithTheLongest);
            if (longestSerie < serieToCompareWithTheLongest)
                longestSerie = serieToCompareWithTheLongest;
            serieToCompareWithTheLongest = 0;
            System.out.println("");
        }
        System.out.println(longestSerie + " is the biggest amount of numbers in ascending order in rows");
        collectInput();
    }
}
