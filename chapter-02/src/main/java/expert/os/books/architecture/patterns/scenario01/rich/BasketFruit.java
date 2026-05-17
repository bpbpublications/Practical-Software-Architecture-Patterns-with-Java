package expert.os.books.architecture.patterns.scenario01.rich;

import expert.os.books.architecture.patterns.scenario01.anemic.Fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasketFruit {

    private final List<Fruit> fruits = new ArrayList<>();


    public List<Fruit> getFruits() {
        return Collections.unmodifiableList(fruits);
    }

    public void add(Fruit fruit) {
        fruits.add(fruit);
    }

}
