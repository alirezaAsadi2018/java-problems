package ir.javacup.delivery;

import java.util.Collection;
import java.util.LinkedList;

public class CallOrderDelivery implements OrderDelivery {
    private LinkedList<Order> list = new LinkedList<>();

    @Override
    public Order getCurrentOrder() {
        if (!list.isEmpty())
            return list.pollFirst();
        return null;
    }

    @Override
    public void takeNewOrder(Order order) {
        if (!list.contains(order))
            list.addLast(order);
    }

    @Override
    public Collection<Order> getOrders() {
        return list;
    }
}
