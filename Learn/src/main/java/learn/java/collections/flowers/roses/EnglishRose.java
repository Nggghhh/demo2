package learn.java.collections.flowers.roses;

import learn.java.collections.flowers.Color;

import java.util.Objects;

public final class EnglishRose extends Rose {
    private boolean presenceOfScent;

    public EnglishRose() {
    }

    public EnglishRose(String name, double basePrice, int stemLength, int hoursSincePickingFlowerUp, Color color, boolean thornsRemoved, RoseType roseType, boolean presenceOfScent) {
        super(name, basePrice, stemLength, hoursSincePickingFlowerUp, color, thornsRemoved, roseType);
        this.presenceOfScent = presenceOfScent;
    }

    @Override
    public void printInfoAboutFlower() {
        super.printInfoAboutFlower();
        if (presenceOfScent) {
            System.out.println("Has scent");
        }
    }

    @Override
    public double calculatePrice() {
        double price = basePrice + stemLength / 2;
        if (this.thornsRemoved) {
            price += THORNS_REMOVAL_COST;
        }
        if (this.presenceOfScent) {
            price += 2.4;
        }
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
        EnglishRose that = (EnglishRose) o;
        return presenceOfScent == that.presenceOfScent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), presenceOfScent);
    }

    @Override
    public String toString() {
        return "EnglishRose{" +
                "presenceOfScent=" + presenceOfScent +
                ", thornsRemoved=" + thornsRemoved +
                ", roseType=" + roseType +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", stemLength=" + stemLength +
                ", hoursSincePickingFlowerUp=" + hoursSincePickingFlowerUp +
                ", color=" + color +
                '}';
    }

    public boolean isPresenceOfScent() {
        return presenceOfScent;
    }

    public void setPresenceOfScent(boolean presenceOfScent) {
        this.presenceOfScent = presenceOfScent;
    }
}
