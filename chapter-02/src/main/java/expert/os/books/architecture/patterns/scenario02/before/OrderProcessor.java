package expert.os.books.architecture.patterns.scenario02.before;

import java.math.BigDecimal;

// AFTER: Obeying the Law of Demeter
class OrderProcessor {
    public void processPayment(Customer customer, BigDecimal amount) {
        // We only talk to our immediate friend (Customer).
        // We don't know (or care) how the Customer stores their payment info.
        customer.charge(amount);
    }
}