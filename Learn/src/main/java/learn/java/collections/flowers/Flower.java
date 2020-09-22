package learn.java.collections.flowers;

import learn.java.collections.PriceCalculator;

import java.util.Objects;

public abstract class Flower implements PriceCalculator {
    protected String name;
    protected double basePrice;
    protected int stemLength;
    protected int hoursSincePickingFlowerUp;
    protected Color color;

    public Flower() {
    }

    public Flower(String name, double basePrice, int stemLength, int hoursSincePickingFlowerUp, Color color) {
        this.name = name;
        this.basePrice = basePrice;
        this.stemLength = stemLength;
        this.hoursSincePickingFlowerUp = hoursSincePickingFlowerUp;
        this.color = color;
    }

    public void printInfoAboutFlower() {
        System.out.println("Name: " + this.name + "\n" +
                "Price: " + this.calculatePrice() + "\n" +
                "Stem length: " + this.stemLength + "\n" +
                "Hours since picking flower up: " + this.hoursSincePickingFlowerUp + "\n" +
                "Color: " + this.color
        );
    }

    public void printNameAndPrice() {
        System.out.println("Name: " + this.name + "\n" +
                "Price: " + this.calculatePrice()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.basePrice, basePrice) == 0 &&
                stemLength == flower.stemLength &&
                hoursSincePickingFlowerUp == flower.hoursSincePickingFlowerUp &&
                Objects.equals(name, flower.name) &&
                color == flower.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, basePrice, stemLength, hoursSincePickingFlowerUp, color);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", stemLength=" + stemLength +
                ", hoursSincePickingFlowerUp=" + hoursSincePickingFlowerUp +
                ", color=" + color +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        this.stemLength = stemLength;
    }

    public int getHoursSincePickingFlowerUp() {
        return hoursSincePickingFlowerUp;
    }

    public void setHoursSincePickingFlowerUp(int hoursSincePickingFlowerUp) {
        this.hoursSincePickingFlowerUp = hoursSincePickingFlowerUp;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
