package expert.os.books.architecture.patterns.remote;

import expert.os.books.architecture.patterns.remote.controller.Stocks;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;


@ApplicationScoped
public class StockService {

    private static final Logger LOGGER = Logger.getLogger(StockService.class.getName());

    private final StockRepository stockRepository;

    @Inject
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @PostConstruct
    void load() {
        LOGGER.info("Loading initial stock data...");
        stockRepository.save(new Stock("AAPL", BigDecimal.valueOf(150.25)));
        stockRepository.save(new Stock("MSFT", BigDecimal.valueOf(300.50)));
        stockRepository.save(new Stock("GOOGL", BigDecimal.valueOf(2500.00)));
        LOGGER.info("Initial stock data loaded.");
    }

    public BigDecimal getCurrentPrice(String tickerSymbol) {
        LOGGER.info("Getting current price for ticker symbol: " + tickerSymbol);
        if (tickerSymbol.equalsIgnoreCase("AAPL")){
            return BigDecimal.valueOf(150.25);
        }
        throw new IllegalArgumentException("Unknown Ticker Symbol: " + tickerSymbol);
    }

    public List<String> search(BigDecimal minPrice, BigDecimal maxPrice, List<String> sectors) {
        LOGGER.info("Querying stocks with minPrice: " + minPrice + ", maxPrice: " + maxPrice + ", sectors: " + sectors);
        List<Stock> stocks = stockRepository.find(sectors, minPrice, maxPrice);
        return List.of("AAPL", "MSFT");
    }

    public void update(String tickerSymbol, BigDecimal newPrice) {
        LOGGER.info("Updating stock price for ticker symbol: " + tickerSymbol + " to new price: " + newPrice);
        var stockOptional = stockRepository.findById(tickerSymbol);
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            stock.update(newPrice);
            stockRepository.save(stock);
            LOGGER.info("Stock price updated successfully.");
        } else {
            throw new IllegalArgumentException("Unknown Ticker Symbol: " + tickerSymbol);
        }
    }

    public void insert(String tickerSymbol, BigDecimal price) {
        LOGGER.info("Inserting new stock with ticker symbol: " + tickerSymbol + " and price: " + price);
        var stock = new Stock(tickerSymbol, price);
        stockRepository.save(stock);
    }

    public void delete(String tickerSymbol) {
        LOGGER.info("Deleting stock with ticker symbol: " + tickerSymbol);
        stockRepository.delete(tickerSymbol);
    }


}