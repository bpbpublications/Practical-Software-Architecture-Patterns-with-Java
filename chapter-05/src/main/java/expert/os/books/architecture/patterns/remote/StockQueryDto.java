package expert.os.books.architecture.patterns.remote;

public record StockQueryDto(double minPrice, double maxPrice, String sector) {
}
