package expert.os.books.architecture.patterns.scenario03;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        BankAccount account = BankAccount.builder()
                .accountNumber("123456789")
                .balance(new java.math.BigDecimal("1000.00"))
                .build();

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());

        BankAccount bankAccount = BankAccount.withNumber("987654321").withBalance(new BigDecimal("500.00"));

        BankAccount bankAccount1 = DomainAccount.openNewAccount("123456789", new BigDecimal("1000.00"));
    }
}
