//Product interface
interface Product {
    void create();
}

// Concrete Products
class Comic implements Product {
    @Override
    public void create() {
        System.out.println("Creating Comic...");
        // Add logic for creating a comic

    }
}

class ActionFigure implements Product {
    @Override
    public void create() {
        System.out.println("Creating Action Figure...");
        // Add logic for creating an action figure

    }
}

class Book implements Product {
    @Override
    public void create() {
        System.out.println("Creating Book...");
        // Add logic for creating a book

    }
}
