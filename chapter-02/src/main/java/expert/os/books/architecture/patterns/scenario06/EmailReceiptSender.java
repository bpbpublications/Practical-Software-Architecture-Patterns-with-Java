package expert.os.books.architecture.patterns.scenario06;

import java.math.BigDecimal;

class EmailReceiptSender implements ReceiptSender {
    public void sendReceipt(BigDecimal amount) {
        System.out.println("Sending Email Receipt for: " + amount);
    }
}