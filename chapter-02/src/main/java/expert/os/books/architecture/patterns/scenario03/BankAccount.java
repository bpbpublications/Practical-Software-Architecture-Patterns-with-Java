package expert.os.books.architecture.patterns.scenario03;

import java.math.BigDecimal;
import java.util.Objects;

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

    //usage sample BankAccount account = BankAccount.builder().accountNumber("123456789").balance(new BigDecimal("1000.00")).build();
    static BankAccountBuilder builder() {
        return new BankAccountBuilder();
    }

    static FluentAccount.BuildStep withNumber(String number) {
        return FluentAccount.account().withNumber(number);
    }

    public static BankAccount of(String accountNumber, BigDecimal balance) {
        Objects.requireNonNull(accountNumber, "accountNumber must not be null");
        Objects.requireNonNull(balance, "balance must not be null");
        return new BankAccount(accountNumber, balance);
    }
}
