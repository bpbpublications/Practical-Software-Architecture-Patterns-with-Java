package expert.os.books.architecture.patterns.scenario03;

import java.math.BigDecimal;

public class BankAccount {

    private final String accountNumber;
    private final BigDecimal balance;

    BankAccount(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
