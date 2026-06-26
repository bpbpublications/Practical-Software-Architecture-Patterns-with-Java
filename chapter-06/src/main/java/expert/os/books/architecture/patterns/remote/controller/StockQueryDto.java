package expert.os.books.architecture.patterns.remote.controller;

import java.math.BigDecimal;
import java.util.List;

public record StockQueryDto(BigDecimal minPrice, BigDecimal maxPrice, List<String> sectors) {
}
