package expert.os.books.architecture.patterns.scenario05.after;

import java.math.BigDecimal;

class StandardBaseTax implements BaseTaxStrategy {

    public BigDecimal calculateBase(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.10"));
    }
}