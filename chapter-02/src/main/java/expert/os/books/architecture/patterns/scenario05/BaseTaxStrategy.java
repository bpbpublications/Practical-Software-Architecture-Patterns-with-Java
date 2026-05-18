package expert.os.books.architecture.patterns.scenario05;

import java.math.BigDecimal;

interface BaseTaxStrategy {
    BigDecimal calculateBase(BigDecimal amount);
}