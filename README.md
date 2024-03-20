# Comp3663
# Book Store Management System

This is a Java program for managing a book store. It allows you to perform operations: purchasing + returning products, renting products, managing inventory, and sending notifications for rental activities.

## How to Run

Compile and run the `Main.java` file.

## Functionality

### 1. Purchase Products + Retrun

- The program allows you to purchase + return different types of products such as books, action figures, and comics.
- Each product is created using the Factory Method design pattern.
- The `Main` class demonstrates how to use the `PurchaseManager` to purchase + return products .

### 2. Rent Products

- You can also rent products from the store.
- Rental operations are implemented using the Strategy design pattern.
- Different rental strategies (e.g., daily, weekly, monthly) can be applied to products.

### 3. Manage Inventory

- Inventory management functionality is provided to keep track of product quantities.
- The `InventoryManager` class maintains the inventory using the Singleton design pattern.

### 4. Send Notifications

- Notifications are sent for rentals.
- Notification functionality is implemented using the Decorator design pattern.
- Different types of notifications email or SMS can be applied to rental operations.

## Navigation of Documents

1. Product Creation (Factory Method)
   * Creator.java
   * Product.java

2. Purchase+Return (Singleton Method)
   * PurchaseManager.java

3. Inventory (Singleton Method)
   * InventoryManager.java

4. Rental (Strategy)
   * RentalStrategy.java (interface)
   * DailyRentalStratrgy.java
   * HourlyRentalStrategy.java
   * WeeklyRentalStrategy.java
   * RentalContent

5. Notifications (Decorator)
   * Notification.java (interface)
   * NotificationDecorator.java
   * EmailNotification.java
   * SmsNotification.java

## Usage

1. Run the program.
2. Follow the prompts to purchase products, rent products, or perform other operations.
3. Check the console output for messages related to the operations you performed.

## Contributors

- [Cameron Burgoyne, Braden Boudreau , Rafe Hambly, Tyler Kennedy]


