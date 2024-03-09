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