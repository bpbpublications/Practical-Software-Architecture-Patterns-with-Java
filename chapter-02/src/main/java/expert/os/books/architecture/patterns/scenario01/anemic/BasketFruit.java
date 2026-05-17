package expert.os.books.architecture.patterns.scenario01.anemic;

import java.util.List;

public class BasketFruit {

    private List<String> fruits;

    public BasketFruit(List<String> fruits) {
        this.fruits = fruits;
    }

    public List<String> getFruits() {
        return fruits;
    }

    public void setFruits(List<String> fruits) {
        this.fruits = fruits;
    }
}
