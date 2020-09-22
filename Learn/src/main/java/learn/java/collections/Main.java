package learn.java.collections;

import learn.java.collections.accessories.Accessory;
import learn.java.collections.flowers.Color;
import learn.java.collections.flowers.Flower;
import learn.java.collections.flowers.lilies.AsiaticLily;
import learn.java.collections.flowers.lilies.OrientalLily;
import learn.java.collections.flowers.roses.BourbonRose;
import learn.java.collections.flowers.roses.EnglishRose;
import learn.java.collections.flowers.roses.RoseType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flower> flowers = new ArrayList<>() {
            {
                this.add(new BourbonRose("Bourbon rose", 2.5, 6, 2, Color.PINK, false, RoseType.OLD_GARDEN_ROSE, true));
                this.add(new BourbonRose("Bourbon rose", 2.5, 6, 2, Color.PINK, true, RoseType.OLD_GARDEN_ROSE, false));
                this.add(new EnglishRose("English rose", 3.5, 4, 1, Color.RED, false, RoseType.MODERN_ROSE, true));
                this.add(new AsiaticLily("Asiatic lily", 4.3, 7, 2, Color.PINK, 6, true));
                this.add(new AsiaticLily("Asiatic lily", 4.3, 8, 2, Color.PINK, 3, false));
                this.add(new OrientalLily("Oriental lily", 5.3, 9, 3, Color.VIOLET, 4, true));
            }
        };
        List<Accessory> accessories = new ArrayList<>() {
            {
                this.add(new Accessory("Wrapper", 2.5));
                this.add(new Accessory("Band", 1.3));
            }
        };

        FlowerShop flowerShop = new FlowerShop(flowers, accessories);
        Bouquet bouquet = flowerShop.formABouquet();
    }
}
