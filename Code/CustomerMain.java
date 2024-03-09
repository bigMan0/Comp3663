import java.util.Scanner;

public class CustomerMain {
    public static void main(String[] args) {
        InventoryManager inventoryManager = InventoryManager.getInstance();
        RentalManager rentalManager = RentalManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Check Available Products");
            System.out.println("2. Rent Product");
            System.out.println("3. Return Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAvailableProducts(inventoryManager);
                    break;
                case 2:
                    rentProduct(rentalManager, scanner);
                    break;
                case 3:
                    returnProduct(rentalManager, scanner);
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

    private static void displayAvailableProducts(InventoryManager inventoryManager) {
        System.out.println("Available Products:");
        System.out.println("Books: " + inventoryManager.checkInventory(InventoryManager.ProductType.BOOK));
        System.out.println("Action Figures: " + inventoryManager.checkInventory(InventoryManager.ProductType.ACTION_FIGURE));
        System.out.println("Comics: " + inventoryManager.checkInventory(InventoryManager.ProductType.COMIC));
    }

    private static void rentProduct(RentalManager rentalManager, Scanner scanner) {
        System.out.println("Enter the product type to rent (BOOK, ACTION_FIGURE, COMIC): ");
        String productTypeString = scanner.next();
        InventoryManager.ProductType productType = InventoryManager.ProductType.valueOf(productTypeString);

        System.out.println("Enter the duration to rent (1 for daily, 7 for weekly, 30 for monthly): ");
        int duration = scanner.nextInt();

        rentalManager.rentProduct("user123", productType, duration); // Assuming user ID "user123"
    }

    private static void returnProduct(RentalManager rentalManager, Scanner scanner) {
        System.out.println("Enter the product type to return (BOOK, ACTION_FIGURE, COMIC): ");
        String productTypeString = scanner.next();
        InventoryManager.ProductType productType = InventoryManager.ProductType.valueOf(productTypeString);

        rentalManager.returnProduct("user123", productType); // Assuming user ID "user123"
    }
}
