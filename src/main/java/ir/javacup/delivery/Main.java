package ir.javacup.delivery;

public class Main {
    public static void main(String[] args) {
        SMSOrderDelivery orderDelivery = new SMSOrderDelivery();
        Order order = new Order();
        order.setName("ali");
        orderDelivery.takeNewOrder(order);
        order = new Order();
        order.setName("hasan");
        orderDelivery.takeNewOrder(order);
        order = new Order();
        order.setName("rooh");
        orderDelivery.takeNewOrder(order);
        System.out.println(orderDelivery.getCurrentOrder().getName());
        System.out.println(orderDelivery.getCurrentOrder().getName());
        System.out.println(orderDelivery.getCurrentOrder().getName());
    }
}
