package learn.java.fundamentals.optional;

import java.util.ArrayList;
import java.util.Scanner;

class FirstOptionalTask {
    private static int[] finalNumbers;

    public static void main(String[] args) {
        enterNumbers();
    }

    private static void enterNumbers() {
        System.out.println("Enter a number.");
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> firstCollectionOfNumbers = new ArrayList<>();

        while (input.hasNextInt()) {
            System.out.println("You can keep entering numbers. Enter something else to proceed.");
            int num = input.nextInt();
            firstCollectionOfNumbers.add(num);
        }

        if (firstCollectionOfNumbers.isEmpty()) {
            System.out.println("You didn't enter any numbers.");
            return;
        }

        finalNumbers = saveNumbers(firstCollectionOfNumbers);
        collectInput();
    }

    private static void collectInput() {
        System.out.println("What's next?\n" +
                "0. Enter new numbers.\n" +
                "1. Find min and max length.\n" +
                "2. Print numbers in ascending and descending order by length.\n" +
                "3. Print numbers that are higher (and lower) than their average length.\n" +
                "Enter something but number to stop."
        );

        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            switch (input.nextInt()) {
                case 0 -> enterNumbers();
                case 1 -> printMinAndMax(finalNumbers);
                case 2 -> printNumbersByLength(finalNumbers);
                case 3 -> printNumbersHigherThanAverageLen(finalNumbers);
                case 4 -> printNumberWithMinimumDifferentDigits(finalNumbers);
                default -> collectInput();
            }
        } else {
            System.out.println("End");
        }
    }

    private static void printNumbers(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\n");
    }

    private static void printNumbers(int number) {
        System.out.println(number);
    }

    private static void printMinAndMax(int[] numbers) {
        int[] numbersSorted = sortArrayByLength(numbers);
        int indexOfMinNumber = 0;
        int indexOfMaxNumber = numbersSorted.length - 1;
        int firstNumberLen = String.valueOf(numbersSorted[indexOfMinNumber]).length();
        int secondNumberLen = String.valueOf(numbersSorted[indexOfMaxNumber]).length();
        System.out.println(
                "The shortest number -> " + numbersSorted[indexOfMinNumber] + " It's length is " + firstNumberLen + "\n" +
                        "The longest number -> " + numbersSorted[indexOfMaxNumber] + " It's length is " + secondNumberLen
        );
        collectInput();
    }

    private static void printNumbersByLength(int[] numbers) {
        int[] numbersSorted = sortArrayByLength(numbers);
        printNumbers(numbersSorted);
        System.out.println("\n");
        printNumbers(flipArray(numbersSorted));
        System.out.println("\n");
        collectInput();
    }

    private static void printNumbersHigherThanAverageLen(int[] numbers) {
        int averageLength = getAverageLength(numbers);
        System.out.println("The average length is " + averageLength + ".");
        System.out.println("These numbers are higher than average length:");

        for (int number : numbers) {
            int numLen = String.valueOf(number).length();
            if (numLen > averageLength)
                System.out.println(number);
        }
        System.out.println("These numbers are lower than average length:");
        for (int number : numbers) {
            int numLen = String.valueOf(number).length();
            if (numLen < averageLength)
                System.out.println(number);
        }
        collectInput();
    }

    private static void printNumberWithMinimumDifferentDigits(int[] numbers) {
        int len = numbers.length;
        int[] numbersWithoutDuplicates = new int[len];
        for (int i = 0; i < len; i++) {
            numbersWithoutDuplicates[i] = arrayToNumber(trim(removeDuplicateElements(sort(numberToArrayOfDigits(finalNumbers[i])))));
        }
        int[] arrayOfLengths = toArrayOfLengths(numbers);
        int[] arrayOfLengthsWithoutDuplicates = toArrayOfLengths(numbersWithoutDuplicates);
        int[] arrayOfDifferencesBetweenLengths = new int[len];
        for (int i = 0; i < len; i++) {
            arrayOfDifferencesBetweenLengths[i] = arrayOfLengths[i] - arrayOfLengthsWithoutDuplicates[i];
        }
        int indexOfDesiredNumber = getMax(arrayOfDifferencesBetweenLengths);
        System.out.println("This is a number that has minimum amount of different digits -> " + numbers[indexOfDesiredNumber] + "\nThis is him without duplicates -> " + numbersWithoutDuplicates[indexOfDesiredNumber]);
        collectInput();
    }

    private static int[] saveNumbers(ArrayList<Integer> numbersToSave) {
        int len = numbersToSave.size();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = numbersToSave.get(i);
        }
        System.out.println("***INPUT IS SAVED***\n");
        return arr;
    }

    private static int getAverageLength(int[] numbers) {
        int averageLength = 0;
        int amountOfNumbers = numbers.length;
        for (int number : numbers) {
            int numLen = String.valueOf(number).length();
            averageLength += numLen;
        }
        return averageLength / amountOfNumbers;
    }

    private static int[] flipArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    private static int[] sortArrayByLength(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                int firstLen = String.valueOf(arr[j]).length();
                int secondLen = String.valueOf(arr[j + 1]).length();
                if (firstLen > secondLen) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] sort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                int firstNum = arr[j];
                int secondNum = arr[j + 1];
                if (firstNum > secondNum) {
                    int temp = firstNum;
                    arr[j] = secondNum;
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] removeDuplicateElements(int array[]) {
        int arrayLength = array.length;
        int[] temporaryArray = new int[arrayLength];
        int j = 0;
        for (int i = 0; i < arrayLength - 1; i++) {
            if (array[i] != array[i + 1]) {
                temporaryArray[j++] = array[i];
            }
        }
        temporaryArray[j++] = array[arrayLength - 1];
        return temporaryArray;
    }

    private static int[] trim(int arr[]) {
        int newLength = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == 0) {
                newLength--;
            }
        }
        int[] newNumbers = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            newNumbers[i] = arr[i];
        }
        return newNumbers;
    }

    private static int arrayToNumber(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result *= 10;
            result += arr[i];
        }
        return result;
    }

    private static int[] numberToArrayOfDigits(int num) {
        char[] numberToChars = String.valueOf(num).toCharArray();
        int numLen = numberToChars.length;
        int[] number = new int[numLen];
        for (int i = 0; i < numLen; i++) {
            number[i] = Character.getNumericValue(numberToChars[i]);
        }

        return number;
    }

    private static int[] toArrayOfLengths(int[] arr) {
        int len = arr.length;
        int[] arrayOfLengths = new int[len];
        for (int i = 0; i < len; i++) {
            arrayOfLengths[i] = String.valueOf(arr[i]).length();
        }
        return arrayOfLengths;
    }

    public static int getMax(int[] inputArray) {
        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            } else {
                return i;
            }
        }
        return -1;
    }
}
