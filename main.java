// Main.java

// Client
public class Main {
    public static void main(String[] args) {
        // Singleton instances
        InventoryManager inventoryManager = InventoryManager.getInstance();
        PurchaseManager purchaseManager = PurchaseManager.getInstance();

        // Creating a comic
        Creator comicCreator = new ComicCreator();
        Product comic = comicCreator.createProduct();
        if (inventoryManager.checkInventory(ProductType.COMIC)) {
            inventoryManager.decrementInventory(ProductType.COMIC);
            comic.create();

            // Simulate purchase
            // purchaseManager.purchaseProduct(ProductType.COMIC);
        }

        // Creating an action figure
        Creator actionFigureCreator = new ActionFigureCreator();
        Product actionFigure = actionFigureCreator.createProduct();
        if (inventoryManager.checkInventory(ProductType.ACTION_FIGURE)) {
            inventoryManager.decrementInventory(ProductType.ACTION_FIGURE);
            actionFigure.create();

            // Simulate purchase
            // purchaseManager.purchaseProduct(ProductType.ACTION_FIGURE);
        }

        // Creating a book
        Creator bookCreator = new BookCreator();
        Product book = bookCreator.createProduct();
        if (inventoryManager.checkInventory(ProductType.BOOK)) {
            inventoryManager.decrementInventory(ProductType.BOOK);
            book.create();
            
            // Simulate purchase
            // purchaseManager.purchaseProduct(ProductType.BOOK);
        }
    }
}
