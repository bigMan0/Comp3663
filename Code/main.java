import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Get instances of PurchaseManager and InventoryManager
        PurchaseManager purchaseManager = PurchaseManager.getInstance();
        InventoryManager inventoryManager = InventoryManager.getInstance();
        RentalContent rentalContent = new RentalContent(inventoryManager);


        // Add initial quantities of products to inventory
        inventoryManager.addProductType(Comic.class, 10);
        inventoryManager.addProductType(ActionFigure.class, 5);
        inventoryManager.addProductType(Book.class, 8);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Display Inventory");
            System.out.println("2. Purchase Item");
            System.out.println("3. Return Item");
            System.out.println("4. Rental");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Display inventory
                    System.out.println();
                    inventoryManager.displayInventory();
                    break;
                case 2:
                    // Purchase item
                    System.out.println("\nSelect item to purchase:");
                    System.out.println("1. Comic");
                    System.out.println("2. Action Figure");
                    System.out.println("3. Book");
                    System.out.print("Enter item number: ");
                    int itemChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    switch (itemChoice) {
                        case 1:
                            purchaseManager.purchaseProduct(Comic.class);
                            break;
                        case 2:
                            purchaseManager.purchaseProduct(ActionFigure.class);
                            break;
                        case 3:
                            purchaseManager.purchaseProduct(Book.class);
                            break;
                        default:
                            System.out.println("Invalid item number.");
                    }
                    break;
                case 3:
                    // Return item
                    System.out.println("\nSelect item to return:");
                    System.out.println("1. Comic");
                    System.out.println("2. Action Figure");
                    System.out.println("3. Book");
                    System.out.print("Enter item number: ");
                    int returnChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    switch (returnChoice) {
                        case 1:
                            purchaseManager.returnProduct(Comic.class);
                            break;
                        case 2:
                            purchaseManager.returnProduct(ActionFigure.class);
                            break;
                        case 3:
                            purchaseManager.returnProduct(Book.class);
                            break;
                        default:
                            System.out.println("Invalid item number.");
                    }
                    break;
                
                    case 4:
                    // Rental
                    System.out.println("\nRental Menu:");
                    System.out.println("1. Rent a product");
                    System.out.println("2. Return a rental");
                    System.out.print("Enter your choice: ");
                    int rentalChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    switch (rentalChoice) {
                        case 1:
                            // Rent a product
                            System.out.println("\nSelect item to rent:");
                            System.out.println("1. Comic");
                            System.out.println("2. Action Figure");
                            System.out.println("3. Book");
                            System.out.print("Enter item number: ");
                            int rentItemChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.println("\nSelect duration:");
                            System.out.println("1. Hourly");
                            System.out.println("2. Daily");
                            System.out.println("3. Weekly");
                            System.out.print("Enter duration number: ");
                            int durationChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            Class<? extends Product> rentProductClass = null;
                            int days = 0;
                            switch (rentItemChoice) {
                                case 1:
                                    rentProductClass = Comic.class;
                                    break;
                                case 2:
                                    rentProductClass = ActionFigure.class;
                                    break;
                                case 3:
                                    rentProductClass = Book.class;
                                    break;
                                default:
                                    System.out.println("Invalid item number.");
                            }
                            switch (durationChoice) {
                                case 1:
                                    System.out.print("Enter number of hours: ");
                                    int hours = scanner.nextInt();
                                    scanner.nextLine(); // Consume newline
                                    rentalContent.rentProduct(rentProductClass, hours);
                                    break;
                                case 2:
                                    System.out.print("Enter number of days: ");
                                    days = scanner.nextInt();
                                    scanner.nextLine(); // Consume newline
                                    rentalContent.rentProduct(rentProductClass, days);
                                    break;
                                case 3:
                                    System.out.print("Enter number of weeks: ");
                                    int weeks = scanner.nextInt();
                                    scanner.nextLine(); // Consume newline
                                    rentalContent.rentProduct(rentProductClass, weeks * 7); // Convert weeks to days
                                    break;
                                default:
                                    System.out.println("Invalid duration number.");
                            }
                            break;
                        case 2:
                            // Return a rental
                            System.out.println("\nSelect item to return:");
                            System.out.println("1. Comic");
                            System.out.println("2. Action Figure");
                            System.out.println("3. Book");
                            System.out.print("Enter item number: ");
                            int returnItemChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            Class<? extends Product> returnProductClass = null;
                            switch (returnItemChoice) {
                                case 1:
                                    returnProductClass = Comic.class;
                                    break;
                                case 2:
                                    returnProductClass = ActionFigure.class;
                                    break;
                                case 3:
                                    returnProductClass = Book.class;
                                    break;
                                default:
                                    System.out.println("Invalid item number.");
                            }
                            rentalContent.returnProduct(returnProductClass);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter 1 or 2.");
                    }
                    break;
            
                case 5:
                    // Exit
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
            System.out.println(); // Add a newline for better readability
        }

        // Close scanner
        scanner.close();
    }
}
