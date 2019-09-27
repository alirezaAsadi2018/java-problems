package ir.javacup.internetShop;

import java.util.function.Function;

public class OrderFunctionUtilImpl implements OrderFunctionUtil {

    @Override
    public Function<Order, Boolean> isBigOrder() {
        return (order) -> {
            long price = 0;
            for (Product product : order.getProducts())
                price += product.getPrice();
            return price >= 10000000;
        };
    }

    @Override
    public Function<Order, Boolean> hasMultipleProducts() {
        return (order) -> order.getProducts().size() > 1;
    }

    @Override
    public Function<Order, Boolean> hasUnavailableProduct() {
        return (order) -> {
            for (Product product : order.getProducts()) {
                if (product.getState() == ProductState.UNAVAILABLE)
                    return true;
            }
            return false;
        };
    }

    @Override
    public Function<Order, Boolean> isReadyToDeliver() {
        return (order) -> {
            if (order.getState() != OrderState.READY_TO_SEND)
                return false;
            for (Product product : order.getProducts()) {
                if (product.getState() == ProductState.UNAVAILABLE)
                    return false;
            }
            return true;
        };
    }

    @Override
    public Function<Order, Boolean> hasPerishableProduct() {
        return (order) -> {
            for (Product product : order.getProducts()) {
                if (product.getType() == ProductType.PERISHABLE)
                    return true;
            }
            return false;
        };
    }

    @Override
    public Function<Order, Boolean> hasExpensiveBreakableProduct() {
        return (order) -> {
            for (Product product : order.getProducts()) {
                if (product.getType() == ProductType.BREAKABLE && product.getPrice() >= 5000000)
                    return true;
            }
            return false;
        };
    }
}
