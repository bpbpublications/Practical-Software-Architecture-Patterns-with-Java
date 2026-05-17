package expert.os.books.architecture.patterns.scenario01.rich;

import java.math.BigDecimal;

public class Customer {
    private int loyaltyPoints;

    // WE TELL: Business logic is co-located with the state it modifies.
    public void processCheckoutRewards(Order order) {
        if (this.loyaltyPoints > 100) {
            order.applyDiscount(BigDecimal.valueOf(10.0));
            this.loyaltyPoints -= 100;
        }
        this.loyaltyPoints += 10;
    }
}
