// Main.java

// Client
public class Main {
    public static void main(String[] args) {
        // Singleton instances
        InventoryManager inventoryManager = InventoryManager.getInstance();
        PurchaseManager purchaseManager = PurchaseManager.getInstance();
        RentalManager rentalManager = RentalManager.getInstance();
        NotificationManager notificationManager = NotificationManager.getInstance();

        // Creating a comic
        Creator comicCreator = new ComicCreator();
        Product comic = comicCreator.createProduct();
        if (inventoryManager.checkInventory(ProductType.COMIC)) {
            inventoryManager.decrementInventory(ProductType.COMIC);
            comic.create();
            // Simulate purchase
            // purchaseManager.purchaseProduct(ProductType.COMIC);
            // Rent the comic
            rentalManager.rentProduct(comic);
            // Send email notification for rental
            notificationManager.sendNotification(new EmailNotificationDecorator(null));
        }

        // Creating an action figure
        Creator actionFigureCreator = new ActionFigureCreator();
        Product actionFigure = actionFigureCreator.createProduct();
        if (inventoryManager.checkInventory(ProductType.ACTION_FIGURE)) {
            inventoryManager.decrementInventory(ProductType.ACTION_FIGURE);
            actionFigure.create();
            // Simulate purchase
            // purchaseManager.purchaseProduct(ProductType.ACTION_FIGURE);
            // Rent the action figure
            rentalManager.rentProduct(actionFigure);
            // Send SMS notification for rental
            notificationManager.sendNotification(new SMSNotificationDecorator(null));
        }

        // Creating a book
        Creator bookCreator = new BookCreator();
        Product book = bookCreator.createProduct();
        if (inventoryManager.checkInventory(ProductType.BOOK)) {
            inventoryManager.decrementInventory(ProductType.BOOK);
            book.create();
            // Simulate purchase
            // purchaseManager.purchaseProduct(ProductType.BOOK);
            // Rent the book
            rentalManager.rentProduct(book);
            // Send email and SMS notifications for rental
            notificationManager.sendNotification(new EmailNotificationDecorator(new SMSNotificationDecorator(null)));
        }
    }
}
