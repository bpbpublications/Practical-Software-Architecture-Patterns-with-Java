package expert.os.books.architecture.patterns.scenario01.anemic;

class Customer {
    private int loyaltyPoints;

    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int points) { this.loyaltyPoints = points; }
}