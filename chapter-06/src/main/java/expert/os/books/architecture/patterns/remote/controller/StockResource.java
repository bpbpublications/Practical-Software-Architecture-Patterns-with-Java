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

@Path("/api/v1/stocks")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class StockResource {

    @Inject
    private StockService stockService;

    @GET
    @Path("/{ticker}")
    public Response getStockPrice(@PathParam("ticker") String ticker) {
        try {
            double price = stockService.getCurrentPrice(ticker);
            String jsonPayload = String.format("{\"ticker\": \"%s\", \"price\": %.2f}", ticker, price);
            return Response.ok(jsonPayload).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}")
                    .build();
        }
    }

    @QUERY
    public Response queryStocks(StockQueryDto query) {
        List<String> results = stockService.queryStocks(query.minPrice(), query.maxPrice(), query.sector());
        String jsonPayload = "{\"results\": [\"" + String.join("\", \"", results) + "\"]}";
        return Response.ok(jsonPayload).build();
    }
}