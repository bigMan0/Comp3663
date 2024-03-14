// InventoryManager.java

// Singleton for inventory management

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private static InventoryManager instance;
    private Map<Class<? extends Product>, Integer> inventory;
 
    private InventoryManager() {
        // Initialize inventory map
        inventory = new HashMap<>();
    }

    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public synchronized int checkInventory(Class<? extends Product> productClass) {
        return inventory.getOrDefault(productClass, 0);
    }
    
    public synchronized void displayInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<Class<? extends Product>, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey().getSimpleName() + ": " + entry.getValue());
        }
    }

    public synchronized void decrementInventory(Class<? extends Product> productClass) {
        int count = inventory.getOrDefault(productClass, 0);
        if (count > 0) {
            inventory.put(productClass, count - 1);
        }
    }

    public synchronized void incrementInventory(Class<? extends Product> productClass) {
        inventory.put(productClass, inventory.getOrDefault(productClass, 0) + 1);
    }

    // Method to add new product types to the inventory
    public synchronized void addProductType(Class<? extends Product> productClass, int initialQuantity) {
        inventory.put(productClass, initialQuantity);
    }
}