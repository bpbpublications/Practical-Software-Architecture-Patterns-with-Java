package expert.os.books.architecture.patterns.scenario01.anemic;

class OrderService {
    public void checkout(Customer customer, Order order) {
        // WE ASK: We pull the state out, calculate externally, and push it back.
        if (customer.getLoyaltyPoints() > 100) {
            order.applyDiscount(10.0);
            customer.setLoyaltyPoints(customer.getLoyaltyPoints() - 100);
        }
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + 10); // Reward for purchase
    }
}