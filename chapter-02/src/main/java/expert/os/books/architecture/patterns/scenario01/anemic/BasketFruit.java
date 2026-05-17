package expert.os.books.architecture.patterns.scenario01.anemic;

import java.util.List;

public class BasketFruit {

    private List<Fruit> fruits;

    public BasketFruit(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }
}
