package ir.javacup.shop;

public class YaldaDiscountStrategy implements DiscountStrategy {
    @Override
    public long priceByDiscount(Clothing clothing) {
        if(clothing instanceof Jacket)
            return (long) (clothing.getBasePrice() * 0.9);
        else if(clothing instanceof Socks)
            return (long) (clothing.getBasePrice() * 0.8);
        else
            return (long) (clothing.getBasePrice() * 0.75);
    }
}
