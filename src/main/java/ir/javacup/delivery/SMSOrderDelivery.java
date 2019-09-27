package ir.javacup.delivery;

import java.util.*;

public class SMSOrderDelivery implements OrderDelivery {
    private Stack<Order> stack = new Stack<>();
    @Override
    public Order getCurrentOrder() {
        if(!stack.isEmpty())
            return stack.pop();
        return null;
    }

    @Override
    public void takeNewOrder(Order order) {
        stack.remove(order);
        stack.add(order);
    }

    @Override
    public Collection<Order> getOrders() {
        return stack;
    }
}
