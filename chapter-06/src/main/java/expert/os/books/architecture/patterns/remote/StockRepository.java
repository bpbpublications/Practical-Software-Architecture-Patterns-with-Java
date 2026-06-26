package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class StockRepository {

    private Map<String, Stock> stocks = new HashMap<>();

    public void save(Stock stock) {
        stocks.put(stock.getSticker(), stock);
    }

    public Optional<Stock> findById(String sticker) {
        return Optional.ofNullable(stocks.get(sticker));
    }

    public void delete(String sticker) {
        stocks.remove(sticker);
    }
}
