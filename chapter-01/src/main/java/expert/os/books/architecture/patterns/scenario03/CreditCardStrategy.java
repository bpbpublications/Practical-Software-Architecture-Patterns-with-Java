package expert.os.books.architecture.patterns.scenario03;

class CreditCardStrategy implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        // Complex algorithm involving Luhn checks, HTTP calls, etc.
        System.out.println("Processing credit card: $" + amount);
    }
}
