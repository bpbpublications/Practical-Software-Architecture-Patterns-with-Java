package expert.os.books.architecture.patterns.scenario05.after;

import java.math.BigDecimal;

interface BaseTaxStrategy {
    BigDecimal calculateBase(BigDecimal amount);
}
