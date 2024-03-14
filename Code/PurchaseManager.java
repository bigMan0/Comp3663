// PurchaseManager.java

// Singleton for purchase and return management
public class PurchaseManager {
    private static PurchaseManager instance;
    private InventoryManager inventoryManager;


    private PurchaseManager() {
        inventoryManager = InventoryManager.getInstance();
    }

    public static synchronized PurchaseManager getInstance() {
        if (instance == null) {
            instance = new PurchaseManager();
        }
        return instance;
    }

     // Method to purchase a product
     public void purchaseProduct(Class<? extends Product> productClass) {
        if (inventoryManager.checkInventory(productClass) > 0) {
            inventoryManager.decrementInventory(productClass);
            System.out.println("Purchased a " + productClass.getSimpleName());
        } else {
            System.out.println("Sorry, " + productClass.getSimpleName() + " is out of stock.");
        }
    }

    // Method to return a product
    public void returnProduct(Class<? extends Product> productClass) {
        inventoryManager.incrementInventory(productClass);
        System.out.println("Returned a " + productClass.getSimpleName());
    }
}
