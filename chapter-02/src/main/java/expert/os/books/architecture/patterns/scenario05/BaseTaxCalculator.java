package expert.os.books.architecture.patterns.scenario05;

abstract class BaseTaxCalculator {
    protected double calculateBase(double amount) {
        return amount * 0.10;
    }
}