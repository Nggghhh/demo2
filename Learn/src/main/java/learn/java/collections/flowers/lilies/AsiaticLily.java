package learn.java.collections.flowers.lilies;

import learn.java.collections.flowers.Color;

import java.util.Objects;

public final class AsiaticLily extends Lily {
    private boolean hasSpotsOnPetals;

    public AsiaticLily() {
    }

    public AsiaticLily(String name, double basePrice, int stemLength, int hoursSincePickingFlowerUp, Color color, int amountOfFlowersPerStem, boolean hasSpotsOnPetals) {
        super(name, basePrice, stemLength, hoursSincePickingFlowerUp, color, amountOfFlowersPerStem);
        this.hasSpotsOnPetals = hasSpotsOnPetals;
    }

    @Override
    public void printInfoAboutFlower() {
        super.printInfoAboutFlower();
        if (hasSpotsOnPetals) {
            System.out.println("Has spots on petals");
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
        AsiaticLily that = (AsiaticLily) o;
        return hasSpotsOnPetals == that.hasSpotsOnPetals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasSpotsOnPetals);
    }

    @Override
    public String toString() {
        return "AsiaticLily{" +
                "hasSpotsOnPetals=" + hasSpotsOnPetals +
                ", amountOfFlowersPerStem=" + amountOfFlowersPerStem +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", stemLength=" + stemLength +
                ", hoursSincePickingFlowerUp=" + hoursSincePickingFlowerUp +
                ", color=" + color +
                '}';
    }

    public boolean isHasSpotsOnPetals() {
        return hasSpotsOnPetals;
    }

    public void setHasSpotsOnPetals(boolean hasSpotsOnPetals) {
        this.hasSpotsOnPetals = hasSpotsOnPetals;
    }
}
