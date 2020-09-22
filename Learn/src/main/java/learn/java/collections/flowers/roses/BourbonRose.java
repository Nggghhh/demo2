package learn.java.collections.flowers.roses;

import learn.java.collections.flowers.Color;

import java.util.Objects;

public final class BourbonRose extends Rose {
    private boolean doubleFlowered;

    public BourbonRose() {
    }

    public BourbonRose(String name, double basePrice, int stemLength, int hoursSincePickingFlowerUp, Color color, boolean thornsRemoved, RoseType roseType, boolean doubleFlowered) {
        super(name, basePrice, stemLength, hoursSincePickingFlowerUp, color, thornsRemoved, roseType);
        this.doubleFlowered = doubleFlowered;
    }

    @Override
    public void printInfoAboutFlower() {
        super.printInfoAboutFlower();
        if (doubleFlowered) {
            System.out.println("Is double flowered!");
        }
    }

    @Override
    public double calculatePrice() {
        double price = basePrice + stemLength / 2;
        if (this.thornsRemoved) {
            price += THORNS_REMOVAL_COST;
        }
        if (this.doubleFlowered) {
            price += 2.2;
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
        BourbonRose that = (BourbonRose) o;
        return doubleFlowered == that.doubleFlowered;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doubleFlowered);
    }

    @Override
    public String toString() {
        return "BourbonRose{" +
                "doubleFlowered=" + doubleFlowered +
                ", thornsRemoved=" + thornsRemoved +
                ", roseType=" + roseType +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", stemLength=" + stemLength +
                ", hoursSincePickingFlowerUp=" + hoursSincePickingFlowerUp +
                ", color=" + color +
                '}';
    }

    public boolean isDoubleFlowered() {
        return doubleFlowered;
    }

    public void setDoubleFlowered(boolean doubleFlowered) {
        this.doubleFlowered = doubleFlowered;
    }
}
