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

import expert.os.books.architecture.patterns.remote.StockService;
import jakarta.inject.Inject;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.logging.Logger;

@ServerEndpoint("/ws/stocks/{ticker}")
public class StockWebSocket {

    private static final Logger LOGGER = Logger.getLogger(StockWebSocket.class.getName());

    @Inject
    private StockService stockService;

    @OnOpen
    public void onOpen(Session session, @PathParam("ticker") String ticker) {
        LOGGER.info("WebSocket Connection Opened: " + session.getId());
        pushPriceUpdate(session, ticker);
    }

    private void pushPriceUpdate(Session session, String ticker) {
        try {
            var price = stockService.getCurrentPrice(ticker);
            String message = String.format("LIVE UPDATE | %s: $%.2f", ticker, price);
            session.getBasicRemote().sendText(message);
            LOGGER.info("Pushed price update to WebSocket: " + message);
        } catch (IOException | IllegalArgumentException exception) {
            System.err.println("Failed to push to WebSocket: " + exception.getMessage());
        }
    }

    @OnClose
    public void onClose(Session session) {
        LOGGER.info("WebSocket Connection Closed: " + session.getId());
    }
}
