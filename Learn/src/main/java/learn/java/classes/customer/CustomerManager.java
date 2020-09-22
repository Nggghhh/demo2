package learn.java.classes.customer;

import learn.java.classes.Manageable;

import java.util.Scanner;

public class CustomerManager implements Manageable {
    private Customer[] customers;

    public CustomerManager(int amountOfCustomers) {
        this.customers = new Customer[amountOfCustomers];
    }

    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(5);

        customerManager.insertNewCustomer(new Customer(3, "Boris", "Comar", "Antonovich", "Street of Pushkin, house of Kolotushkin", 5345654375437543L, 6456434543458676L));
        customerManager.insertNewCustomer(new Customer(4, "Anton", "Antonovich", "Comarovich", "Street of Pushkin, house of Kolotushkin", 7345654375437543L, 9456434543458676L));
        customerManager.insertNewCustomer(new Customer(0, "Anton", "Borisov", "Comarovich", "Street of Pushkin, house of Kolotushkin", 2345654375437543L, 3456434543458676L));
        customerManager.insertNewCustomer(new Customer(1, "Boris", "Antonov", "Comarovich", "Street of Pushkin, house of Kolotushkin", 1345654375437543L, 1456434543458676L));
        customerManager.insertNewCustomer(new Customer(2, "Comar", "Borisov", "Antonovich", "Street of Pushkin, house of Kolotushkin", 4345654375437543L, 5456434543458676L));

        customerManager.collectInput();
    }

    public void sortAlphabetically(Customer[] customersToSort) {
        printAllCustomers(sort(customersToSort));
        collectInput();
    }

    public void printAllCustomers(Customer[] customers) {
        for (Customer customer : customers) {
            customer.printPersonalData();
        }
    }

    public void printCustomersWhoseCreditCardNumberIsInBetween() {
        System.out.println("Enter first number");
        long lesserNumber = checkIfInputIsALong();
        System.out.println("Enter second number");
        long biggerNumber = checkIfInputIsALong();

        for (Customer customer : customers) {
            if (customer.getCreditCardNumber() > lesserNumber && customer.getCreditCardNumber() < biggerNumber) {
                customer.printPersonalData();
            }
        }
        collectInput();
    }

    private Customer[] sort(Customer[] customers) {
        int length = customers.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                Customer firstCustomer = customers[j];
                Customer secondCustomer = customers[j + 1];
                String firstNum = firstCustomer.getFullName();
                String secondNum = secondCustomer.getFullName();
                if (firstNum.compareTo(secondNum) > 0) {
                    Customer temp = secondCustomer;
                    customers[j + 1] = firstCustomer;
                    customers[j] = temp;
                }
            }
        }
        return customers;
    }

    @Override
    public void collectInput() {
        System.out.println("What do you wanna do?" +
                "\n0. Print all customers in alphabetical order." +
                "\n1. Print all customers whose credit card number is in between x and y.");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case 0:
                    sortAlphabetically(customers);
                    break;
                case 1:
                    printCustomersWhoseCreditCardNumberIsInBetween();
                    break;
            }
        }
    }

    public void insertNewCustomer(Customer customer) {
        if (isListFull()) {
            expandList();
        }

        for (int i = 0; i < customers.length; i++) {
            if (isSlotInListEmpty(i)) {
                customers[i] = customer;
                return;
            }
        }
    }

    @Override
    public boolean isSlotInListEmpty(int slotIndex) {
        return customers[slotIndex] == null;
    }

    @Override
    public boolean isListFull() {
        for (int i = 0; i < customers.length; i++) {
            if (isSlotInListEmpty(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void expandList() {
        System.out.println("Customer list is full. Expanding...");
        int currentLength = customers.length;
        Customer[] newListOfCustomers = new Customer[currentLength * 2];
        for (int i = 0; i < currentLength; i++) {
            newListOfCustomers[i] = customers[i];
        }
        customers = newListOfCustomers;
    }

    @Override
    public int checkIfInputIsAInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.hasNextInt() ? scanner.nextInt() : checkIfInputIsAInteger();
    }

    @Override
    public long checkIfInputIsALong() {
        Scanner scanner = new Scanner(System.in);
        return scanner.hasNextLong() ? scanner.nextLong() : checkIfInputIsALong();
    }
}
