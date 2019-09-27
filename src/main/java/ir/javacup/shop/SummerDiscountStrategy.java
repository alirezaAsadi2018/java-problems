package ir.javacup.shop;

public class SummerDiscountStrategy implements DiscountStrategy {
    @Override
    public long priceByDiscount(Clothing clothing) {
        switch (clothing.getSeason()) {
            case SPRING:
                return (long) (clothing.getBasePrice() * 0.6);
            case SUMMER:
                return (long) (clothing.getBasePrice() * 0.5);
            case FALL:
                return clothing.getBasePrice();
            case WINTER:
                return (long) (clothing.getBasePrice() * 0.7);
        }
        return clothing.getBasePrice();
    }
}
