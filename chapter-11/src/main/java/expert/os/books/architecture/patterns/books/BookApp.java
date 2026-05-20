package expert.os.books.architecture.patterns.books;

import jakarta.enterprise.context.control.RequestContextController;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class BookApp {

    public static void main(String[] args) {

        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            var requestContextController = container.select(RequestContextController.class).get();
            requestContextController.activate();
            var service = container.select(NextReadBookService.class).get();
            var bookRequest = new BookRequest("Clean Code", "Robert C. Martin");
            var books = service.recommend(bookRequest);
            System.out.println(books);
            requestContextController.deactivate();
        }
    }
}
