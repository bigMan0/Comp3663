// RentalStrategy.java

// Rental strategy interface
interface RentalStrategy {

    void rent(Product product, int duration);
} 

// Concrete rental strategies
class DailyRentalStrategy implements RentalStrategy {
    @Override
    public void rent(Product product, int duration) {
        System.out.println("Renting " + product.getClass().getSimpleName() + " on daily basis...");
        // Add logic for daily rental
    }
}

class WeeklyRentalStrategy implements RentalStrategy {
    @Override
    public void rent(Product product, int duration) {
        System.out.println("Renting " + product.getClass().getSimpleName() + " on weekly basis...");
        // Add logic for weekly rental
    }
}

class MonthlyRentalStrategy implements RentalStrategy {
    @Override
    public void rent(Product product, int duration) {
        System.out.println("Renting " + product.getClass().getSimpleName() + " on monthly basis...");
        // Add logic for monthly rental
    }
}
