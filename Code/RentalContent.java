
public class RentalContent {
    private RentalStrategy rentalStrategy;
    private InventoryManager inventoryManager;

    public RentalContent(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void setRentalStrategy(RentalStrategy rentalStrategy) {
        this.rentalStrategy = rentalStrategy;
    }

    public double calculatePrice(int days) {
        return rentalStrategy.calculatePrice(days);
    }

    public void rentProduct(Class<? extends Product> productClass, int hours, Notification notification) {
        // Check if product is available in inventory
        if (inventoryManager.checkInventory(productClass) > 0) {
            inventoryManager.decrementInventory(productClass); // Decrement inventory count
            System.out.println("Rented a " + productClass.getSimpleName() + " for " + hours + " hours.\n");

            //send notification after user rents product
            notification.sendNotification();
        } else {
            System.out.println("Sorry, " + productClass.getSimpleName() + " is out of stock.");
        }
    }

    public void returnProduct(Class<? extends Product> productClass) {
        inventoryManager.incrementInventory(productClass); // Increment inventory count
        System.out.println("Returned a " + productClass.getSimpleName() + ".");
    }
}
