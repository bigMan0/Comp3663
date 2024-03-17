//Product interface
interface Product {
    void create();
    void setPrice(double price);
    double getPrice();
}

// Concrete Products
class Comic implements Product {
    private double price;

    @Override
    public void create() {
        System.out.println("Creating Comic...");
    }
        
    @Override
    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

}

class ActionFigure implements Product {
    private double price;

    @Override
    public void create() {
        System.out.println("Creating Action Figure...");
    }

    @Override
    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

class Book implements Product {
    private double price;

    @Override
    public void create() {
        System.out.println("Creating Book...");
    }

    @Override
    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
