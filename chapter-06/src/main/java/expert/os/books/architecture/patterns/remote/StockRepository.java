package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

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

    public List<Stock> find(List<String> sectors, BigDecimal minPrice, BigDecimal maxPrice) {
        Predicate<Stock> minPricePredicate = stock -> stock.getPrice().compareTo(minPrice) >= 0;
        Predicate<Stock> maxPricePredicate = stock -> stock.getPrice().compareTo(maxPrice) <= 0;
        Predicate<Stock> isSticker = stock -> sectors.isEmpty() || sectors.contains(stock.getSticker());
        return stocks.values().stream()
                .filter(minPricePredicate.and(maxPricePredicate).and(isSticker))
                .toList();
    }
}
