import java.util.HashMap;
import java.util.Map;

// Singleton for rental management
class RentalManager {
    private static RentalManager instance;
    private RentalStrategy rentalStrategy;
    private InventoryManager inventoryManager;
    private Map<String, Map<InventoryManager.ProductType, Integer>> userRentals;

    private RentalManager() {
        // Default rental strategy
        this.rentalStrategy = new DailyRentalStrategy();
        this.inventoryManager = InventoryManager.getInstance();
        this.userRentals = new HashMap<>();
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

    public void rentProduct(String userId, InventoryManager.ProductType type, int duration) {
        int availableInventory = inventoryManager.checkInventory(type);
        if (availableInventory > 0) {
            switch (duration) {
                case 1:
                    rentalStrategy = new DailyRentalStrategy();
                    break;
                case 7:
                    rentalStrategy = new WeeklyRentalStrategy();
                    break;
                case 30:
                    rentalStrategy = new MonthlyRentalStrategy();
                    break;
                default:
                    System.out.println("Invalid duration. Please select 1 for daily, 7 for weekly, or 30 for monthly.");
                    return;
            }
            rentalStrategy.rent(getProductByType(type), duration);
            inventoryManager.decrementInventory(type);
            addUserRental(userId, type, duration);
        } else {
            System.out.println("Sorry, " + type.toString() + " is out of stock.");
        }
    }

    public void returnProduct(String userId, InventoryManager.ProductType type) {
        int rentalDuration = removeUserRental(userId, type);
        if (rentalDuration >= 0) {
            inventoryManager.incrementInventory(type);
            System.out.println("Product returned: " + type.toString());
        } else {
            System.out.println("No rental record found for user " + userId + " and product " + type.toString());
        }
    }

    private void addUserRental(String userId, InventoryManager.ProductType type, int duration) {
        userRentals.putIfAbsent(userId, new HashMap<>());
        userRentals.get(userId).put(type, duration);
    }

    private int removeUserRental(String userId, InventoryManager.ProductType type) {
        Map<InventoryManager.ProductType, Integer> userRentalMap = userRentals.get(userId);
        if (userRentalMap != null) {
            Integer rentalDuration = userRentalMap.remove(type);
            return rentalDuration != null ? rentalDuration : -1; // Return -1 if no rental record found
        }
        return -1; // Return -1 if no rental record found
    }

    // Helper method to get Product instance by type
    private Product getProductByType(InventoryManager.ProductType type) {
        switch (type) {
            case BOOK:
                return new Book(); // Create and return a new Book instance
            case ACTION_FIGURE:
                return new ActionFigure(); // Create and return a new ActionFigure instance
            case COMIC:
                return new Comic(); // Create and return a new Comic instance
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}
