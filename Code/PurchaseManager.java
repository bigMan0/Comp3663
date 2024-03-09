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
    public void purchaseProduct(InventoryManager.ProductType type) {
        if (inventoryManager.checkInventory(type) > 0) {
            inventoryManager.decrementInventory(type);
            System.out.println("Purchased a " + type.toString());
        } else {
            System.out.println("Sorry, " + type.toString() + " is out of stock.");
        }
    }

    // Method to return a product
    public void returnProduct(InventoryManager.ProductType type) {
        inventoryManager.incrementInventory(type);
        System.out.println("Returned a " + type.toString());
    }
}
