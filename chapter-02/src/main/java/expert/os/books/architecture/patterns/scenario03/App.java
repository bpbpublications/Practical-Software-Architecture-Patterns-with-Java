package expert.os.books.architecture.patterns.scenario03;

public class App {

    public static void main(String[] args) {
        BankAccount account = BankAccount.builder()
                .accountNumber("123456789")
                .balance(new java.math.BigDecimal("1000.00"))
                .build();

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
    }
}
