package expert.os.books.architecture.patterns.scenario03;

public class BankAccountBuilder {
    private String accountNumber;
    private double balance;

    public BankAccountBuilder accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public BankAccountBuilder balance(double balance) {
        this.balance = balance;
        return this;
    }


    public BankAccount build() {
        return new BankAccount(accountNumber, balance);
    }
}