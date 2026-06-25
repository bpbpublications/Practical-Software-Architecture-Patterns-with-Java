package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

// ============================================================================
// 1. THE SHARED SERVICE (Simple Layered Approach)
// ============================================================================

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