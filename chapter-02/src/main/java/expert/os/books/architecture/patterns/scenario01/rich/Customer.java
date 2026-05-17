package expert.os.books.architecture.patterns.scenario01.rich;

public class Customer {
    private int loyaltyPoints;

    // WE TELL: Business logic is co-located with the state it modifies.
    public void processCheckoutRewards(Order order) {
        if (this.loyaltyPoints > 100) {
            order.applyDiscount(10.0);
            this.loyaltyPoints -= 100;
        }
        this.loyaltyPoints += 10;
    }
}
