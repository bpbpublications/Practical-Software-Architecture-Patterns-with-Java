package expert.os.books.architecture.patterns.scenario06;

import java.math.BigDecimal;

class CryptoPayment implements Payable {

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Transferring Crypto: " + amount);
    }
}