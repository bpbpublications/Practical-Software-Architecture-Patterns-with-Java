package expert.os.books.architecture.patterns.remote.controller;

import expert.os.books.architecture.patterns.remote.StockService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;

@ServerEndpoint("/ws/stocks/{ticker}")
@ApplicationScoped
public class StockWebSocket {

    @Inject
    private StockService stockService;

    @OnOpen
    public void onOpen(Session session, @PathParam("ticker") String ticker) {
        System.out.println("WebSocket Connection Opened: " + session.getId());

        // Pushing data immediately upon connection without the client requesting it
        pushPriceUpdate(session, ticker);
    }

    private void pushPriceUpdate(Session session, String ticker) {
        try {
            double price = stockService.getCurrentPrice(ticker);
            String message = String.format("LIVE UPDATE | %s: $%.2f", ticker, price);

            // Asynchronous push over the open TCP pipe
            session.getBasicRemote().sendText(message);
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Failed to push to WebSocket: " + e.getMessage());
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("WebSocket Connection Closed: " + session.getId());
    }
}
