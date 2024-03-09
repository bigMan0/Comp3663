// RentalManager.java

// Singleton for rental management
class RentalManager {
    private static RentalManager instance;
    private RentalStrategy rentalStrategy;

    private RentalManager() {
        // Default rental strategy
        this.rentalStrategy = new DailyRentalStrategy();
    }

    public static synchronized RentalManager getInstance() {
        if (instance == null) {
            instance = new RentalManager();
        }
        return instance;
    }

    public void setRentalStrategy(RentalStrategy rentalStrategy) {
        this.rentalStrategy = rentalStrategy;
    }

    public void rentProduct(Product product) {
        rentalStrategy.rent(product);
    }
}
