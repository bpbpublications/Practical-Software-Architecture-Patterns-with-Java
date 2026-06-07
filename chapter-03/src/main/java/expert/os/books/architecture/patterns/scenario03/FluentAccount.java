package expert.os.books.architecture.patterns.scenario03;

import java.math.BigDecimal;
import java.util.Objects;

public class FluentAccount {

    private FluentAccount() {
    }

    public static AccountNumberStep account() {
        return new Builder();
    }

    // The interfaces dictate the exact flow of method chaining
    public interface AccountNumberStep {
        BuildStep withNumber(String number);
    }

    public interface BuildStep {
        BankAccount withBalance(BigDecimal balance);

        BankAccount build();
    }

    private static class Builder implements AccountNumberStep, BuildStep {
        private String number;
        private BigDecimal balance = BigDecimal.ZERO;

        public BuildStep withNumber(String number) {
            this.number = Objects.requireNonNull(number, "number must not be null");
            return this;
        }

        public BankAccount withBalance(BigDecimal balance) {
            this.balance = Objects.requireNonNull(balance, "balance must not be null");
            return build();
        }

        public BankAccount build() {
            return new BankAccount(number, balance);
        }
    }
}