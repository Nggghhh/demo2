package learn.java.collections;

import learn.java.collections.accessories.Accessory;
import learn.java.collections.flowers.Flower;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowerShop {
    private List<? extends Flower> flowersAvailable;
    private List<? extends Accessory> accessoriesAvailable;

    public FlowerShop() {
    }

    public FlowerShop(List<? extends Flower> flowersAvailable, List<? extends Accessory> accessoriesAvailable) {
        this.flowersAvailable = flowersAvailable;
        this.accessoriesAvailable = accessoriesAvailable;
    }

    public Bouquet formABouquet() {
        List<Flower> flowers = selectFlowers(new ArrayList<>());
        Accessory accessory = selectAccessory();

        Bouquet bouquet = (accessory != null) ? new Bouquet(flowers, accessory) : new Bouquet(flowers);
        return confirmTransaction(bouquet) ? bouquet : formABouquet();
    }

    private boolean confirmTransaction(Bouquet bouquet) {
        Scanner input = new Scanner(System.in);
        bouquet.printInfoAboutBouquet();

        System.out.println("Are you satisfied? Enter 0 to confirm, enter something else to create new bouquet");
        if (input.hasNextInt()) {
            return input.nextInt() == 0;
        }
        return false;
    }

    private List<Flower> selectFlowers(List<Flower> flowers) {
        Scanner input = new Scanner(System.in);
        double price = 0;
        System.out.println("Enter a number from 0 to " + (flowersAvailable.size() - 1) + " to choose your flowers. Enter something else to proceed");
        printInfoAboutFlowers(flowersAvailable);

        while (input.hasNextInt()) {
            try {
                Flower flower = flowersAvailable.get(input.nextInt());
                flowers.add(flower);
                price += flower.calculatePrice();
                System.out.println("Bouquet price: " + price);
                printNameAndPriceOfFlowers(flowers);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Your number is too big or less than 0. Try again");
                if (price > 0) {
                    System.out.println("Bouquet price: " + price);
                    printNameAndPriceOfFlowers(flowers);
                }
            }
        }
        if (!flowers.isEmpty()) {
            return flowers;
        }
        System.out.println("You didn't pick any flowers. Try again");
        return selectFlowers(flowers);
    }

    private Accessory selectAccessory() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number from 0 to " + (accessoriesAvailable.size() - 1) + " to choose your accessory. Enter something else to proceed");
        printInfoAboutAccessories(accessoriesAvailable);

        if (input.hasNextInt()) {
            try {
                return accessoriesAvailable.get(input.nextInt());
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return null;
    }

    public static int checkIfInputIsANumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.hasNextInt() ? scanner.nextInt() : checkIfInputIsANumber();
    }

    public void printInfoAboutFlowers(List<? extends Flower> flowersToPrint) {
        for (Flower flower : flowersToPrint) {
            flower.printInfoAboutFlower();
            System.out.println();
        }
    }

    public void printInfoAboutAccessories(List<? extends Accessory> accessories) {
        for (Accessory accessory : accessories) {
            accessory.printInfoAboutAccessory();
            System.out.println();
        }
    }

    public void printNameAndPriceOfFlowers(List<? extends Flower> flowersToPrint) {
        for (Flower flower : flowersToPrint) {
            flower.printNameAndPrice();
            System.out.println();
        }
    }

    public List<? extends Flower> getFlowersAvailable() {
        return flowersAvailable;
    }

    public void setFlowersAvailable(List<? extends Flower> flowersAvailable) {
        this.flowersAvailable = flowersAvailable;
    }

    public List<? extends Accessory> getAccessoriesAvailable() {
        return accessoriesAvailable;
    }

    public void setAccessoriesAvailable(List<? extends Accessory> accessoriesAvailable) {
        this.accessoriesAvailable = accessoriesAvailable;
    }
}
