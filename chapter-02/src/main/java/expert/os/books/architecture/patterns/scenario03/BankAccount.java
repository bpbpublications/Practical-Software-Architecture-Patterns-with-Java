package expert.os.books.architecture.patterns.scenario03;

public class BankAccount {

    private final String accountNumber;
    private final double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
