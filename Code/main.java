import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class Main {
    // No Functionality for Buttons yet, will be implemented soon
    // Method to create a basic frontend GUI using Java Swing
    public static void buildGUI(){
        JFrame frame = new JFrame("RainbowPlus");

        // Title for Page Start Section
        JLabel title = new JLabel("RainbowPlus", SwingConstants.CENTER);
        Font heading = new Font("sans-serif", Font.BOLD, 20);
        title.setFont(heading);
        title.setPreferredSize(new Dimension(300,50));
        title.setOpaque(true);
        title.setBackground(Color.pink);
        frame.getContentPane().add(title, BorderLayout.PAGE_START);

        // Flow Pane for Main Body
        JPanel pane = new JPanel(new FlowLayout());
        pane.setPreferredSize(new Dimension(300,400));
        pane.setBackground(Color.LIGHT_GRAY);
        pane.setOpaque(true);
        frame.getContentPane().add(pane, BorderLayout.CENTER);

        // Rental Durations List
        String[] rentalTypes = new String[] {"Hourly", "Daily", "Weekly"};
        JComboBox<String> types = new JComboBox<>(rentalTypes);

        // Item Listener
        types.addItemListener((ItemEvent e) -> {
            Object item = e.getItem();
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println(item + " has been selected");
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                System.out.println(item + " has been deselected");
            }
        }); 

        pane.add(types, BorderLayout.CENTER);

        // Adding Buttons for Inventory Management
        JButton purchaseItem = new JButton("Purchase");
        purchaseItem.setPreferredSize(new Dimension(125, 30));
        purchaseItem.setBackground(Color.green);
        purchaseItem.setOpaque(true);

        JButton rentalItem = new JButton("Rent");
        rentalItem.setPreferredSize(new Dimension(125, 30));
        rentalItem.setBackground(Color.blue);
        rentalItem.setOpaque(true);

        JButton returnItem = new JButton("Return");
        returnItem.setPreferredSize(new Dimension(125, 30));
        returnItem.setBackground(Color.red);
        returnItem.setOpaque(true);

        // Add Buttons to Pane
        pane.add(purchaseItem);
        pane.add(rentalItem);
        pane.add(returnItem);

        // Add Checkboxes to Select Items
        JCheckBox bookBox = new JCheckBox("Book");
        JCheckBox comicBox = new JCheckBox("Comic");
        JCheckBox actionBox = new JCheckBox("Action Figure");

        // Add Checkboxes to Pane
        pane.add(bookBox);
        pane.add(comicBox);
        pane.add(actionBox);

        frame.pack();
        frame.setVisible(true);

    }


    public static void main(String[] args) {
<<<<<<< HEAD
        // Get instances of PurchaseManager and InventoryManager and RentalContent
=======
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                buildGUI();
            }
        });

        // Get instances of PurchaseManager and InventoryManager
>>>>>>> 89078824f4205a88eb31d7206f3fffddc4344dcf
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

                            // Offer choice for notification method
                            System.out.println("\nSelect notification method:");
                            System.out.println("1. Email");
                            System.out.println("2. SMS");
                            System.out.print("Enter notification method number: ");
                            int notificationChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                           

                            Class<? extends Product> rentProductClass = null;
                            int hours = 0;
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
                                    hours = scanner.nextInt();
                                    scanner.nextLine(); // Consume newline
                                    break;

                                case 2:
                                    System.out.print("Enter number of days: ");
                                    int days = scanner.nextInt();
                                    hours = days * 24;//convert to hours

                                    scanner.nextLine(); // Consume newline
                                    break;

                                case 3:
                                    System.out.print("Enter number of weeks: ");
                                    int week = scanner.nextInt();
                                    hours = week * 168;//convert to hours

                                    scanner.nextLine(); // Consume newline
                                    break;

                                default:
                                    System.out.println("Invalid duration number.");
                            }

                            Notification notification = null;
                            switch(notificationChoice){
                                case 1:
                                    notification = new EmailNotification(rentProductClass, hours);
                                    break;
                                
                                case 2:
                                    notification = new SmsNotification(rentProductClass, hours);
                                    break;
                                
                                default:
                                    System.out.println("Invalid duration number");
                                }
                            
                            //rent product and send notification
                            rentalContent.rentProduct(rentProductClass, hours, notification);
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
