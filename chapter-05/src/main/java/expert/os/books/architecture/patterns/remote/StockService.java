package expert.os.books.architecture.patterns.remote;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

// ============================================================================
// 1. THE SHARED SERVICE (Simple Layered Approach)
// ============================================================================

@ApplicationScoped
class StockService {
    public double getCurrentPrice(String tickerSymbol) {
        if (tickerSymbol.equalsIgnoreCase("AAPL")) return 150.25;
        throw new IllegalArgumentException("Unknown Ticker Symbol: " + tickerSymbol);
    }

    public List<String> queryStocks(double minPrice, double maxPrice, String sector) {
        return List.of("AAPL", "MSFT");
    }
}