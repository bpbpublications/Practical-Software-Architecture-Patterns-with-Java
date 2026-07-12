package expert.os.books.architecture.patterns;

import java.math.BigDecimal;

public record Voucher(String code, BigDecimal discountPercentage, boolean isActive) {

}