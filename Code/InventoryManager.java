// InventoryManager.java

// Singleton for inventory management
public class InventoryManager {
    private static InventoryManager instance;
    private int bookInventory;
    private int actionFigureInventory;
    private int comicInventory;

    // Enum to represent different types of products
    public enum ProductType {
        BOOK,
        ACTION_FIGURE,
        COMIC
    }

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

    public synchronized int checkInventory(ProductType type) {
        switch (type) {
            case BOOK:
                return bookInventory;
            case ACTION_FIGURE:
                return actionFigureInventory;
            case COMIC:
                return comicInventory;
            default:
                return 0;
        }
    }

    public synchronized void decrementInventory(ProductType type) {
        switch (type) {
            case BOOK:
                if (bookInventory > 0) {
                    bookInventory--;
                }
                break;
            case ACTION_FIGURE:
                if (actionFigureInventory > 0) {
                    actionFigureInventory--;
                }
                break;
            case COMIC:
                if (comicInventory > 0) {
                    comicInventory--;
                }
                break;
        }
    }

    public synchronized void incrementInventory(ProductType type) {
        switch (type) {
            case BOOK:
                bookInventory++;
                break;
            case ACTION_FIGURE:
                actionFigureInventory++;
                break;
            case COMIC:
                comicInventory++;
                break;
        }
    }
}
