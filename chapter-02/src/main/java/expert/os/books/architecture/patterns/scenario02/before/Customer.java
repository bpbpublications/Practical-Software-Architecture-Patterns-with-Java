package expert.os.books.architecture.patterns.scenario02.before;

import java.math.BigDecimal;

public class Customer {

    private Wallet wallet;


    public void charge(BigDecimal amount) {
        wallet.getDefaultPaymentMethod().charge(amount);
    }
}
