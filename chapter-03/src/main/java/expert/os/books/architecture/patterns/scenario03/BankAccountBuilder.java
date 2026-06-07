package expert.os.books.architecture.patterns.scenario03;

import java.math.BigDecimal;
import java.util.Objects;


public class BankAccountBuilder {
    private String accountNumber;
    private BigDecimal balance;

    public BankAccountBuilder accountNumber(String accountNumber) {
        this.accountNumber =  Objects.requireNonNull(accountNumber, "accountNumber must not be null");;
        return this;
    }

    public BankAccountBuilder balance(BigDecimal balance) {
        this.balance =  Objects.requireNonNull(balance, "balance must not be null");;
        return this;
    }

    public BankAccount build() {
        Objects.requireNonNull(accountNumber, "accountNumber must not be null");
        Objects.requireNonNull(balance, "balance must not be null");
        return new BankAccount(accountNumber, balance);
    }
}