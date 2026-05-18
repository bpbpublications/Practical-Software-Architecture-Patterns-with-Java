package expert.os.books.architecture.patterns.scenario05.before;

import java.math.BigDecimal;

abstract class BaseTaxCalculator {
    protected BigDecimal calculateBase(BigDecimal amount) {
        return amount.multiply( BigDecimal.valueOf(0.10));
    }
}