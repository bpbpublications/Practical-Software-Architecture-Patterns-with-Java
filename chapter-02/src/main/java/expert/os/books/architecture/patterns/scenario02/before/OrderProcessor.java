package expert.os.books.architecture.patterns.scenario02.before;

import java.math.BigDecimal;

// BEFORE: Violating the Law of Demeter (The "Train Wreck")
class OrderProcessor {
    public void processPayment(Customer customer, BigDecimal amount) {
        // THE LEAK: The processor knows the deep internal structure of Customer.
        // If Customer switches from a "Wallet" to a "BillingProfile", this code breaks!
        PaymentMethod method = customer.getWallet().getDefaultPaymentMethod();
        method.charge(amount);
    }
}