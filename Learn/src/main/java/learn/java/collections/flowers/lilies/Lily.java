package learn.java.collections.flowers.lilies;

import learn.java.collections.flowers.Color;
import learn.java.collections.flowers.Flower;

import java.util.Objects;

public abstract class Lily extends Flower {
    protected int amountOfFlowersPerStem;

    public Lily() {
    }

    public Lily(String name, double basePrice, int stemLength, int hoursSincePickingFlowerUp, Color color, int amountOfFlowersPerStem) {
        super(name, basePrice, stemLength, hoursSincePickingFlowerUp, color);
        this.amountOfFlowersPerStem = amountOfFlowersPerStem;
    }

    @Override
    public void printInfoAboutFlower() {
        super.printInfoAboutFlower();
        System.out.println("Flowers per stem: " + amountOfFlowersPerStem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lily lily = (Lily) o;
        return amountOfFlowersPerStem == lily.amountOfFlowersPerStem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amountOfFlowersPerStem);
    }

    @Override
    public String toString() {
        return "Lily{" +
                "amountOfFlowersPerStem=" + amountOfFlowersPerStem +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", stemLength=" + stemLength +
                ", hoursSincePickingFlowerUp=" + hoursSincePickingFlowerUp +
                ", color=" + color +
                '}';
    }

    public int getAmountOfFlowersPerStem() {
        return amountOfFlowersPerStem;
    }

    public void setAmountOfFlowersPerStem(int amountOfFlowersPerStem) {
        this.amountOfFlowersPerStem = amountOfFlowersPerStem;
    }
}
