package expert.os.books.architecture.patterns.scenario06;


import java.math.BigDecimal;

class CreditCardPayment implements Payable, Refundable {

    public void pay(BigDecimal amount) {
        System.out.println("Charging Credit Card: " + amount);
    }
    public void refund(BigDecimal amount) {
        System.out.println("Refunding Credit Card: " + amount);
    }
}