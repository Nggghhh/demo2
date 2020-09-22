package learn.java.collections;

import learn.java.collections.accessories.Accessory;
import learn.java.collections.flowers.Flower;
import org.apache.commons.math3.util.Precision;

import java.util.List;

public class Bouquet implements PriceCalculator {
    private List<Flower> flowers;
    private Accessory accessory;

    public Bouquet() {
    }

    public Bouquet(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public Bouquet(List<Flower> flowers, Accessory accessory) {
        this.flowers = flowers;
        this.accessory = accessory;
    }

    public void printInfoAboutBouquet() {
        for (Flower flower : flowers) {
            System.out.println("Flowers:");
            flower.printInfoAboutFlower();
            System.out.println("");
        }
        if (accessory != null) {
            System.out.println("Accessory:");
            accessory.printInfoAboutAccessory();
        }
        System.out.println("");
        System.out.println("Total price is: " + calculatePrice());
        System.out.println("");
    }

    @Override
    public double calculatePrice() {
        double price = 0;
        for (Flower flower : flowers) {
            price += flower.calculatePrice();
        }
        return Precision.round((accessory != null ? price + accessory.getPrice() : price), 2);
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }
}
