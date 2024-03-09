// InventoryManager.java

// Singleton for inventory management
class InventoryManager {
    private static InventoryManager instance;
    private int bookInventory;
    private int actionFigureInventory;
    private int comicInventory;

    private InventoryManager() {
        // Initialize inventories
        bookInventory = 100; // Initial quantity of books
        actionFigureInventory = 50; // Initial quantity of action figures
        comicInventory = 75; // Initial quantity of comics
    }

    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public synchronized boolean checkInventory(ProductType type) {
        switch (type) {
            case BOOK:
                return bookInventory > 0;
            case ACTION_FIGURE:
                return actionFigureInventory > 0;
            case COMIC:
                return comicInventory > 0;
            default:
                return false;
        }
    }

    public synchronized void decrementInventory(ProductType type) {
        switch (type) {
            case BOOK:
                bookInventory--;
                break;
            case ACTION_FIGURE:
                actionFigureInventory--;
                break;
            case COMIC:
                comicInventory--;
                break;
        }
    }

    // You can add more methods for inventory management as needed
}
