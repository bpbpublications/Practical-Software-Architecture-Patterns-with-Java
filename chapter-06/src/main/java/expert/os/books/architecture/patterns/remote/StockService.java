package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;


@ApplicationScoped
public class StockService {

    private static final Logger LOGGER = Logger.getLogger(StockService.class.getName());

    public BigDecimal getCurrentPrice(String tickerSymbol) {
        LOGGER.info("Getting current price for ticker symbol: " + tickerSymbol);
        if (tickerSymbol.equalsIgnoreCase("AAPL")){
            return BigDecimal.valueOf(150.25);
        }
        throw new IllegalArgumentException("Unknown Ticker Symbol: " + tickerSymbol);
    }

    public List<String> queryStocks(BigDecimal minPrice, BigDecimal maxPrice, String sector) {
        LOGGER.info("Querying stocks with minPrice: " + minPrice + ", maxPrice: " + maxPrice + ", sector: " + sector);
        return List.of("AAPL", "MSFT");
    }
}