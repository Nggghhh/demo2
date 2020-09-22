package learn.java.collections.flowers.lilies;

import learn.java.collections.flowers.Color;

import java.util.Objects;

public final class OrientalLily extends Lily {
    private boolean petalsRecurved;

    public OrientalLily() {
    }

    public OrientalLily(String name, double basePrice, int stemLength, int hoursSincePickingFlowerUp, Color color, int amountOfFlowersPerStem, boolean petalsRecurved) {
        super(name, basePrice, stemLength, hoursSincePickingFlowerUp, color, amountOfFlowersPerStem);
        this.petalsRecurved = petalsRecurved;
    }

    @Override
    public void printInfoAboutFlower() {
        super.printInfoAboutFlower();
        if (petalsRecurved) {
            System.out.println("Petals are recurved");
        }
    }

    @Override
    public double calculatePrice() {
        double price = basePrice + amountOfFlowersPerStem / 2 + stemLength / 2;
        if (hoursSincePickingFlowerUp > 4) {
            price /= 2;
        }
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrientalLily that = (OrientalLily) o;
        return petalsRecurved == that.petalsRecurved;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), petalsRecurved);
    }

    @Override
    public String toString() {
        return "OrientalLily{" +
                "petalsRecurved=" + petalsRecurved +
                ", amountOfFlowersPerStem=" + amountOfFlowersPerStem +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", stemLength=" + stemLength +
                ", hoursSincePickingFlowerUp=" + hoursSincePickingFlowerUp +
                ", color=" + color +
                '}';
    }

    public boolean isPetalsRecurved() {
        return petalsRecurved;
    }

    public void setPetalsRecurved(boolean petalsRecurved) {
        this.petalsRecurved = petalsRecurved;
    }
}
