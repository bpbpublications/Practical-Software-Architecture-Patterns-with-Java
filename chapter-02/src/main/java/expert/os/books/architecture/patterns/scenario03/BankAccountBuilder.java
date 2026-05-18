package expert.os.books.architecture.patterns.scenario03;

import java.math.BigDecimal;


public class BankAccountBuilder {
    private String accountNumber;
    private BigDecimal balance;

    public BankAccountBuilder accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public BankAccountBuilder balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }


    public BankAccount build() {
        return new BankAccount(accountNumber, balance);
    }
}