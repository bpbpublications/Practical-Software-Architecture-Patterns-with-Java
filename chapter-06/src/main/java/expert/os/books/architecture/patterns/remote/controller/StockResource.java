package expert.os.books.architecture.patterns.remote.controller;

import expert.os.books.architecture.patterns.remote.infrastructure.QUERY;
import expert.os.books.architecture.patterns.remote.StockQueryDto;
import expert.os.books.architecture.patterns.remote.StockService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Logger;

@Path("/api/v1/stocks")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class StockResource {

    private static final Logger LOGGER = Logger.getLogger(StockResource.class.getName());

    @Inject
    private StockService stockService;

    @GET
    @Path("/{ticker}")
    public Response getStockPrice(@PathParam("ticker") String ticker) {
        try {
            var price = stockService.getCurrentPrice(ticker);
            LOGGER.info("Retrieved price for ticker: " + ticker);
            LOGGER.info("Constructed JSON payload for ticker: " + ticker);
            return Response.ok(new StockResult(ticker, price)).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }

    @QUERY
    public Response queryStocks(StockQueryDto query) {
        LOGGER.info("Constructed JSON payload for query: " + query);
        List<String> results = stockService.queryStocks(query.minPrice(), query.maxPrice(), query.sector());
        return Response.ok(new Stocks(results)).build();
    }
}