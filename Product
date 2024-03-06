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

// Creator interface
interface Creator {
    Product createProduct();
}

// Concrete Creators
class ComicCreator implements Creator {
    @Override
    public Product createProduct() {
        return new Comic();
    }
}

class ActionFigureCreator implements Creator {
    @Override
    public Product createProduct() {
        return new ActionFigure();
    }
}

class BookCreator implements Creator {
    @Override
    public Product createProduct() {
        return new Book();
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        // Creating a comic
        Creator comicCreator = new ComicCreator();
        Product comic = comicCreator.createProduct();
        comic.create();

        // Creating an action figure
        Creator actionFigureCreator = new ActionFigureCreator();
        Product actionFigure = actionFigureCreator.createProduct();
        actionFigure.create();

        // Creating a book
        Creator bookCreator = new BookCreator();
        Product book = bookCreator.createProduct();
        book.create();
    }
}
