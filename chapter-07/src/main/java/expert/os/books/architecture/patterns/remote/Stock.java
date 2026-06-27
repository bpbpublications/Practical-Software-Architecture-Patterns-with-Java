package expert.os.books.architecture.patterns.remote;

import java.math.BigDecimal;
import java.util.Objects;

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

    void update(BigDecimal newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "sticker='" + sticker + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Stock stock)) {
            return false;
        }
        return Objects.equals(sticker, stock.sticker);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sticker);
    }
}
