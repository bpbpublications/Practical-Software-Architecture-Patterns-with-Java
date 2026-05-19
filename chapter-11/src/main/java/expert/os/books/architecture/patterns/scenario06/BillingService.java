package expert.os.books.architecture.patterns.scenario06;

import java.math.BigDecimal;

class BillingService {
    private final Payable paymentMethod;
    private final ReceiptSender receiptSender;

    // Constructor Injection (DIP)
    public BillingService(Payable paymentMethod, ReceiptSender receiptSender) {
        this.paymentMethod = paymentMethod;
        this.receiptSender = receiptSender;
    }

    public void processInvoice(BigDecimal amount) {
        paymentMethod.pay(amount);
        receiptSender.sendReceipt(amount);
    }
}
