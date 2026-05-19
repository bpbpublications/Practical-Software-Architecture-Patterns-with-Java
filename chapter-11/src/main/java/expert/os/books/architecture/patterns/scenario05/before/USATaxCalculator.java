package expert.os.books.architecture.patterns.scenario05.before;

import java.math.BigDecimal;

class USATaxCalculator extends BaseTaxCalculator {
    public BigDecimal calculate(BigDecimal amount) {
        return calculateBase(amount).add(BigDecimal.valueOf(5.00)); // Tightly coupled to parent's implementation
    }
}