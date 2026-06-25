package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class StockService {
    public double getCurrentPrice(String tickerSymbol) {
        if (tickerSymbol.equalsIgnoreCase("AAPL")) return 150.25;
        throw new IllegalArgumentException("Unknown Ticker Symbol: " + tickerSymbol);
    }

    public List<String> queryStocks(double minPrice, double maxPrice, String sector) {
        return List.of("AAPL", "MSFT");
    }
}