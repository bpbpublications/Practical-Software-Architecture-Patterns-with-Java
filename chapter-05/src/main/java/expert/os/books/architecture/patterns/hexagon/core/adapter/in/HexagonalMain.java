package expert.os.books.architecture.patterns.hexagon.core.adapter.in;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class HexagonalMain {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {


        }
    }
}
