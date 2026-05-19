package expert.os.books.architecture.patterns.scenario03;

import java.math.BigDecimal;

public class DomainAccount {

    public static BankAccount openNewAccount(String account, BigDecimal initialDeposit) {
        if (account == null || initialDeposit == null) {
            throw new IllegalArgumentException("Account ID and initial deposit are required");
        }
        return new BankAccount(account, initialDeposit);
    }
}
