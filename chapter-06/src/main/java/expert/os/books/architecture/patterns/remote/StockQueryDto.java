package expert.os.books.architecture.patterns.remote;

import java.math.BigDecimal;

public record StockQueryDto(BigDecimal minPrice, BigDecimal maxPrice, String sector) {
}
