package expert.os.books.architecture.patterns.remote;

import java.math.BigDecimal;

public class Stock {

    private String sticker;

    private BigDecimal price;

    public Stock(String sticker, BigDecimal price) {
        this.sticker = sticker;
        this.price = price;
    }

    public String getSticker() {
        return sticker;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
