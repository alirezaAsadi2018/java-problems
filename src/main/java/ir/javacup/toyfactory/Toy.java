package ir.javacup.toyfactory;

public class Toy {
    private double basePrice;
    protected ToySize size;
    public Toy(double basePrice, ToySize size){
        this.basePrice = basePrice;
        this.size = size;
    }
    public double getBasePrice(){
        return basePrice;
    }
    public double getPrice(){
        switch (size){
            case SMALL:
                return basePrice;
            case MEDIUM:
                return basePrice * 1.5;
            case LARGE:
                return basePrice * 2;
        }
        return basePrice;
    }
    public double getPrice(double discount){
        return getPrice() * (1 - discount / 100);
    }
}
