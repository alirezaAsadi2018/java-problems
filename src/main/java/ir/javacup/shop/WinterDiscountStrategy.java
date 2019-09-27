package ir.javacup.shop;

public class WinterDiscountStrategy implements DiscountStrategy {
    @Override
    public long priceByDiscount(Clothing clothing) {
        long basePrice;
        switch (clothing.getSeason()) {
            case SPRING:
                basePrice = clothing.getBasePrice();
                if (clothing instanceof Jacket)
                    basePrice *= 0.9;
                return basePrice;
            case SUMMER:
                basePrice = (long) (clothing.getBasePrice() * 0.75);
                if (clothing instanceof Jacket)
                    basePrice *= 0.9;
                return basePrice;
            case FALL:
                basePrice = (long) (clothing.getBasePrice() * 0.6);
                if (clothing instanceof Jacket)
                    basePrice *= 0.9;
                return basePrice;
            case WINTER:
                basePrice = (long) (clothing.getBasePrice() * 0.5);
                if (clothing instanceof Jacket)
                    basePrice *= 0.9;
                return basePrice;
        }
        return clothing.getBasePrice();
    }
}
