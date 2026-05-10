package expert.os.books.architecture.patterns.scenario03;

import org.joda.money.Money;

class CreditCardStrategy implements PaymentProcessor {
    @Override
    public void processPayment(Money amount) {
        // Complex algorithm involving Luhn checks, HTTP calls, etc.
        System.out.println("Processing credit card: $" + amount);
    }
}
