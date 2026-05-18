package expert.os.books.architecture.patterns.scenario05.after;

import java.math.BigDecimal;

class USATaxCalculator {
    private final BaseTaxStrategy baseStrategy;

    // Composing the behavior via constructor
    public USATaxCalculator(BaseTaxStrategy baseStrategy) {
        this.baseStrategy = baseStrategy;
    }

    public BigDecimal calculate(BigDecimal amount) {
        // Delegation instead of inheritance
        return baseStrategy.calculateBase(amount).add(new BigDecimal("5.00"));
    }
}