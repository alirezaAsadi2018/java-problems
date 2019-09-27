package ir.javacup.delivery;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class InPersonOrderDelivery implements OrderDelivery {
    private TreeSet<Order> set =
            new TreeSet<>(Comparator.comparing(order->order.getName().charAt(1)));

    @Override
    public Order getCurrentOrder() {
        if(!set.isEmpty())
            return set.pollFirst();
        return null;
    }

    @Override
    public void takeNewOrder(Order order) {
        set.add(order);
    }

    @Override
    public Collection<Order> getOrders() {
        return set;
    }
}
