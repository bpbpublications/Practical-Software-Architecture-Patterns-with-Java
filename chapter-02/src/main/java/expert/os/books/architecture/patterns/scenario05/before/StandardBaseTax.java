package expert.os.books.architecture.patterns.scenario05.before;

import java.math.BigDecimal;

class StandardBaseTax implements BaseTaxStrategy {

    public BigDecimal calculateBase(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.10"));
    }
}