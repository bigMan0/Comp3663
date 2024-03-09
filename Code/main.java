// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PurchaseManager purchaseManager = PurchaseManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Check Inventory");
            System.out.println("2. Purchase Product");
            System.out.println("3. Return Product");
            System.out.println("4. Exit\n");
            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    displayInventory();
                    break;
                case 2:
                    System.out.println();
                    purchaseProduct(purchaseManager, scanner);
                    break;
                case 3:
                    System.out.println();   
                    returnProduct(purchaseManager, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayInventory() {
        InventoryManager inventoryManager = InventoryManager.getInstance();
        System.out.println("Inventory Status:");
        System.out.println("Books: " + inventoryManager.checkInventory(InventoryManager.ProductType.BOOK));
        System.out.println("Action Figures: " + inventoryManager.checkInventory(InventoryManager.ProductType.ACTION_FIGURE));
        System.out.println("Comics: " + inventoryManager.checkInventory(InventoryManager.ProductType.COMIC));
    }

    private static void purchaseProduct(PurchaseManager purchaseManager, Scanner scanner) {
        System.out.println("Enter the product type to purchase (BOOK, ACTION_FIGURE, COMIC): ");
        String productTypeString = scanner.next().toUpperCase();
        InventoryManager.ProductType productType = InventoryManager.ProductType.valueOf(productTypeString);
        purchaseManager.purchaseProduct(productType);
    }

    private static void returnProduct(PurchaseManager purchaseManager, Scanner scanner) {
        System.out.println("Enter the product type to return (BOOK, ACTION_FIGURE, COMIC): ");
        String productTypeString = scanner.next().toUpperCase();
        InventoryManager.ProductType productType = InventoryManager.ProductType.valueOf(productTypeString);
        purchaseManager.returnProduct(productType);
    }
}
