package learn.java.collections.flowers.roses;

import learn.java.collections.flowers.Color;
import learn.java.collections.flowers.Flower;

import java.util.Objects;

public abstract class Rose extends Flower {
    protected final double THORNS_REMOVAL_COST = 3.8;
    protected boolean thornsRemoved;
    protected RoseType roseType;

    public Rose() {
    }

    public Rose(String name, double basePrice, int stemLength, int hoursSincePickingFlowerUp, Color color, boolean thornsRemoved, RoseType roseType) {
        super(name, basePrice, stemLength, hoursSincePickingFlowerUp, color);
        this.thornsRemoved = thornsRemoved;
        this.roseType = roseType;
    }

    @Override
    public void printInfoAboutFlower() {
        super.printInfoAboutFlower();
        System.out.println("Rose type: " + this.roseType);
        if (!thornsRemoved) {
            System.out.println("Price without thorns: " + (this.calculatePrice() + THORNS_REMOVAL_COST));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rose rose = (Rose) o;
        return thornsRemoved == rose.thornsRemoved &&
                roseType == rose.roseType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), thornsRemoved, roseType);
    }

    @Override
    public String toString() {
        return "Rose{" +
                "thornsRemoved=" + thornsRemoved +
                ", roseType=" + roseType +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", stemLength=" + stemLength +
                ", hoursSincePickingFlowerUp=" + hoursSincePickingFlowerUp +
                ", color=" + color +
                '}';
    }

    public boolean isThornsRemoved() {
        return thornsRemoved;
    }

    public void setThornsRemoved(boolean thornsRemoved) {
        this.thornsRemoved = thornsRemoved;
    }

    public RoseType getRoseType() {
        return roseType;
    }

    public void setRoseType(RoseType roseType) {
        this.roseType = roseType;
    }
}
