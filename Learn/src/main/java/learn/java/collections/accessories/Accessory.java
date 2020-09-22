package learn.java.collections.accessories;

import java.util.Objects;

public class Accessory {
    private String name;
    private double price;

    public Accessory() {
    }

    public Accessory(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void printInfoAboutAccessory() {
        System.out.println("Name: " + this.name);
        System.out.println("Price: " + this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessory accessory = (Accessory) o;
        return Double.compare(accessory.price, price) == 0 &&
                Objects.equals(name, accessory.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
